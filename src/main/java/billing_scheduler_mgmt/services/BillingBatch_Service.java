package billing_scheduler_mgmt.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import billing_master_mgmt.model.master.BillingMaster;
import billing_master_mgmt.model.repo.cud.BillingMasterCUD_Repo;
import billing_master_mgmt.model.repo.read.BillingMasterRead_Repo;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetail;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;
import billing_resourceasset_details_mgmt.model.repo.cud.BillingResourceAssetDetailsCUD_Repo;
import billing_scheduler_mgmt.model.*;
import billing_work_details_mgmt.model.master.BillingWorkDetail;
import billing_work_details_mgmt.model.repo.cud.BillingWorkDetailsCUD_Repo;
import billing_work_details_mgmt.model.repo.read.BillingWorkDetailsRead_Repo;

@Service("billingBatchServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BillingBatch_Service implements I_BillingBatch_Service
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ConsignmentDetailService.class);

	@Autowired
	private ServiceWorkBillingMasterRead_Repo serviceWorkBillingMasterReadRepo;
	
	@Autowired
	private JobWorkBillingDetailsRead_Repo jobWorkBillingDetailsReadRepo;
	
	@Autowired
	private StoreOrderBillingOutwardsRead_Repo storeOrderBillingOutwardsReadRepo;
	
	@Autowired
	private BillingMasterRead_Repo billingMasterReadRepo;	

	@Autowired
	private BillingMasterCUD_Repo billingMasterCUDRepo;
	
	@Autowired
	private BillingWorkDetailsRead_Repo billingWorkDetailsReadRepo;
	
	@Autowired
	private BillingWorkDetailsCUD_Repo billingWorkDetailsCUDRepo;
		
	@Autowired
	private BillingResourceAssetDetailsCUD_Repo billingResourceAssetDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<Void> createUpdateBill(Long sNo)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			CopyOnWriteArrayList<BillingWorkDetail> billingWorkDetails = new CopyOnWriteArrayList<BillingWorkDetail>();
			CopyOnWriteArrayList<Long> sList = new CopyOnWriteArrayList<Long>();
			BillingResourceAssetDetail billingResourceAssetDetail = null;
			BillingResourceAssetDetailPK billingResourceAssetDetailPK = null; 			
			
			delBillData(sNo);			
			Long pNo = (long) 0;
			Long bNo = (long) 0;
			Long bWNo = (long) 0;
		
			ServiceWorkMaster serviceWorkMaster = serviceWorkBillingMasterReadRepo.findById(sNo).get();
			pNo= serviceWorkMaster.getPartySeqNo();
			BillingMaster billingMaster = new BillingMaster();
			billingMaster.setServiceWorkSeqNo(sNo);
			billingMaster.setToPartySeqNo(pNo);
			billingMaster = billingMasterCUDRepo.save(billingMaster);
			bNo = billingMaster.getBillSeqNo();
			BillingWorkDetail billingWorkDetail = null;
			CopyOnWriteArrayList<JobWorkDetail> jobWorkDetails = jobWorkBillingDetailsReadRepo.getSelectJobWorkDetailForService(sNo);
			CopyOnWriteArrayList<StoreOrderOutward> storeOrderOutwards = null;
			
			for (int j = 0; j < jobWorkDetails.size(); j++) 
			{
			billingWorkDetail = new BillingWorkDetail();
			billingWorkDetail.setBillSeqNo(bNo);
			billingWorkDetail.setJobWorkSeqNo(jobWorkDetails.get(j).getJobWorkSeqNo());
			billingWorkDetail.setServiceWorkSeqNo(sNo);			
			billingWorkDetail = billingWorkDetailsCUDRepo.save(billingWorkDetail);
			bWNo = billingWorkDetail.getBillWorkSeqNo();
			sList.add(jobWorkDetails.get(j).getJobWorkSeqNo());
			billingWorkDetails.add(billingWorkDetail);
			}
			
			storeOrderOutwards = storeOrderBillingOutwardsReadRepo.getAllOrderOutwards(sList);
			
			for (int k = 0; k < storeOrderOutwards.size(); k++) 
			{
			billingResourceAssetDetailPK = new BillingResourceAssetDetailPK();	
			billingResourceAssetDetail = new BillingResourceAssetDetail();
			billingResourceAssetDetailPK.setAssetSeqNo(storeOrderOutwards.get(k).getAssetSeqNo());
			billingResourceAssetDetailPK.setBillWorkSeqNo(billingWorkDetails.get(k).getBillWorkSeqNo());
			billingResourceAssetDetailPK.setResourceSeqNo(storeOrderOutwards.get(k).getItemSeqNo());
			billingResourceAssetDetail.setId(billingResourceAssetDetailPK);
			billingResourceAssetDetail.setQty(storeOrderOutwards.get(k).getQtyAllocated());				
			billingResourceAssetDetail = billingResourceAssetDetailsCUDRepo.save(billingResourceAssetDetail);
			}
			
	return;
}, asyncExecutor);
return future;
}

	
public CompletableFuture<Void> delBillData(Long sNo)
{
	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
	{
	CopyOnWriteArrayList<BillingMaster> billingMasters = billingMasterReadRepo.getSelectBillsForService(sNo);
	CopyOnWriteArrayList<Long> bNoList = new CopyOnWriteArrayList<Long>();
	CopyOnWriteArrayList<Long> bwNoList = new CopyOnWriteArrayList<Long>();
	
	if(billingMasters!=null)
	{
	for (int i = 0; i < billingMasters.size(); i++) 
	{
	bNoList.add(billingMasters.get(i).getBillSeqNo());	
	}
	
	CopyOnWriteArrayList<BillingWorkDetail> billingWorkDetails = billingWorkDetailsReadRepo.getSelectBillWorkDetailsForBills(bNoList);
	if(billingWorkDetails!=null)
	{
		for (int i = 0; i < billingMasters.size(); i++) 
		{
		bwNoList.add(billingWorkDetails.get(i).getBillWorkSeqNo());	
		}		
		billingWorkDetailsCUDRepo.delSelectBillWorkDetailsForBills(bNoList);
		billingResourceAssetDetailsCUDRepo.delSelectBillResourceAssetDetailsForBillWorks(bwNoList);		
	}
	}
	
return;
}, asyncExecutor);
return future;
	}
	
}