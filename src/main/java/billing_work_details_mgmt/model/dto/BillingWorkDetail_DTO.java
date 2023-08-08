package billing_work_details_mgmt.model.dto;

import java.io.Serializable;

public class BillingWorkDetail_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4826760094903105020L;
	private Long billWorkSeqNo;
	private Long billSeqNo;
	private Long jobWorkSeqNo;
	private Long serviceWorkSeqNo;

	public Long getBillWorkSeqNo() {
		return billWorkSeqNo;
	}

	public void setBillWorkSeqNo(Long billWorkSeqNo) {
		this.billWorkSeqNo = billWorkSeqNo;
	}

	public Long getBillSeqNo() {
		return billSeqNo;
	}

	public void setBillSeqNo(Long billSeqNo) {
		this.billSeqNo = billSeqNo;
	}

	public Long getJobWorkSeqNo() {
		return jobWorkSeqNo;
	}

	public void setJobWorkSeqNo(Long jobWorkSeqNo) {
		this.jobWorkSeqNo = jobWorkSeqNo;
	}

	public Long getServiceWorkSeqNo() {
		return serviceWorkSeqNo;
	}

	public void setServiceWorkSeqNo(Long serviceWorkSeqNo) {
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}

	public BillingWorkDetail_DTO(Long billWorkSeqNo, Long billSeqNo, Long jobWorkSeqNo, Long serviceWorkSeqNo) {
		super();
		this.billWorkSeqNo = billWorkSeqNo;
		this.billSeqNo = billSeqNo;
		this.jobWorkSeqNo = jobWorkSeqNo;
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}

	public BillingWorkDetail_DTO() {
		super();
	}

}