package billing_master_mgmt.services.cud;

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
import billing_master_mgmt.model.dto.BillingMaster_DTO;
import billing_master_mgmt.model.master.BillingMaster;
import billing_master_mgmt.model.repo.cud.BillingMasterCUD_Repo;

@Service("billingMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BillingMasterCUD_Service implements I_BillingMasterCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(BillingMasterService.class);

	@Autowired
	private BillingMasterCUD_Repo billingMasterCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<BillingMaster_DTO> newBill(BillingMaster_DTO billingMaster_DTO) {
		CompletableFuture<BillingMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			BillingMaster_DTO jcmDTO = null;
			if (!billingMasterCUDRepo.existsById(billingMaster_DTO.getBillSeqNo())) 
			{
				jcmDTO = this.getBillingMaster_DTO(
						billingMasterCUDRepo.save(this.setBillingMaster_DTO(billingMaster_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updBill(BillingMaster_DTO billingMaster_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (billingMasterCUDRepo.existsById(billingMaster_DTO.getBillSeqNo())) 
			{
				billingMasterCUDRepo.save(this.setBillingMaster_DTO(billingMaster_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updBillPrintDate( Long bid,  String dt) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime dTTm = LocalDateTime.parse(dt, formatter);
			Timestamp toTs = Timestamp.valueOf(dTTm);
			billingMasterCUDRepo.updBillPrintDate(bid, toTs);
			return;
		}, asyncExecutor);

		return future;
	}
	
	@Override
	public CompletableFuture<Void> updBillDueDate( Long bid,  String dt) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime dTTm = LocalDateTime.parse(dt, formatter);
			Timestamp toTs = Timestamp.valueOf(dTTm);
			billingMasterCUDRepo.updBillDueDate(bid, toTs);
			return;
		}, asyncExecutor);

		return future;
	}
	
	
	@Override
	public CompletableFuture<Void> delSelectBills(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingMasterCUDRepo.delSelectBills(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillsForPartiesFrom(CopyOnWriteArrayList<Long> pids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingMasterCUDRepo.delSelectBillsForPartiesFrom(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillsForPartiesTo(CopyOnWriteArrayList<Long> pids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingMasterCUDRepo.delSelectBillsForPartiesTo(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillsByBillingIds(CopyOnWriteArrayList<String> sids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingMasterCUDRepo.delSelectBillsByBillingIds(sids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillsPending()
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingMasterCUDRepo.delSelectBillsPending();
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillsDue(String dt) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime dTTm = LocalDateTime.parse(dt, formatter);
			Timestamp dTs = Timestamp.valueOf(dTTm);			
			billingMasterCUDRepo.delSelectBillsDue(dTs);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectBillsDueBetweenTimes(String frDtTm, String toDtTm) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
			LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frTs = Timestamp.valueOf(frDTTm);
			Timestamp toTs = Timestamp.valueOf(toDTTm);
			billingMasterCUDRepo.delSelectBillsDueBetweenETimes(frTs, toTs);
			return;
		}, asyncExecutor);

		return future;
	}
	
	@Override
	public CompletableFuture<Void> delAllBills() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			billingMasterCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized BillingMaster_DTO getBillingMaster_DTO(BillingMaster billingMaster2) 
	{
		BillingMaster_DTO billingMasterDTO = new BillingMaster_DTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		billingMasterDTO.setDueDate(formatter.format(billingMaster2.getDueDate().toLocalDateTime()));
		billingMasterDTO.setPrintDate(formatter.format(billingMaster2.getPrintDate().toLocalDateTime()));
		billingMasterDTO.setBilling_id(billingMaster2.getBilling_id());
		billingMasterDTO.setByLocationSeqNo(billingMaster2.getByLocationSeqNo());
		billingMasterDTO.setByLocationSeqNo(billingMaster2.getByLocationSeqNo());
		billingMasterDTO.setByPartySeqNo(billingMaster2.getByPartySeqNo());
		billingMasterDTO.setToPartySeqNo(billingMaster2.getToPartySeqNo());
		billingMasterDTO.setPreparedbySeqNo(billingMaster2.getPreparedbySeqNo());
		billingMasterDTO.setServiceWorkSeqNo(billingMaster2.getServiceWorkSeqNo());
		billingMasterDTO.setToLocationSeqNo(billingMaster2.getToLocationSeqNo());
		billingMasterDTO.setToLocationTxt(billingMaster2.getToLocationTxt());
		billingMasterDTO.setToPartySeqNo(billingMaster2.getToPartySeqNo());
		return billingMasterDTO;
	}

	private synchronized BillingMaster setBillingMaster_DTO(BillingMaster_DTO billingMasterDTO) {
		BillingMaster billingMaster = new BillingMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime pd = LocalDateTime.parse(billingMasterDTO.getPrintDate(), formatter);
		LocalDateTime dd = LocalDateTime.parse(billingMasterDTO.getDueDate(), formatter);
		Timestamp pds = Timestamp.valueOf(pd);		
		Timestamp dds = Timestamp.valueOf(dd);
		billingMaster.setDueDate(pds);
		billingMaster.setPrintDate(pds);
		billingMaster.setBilling_id(billingMasterDTO.getBilling_id());
		billingMaster.setByLocationSeqNo(billingMasterDTO.getByLocationSeqNo());
		billingMaster.setByLocationSeqNo(billingMasterDTO.getByLocationSeqNo());
		billingMaster.setByPartySeqNo(billingMasterDTO.getByPartySeqNo());
		billingMaster.setToPartySeqNo(billingMasterDTO.getToPartySeqNo());
		billingMaster.setPreparedbySeqNo(billingMasterDTO.getPreparedbySeqNo());
		billingMaster.setServiceWorkSeqNo(billingMasterDTO.getServiceWorkSeqNo());
		billingMaster.setToLocationSeqNo(billingMasterDTO.getToLocationSeqNo());
		billingMaster.setToLocationTxt(billingMasterDTO.getToLocationTxt());
		billingMaster.setToPartySeqNo(billingMasterDTO.getToPartySeqNo());
		return billingMaster;
	}

}