package billing_work_details_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import billing_work_details_mgmt.model.master.BillingWorkDetail;

@Repository("billingWorkDetailCUDRepo")
public interface BillingWorkDetailsCUD_Repo extends JpaRepository<BillingWorkDetail, Long> 
{

	@Query(value = "update  Billing_WORK_DETAILs set okflag = :st where bill_work_SEQ_NO = :bid", nativeQuery = true)
	void updOkStatus(@Param("bid") Long bid, @Param("st") Character st);

	@Query(value = "update  Billing_WORK_DETAILs set doneflag = :st where bill_work_SEQ_NO = :bid", nativeQuery = true)
	void updDoneStatus(@Param("bid") Long bid, @Param("st") Character st);

	@Query(value = "delete from Billing_WORK_DETAILs where bill_SEQ_NO in :ids ", nativeQuery = true)
	void delSelectBillWorkDetailsForBills(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Billing_WORK_DETAILs where service_work_SEQ_NO in :sids ", nativeQuery = true)
	void delSelectBillWorkDetailsForServices(@Param("sids") CopyOnWriteArrayList<Long> sids);

	@Query(value = "SELECT * from  Billing_WORK_DETAILs where job_work_SEQ_NO in :jids ", nativeQuery = true)
	void delSelectBillWorkDetailsForJobs(@Param("jids") CopyOnWriteArrayList<Long> jids);
	
}