package billing_master_mgmt.model.dto;

import java.io.Serializable;

public class BillingMaster_DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long billSeqNo;
	private Long byLocationSeqNo;
	private Long byPartySeqNo;
	private String dueDate;
	private Long preparedbySeqNo;
	private String printDate;
	private Long serviceWorkSeqNo;
	private Long toLocationSeqNo;
	private String toLocationTxt;
	private Long toPartySeqNo;
	private String billing_id;

	public BillingMaster_DTO() {
	}

	public Long getBillSeqNo() {
		return this.billSeqNo;
	}

	public void setBillSeqNo(Long billSeqNo) {
		this.billSeqNo = billSeqNo;
	}

	public Long getByLocationSeqNo() {
		return this.byLocationSeqNo;
	}

	public void setByLocationSeqNo(Long byLocationSeqNo) {
		this.byLocationSeqNo = byLocationSeqNo;
	}

	public Long getByPartySeqNo() {
		return this.byPartySeqNo;
	}

	public void setByPartySeqNo(Long byPartySeqNo) {
		this.byPartySeqNo = byPartySeqNo;
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Long getPreparedbySeqNo() {
		return this.preparedbySeqNo;
	}

	public void setPreparedbySeqNo(Long preparedbySeqNo) {
		this.preparedbySeqNo = preparedbySeqNo;
	}

	public String getPrintDate() {
		return this.printDate;
	}

	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	public Long getServiceWorkSeqNo() {
		return this.serviceWorkSeqNo;
	}

	public void setServiceWorkSeqNo(Long serviceWorkSeqNo) {
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}

	public Long getToLocationSeqNo() {
		return this.toLocationSeqNo;
	}

	public void setToLocationSeqNo(Long toLocationSeqNo) {
		this.toLocationSeqNo = toLocationSeqNo;
	}

	public String getToLocationTxt() {
		return this.toLocationTxt;
	}

	public void setToLocationTxt(String toLocationTxt) {
		this.toLocationTxt = toLocationTxt;
	}

	public Long getToPartySeqNo() {
		return this.toPartySeqNo;
	}

	public void setToPartySeqNo(Long toPartySeqNo) {
		this.toPartySeqNo = toPartySeqNo;
	}

	public String getBilling_id() {
		return billing_id;
	}

	public void setBilling_id(String billing_id) {
		this.billing_id = billing_id;
	}

	public BillingMaster_DTO(Long billSeqNo, Long byLocationSeqNo, Long byPartySeqNo, String dueDate,
			Long preparedbySeqNo, String printDate, Long serviceWorkSeqNo, Long toLocationSeqNo, String toLocationTxt,
			Long toPartySeqNo, String billing_id) {
		super();
		this.billSeqNo = billSeqNo;
		this.byLocationSeqNo = byLocationSeqNo;
		this.byPartySeqNo = byPartySeqNo;
		this.dueDate = dueDate;
		this.preparedbySeqNo = preparedbySeqNo;
		this.printDate = printDate;
		this.serviceWorkSeqNo = serviceWorkSeqNo;
		this.toLocationSeqNo = toLocationSeqNo;
		this.toLocationTxt = toLocationTxt;
		this.toPartySeqNo = toPartySeqNo;
		this.billing_id = billing_id;
	}

}