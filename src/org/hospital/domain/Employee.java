package org.hospital.domain;

import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "employee", catalog = "hospitalsystem")
public class Employee implements java.io.Serializable {

	// Fields

	private Long employeeId;
	private Department department;
	private Position position;
	private Clinic clinic;
	private String account;
	private String pwd;
	private String name;
	private String identity;
	private Short age;
	private Short sex;
	private String phone;
	private String address;
	private Date birthdate;
	private String birthplace;
	private String nation;
	private Short marriage;
	private Double billCost;
	private Timestamp registerTime;
	private Timestamp loginTime;
	private Short status;
	private Short isOnJob;
	private Set<Position> positions = new HashSet<Position>(0);
	private Set<Department> departmentsForEmployeeId = new HashSet<Department>(0);
	private Set<ClientTreatmentInfo> clienttreatmentinfos = new HashSet<ClientTreatmentInfo>(0);
	private Set<Project> projects = new HashSet<Project>(0);
	private Set<Clinic> clinicsForCreatorId = new HashSet<Clinic>(0);
	private Set<Department> departmentsForCreatorId = new HashSet<Department>(0);
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<Log> logs = new HashSet<Log>(0);
	private Set<Clinic> clinicsForEmployeeId = new HashSet<Clinic>(0);
	private Set<Record> records = new HashSet<Record>(0);

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(Position position, String account, String pwd, Timestamp registerTime,
			Short status, Short isOnJob) {
		this.position = position;
		this.account = account;
		this.pwd = pwd;
		this.registerTime = registerTime;
		this.status = status;
		this.isOnJob = isOnJob;
	}

	/** full constructor */
	public Employee(Department department, Position position, Clinic clinic, String account,
			String pwd, String name, String identity, Short age, Short sex, String phone,
			String address, Date birthdate, String birthplace, String nation, Short marriage,
			Double billCost, Timestamp registerTime, Timestamp loginTime, Short status,
			Short isOnJob, Set<Position> positions, Set<Department> departmentsForEmployeeId,
			Set<ClientTreatmentInfo> clienttreatmentinfos, Set<Project> projects,
			Set<Clinic> clinicsForCreatorId, Set<Department> departmentsForCreatorId,
			Set<Bill> bills, Set<Log> logs, Set<Clinic> clinicsForEmployeeId, Set<Record> records) {
		this.department = department;
		this.position = position;
		this.clinic = clinic;
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.identity = identity;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.nation = nation;
		this.marriage = marriage;
		this.billCost = billCost;
		this.registerTime = registerTime;
		this.loginTime = loginTime;
		this.status = status;
		this.isOnJob = isOnJob;
		this.positions = positions;
		this.departmentsForEmployeeId = departmentsForEmployeeId;
		this.clienttreatmentinfos = clienttreatmentinfos;
		this.projects = projects;
		this.clinicsForCreatorId = clinicsForCreatorId;
		this.departmentsForCreatorId = departmentsForCreatorId;
		this.bills = bills;
		this.logs = logs;
		this.clinicsForEmployeeId = clinicsForEmployeeId;
		this.records = records;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "employeeId", unique = true, nullable = false)
	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentId")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "positionId", nullable = false)
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinicId")
	public Clinic getClinic() {
		return this.clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@Column(name = "account", nullable = false, length = 50)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "pwd", nullable = false, length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "identity", length = 18)
	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Column(name = "age")
	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@Column(name = "sex")
	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", length = 10)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "birthplace")
	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Column(name = "nation", length = 50)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "marriage")
	public Short getMarriage() {
		return this.marriage;
	}

	public void setMarriage(Short marriage) {
		this.marriage = marriage;
	}

	@Column(name = "billCost", precision = 22, scale = 0)
	public Double getBillCost() {
		return this.billCost;
	}

	public void setBillCost(Double billCost) {
		this.billCost = billCost;
	}

	@Column(name = "registerTime", nullable = false, length = 19)
	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "loginTime", length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "isOnJob", nullable = false)
	public Short getIsOnJob() {
		return this.isOnJob;
	}

	public void setIsOnJob(Short isOnJob) {
		this.isOnJob = isOnJob;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeByEmployeeId")
	public Set<Department> getDepartmentsForEmployeeId() {
		return this.departmentsForEmployeeId;
	}

	public void setDepartmentsForEmployeeId(Set<Department> departmentsForEmployeeId) {
		this.departmentsForEmployeeId = departmentsForEmployeeId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<ClientTreatmentInfo> getClienttreatmentinfos() {
		return this.clienttreatmentinfos;
	}

	public void setClienttreatmentinfos(Set<ClientTreatmentInfo> clienttreatmentinfos) {
		this.clienttreatmentinfos = clienttreatmentinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeByCreatorId")
	public Set<Clinic> getClinicsForCreatorId() {
		return this.clinicsForCreatorId;
	}

	public void setClinicsForCreatorId(Set<Clinic> clinicsForCreatorId) {
		this.clinicsForCreatorId = clinicsForCreatorId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeByCreatorId")
	public Set<Department> getDepartmentsForCreatorId() {
		return this.departmentsForCreatorId;
	}

	public void setDepartmentsForCreatorId(Set<Department> departmentsForCreatorId) {
		this.departmentsForCreatorId = departmentsForCreatorId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeByEmployeeId")
	public Set<Clinic> getClinicsForEmployeeId() {
		return this.clinicsForEmployeeId;
	}

	public void setClinicsForEmployeeId(Set<Clinic> clinicsForEmployeeId) {
		this.clinicsForEmployeeId = clinicsForEmployeeId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Record> getRecords() {
		return this.records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

}