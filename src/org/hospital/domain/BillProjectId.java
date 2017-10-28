package org.hospital.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BillprojectId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class BillProjectId implements java.io.Serializable {

	// Fields

	private Long billId;
	private Long projectId;

	// Constructors

	/** default constructor */
	public BillProjectId() {
	}

	/** full constructor */
	public BillProjectId(Long billId, Long projectId) {
		this.billId = billId;
		this.projectId = projectId;
	}

	// Property accessors

	@Column(name = "billId", nullable = false)
	public Long getBillId() {
		return this.billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	@Column(name = "projectId", nullable = false)
	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BillProjectId))
			return false;
		BillProjectId castOther = (BillProjectId) other;

		return ((this.getBillId() == castOther.getBillId()) || (this.getBillId() != null
				&& castOther.getBillId() != null && this.getBillId().equals(castOther.getBillId())))
				&& ((this.getProjectId() == castOther.getProjectId()) || (this.getProjectId() != null
						&& castOther.getProjectId() != null && this.getProjectId().equals(
						castOther.getProjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBillId() == null ? 0 : this.getBillId().hashCode());
		result = 37 * result + (getProjectId() == null ? 0 : this.getProjectId().hashCode());
		return result;
	}

}