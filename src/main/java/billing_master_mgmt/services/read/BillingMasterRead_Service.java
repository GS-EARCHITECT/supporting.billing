package billing_master_mgmt.services.read;

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
import billing_master_mgmt.model.repo.read.BillingMasterRead_Repo;

@Service("billingMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BillingMasterRead_Service implements I_BillingMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(BillingMasterService.class);

	@Autowired
	private BillingMasterRead_Repo billingMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getAllBills()  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.findAll();
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBills(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBills(jcmSeqNos);
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForPartiesFrom(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsForPartiesFrom(pids);
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForPartiesTo(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsForPartiesTo(pids);
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsByBillingIds(CopyOnWriteArrayList<String> sids) 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsByBillingIds(sids);
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsPending();
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsDue(String dt) 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime pDTTm = LocalDateTime.parse(dt, formatter);
		Timestamp pTs = Timestamp.valueOf(pDTTm);		
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsDue(pTs);
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsDueBetweenTimes( String frDtTm, String toDtTm) 
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDTTm = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDTTm = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTs = Timestamp.valueOf(frDTTm);
		Timestamp toTs = Timestamp.valueOf(toDTTm);
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsDueBetweenETimes(frTs, toTs);
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForService(Long id)
	{
	CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
	{
	CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsForService(id);
	CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
	jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
	return jcmDTOs;
	},asyncExecutor);
	return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForServiceOkNotDone(Long id)
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<BillingMaster> billingList = (CopyOnWriteArrayList<BillingMaster>) billingMasterReadRepo.getSelectBillsForServiceOkNotDone(id);
		CopyOnWriteArrayList<BillingMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();
		jcmDTOs = billingList != null ? this.getBillingMaster_DTOs(billingList) : null;
		return jcmDTOs;
		},asyncExecutor);
		return future;
	}
	
	private synchronized CopyOnWriteArrayList<BillingMaster_DTO> getBillingMaster_DTOs(CopyOnWriteArrayList<BillingMaster> billingMasters) {
		BillingMaster_DTO billingDTO = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingDTOs = new CopyOnWriteArrayList<BillingMaster_DTO>();

		for (int i = 0; i < billingMasters.size(); i++) {
			billingDTO = getBillingMaster_DTO(billingMasters.get(i));
			billingDTOs.add(billingDTO);
		}
		return billingDTOs;
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

}