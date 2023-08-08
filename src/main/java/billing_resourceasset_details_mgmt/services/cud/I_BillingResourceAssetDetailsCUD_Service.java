package billing_resourceasset_details_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import billing_resourceasset_details_mgmt.model.dto.BillingResourceAssetDetail_DTO;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;

public interface I_BillingResourceAssetDetailsCUD_Service 
{	
	public CompletableFuture<BillingResourceAssetDetail_DTO> newBillResourceAssetDetail(BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO);
	public CompletableFuture<Void> updBillResourceAssetDetail(BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO);
	public CompletableFuture<Void> delSelectBillResourceAssetDetails(CopyOnWriteArrayList<BillingResourceAssetDetailPK> ids);
	public CompletableFuture<Void> delSelectBillResourceAssetDetailsForBillWorks(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delAllBillResourceAssetDetails();
}