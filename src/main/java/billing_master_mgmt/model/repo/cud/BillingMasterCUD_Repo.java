package billing_master_mgmt.model.repo.cud;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import billing_master_mgmt.model.master.BillingMaster;

@Repository("billingMasterCUDRepo")
public interface BillingMasterCUD_Repo extends JpaRepository<BillingMaster, Long> 
{

	@Query(value = "update  Billing_MASTER set okflag = :st where bill_SEQ_NO = :bid", nativeQuery = true)
	void updOkStatus(@Param("bid") Long bid, @Param("st") Character st);

	@Query(value = "update  Billing_MASTER set doneflag = :st where bill_SEQ_NO = :bid", nativeQuery = true)
	void updDoneStatus(@Param("bid") Long bid, @Param("st") Character st);
	
	@Query(value = "update  Billing_MASTER set print_date = :dt where bill_SEQ_NO = :bid", nativeQuery = true)
	void updBillPrintDate(@Param("bid") Long bid, @Param("dt") Timestamp dt);
	
	@Query(value = "update  Billing_MASTER set due_date = :dt where bill_SEQ_NO = :bid", nativeQuery = true)
	void updBillDueDate(@Param("bid") Long bid, @Param("dt") Timestamp dt);
	
	@Query(value = "delete from Billing_MASTER where billing_SEQ_NO in :ids ", nativeQuery = true)
	void delSelectBills(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  Billing_MASTER where by_party_SEQ_NO in :pids ", nativeQuery = true)
	void delSelectBillsForPartiesFrom(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Billing_MASTER where to_party_SEQ_NO in :pids ", nativeQuery = true)
	void delSelectBillsForPartiesTo(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  Billing_MASTER where upper(trim(billing_id)) in :sids ", nativeQuery = true)
	void delSelectBillsByBillingIds(@Param("sids") CopyOnWriteArrayList<String> sids);
	
	@Query(value = "SELECT * from  Billing_MASTER where print_date IS NULL ", nativeQuery = true)
	void delSelectBillsPending();
	
	@Query(value = "SELECT * from  Billing_MASTER where (print_date IS NULL and due_date < :dt) ", nativeQuery = true)
	void delSelectBillsDue(@Param("dt") Timestamp dt);
	
	@Query(value = "SELECT * FROM Billing_MASTER where (due_date <= :frDtTm and due_date >= :toDtTm) ORDER BY billing_sEQ_NO",nativeQuery = true)
	void delSelectBillsDueBetweenETimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
}