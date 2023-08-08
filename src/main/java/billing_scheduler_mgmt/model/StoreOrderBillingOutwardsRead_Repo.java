package billing_scheduler_mgmt.model;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("storeOrderBillingOutwardsRepo")
public interface StoreOrderBillingOutwardsRead_Repo extends JpaRepository<StoreOrderOutward, Long> 
{
@Query(value = "SELECT * FROM STORE_ORDER_outwards where job_work_seq_no in :ids ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<StoreOrderOutward> getAllOrderOutwards(@Param("ids") CopyOnWriteArrayList<Long> ids);


} 

