package org.hospital.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "project", catalog = "hospitalsystem")
public class Project implements java.io.Serializable {

	// Fields

	private Long projectId;
	private Employee employee;
	private String category;
	private String name;
	private Long unitPrice;
	private String introduction;
	private Short suggestNumber;
	private Short type;
	private Short status;
	private Timestamp createTime;
	private Set<ClientTreatmentProject> clienttreatmentprojects = new HashSet<ClientTreatmentProject>(
			0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** minimal constructor */
	public Project(Employee employee, String category, String name, Long unitPrice,
			Short suggestNumber, Short type, Short status, Timestamp createTime) {
		this.employee = employee;
		this.category = category;
		this.name = name;
		this.unitPrice = unitPrice;
		this.suggestNumber = suggestNumber;
		this.type = type;
		this.status = status;
		this.createTime = createTime;
	}

	/** full constructor */
	public Project(Employee employee, String category, String name, Long unitPrice,
			String introduction, Short suggestNumber, Short type, Short status,
			Timestamp createTime, Set<ClientTreatmentProject> clienttreatmentprojects) {
		this.employee = employee;
		this.category = category;
		this.name = name;
		this.unitPrice = unitPrice;
		this.introduction = introduction;
		this.suggestNumber = suggestNumber;
		this.type = type;
		this.status = status;
		this.createTime = createTime;
		this.clienttreatmentprojects = clienttreatmentprojects;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "projectId", unique = true, nullable = false)
	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creatorId", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "category", nullable = false)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "unitPrice", nullable = false)
	public Long getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "introduction")
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "suggestNumber", nullable = false)
	public Short getSuggestNumber() {
		return this.suggestNumber;
	}

	public void setSuggestNumber(Short suggestNumber) {
		this.suggestNumber = suggestNumber;
	}

	@Column(name = "type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	public Set<ClientTreatmentProject> getClienttreatmentprojects() {
		return this.clienttreatmentprojects;
	}

	public void setClienttreatmentprojects(Set<ClientTreatmentProject> clienttreatmentprojects) {
		this.clienttreatmentprojects = clienttreatmentprojects;
	}

}