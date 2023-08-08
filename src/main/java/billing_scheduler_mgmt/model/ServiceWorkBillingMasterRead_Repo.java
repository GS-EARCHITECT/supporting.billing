package billing_scheduler_mgmt.model;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("serviceWorkBillingReadRepo")
public interface ServiceWorkBillingMasterRead_Repo extends JpaRepository<ServiceWorkMaster, Long> 
{
@Query(value = "SELECT * FROM SERVICE_WORK_MASTER where upper(trim(to_bill)) = 'Y' ORDER BY service_work_sEQ_NO",nativeQuery = true)
CopyOnWriteArrayList<ServiceWorkMaster> getSelectWorksBillPending();
}