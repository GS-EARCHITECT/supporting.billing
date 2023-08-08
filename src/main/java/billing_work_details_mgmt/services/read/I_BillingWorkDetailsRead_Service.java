package billing_work_details_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import billing_work_details_mgmt.model.dto.BillingWorkDetail_DTO;

public interface I_BillingWorkDetailsRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getAllBillWorkDetails();
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetails( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForBills(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForServices(CopyOnWriteArrayList<Long> sids);
	public CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForJobs(CopyOnWriteArrayList<Long> jids);
}
	
	