package billing_resourceasset_details_mgmt.model.dto;

import java.io.Serializable;

public class BillingResourceAssetDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4894031545130990964L;
	private Long resourceSeqNo;
	private Long billWorkSeqNo;
	private Long assetSeqNo;
	private Float disc;
	private Float discPerc;
	private Float duration;
	private Long durationSeqNo;
	private Float qty;
	private Long qtyUnitSeqNo;
	private Float tax;
	private Float taxPerc;

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getBillWorkSeqNo() {
		return billWorkSeqNo;
	}

	public void setBillWorkSeqNo(Long billWorkSeqNo) {
		this.billWorkSeqNo = billWorkSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Float getDisc() {
		return disc;
	}

	public void setDisc(Float disc) {
		this.disc = disc;
	}

	public Float getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(Float discPerc) {
		this.discPerc = discPerc;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getDurationSeqNo() {
		return durationSeqNo;
	}

	public void setDurationSeqNo(Long durationSeqNo) {
		this.durationSeqNo = durationSeqNo;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getTaxPerc() {
		return taxPerc;
	}

	public void setTaxPerc(Float taxPerc) {
		this.taxPerc = taxPerc;
	}

	public BillingResourceAssetDetail_DTO(Long resourceSeqNo, Long billWorkSeqNo, Long assetSeqNo, Float disc,
			Float discPerc, Float duration, Long durationSeqNo, Float qty, Long qtyUnitSeqNo, Float tax,
			Float taxPerc) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.billWorkSeqNo = billWorkSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.disc = disc;
		this.discPerc = discPerc;
		this.duration = duration;
		this.durationSeqNo = durationSeqNo;
		this.qty = qty;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.tax = tax;
		this.taxPerc = taxPerc;
	}

	public BillingResourceAssetDetail_DTO() {
		super();
	}

}