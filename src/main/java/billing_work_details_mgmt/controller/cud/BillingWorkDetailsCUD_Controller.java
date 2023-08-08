package billing_work_details_mgmt.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import billing_work_details_mgmt.model.dto.BillingWorkDetail_DTO;
import billing_work_details_mgmt.services.cud.I_BillingWorkDetailsCUD_Service;

@RestController
@RequestMapping("/billingWorkDetailsCUDMgmt")
public class BillingWorkDetailsCUD_Controller 
{
	@Autowired
	private I_BillingWorkDetailsCUD_Service billingWorkDetailsCUDService;

	@PostMapping("/newBillingWorkDetail")
	public ResponseEntity<BillingWorkDetail_DTO> newBillingWorkDetail(
			@RequestBody BillingWorkDetail_DTO billingWorkDetail_DTO) {
		CompletableFuture<BillingWorkDetail_DTO> future = null;
		BillingWorkDetail_DTO billingWorkDetail_DTO2 = null;
		try {
			future = billingWorkDetailsCUDService.newBillWorkDetail(billingWorkDetail_DTO);
			billingWorkDetail_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingWorkDetail_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updBillingWorkDetail")
	public void updBillingWorkDetail(@RequestBody BillingWorkDetail_DTO billingWorkDetail_DTO) 
	{
		billingWorkDetailsCUDService.updBillWorkDetail(billingWorkDetail_DTO);
		return;
	}

	@DeleteMapping("/delSelectBillWorkDetails")
	public void delSelectBillWorkDetails(@RequestBody CopyOnWriteArrayList<Long> pids) {
		billingWorkDetailsCUDService.delSelectBillWorkDetails(pids);
		return;
	}
	
	@DeleteMapping("/delSelectBillWorkDetailsForBills")
	public void delSelectBillWorkDetailsForBills(@RequestBody CopyOnWriteArrayList<Long> pids) {
		billingWorkDetailsCUDService.delSelectBillWorkDetailsForBills(pids);
		return;
	}

	@DeleteMapping("/delSelectBillWorkDetailsForServices")
	public void delSelectBillWorkDetailsForServices(@RequestBody CopyOnWriteArrayList<Long> pids) {
		billingWorkDetailsCUDService.delSelectBillWorkDetailsForServices(pids);
		return;
	}
	
	@DeleteMapping("/delSelectBillWorkDetailsForJobs")
	public void delSelectBillWorkDetailsForJobs(@RequestBody CopyOnWriteArrayList<Long> sids) 
	{
		billingWorkDetailsCUDService.delSelectBillWorkDetailsForJobs(sids);
		return;
	}
	
	@DeleteMapping("/delAllBillingWorkDetails")
	public void delAllBillingWorkDetails()
	{
		billingWorkDetailsCUDService.delAllBillWorkDetails();
		return;
	}

}