package billing_resourceasset_details_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetail;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;

@Repository("billingResourceAssetDetailCUDRepo")
public interface BillingResourceAssetDetailsCUD_Repo extends JpaRepository<BillingResourceAssetDetail, BillingResourceAssetDetailPK> 
{
	@Query(value = "delete from Billing_RESOURCEASSET_DETAILs where bill_work_SEQ_NO in :ids", nativeQuery = true)
	void delSelectBillResourceAssetDetailsForBillWorks(@Param("ids") CopyOnWriteArrayList<Long> ids);	
}