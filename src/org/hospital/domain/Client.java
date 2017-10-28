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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "client", catalog = "hospitalsystem")
public class Client implements java.io.Serializable {

	// Fields

	private Long clientId;
	private String name;
	private String identity;
	private Short age;
	private Short sex;
	private String phone;
	private String address;
	private Timestamp birthdate;
	private String birthplace;
	private String nation;
	private Short marriage;
	private String occupation;
	private String company;
	private Timestamp registerTime;
	private Short status;
	private Set<Record> records = new HashSet<Record>(0);
	private Set<ClientTreatmentInfo> clienttreatmentinfos = new HashSet<ClientTreatmentInfo>(0);
	private Set<ClientTreatmentProject> clienttreatmentprojects = new HashSet<ClientTreatmentProject>(
			0);
	private Set<Hospitalization> hospitalizations = new HashSet<Hospitalization>(0);
	private Set<Bill> bills = new HashSet<Bill>(0);

	// Constructors

	/** default constructor */
	public Client() {
	}

	/** minimal constructor */
	public Client(String name, Timestamp registerTime, Short status) {
		this.name = name;
		this.registerTime = registerTime;
		this.status = status;
	}

	/** full constructor */
	public Client(String name, String identity, Short age, Short sex, String phone, String address,
			Timestamp birthdate, String birthplace, String nation, Short marriage,
			String occupation, String company, Timestamp registerTime, Short status,
			Set<Record> records, Set<ClientTreatmentInfo> clienttreatmentinfos,
			Set<ClientTreatmentProject> clienttreatmentprojects,
			Set<Hospitalization> hospitalizations, Set<Bill> bills) {
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
		this.occupation = occupation;
		this.company = company;
		this.registerTime = registerTime;
		this.status = status;
		this.records = records;
		this.clienttreatmentinfos = clienttreatmentinfos;
		this.clienttreatmentprojects = clienttreatmentprojects;
		this.hospitalizations = hospitalizations;
		this.bills = bills;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "clientId", unique = true, nullable = false)
	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Column(name = "name", nullable = false, length = 50)
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

	@Column(name = "birthdate", length = 19)
	public Timestamp getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
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

	@Column(name = "occupation", length = 50)
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "company")
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "registerTime", nullable = false, length = 19)
	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Record> getRecords() {
		return this.records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public Set<ClientTreatmentInfo> getClienttreatmentinfos() {
		return this.clienttreatmentinfos;
	}

	public void setClienttreatmentinfos(Set<ClientTreatmentInfo> clienttreatmentinfos) {
		this.clienttreatmentinfos = clienttreatmentinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public Set<ClientTreatmentProject> getClienttreatmentprojects() {
		return this.clienttreatmentprojects;
	}

	public void setClienttreatmentprojects(Set<ClientTreatmentProject> clienttreatmentprojects) {
		this.clienttreatmentprojects = clienttreatmentprojects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Hospitalization> getHospitalizations() {
		return this.hospitalizations;
	}

	public void setHospitalizations(Set<Hospitalization> hospitalizations) {
		this.hospitalizations = hospitalizations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

}