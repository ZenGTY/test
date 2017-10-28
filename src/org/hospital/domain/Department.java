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
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "department", catalog = "hospitalsystem")
public class Department implements java.io.Serializable {

	// Fields

	private Integer departmentId;
	private Employee employeeByCreatorId;
	private Employee employeeByEmployeeId;
	private Clinic clinic;
	private String name;
	private String phone;
	private Timestamp createTime;
	private Set<Employee> employees = new HashSet<Employee>(0);
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<Hospitalization> hospitalizations = new HashSet<Hospitalization>(0);
	private Set<ClientTreatmentInfo> clienttreatmentinfos = new HashSet<ClientTreatmentInfo>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Employee employeeByCreatorId, Employee employeeByEmployeeId, Clinic clinic,
			String name, Timestamp createTime) {
		this.employeeByCreatorId = employeeByCreatorId;
		this.employeeByEmployeeId = employeeByEmployeeId;
		this.clinic = clinic;
		this.name = name;
		this.createTime = createTime;
	}

	/** full constructor */
	public Department(Employee employeeByCreatorId, Employee employeeByEmployeeId, Clinic clinic,
			String name, String phone, Timestamp createTime, Set<Employee> employees,
			Set<Bill> bills, Set<Hospitalization> hospitalizations,
			Set<ClientTreatmentInfo> clienttreatmentinfos) {
		this.employeeByCreatorId = employeeByCreatorId;
		this.employeeByEmployeeId = employeeByEmployeeId;
		this.clinic = clinic;
		this.name = name;
		this.phone = phone;
		this.createTime = createTime;
		this.employees = employees;
		this.bills = bills;
		this.hospitalizations = hospitalizations;
		this.clienttreatmentinfos = clienttreatmentinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "departmentId", unique = true, nullable = false)
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creatorId", nullable = false)
	public Employee getEmployeeByCreatorId() {
		return this.employeeByCreatorId;
	}

	public void setEmployeeByCreatorId(Employee employeeByCreatorId) {
		this.employeeByCreatorId = employeeByCreatorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable = false)
	public Employee getEmployeeByEmployeeId() {
		return this.employeeByEmployeeId;
	}

	public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
		this.employeeByEmployeeId = employeeByEmployeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinicId", nullable = false)
	public Clinic getClinic() {
		return this.clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Hospitalization> getHospitalizations() {
		return this.hospitalizations;
	}

	public void setHospitalizations(Set<Hospitalization> hospitalizations) {
		this.hospitalizations = hospitalizations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<ClientTreatmentInfo> getClienttreatmentinfos() {
		return this.clienttreatmentinfos;
	}

	public void setClienttreatmentinfos(Set<ClientTreatmentInfo> clienttreatmentinfos) {
		this.clienttreatmentinfos = clienttreatmentinfos;
	}

}