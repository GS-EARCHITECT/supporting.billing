package billing_resourceasset_details_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetail;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;

@Repository("billingResourceAssetDetailsReadRepo")
public interface BillingResourceAssetDetailsRead_Repo extends JpaRepository<BillingResourceAssetDetail, BillingResourceAssetDetailPK> 
{

	@Query(value = "select * from Billing_RESOURCEASSET_DETAILs where bill_work_SEQ_NO in :ids ORDER BY bill_work_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingResourceAssetDetail> getSelectBillResourceAssetDetailsForBillWorks(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
}