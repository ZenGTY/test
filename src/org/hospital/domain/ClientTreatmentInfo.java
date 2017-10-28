package org.hospital.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clienttreatmentinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clienttreatmentinfo", catalog = "hospitalsystem")
public class ClientTreatmentInfo implements java.io.Serializable {

	// Fields

	private Long clientTreatmentInfoId;
	private ClientTreatmentProject clienttreatmentproject;
	private Employee employee;
	private Department department;
	private Client client;
	private Clinic clinic;
	private Timestamp treatTime;

	// Constructors

	/** default constructor */
	public ClientTreatmentInfo() {
	}

	/** full constructor */
	public ClientTreatmentInfo(ClientTreatmentProject clienttreatmentproject, Employee employee,
			Department department, Client client, Clinic clinic, Timestamp treatTime) {
		this.clienttreatmentproject = clienttreatmentproject;
		this.employee = employee;
		this.department = department;
		this.client = client;
		this.clinic = clinic;
		this.treatTime = treatTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "clientTreatmentInfoId", unique = true, nullable = false)
	public Long getClientTreatmentInfoId() {
		return this.clientTreatmentInfoId;
	}

	public void setClientTreatmentInfoId(Long clientTreatmentInfoId) {
		this.clientTreatmentInfoId = clientTreatmentInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientTreatmentProjectId", nullable = false)
	public ClientTreatmentProject getClienttreatmentproject() {
		return this.clienttreatmentproject;
	}

	public void setClienttreatmentproject(ClientTreatmentProject clienttreatmentproject) {
		this.clienttreatmentproject = clienttreatmentproject;
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

	@Column(name = "treatTime", nullable = false, length = 19)
	public Timestamp getTreatTime() {
		return this.treatTime;
	}

	public void setTreatTime(Timestamp treatTime) {
		this.treatTime = treatTime;
	}

}