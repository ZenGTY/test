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
 * Hospitalization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hospitalization", catalog = "hospitalsystem")
public class Hospitalization implements java.io.Serializable {

	// Fields

	private Long hospitalizationId;
	private Department department;
	private Client client;
	private String codeIcd;
	private String enterDiagnosis;
	private String leaveDiagnosis;
	private String enterSituation;
	private String leaveSituation;
	private Timestamp enterTime;
	private Timestamp leaveTime;

	// Constructors

	/** default constructor */
	public Hospitalization() {
	}

	/** minimal constructor */
	public Hospitalization(Department department, Client client, Timestamp enterTime) {
		this.department = department;
		this.client = client;
		this.enterTime = enterTime;
	}

	/** full constructor */
	public Hospitalization(Department department, Client client, String codeIcd,
			String enterDiagnosis, String leaveDiagnosis, String enterSituation,
			String leaveSituation, Timestamp enterTime, Timestamp leaveTime) {
		this.department = department;
		this.client = client;
		this.codeIcd = codeIcd;
		this.enterDiagnosis = enterDiagnosis;
		this.leaveDiagnosis = leaveDiagnosis;
		this.enterSituation = enterSituation;
		this.leaveSituation = leaveSituation;
		this.enterTime = enterTime;
		this.leaveTime = leaveTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "hospitalizationId", unique = true, nullable = false)
	public Long getHospitalizationId() {
		return this.hospitalizationId;
	}

	public void setHospitalizationId(Long hospitalizationId) {
		this.hospitalizationId = hospitalizationId;
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

	@Column(name = "codeICD", length = 50)
	public String getCodeIcd() {
		return this.codeIcd;
	}

	public void setCodeIcd(String codeIcd) {
		this.codeIcd = codeIcd;
	}

	@Column(name = "enterDiagnosis")
	public String getEnterDiagnosis() {
		return this.enterDiagnosis;
	}

	public void setEnterDiagnosis(String enterDiagnosis) {
		this.enterDiagnosis = enterDiagnosis;
	}

	@Column(name = "leaveDiagnosis")
	public String getLeaveDiagnosis() {
		return this.leaveDiagnosis;
	}

	public void setLeaveDiagnosis(String leaveDiagnosis) {
		this.leaveDiagnosis = leaveDiagnosis;
	}

	@Column(name = "enterSituation")
	public String getEnterSituation() {
		return this.enterSituation;
	}

	public void setEnterSituation(String enterSituation) {
		this.enterSituation = enterSituation;
	}

	@Column(name = "leaveSituation")
	public String getLeaveSituation() {
		return this.leaveSituation;
	}

	public void setLeaveSituation(String leaveSituation) {
		this.leaveSituation = leaveSituation;
	}

	@Column(name = "enterTime", nullable = false, length = 19)
	public Timestamp getEnterTime() {
		return this.enterTime;
	}

	public void setEnterTime(Timestamp enterTime) {
		this.enterTime = enterTime;
	}

	@Column(name = "leaveTime", length = 19)
	public Timestamp getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}

}