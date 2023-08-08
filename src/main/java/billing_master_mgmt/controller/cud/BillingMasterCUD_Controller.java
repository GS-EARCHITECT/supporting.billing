package billing_master_mgmt.controller.cud;

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
import billing_master_mgmt.model.dto.BillingMaster_DTO;
import billing_master_mgmt.services.cud.I_BillingMasterCUD_Service;

@RestController
@RequestMapping("/billingMasterCUDMgmt")
public class BillingMasterCUD_Controller {
	@Autowired
	private I_BillingMasterCUD_Service billingMasterCUDService;

	@PostMapping("/newBillingMaster")
	public ResponseEntity<BillingMaster_DTO> newBillingMaster(
			@RequestBody BillingMaster_DTO billingMaster_DTO) {
		CompletableFuture<BillingMaster_DTO> future = null;
		BillingMaster_DTO billingMaster_DTO2 = null;
		try {
			future = billingMasterCUDService.newBill(billingMaster_DTO);
			billingMaster_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMaster_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updBillingMaster")
	public void updBillingMaster(@RequestBody BillingMaster_DTO billingMaster_DTO) {
		billingMasterCUDService.updBill(billingMaster_DTO);
		return;
	}

	@PutMapping("/updBillPrintDate/{bid}/{pt}")
	public void updBillPrintDate(@PathVariable Long bid, @PathVariable String pt)
	{
		billingMasterCUDService.updBillPrintDate(bid, pt);
		return;
	}

	@PutMapping("/updBillDueDate/{bid}/{dt}")
	public void updBillDueDate(@PathVariable Long bid, @PathVariable String dt)
	{
		billingMasterCUDService.updBillDueDate(bid, dt);
		return;
	}
		
	@DeleteMapping("/delSelectBillingMasters")
	public void delSelectBillingMasters(@RequestBody CopyOnWriteArrayList<Long> pids) {
		billingMasterCUDService.delSelectBills(pids);
		return;
	}
	
	@DeleteMapping("/delSelectBillingMastersForPartiesFrom")
	public void delSelectBillingMastersForPartiesFrom(@RequestBody CopyOnWriteArrayList<Long> pids) {
		billingMasterCUDService.delSelectBillsForPartiesFrom(pids);
		return;
	}

	@DeleteMapping("/delSelectBillingMastersForPartiesTo")
	public void delSelectBillingMastersForPartiesTo(@RequestBody CopyOnWriteArrayList<Long> pids) {
		billingMasterCUDService.delSelectBillsForPartiesTo(pids);
		return;
	}
	
	@DeleteMapping("/delSelectBillingMastersByBillingIds")
	public void delSelectBillingMastersByBillingIds(@RequestBody CopyOnWriteArrayList<String> sids) 
	{
		billingMasterCUDService.delSelectBillsByBillingIds(sids);
		return;
	}
	
	@DeleteMapping("/delSelectBillingMastersPending")
	public void delSelectBillingMastersPending(@RequestBody CopyOnWriteArrayList<Long> pids) {
		billingMasterCUDService.delSelectBillsPending();
		return;
	}

	@DeleteMapping("/delSelectBillsDue/{dd}")
	public void delSelectBillsDue(@PathVariable String dd) 
	{
		billingMasterCUDService.delSelectBillsDue(dd);
		return;
	}

	@DeleteMapping("/delSelectBillsDueBetweenTimes/{fr}/{to}")
	public void delSelectBillsDueBetweenTimes(@PathVariable String fr, @PathVariable String to) 
	{
		billingMasterCUDService.delSelectBillsDueBetweenTimes(fr, to);
		return;
	}
	
	@DeleteMapping("/delAllBillingMasters")
	public void delAllBillingMasters()
	{
		billingMasterCUDService.delAllBills();
		return;
	}

}