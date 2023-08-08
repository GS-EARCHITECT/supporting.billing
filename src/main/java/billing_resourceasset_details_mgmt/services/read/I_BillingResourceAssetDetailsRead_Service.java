package billing_resourceasset_details_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import billing_resourceasset_details_mgmt.model.dto.BillingResourceAssetDetail_DTO;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;

public interface I_BillingResourceAssetDetailsRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getAllBillResourceAssetDetails();
	public CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getSelectBillResourceAssetDetails( CopyOnWriteArrayList<BillingResourceAssetDetailPK> ids);
	public CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getSelectBillResourceAssetDetailsForBillWorks(CopyOnWriteArrayList<Long> ids);
	}
	
	