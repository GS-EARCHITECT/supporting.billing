package billing_work_details_mgmt.services.read;

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

import billing_work_details_mgmt.model.dto.BillingWorkDetail_DTO;
import billing_work_details_mgmt.model.master.BillingWorkDetail;
import billing_work_details_mgmt.model.repo.read.BillingWorkDetailsRead_Repo;

@Service("billingWorkDetailsReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BillingWorkDetailsRead_Service implements I_BillingWorkDetailsRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(BillingWorkDetailService.class);

	@Autowired
	private BillingWorkDetailsRead_Repo billingWorkDetailsReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getAllBillWorkDetails()  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingWorkDetail> billingList = (CopyOnWriteArrayList<BillingWorkDetail>) billingWorkDetailsReadRepo.findAll();
		CopyOnWriteArrayList<BillingWorkDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingWorkDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingWorkDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetails(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingWorkDetail> billingList = (CopyOnWriteArrayList<BillingWorkDetail>) billingWorkDetailsReadRepo.findAllById(jcmSeqNos);
		CopyOnWriteArrayList<BillingWorkDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingWorkDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingWorkDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForBills(CopyOnWriteArrayList<Long> ids)  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingWorkDetail> billingList = (CopyOnWriteArrayList<BillingWorkDetail>) billingWorkDetailsReadRepo.getSelectBillWorkDetailsForBills(ids);
		CopyOnWriteArrayList<BillingWorkDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingWorkDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingWorkDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForServices(CopyOnWriteArrayList<Long> sids) 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingWorkDetail> billingList = (CopyOnWriteArrayList<BillingWorkDetail>) billingWorkDetailsReadRepo.getSelectBillWorkDetailsForServices(sids);
		CopyOnWriteArrayList<BillingWorkDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingWorkDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingWorkDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForJobs(CopyOnWriteArrayList<Long> jids) 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingWorkDetail> billingList = (CopyOnWriteArrayList<BillingWorkDetail>) billingWorkDetailsReadRepo.getSelectBillWorkDetailsForJobs(jids);
		CopyOnWriteArrayList<BillingWorkDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingWorkDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingWorkDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	private synchronized CopyOnWriteArrayList<BillingWorkDetail_DTO> getBillingWorkDetail_DTOs(CopyOnWriteArrayList<BillingWorkDetail> billingWorkDetails) {
		BillingWorkDetail_DTO billingDTO = null;
		CopyOnWriteArrayList<BillingWorkDetail_DTO> billingDTOs = new CopyOnWriteArrayList<BillingWorkDetail_DTO>();

		for (int i = 0; i < billingWorkDetails.size(); i++) {
			billingDTO = getBillingWorkDetail_DTO(billingWorkDetails.get(i));
			billingDTOs.add(billingDTO);
		}
		return billingDTOs;
	}

	private synchronized BillingWorkDetail_DTO getBillingWorkDetail_DTO(BillingWorkDetail billingWorkDetail2) 
	{
		BillingWorkDetail_DTO billingWorkDetailDTO = new BillingWorkDetail_DTO();
		billingWorkDetailDTO.setBillSeqNo(billingWorkDetail2.getBillSeqNo());
		billingWorkDetailDTO.setBillWorkSeqNo(billingWorkDetail2.getBillWorkSeqNo());
		billingWorkDetailDTO.setJobWorkSeqNo(billingWorkDetail2.getJobWorkSeqNo());
		billingWorkDetailDTO.setServiceWorkSeqNo(billingWorkDetail2.getServiceWorkSeqNo());
		return billingWorkDetailDTO;
	}

}