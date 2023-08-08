package billing_work_details_mgmt.services.cud;

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

import billing_work_details_mgmt.model.dto.BillingWorkDetail_DTO;
import billing_work_details_mgmt.model.master.BillingWorkDetail;
import billing_work_details_mgmt.model.repo.cud.BillingWorkDetailsCUD_Repo;

@Service("billingWorkDetailCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BillingWorkDetailsCUD_Service implements I_BillingWorkDetailsCUD_Service 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(BillingWorkDetailService.class);

	@Autowired
	private BillingWorkDetailsCUD_Repo billingWorkDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<BillingWorkDetail_DTO> newBillWorkDetail(BillingWorkDetail_DTO billingWorkDetail_DTO) 
	{
		CompletableFuture<BillingWorkDetail_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			BillingWorkDetail_DTO jcmDTO = null;
			if (!billingWorkDetailsCUDRepo.existsById(billingWorkDetail_DTO.getBillSeqNo())) 
			{
				jcmDTO = this.getBillingWorkDetail_DTO(
						billingWorkDetailsCUDRepo.save(this.setBillingWorkDetail_DTO(billingWorkDetail_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updBillWorkDetail(BillingWorkDetail_DTO billingWorkDetail_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (billingWorkDetailsCUDRepo.existsById(billingWorkDetail_DTO.getBillSeqNo())) 
			{
				billingWorkDetailsCUDRepo.save(this.setBillingWorkDetail_DTO(billingWorkDetail_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> delSelectBillWorkDetails(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingWorkDetailsCUDRepo.deleteAllById(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillWorkDetailsForBills(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingWorkDetailsCUDRepo.delSelectBillWorkDetailsForBills(ids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillWorkDetailsForServices(CopyOnWriteArrayList<Long> sids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingWorkDetailsCUDRepo.delSelectBillWorkDetailsForServices(sids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillWorkDetailsForJobs(CopyOnWriteArrayList<Long> jids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingWorkDetailsCUDRepo.delSelectBillWorkDetailsForJobs(jids);
			return;
		}, asyncExecutor);

		return future;
	}
		
	@Override
	public CompletableFuture<Void> delAllBillWorkDetails() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingWorkDetailsCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
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

	private synchronized BillingWorkDetail setBillingWorkDetail_DTO(BillingWorkDetail_DTO billingWorkDetailDTO) 
	{
		BillingWorkDetail billingWorkDetail = new BillingWorkDetail();
		billingWorkDetail.setBillSeqNo(billingWorkDetailDTO.getBillSeqNo());
		billingWorkDetailDTO.setJobWorkSeqNo(billingWorkDetailDTO.getJobWorkSeqNo());
		billingWorkDetailDTO.setServiceWorkSeqNo(billingWorkDetailDTO.getServiceWorkSeqNo());
		return billingWorkDetail;
	}

}