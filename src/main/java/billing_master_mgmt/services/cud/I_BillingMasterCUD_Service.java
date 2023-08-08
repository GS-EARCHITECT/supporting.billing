package billing_master_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import billing_master_mgmt.model.dto.BillingMaster_DTO;

public interface I_BillingMasterCUD_Service 
{	
	public CompletableFuture<BillingMaster_DTO> newBill(BillingMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> updBill(BillingMaster_DTO shippingMaster_DTO);
	public CompletableFuture<Void> updBillPrintDate( Long bid,  String dt);
	public CompletableFuture<Void> updBillDueDate( Long bid,  String dt);
	public CompletableFuture<Void> delSelectBills( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectBillsForPartiesFrom( CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectBillsForPartiesTo( CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectBillsByBillingIds(CopyOnWriteArrayList<String> sids);
	public CompletableFuture<Void> delSelectBillsPending();
	public CompletableFuture<Void> delSelectBillsDue( String dt);
	public CompletableFuture<Void> delSelectBillsDueBetweenTimes(String frDtTm, String toDtTm);
	public CompletableFuture<Void> delAllBills();
}