package org.hospital.domain;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Billproject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "billproject", catalog = "hospitalsystem")
public class BillProject implements java.io.Serializable {

	// Fields

	private BillProjectId id;
	private Short number;
	private Double price;
	private Timestamp deadline;
	private String extraInfo;

	// Constructors

	/** default constructor */
	public BillProject() {
	}

	/** minimal constructor */
	public BillProject(BillProjectId id, Short number, Double price) {
		this.id = id;
		this.number = number;
		this.price = price;
	}

	/** full constructor */
	public BillProject(BillProjectId id, Short number, Double price, Timestamp deadline,
			String extraInfo) {
		this.id = id;
		this.number = number;
		this.price = price;
		this.deadline = deadline;
		this.extraInfo = extraInfo;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "billId", column = @Column(name = "billId", nullable = false)),
			@AttributeOverride(name = "projectId", column = @Column(name = "projectId", nullable = false)) })
	public BillProjectId getId() {
		return this.id;
	}

	public void setId(BillProjectId id) {
		this.id = id;
	}

	@Column(name = "number", nullable = false)
	public Short getNumber() {
		return this.number;
	}

	public void setNumber(Short number) {
		this.number = number;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "deadline", length = 19)
	public Timestamp getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	@Column(name = "extraInfo")
	public String getExtraInfo() {
		return this.extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

}