package billing_resourceasset_details_mgmt.controller.read;

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

import billing_resourceasset_details_mgmt.model.dto.BillingResourceAssetDetail_DTO;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;
import billing_resourceasset_details_mgmt.services.read.I_BillingResourceAssetDetailsRead_Service;

@RestController
@RequestMapping("/billingResourceAssetDetailReadMgmt")
public class BillingResourceAssetDetailsRead_Controller {
	@Autowired
	private I_BillingResourceAssetDetailsRead_Service billingResourceAssetDetailsReadService;

	@GetMapping(value = "/getAllBillResourceAssetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getAllBillResourceAssetDetails() {
		CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingResourceAssetDetailsReadService.getAllBillResourceAssetDetails();
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

	@GetMapping(value = "/getSelectBillResourceAssetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getSelectBillResourceAssetDetails(
			@RequestBody CopyOnWriteArrayList<BillingResourceAssetDetailPK> billingResourceAssetDetailPKs) {
		CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingResourceAssetDetailsReadService.getSelectBillResourceAssetDetails(billingResourceAssetDetailPKs);
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

	@GetMapping(value = "/getSelectBillResourceAssetDetailsForBillWorks", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> getSelectBillResourceAssetDetailsForBillWorks(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<BillingResourceAssetDetail_DTO>> billingDetail_DTOs = null;
		CopyOnWriteArrayList<BillingResourceAssetDetail_DTO> billingDetailList = null;
		try {
			billingDetail_DTOs = billingResourceAssetDetailsReadService.getSelectBillResourceAssetDetailsForBillWorks(pids);
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