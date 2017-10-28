package org.hospital.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PositionpermissionId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PositionPermissionId implements java.io.Serializable {

	// Fields

	private Integer positionId;
	private Integer permissionId;

	// Constructors

	/** default constructor */
	public PositionPermissionId() {
	}

	/** full constructor */
	public PositionPermissionId(Integer positionId, Integer permissionId) {
		this.positionId = positionId;
		this.permissionId = permissionId;
	}

	// Property accessors

	@Column(name = "positionId", nullable = false)
	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@Column(name = "permissionId", nullable = false)
	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PositionPermissionId))
			return false;
		PositionPermissionId castOther = (PositionPermissionId) other;

		return ((this.getPositionId() == castOther.getPositionId()) || (this.getPositionId() != null
				&& castOther.getPositionId() != null && this.getPositionId().equals(
				castOther.getPositionId())))
				&& ((this.getPermissionId() == castOther.getPermissionId()) || (this
						.getPermissionId() != null && castOther.getPermissionId() != null && this
						.getPermissionId().equals(castOther.getPermissionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPositionId() == null ? 0 : this.getPositionId().hashCode());
		result = 37 * result + (getPermissionId() == null ? 0 : this.getPermissionId().hashCode());
		return result;
	}

}