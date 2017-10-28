package org.hospital.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "permission", catalog = "hospitalsystem")
public class Permission implements java.io.Serializable {

	// Fields

	private Integer permissionId;
	private String name;

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** full constructor */
	public Permission(String name) {
		this.name = name;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "permissionId", unique = true, nullable = false)
	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}