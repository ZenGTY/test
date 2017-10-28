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
 * Clinic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clinic", catalog = "hospitalsystem")
public class Clinic implements java.io.Serializable {

	// Fields

	private Integer clinicId;
	private Employee employeeByCreatorId;
	private Employee employeeByEmployeeId;
	private String name;
	private String address;
	private String phone;
	private Timestamp createTime;
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<ClientTreatmentInfo> clienttreatmentinfos = new HashSet<ClientTreatmentInfo>(0);
	private Set<Employee> employees = new HashSet<Employee>(0);
	private Set<Department> departments = new HashSet<Department>(0);

	// Constructors

	/** default constructor */
	public Clinic() {
	}

	/** minimal constructor */
	public Clinic(Employee employeeByCreatorId, Employee employeeByEmployeeId, String name,
			Timestamp createTime) {
		this.employeeByCreatorId = employeeByCreatorId;
		this.employeeByEmployeeId = employeeByEmployeeId;
		this.name = name;
		this.createTime = createTime;
	}

	/** full constructor */
	public Clinic(Employee employeeByCreatorId, Employee employeeByEmployeeId, String name,
			String address, String phone, Timestamp createTime, Set<Bill> bills,
			Set<ClientTreatmentInfo> clienttreatmentinfos, Set<Employee> employees,
			Set<Department> departments) {
		this.employeeByCreatorId = employeeByCreatorId;
		this.employeeByEmployeeId = employeeByEmployeeId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.createTime = createTime;
		this.bills = bills;
		this.clienttreatmentinfos = clienttreatmentinfos;
		this.employees = employees;
		this.departments = departments;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "clinicId", unique = true, nullable = false)
	public Integer getClinicId() {
		return this.clinicId;
	}

	public void setClinicId(Integer clinicId) {
		this.clinicId = clinicId;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	public Set<ClientTreatmentInfo> getClienttreatmentinfos() {
		return this.clienttreatmentinfos;
	}

	public void setClienttreatmentinfos(Set<ClientTreatmentInfo> clienttreatmentinfos) {
		this.clienttreatmentinfos = clienttreatmentinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

}