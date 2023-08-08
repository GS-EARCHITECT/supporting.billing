package billing_work_details_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import billing_work_details_mgmt.model.master.BillingWorkDetail;

@Repository("billingWorkDetailsReadRepo")
public interface BillingWorkDetailsRead_Repo extends JpaRepository<BillingWorkDetail, Long> 
{

	@Query(value = "select * from Billing_WORK_DETAILs where bill_SEQ_NO in :ids ORDER BY bill_work_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingWorkDetail> getSelectBillWorkDetailsForBills(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Billing_WORK_DETAILs where service_work_SEQ_NO in :sids ORDER BY bill_work_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingWorkDetail> getSelectBillWorkDetailsForServices(@Param("sids") CopyOnWriteArrayList<Long> sids);

	@Query(value = "SELECT * from  Billing_WORK_DETAILs where job_work_SEQ_NO in :jids ORDER BY bill_work_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingWorkDetail> getSelectBillWorkDetailsForJobs(@Param("jids") CopyOnWriteArrayList<Long> jids);

	
}