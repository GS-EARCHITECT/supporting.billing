package billing_master_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import billing_master_mgmt.model.dto.BillingMaster_DTO;

public interface I_BillingMasterRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getAllBills();
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBills( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForPartiesFrom( CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForPartiesTo( CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsByBillingIds( CopyOnWriteArrayList<String> sids);
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsPending();
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsDue(String dt);
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsDueBetweenTimes( String frDtTm, String toDtTm);
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForService(Long id);
	public CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForServiceOkNotDone(Long id);
}