package billing_scheduler_mgmt.services;

import java.util.concurrent.CompletableFuture;

public interface I_BillingBatch_Service 
{
	public CompletableFuture<Void> createUpdateBill(Long sNo);
}