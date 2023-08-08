package billing_resourceasset_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BILLING_RESOURCEASSET_DETAILS database table.
 * 
 */
@Embeddable
public class BillingResourceAssetDetailPK implements Serializable 
{
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name="BILL_WORK_SEQ_NO")
	private Long billWorkSeqNo;

	@Column(name="ASSET_SEQ_NO")
	private Long assetSeqNo;

	public BillingResourceAssetDetailPK() {
	}
	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}
	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}
	public Long getBillWorkSeqNo() {
		return this.billWorkSeqNo;
	}
	public void setBillWorkSeqNo(Long billWorkSeqNo) {
		this.billWorkSeqNo = billWorkSeqNo;
	}
	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}
	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BillingResourceAssetDetailPK)) {
			return false;
		}
		BillingResourceAssetDetailPK castOther = (BillingResourceAssetDetailPK)other;
		return 
			(this.resourceSeqNo == castOther.resourceSeqNo)
			&& (this.billWorkSeqNo == castOther.billWorkSeqNo)
			&& (this.assetSeqNo == castOther.assetSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.resourceSeqNo ^ (this.resourceSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.billWorkSeqNo ^ (this.billWorkSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));
		
		return hash;
	}
}