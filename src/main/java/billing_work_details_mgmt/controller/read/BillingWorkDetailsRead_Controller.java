package billing_work_details_mgmt.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import billing_work_details_mgmt.model.dto.BillingWorkDetail_DTO;
import billing_work_details_mgmt.services.read.I_BillingWorkDetailsRead_Service;

@RestController
@RequestMapping("/billingWorkDetailReadMgmt")
public class BillingWorkDetailsRead_Controller {
	@Autowired
	private I_BillingWorkDetailsRead_Service billingWorkDetailsReadService;

	@GetMapping(value = "/getAllBillWorkDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getAllBillWorkDetails() {
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingWorkDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingWorkDetailsReadService.getAllBillWorkDetails();
			billingDetailList = billingDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillWorkDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetails(
			@RequestBody CopyOnWriteArrayList<Long> billingDetailSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingWorkDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingWorkDetailsReadService.getSelectBillWorkDetails(billingDetailSeqNos);
			billingDetailList = billingDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillWorkDetailsForBills", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForPartiesFrom(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingWorkDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingWorkDetailsReadService.getSelectBillWorkDetailsForBills(pids);
			billingDetailList = billingDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillWorkDetailsForServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsForServices(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingWorkDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingWorkDetailsReadService.getSelectBillWorkDetailsForServices(pids);
			billingDetailList = billingDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBillWorkDetailsForJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingWorkDetail_DTO>> getSelectBillWorkDetailsByBillingIds(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<BillingWorkDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingWorkDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingWorkDetailsReadService.getSelectBillWorkDetailsForJobs(ids);
			billingDetailList = billingDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingDetailList, HttpStatus.OK);
	}
	
}