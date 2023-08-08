package billing_resourceasset_details_mgmt.services.cud;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import billing_resourceasset_details_mgmt.model.repo.cud.BillingResourceAssetDetailsCUD_Repo;

@Service("billingResourceAssetDetailsCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BillingResourceAssetDetailsCUD_Service implements I_BillingResourceAssetDetailsCUD_Service 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(BillingResourceAssetDetailService.class);

	@Autowired
	private BillingResourceAssetDetailsCUD_Repo billingResourceAssetDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<BillingResourceAssetDetail_DTO> newBillResourceAssetDetail(BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO) 
	{
		CompletableFuture<BillingResourceAssetDetail_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO2 = null;
			BillingResourceAssetDetailPK billingResourceAssetDetailPK = new BillingResourceAssetDetailPK(); 
			billingResourceAssetDetailPK.setAssetSeqNo(billingResourceAssetDetail_DTO.getAssetSeqNo());
			billingResourceAssetDetailPK.setBillWorkSeqNo(billingResourceAssetDetail_DTO.getBillWorkSeqNo());
			billingResourceAssetDetailPK.setResourceSeqNo(billingResourceAssetDetail_DTO.getResourceSeqNo());
			
			if (!billingResourceAssetDetailsCUDRepo.existsById(billingResourceAssetDetailPK)) 
			{
				billingResourceAssetDetail_DTO2 = this.getBillingResourceAssetDetail_DTO(
						billingResourceAssetDetailsCUDRepo.save(this.setBillingResourceAssetDetail_DTO(billingResourceAssetDetail_DTO)));
				}
			return billingResourceAssetDetail_DTO2;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updBillResourceAssetDetail(BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			BillingResourceAssetDetailPK billingResourceAssetDetailPK = new BillingResourceAssetDetailPK(); 
			billingResourceAssetDetailPK.setAssetSeqNo(billingResourceAssetDetail_DTO.getAssetSeqNo());
			billingResourceAssetDetailPK.setBillWorkSeqNo(billingResourceAssetDetail_DTO.getBillWorkSeqNo());
			billingResourceAssetDetailPK.setResourceSeqNo(billingResourceAssetDetail_DTO.getResourceSeqNo());
			
			if (billingResourceAssetDetailsCUDRepo.existsById(billingResourceAssetDetailPK)) 
			{
				billingResourceAssetDetailsCUDRepo.save(this.setBillingResourceAssetDetail_DTO(billingResourceAssetDetail_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> delSelectBillResourceAssetDetails(CopyOnWriteArrayList<BillingResourceAssetDetailPK> ids) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingResourceAssetDetailsCUDRepo.deleteAllById(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillResourceAssetDetailsForBillWorks(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingResourceAssetDetailsCUDRepo.delSelectBillResourceAssetDetailsForBillWorks(ids);
			return;
		}, asyncExecutor);

		return future;
	}

	
	@Override
	public CompletableFuture<Void> delAllBillResourceAssetDetails() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingResourceAssetDetailsCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
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

	private synchronized BillingResourceAssetDetail setBillingResourceAssetDetail_DTO(BillingResourceAssetDetail_DTO billingResourceAssetDetailDTO) 
	{
		BillingResourceAssetDetail billingResourceAssetDetail = new BillingResourceAssetDetail();
		BillingResourceAssetDetailPK billingResourceAssetDetailPK = new BillingResourceAssetDetailPK();
		billingResourceAssetDetailPK.setAssetSeqNo(billingResourceAssetDetailDTO.getAssetSeqNo());
		billingResourceAssetDetailPK.setBillWorkSeqNo(billingResourceAssetDetailDTO.getBillWorkSeqNo());
		billingResourceAssetDetailPK.setResourceSeqNo(billingResourceAssetDetailDTO.getResourceSeqNo());
		billingResourceAssetDetail.setId(billingResourceAssetDetailPK);
		billingResourceAssetDetail.setDisc(billingResourceAssetDetailDTO.getDisc());
		billingResourceAssetDetail.setDiscPerc(billingResourceAssetDetailDTO.getDiscPerc());
		billingResourceAssetDetail.setDuration(billingResourceAssetDetailDTO.getDuration());
		billingResourceAssetDetail.setDurationSeqNo(billingResourceAssetDetailDTO.getDurationSeqNo());
		billingResourceAssetDetail.setQty(billingResourceAssetDetailDTO.getQty());
		billingResourceAssetDetail.setQtyUnitSeqNo(billingResourceAssetDetailDTO.getQtyUnitSeqNo());
		billingResourceAssetDetail.setTax(billingResourceAssetDetailDTO.getTax());
		billingResourceAssetDetail.setTaxPerc(billingResourceAssetDetailDTO.getTaxPerc());				
		return billingResourceAssetDetail;
	}

}