package billing_master_mgmt.model.repo.read;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import billing_master_mgmt.model.master.BillingMaster;

@Repository("billingMasterReadRepo")
public interface BillingMasterRead_Repo extends JpaRepository<BillingMaster, Long> 
{

	@Query(value = "select * from Billing_MASTER where bill_SEQ_NO in :ids ORDER BY bill_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBills(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Billing_MASTER where by_party_SEQ_NO in :pids ORDER BY bill_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsForPartiesFrom(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Billing_MASTER where to_party_SEQ_NO in :pids ORDER BY bill_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsForPartiesTo(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Billing_MASTER where upper(trim(billing_id)) in :sids ORDER BY bill_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsByBillingIds(@Param("sids") CopyOnWriteArrayList<String> sids);
	
	@Query(value = "SELECT * from  Billing_MASTER where print_date IS NULL ORDER BY bill_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsPending();
	
	@Query(value = "SELECT * from  Billing_MASTER where (print_date IS NULL and due_date < :dt) ORDER BY bill_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsDue(@Param("dt") Timestamp dt);
	
	@Query(value = "SELECT * FROM Billing_MASTER where (due_date <= :frDtTm and due_date >= :toDtTm) ORDER BY billing_sEQ_NO",nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsDueBetweenETimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "select * from Billing_MASTER where service_work_SEQ_NO = :id ", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsForService(@Param("id") Long id);

	@Query(value = "select * from Billing_MASTER where (service_work_SEQ_NO = :id and upper(trim(okflag)) <> 'Y')", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsForServiceNotOk(@Param("id") Long id);
	
	@Query(value = "select * from Billing_MASTER where (service_work_SEQ_NO = :id and upper(trim(okflag)) = 'Y' and upper(trim(doneflag)) <> 'Y')", nativeQuery = true)
	CopyOnWriteArrayList<BillingMaster> getSelectBillsForServiceOkNotDone(@Param("id") Long id);
	
}