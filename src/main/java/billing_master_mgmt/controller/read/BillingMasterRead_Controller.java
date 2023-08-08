package billing_master_mgmt.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import billing_master_mgmt.model.dto.BillingMaster_DTO;
import billing_master_mgmt.services.read.I_BillingMasterRead_Service;

@RestController
@RequestMapping("/billingMasterReadMgmt")
public class BillingMasterRead_Controller {
	@Autowired
	private I_BillingMasterRead_Service billingMasterReadService;

	@GetMapping(value = "/getAllBills", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getAllBills() {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getAllBills();
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBills", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBills(
			@RequestBody CopyOnWriteArrayList<Long> billingMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBills(billingMasterSeqNos);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillsForPartiesFrom", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForPartiesFrom(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsForPartiesFrom(pids);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillsForPartiesTo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForPartiesTo(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsForPartiesTo(pids);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillsByBillingIds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsByBillingIds(
			@RequestBody CopyOnWriteArrayList<String> ids) {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsByBillingIds(ids);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillsPending()", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsPending() {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsPending();
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillsDue/{dt}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsDue(@PathVariable String dt) {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsDue(dt);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillsDueBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectWorksBetweenATimes(@PathVariable String fr,
			@PathVariable String to) {
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsDueBetweenTimes(fr, to);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectBillsForService/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForServices(@PathVariable Long id)
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsForService(id);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectBillsForServiceOkNotDone/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingMaster_DTO>> getSelectBillsForServiceOkNotDone(@PathVariable Long id)
	{
		CompletableFuture<CopyOnWriteArrayList<BillingMaster_DTO>> billingMaster_DTOs = null;
		CopyOnWriteArrayList<BillingMaster_DTO> billingMasterList = null;
		try {
			billingMaster_DTOs = billingMasterReadService.getSelectBillsForServiceOkNotDone(id);
			billingMasterList = billingMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingMasterList, HttpStatus.OK);
	}

}