package billing_work_details_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import billing_work_details_mgmt.model.dto.BillingWorkDetail_DTO;

public interface I_BillingWorkDetailsCUD_Service 
{	
	public CompletableFuture<BillingWorkDetail_DTO> newBillWorkDetail(BillingWorkDetail_DTO billingWorkDetail_DTO);
	public CompletableFuture<Void> updBillWorkDetail(BillingWorkDetail_DTO billingWorkDetail_DTO);
	public CompletableFuture<Void> delAllBillWorkDetails();
	public CompletableFuture<Void> delSelectBillWorkDetails(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectBillWorkDetailsForBills(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectBillWorkDetailsForServices(CopyOnWriteArrayList<Long> sids);
	public CompletableFuture<Void> delSelectBillWorkDetailsForJobs(CopyOnWriteArrayList<Long> jids);
}