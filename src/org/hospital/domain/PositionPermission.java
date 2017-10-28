package org.hospital.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Positionpermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "positionpermission", catalog = "hospitalsystem")
public class PositionPermission implements java.io.Serializable {

	// Fields

	private PositionPermissionId id;

	// Constructors

	/** default constructor */
	public PositionPermission() {
	}

	/** full constructor */
	public PositionPermission(PositionPermissionId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "positionId", column = @Column(name = "positionId", nullable = false)),
			@AttributeOverride(name = "permissionId", column = @Column(name = "permissionId", nullable = false)) })
	public PositionPermissionId getId() {
		return this.id;
	}

	public void setId(PositionPermissionId id) {
		this.id = id;
	}

}