package billing_scheduler_mgmt.model;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("jobWorkBillingDetailsReadRepo")
public interface JobWorkBillingDetailsRead_Repo extends JpaRepository<JobWorkDetail, Long> 
{	
	@Query(value = "SELECT * FROM JOB_DETAILS where SERVICE_WORK_SEQ_NO = :servWorkSeqNo ORDER BY job_work_seq_no",nativeQuery = true) 
	CopyOnWriteArrayList<JobWorkDetail> getSelectJobWorkDetailForService(@Param("servWorkSeqNo") Long servWorkSeqNo);
	
}