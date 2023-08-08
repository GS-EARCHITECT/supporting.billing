package billing_resourceasset_details_mgmt.services.read;

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
import billing_resourceasset_details_mgmt.model.dto.BillingResourceAssetDetail_DTO;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetail;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;
import billing_resourceasset_details_mgmt.model.repo.read.BillingResourceAssetDetailsRead_Repo;

@Service("billingResourceAssetDetailsReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BillingResourceAssetDetailsRead_Service implements I_BillingResourceAssetDetailsRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(BillingResourceAssetDetailService.class);

	@Autowired
	private BillingResourceAssetDetailsRead_Repo billingResourceAssetDetailsReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getAllBillResourceAssetDetails()  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingResourceAssetDetail> billingList = (CopyOnWriteArrayList<BillingResourceAssetDetail>) billingResourceAssetDetailsReadRepo.findAll();
		CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingResourceAssetDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getSelectBillResourceAssetDetails(CopyOnWriteArrayList<BillingResourceAssetDetailPK> billingResourceAssetDetailPKs)  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingResourceAssetDetail> billingList = (CopyOnWriteArrayList<BillingResourceAssetDetail>) billingResourceAssetDetailsReadRepo.findAllById(billingResourceAssetDetailPKs);
		CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingResourceAssetDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getSelectBillResourceAssetDetailsForBillWorks(CopyOnWriteArrayList<Long> ids)  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingResourceAssetDetail> billingList = (CopyOnWriteArrayList<BillingResourceAssetDetail>) billingResourceAssetDetailsReadRepo.getSelectBillResourceAssetDetailsForBillWorks(ids);
		CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>();
		jcmDTOs = billingList != null ? this.getBillingResourceAssetDetail_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	private synchronized CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> getBillingResourceAssetDetail_DTOs(CopyOnWriteArrayList<BillingResourceAssetDetail> billingResourceAssetDetails) {
		BillingResourceAssetDetail_DTO billingDTO = null;
		CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> billingDTOs = new CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>();

		for (int i = 0; i < billingResourceAssetDetails.size(); i++) {
			billingDTO = getBillingResourceAssetDetail_DTO(billingResourceAssetDetails.get(i));
			billingDTOs.add(billingDTO);
		}
		return billingDTOs;
	}

	private synchronized BillingResourceAssetDetail_DTO getBillingResourceAssetDetail_DTO(BillingResourceAssetDetail billingResourceAssetDetail) 
	{
		BillingResourceAssetDetail_DTO billingResourceAssetDetailDTO = new BillingResourceAssetDetail_DTO();
		billingResourceAssetDetailDTO.setAssetSeqNo(billingResourceAssetDetail.getId().getAssetSeqNo());
		billingResourceAssetDetailDTO.setBillWorkSeqNo(billingResourceAssetDetail.getId().getBillWorkSeqNo());
		billingResourceAssetDetailDTO.setDisc(billingResourceAssetDetail.getDisc());
		billingResourceAssetDetailDTO.setDiscPerc(billingResourceAssetDetail.getDiscPerc());
		billingResourceAssetDetailDTO.setDuration(billingResourceAssetDetail.getDuration());
		billingResourceAssetDetailDTO.setDurationSeqNo(billingResourceAssetDetail.getDurationSeqNo());
		billingResourceAssetDetailDTO.setQty(billingResourceAssetDetail.getQty());
		billingResourceAssetDetailDTO.setQtyUnitSeqNo(billingResourceAssetDetail.getQtyUnitSeqNo());
		billingResourceAssetDetailDTO.setTax(billingResourceAssetDetail.getTax());
		billingResourceAssetDetailDTO.setTaxPerc(billingResourceAssetDetail.getTaxPerc());
		billingResourceAssetDetailDTO.setResourceSeqNo(billingResourceAssetDetail.getId().getResourceSeqNo());		
		return billingResourceAssetDetailDTO;
	}

}