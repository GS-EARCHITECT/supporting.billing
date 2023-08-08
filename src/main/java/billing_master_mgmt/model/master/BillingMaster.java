package billing_master_mgmt.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The persistent class for the BILLING_MASTER database table.
 * 
 */
@Entity
@Table(name = "BILLING_MASTER")
public class BillingMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_NO_SEQUENCE")
	@SequenceGenerator(name = "BILL_NO_SEQUENCE", sequenceName = "BILL_NO_SEQUENCE", allocationSize = 1)
	@Column(name = "BILL_SEQ_NO")
	private Long billSeqNo;

	@Column(name = "BY_LOCATION_SEQ_NO")
	private Long byLocationSeqNo;

	@Column(name = "BY_PARTY_SEQ_NO")
	private Long byPartySeqNo;

	@Column(name = "DUE_DATE")
	private Timestamp dueDate;

	@Column(name = "PREPAREDBY_SEQ_NO")
	private Long preparedbySeqNo;

	@Column(name = "PRINT_DATE")
	private Timestamp printDate;

	@Column(name = "SERVICE_WORK_SEQ_NO")
	private Long serviceWorkSeqNo;

	@Column(name = "TO_LOCATION_SEQ_NO")
	private Long toLocationSeqNo;

	@Column(name = "TO_LOCATION_TXT")
	private String toLocationTxt;
	
	@Column(name = "BILLING_ID")
	private String billing_id;
	
	@Column(name = "TO_PARTY_SEQ_NO")
	private Long toPartySeqNo;

	public BillingMaster() {
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

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Long getPreparedbySeqNo() {
		return this.preparedbySeqNo;
	}

	public void setPreparedbySeqNo(Long preparedbySeqNo) {
		this.preparedbySeqNo = preparedbySeqNo;
	}

	public Timestamp getPrintDate() {
		return this.printDate;
	}

	public void setPrintDate(Timestamp printDate)
	{
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billSeqNo == null) ? 0 : billSeqNo.hashCode());
		result = prime * result + ((byLocationSeqNo == null) ? 0 : byLocationSeqNo.hashCode());
		result = prime * result + ((byPartySeqNo == null) ? 0 : byPartySeqNo.hashCode());
		result = prime * result + ((toLocationSeqNo == null) ? 0 : toLocationSeqNo.hashCode());
		result = prime * result + ((toPartySeqNo == null) ? 0 : toPartySeqNo.hashCode());
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
		BillingMaster other = (BillingMaster) obj;
		if (billSeqNo == null) {
			if (other.billSeqNo != null)
				return false;
		} else if (!billSeqNo.equals(other.billSeqNo))
			return false;
		if (byLocationSeqNo == null) {
			if (other.byLocationSeqNo != null)
				return false;
		} else if (!byLocationSeqNo.equals(other.byLocationSeqNo))
			return false;
		if (byPartySeqNo == null) {
			if (other.byPartySeqNo != null)
				return false;
		} else if (!byPartySeqNo.equals(other.byPartySeqNo))
			return false;
		if (toLocationSeqNo == null) {
			if (other.toLocationSeqNo != null)
				return false;
		} else if (!toLocationSeqNo.equals(other.toLocationSeqNo))
			return false;
		if (toPartySeqNo == null) {
			if (other.toPartySeqNo != null)
				return false;
		} else if (!toPartySeqNo.equals(other.toPartySeqNo))
			return false;
		return true;
	}

	public BillingMaster(Long billSeqNo, Long byLocationSeqNo, Long byPartySeqNo, Timestamp dueDate,
			Long preparedbySeqNo, Timestamp printDate, Long serviceWorkSeqNo, Long toLocationSeqNo,
			String toLocationTxt, String billing_id, Long toPartySeqNo) {
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
		this.billing_id = billing_id;
		this.toPartySeqNo = toPartySeqNo;
	}

}