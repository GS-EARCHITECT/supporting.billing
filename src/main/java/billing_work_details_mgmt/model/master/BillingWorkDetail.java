package billing_work_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the BILLING_WORK_DETAILS database table.
 * 
 */
@Entity
@Table(name = "BILLING_WORK_DETAILS")
public class BillingWorkDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_WORK_SEQUENCE")
	@SequenceGenerator(name = "BILL_WORK_SEQUENCE", sequenceName = "BILL_WORK_SEQUENCE", allocationSize = 1)
	@Column(name = "BILL_WORK_SEQ_NO")
	private Long billWorkSeqNo;

	@Column(name = "BILL_SEQ_NO")
	private Long billSeqNo;

	@Column(name = "JOB_WORK_SEQ_NO")
	private Long jobWorkSeqNo;

	@Column(name = "SERVICE_WORK_SEQ_NO")
	private Long serviceWorkSeqNo;

	public BillingWorkDetail() {
	}

	public Long getBillWorkSeqNo() {
		return this.billWorkSeqNo;
	}

	public void setBillWorkSeqNo(Long billWorkSeqNo) {
		this.billWorkSeqNo = billWorkSeqNo;
	}

	public Long getBillSeqNo() {
		return this.billSeqNo;
	}

	public void setBillSeqNo(Long billSeqNo) {
		this.billSeqNo = billSeqNo;
	}

	public Long getJobWorkSeqNo() {
		return this.jobWorkSeqNo;
	}

	public void setJobWorkSeqNo(Long jobWorkSeqNo) {
		this.jobWorkSeqNo = jobWorkSeqNo;
	}

	public Long getServiceWorkSeqNo() {
		return this.serviceWorkSeqNo;
	}

	public void setServiceWorkSeqNo(Long serviceWorkSeqNo) {
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billSeqNo == null) ? 0 : billSeqNo.hashCode());
		result = prime * result + ((billWorkSeqNo == null) ? 0 : billWorkSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingWorkDetail other = (BillingWorkDetail) obj;
		if (billSeqNo == null) {
			if (other.billSeqNo != null)
				return false;
		} else if (!billSeqNo.equals(other.billSeqNo))
			return false;
		if (billWorkSeqNo == null) {
			if (other.billWorkSeqNo != null)
				return false;
		} else if (!billWorkSeqNo.equals(other.billWorkSeqNo))
			return false;
		return true;
	}

	public BillingWorkDetail(Long billWorkSeqNo, Long billSeqNo, Long jobWorkSeqNo, Long serviceWorkSeqNo) {
		super();
		this.billWorkSeqNo = billWorkSeqNo;
		this.billSeqNo = billSeqNo;
		this.jobWorkSeqNo = jobWorkSeqNo;
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}

}