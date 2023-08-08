package billing_resourceasset_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the BILLING_RESOURCEASSET_DETAILS database table.
 * 
 */
@Entity
@Table(name = "BILLING_RESOURCEASSET_DETAILS")
public class BillingResourceAssetDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BillingResourceAssetDetailPK id;

	@Column(name = "DISC")
	private Float disc;

	@Column(name = "DISC_PERC")
	private Float discPerc;

	@Column(name = "DURATION")
	private Float duration;

	@Column(name = "DURATION_SEQ_NO")
	private Long durationSeqNo;

	@Column(name = "QTY")
	private Float qty;

	@Column(name = "QTY_UNIT_SEQ_NO")
	private Long qtyUnitSeqNo;

	@Column(name = "TAX")
	private Float tax;

	@Column(name = "TAX_PERC")
	private Float taxPerc;

	public BillingResourceAssetDetail() {
	}

	public BillingResourceAssetDetailPK getId() {
		return this.id;
	}

	public void setId(BillingResourceAssetDetailPK id) {
		this.id = id;
	}

	public Float getDisc() {
		return this.disc;
	}

	public void setDisc(Float disc) {
		this.disc = disc;
	}

	public Float getDiscPerc() {
		return this.discPerc;
	}

	public void setDiscPerc(Float discPerc) {
		this.discPerc = discPerc;
	}

	public Float getDuration() {
		return this.duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getDurationSeqNo() {
		return this.durationSeqNo;
	}

	public void setDurationSeqNo(Long durationSeqNo) {
		this.durationSeqNo = durationSeqNo;
	}

	public Float getQty() {
		return this.qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtyUnitSeqNo() {
		return this.qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Float getTax() {
		return this.tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getTaxPerc() {
		return this.taxPerc;
	}

	public void setTaxPerc(Float taxPerc) {
		this.taxPerc = taxPerc;
	}

	public BillingResourceAssetDetail(BillingResourceAssetDetailPK id, Float disc, Float discPerc, Float duration,
			Long durationSeqNo, Float qty, Long qtyUnitSeqNo, Float tax, Float taxPerc) {
		super();
		this.id = id;
		this.disc = disc;
		this.discPerc = discPerc;
		this.duration = duration;
		this.durationSeqNo = durationSeqNo;
		this.qty = qty;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.tax = tax;
		this.taxPerc = taxPerc;
	}

}