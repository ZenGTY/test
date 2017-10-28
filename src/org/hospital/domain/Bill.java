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
 * Bill entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bill", catalog = "hospitalsystem")
public class Bill implements java.io.Serializable {

	// Fields

	private Long billId;
	private Employee employee;
	private Department department;
	private Client client;
	private Clinic clinic;
	private String category;
	private Double totalCost;
	private Double totalPrice;
	private Timestamp datetime;
	private Short status;
	private Set<ClientTreatmentProject> clienttreatmentprojects = new HashSet<ClientTreatmentProject>(
			0);

	// Constructors

	/** default constructor */
	public Bill() {
	}

	/** minimal constructor */
	public Bill(Employee employee, Department department, Client client, Clinic clinic,
			String category, Double totalCost, Double totalPrice, Timestamp datetime, Short status) {
		this.employee = employee;
		this.department = department;
		this.client = client;
		this.clinic = clinic;
		this.category = category;
		this.totalCost = totalCost;
		this.totalPrice = totalPrice;
		this.datetime = datetime;
		this.status = status;
	}

	/** full constructor */
	public Bill(Employee employee, Department department, Client client, Clinic clinic,
			String category, Double totalCost, Double totalPrice, Timestamp datetime, Short status,
			Set<ClientTreatmentProject> clienttreatmentprojects) {
		this.employee = employee;
		this.department = department;
		this.client = client;
		this.clinic = clinic;
		this.category = category;
		this.totalCost = totalCost;
		this.totalPrice = totalPrice;
		this.datetime = datetime;
		this.status = status;
		this.clienttreatmentprojects = clienttreatmentprojects;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "billId", unique = true, nullable = false)
	public Long getBillId() {
		return this.billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentId", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientId", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinicId", nullable = false)
	public Clinic getClinic() {
		return this.clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@Column(name = "category", nullable = false, length = 50)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "totalCost", nullable = false, precision = 22, scale = 0)
	public Double getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name = "totalPrice", nullable = false, precision = 22, scale = 0)
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "datetime", nullable = false, length = 19)
	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bill")
	public Set<ClientTreatmentProject> getClienttreatmentprojects() {
		return this.clienttreatmentprojects;
	}

	public void setClienttreatmentprojects(Set<ClientTreatmentProject> clienttreatmentprojects) {
		this.clienttreatmentprojects = clienttreatmentprojects;
	}

}