package billing_resourceasset_details_mgmt.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import billing_resourceasset_details_mgmt.model.dto.BillingResourceAssetDetail_DTO;
import billing_resourceasset_details_mgmt.model.master.BillingResourceAssetDetailPK;
import billing_resourceasset_details_mgmt.services.cud.I_BillingResourceAssetDetailsCUD_Service;

@RestController
@RequestMapping("/billingResourceAssetDetailsCUDMgmt")
public class BillingResourceAssetDetailsCUD_Controller {
	@Autowired
	private I_BillingResourceAssetDetailsCUD_Service billingResourceAssetDetailsCUDService;

	@PostMapping("/newBillingResourceAssetDetail")
	public ResponseEntity<BillingResourceAssetDetail_DTO> newBillingResourceAssetDetail(
			@RequestBody BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO) {
		CompletableFuture<BillingResourceAssetDetail_DTO> future = null;
		BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO2 = null;
		try {
			future = billingResourceAssetDetailsCUDService.newBillResourceAssetDetail(billingResourceAssetDetail_DTO);
			billingResourceAssetDetail_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(billingResourceAssetDetail_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updBillingResourceAssetDetail")
	public void updBillingResourceAssetDetail(
			@RequestBody BillingResourceAssetDetail_DTO billingResourceAssetDetail_DTO) {
		billingResourceAssetDetailsCUDService.updBillResourceAssetDetail(billingResourceAssetDetail_DTO);
		return;
	}

	@DeleteMapping("/delSelectBillResourceAssetDetails")
	public void delSelectBillResourceAssetDetails(
			@RequestBody CopyOnWriteArrayList<BillingResourceAssetDetailPK> pids) {
		billingResourceAssetDetailsCUDService.delSelectBillResourceAssetDetails(pids);
		return;
	}

	@DeleteMapping("/delSelectBillResourceAssetDetailsForBillWorks")
	public void delSelectBillResourceAssetDetailsForBillWorks(@RequestBody CopyOnWriteArrayList<Long> ids) {
		billingResourceAssetDetailsCUDService.delSelectBillResourceAssetDetailsForBillWorks(ids);
		return;
	}

	@DeleteMapping("/delAllBillingResourceAssetDetails")
	public void delAllBillingResourceAssetDetails() {
		billingResourceAssetDetailsCUDService.delAllBillResourceAssetDetails();
		return;
	}

}