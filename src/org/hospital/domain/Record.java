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
 * Record entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record", catalog = "hospitalsystem")
public class Record implements java.io.Serializable {

	// Fields

	private Long recordId;
	private Employee employee;
	private Client client;
	private String complain;
	private String presentIllness;
	private String pastIllness;
	private String physicalExamination;
	private String basis;
	private String antidiastole;
	private String preliminaryDiagnosis;
	private String diagnosisPlan;
	private String treatmentPlan;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** minimal constructor */
	public Record(Employee employee, Client client, Timestamp createTime) {
		this.employee = employee;
		this.client = client;
		this.createTime = createTime;
	}

	/** full constructor */
	public Record(Employee employee, Client client, String complain, String presentIllness,
			String pastIllness, String physicalExamination, String basis, String antidiastole,
			String preliminaryDiagnosis, String diagnosisPlan, String treatmentPlan,
			Timestamp createTime) {
		this.employee = employee;
		this.client = client;
		this.complain = complain;
		this.presentIllness = presentIllness;
		this.pastIllness = pastIllness;
		this.physicalExamination = physicalExamination;
		this.basis = basis;
		this.antidiastole = antidiastole;
		this.preliminaryDiagnosis = preliminaryDiagnosis;
		this.diagnosisPlan = diagnosisPlan;
		this.treatmentPlan = treatmentPlan;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "recordId", unique = true, nullable = false)
	public Long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
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
	@JoinColumn(name = "clientId", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "complain", length = 500)
	public String getComplain() {
		return this.complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	@Column(name = "presentIllness", length = 500)
	public String getPresentIllness() {
		return this.presentIllness;
	}

	public void setPresentIllness(String presentIllness) {
		this.presentIllness = presentIllness;
	}

	@Column(name = "pastIllness", length = 500)
	public String getPastIllness() {
		return this.pastIllness;
	}

	public void setPastIllness(String pastIllness) {
		this.pastIllness = pastIllness;
	}

	@Column(name = "physicalExamination", length = 500)
	public String getPhysicalExamination() {
		return this.physicalExamination;
	}

	public void setPhysicalExamination(String physicalExamination) {
		this.physicalExamination = physicalExamination;
	}

	@Column(name = "basis", length = 500)
	public String getBasis() {
		return this.basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	@Column(name = "antidiastole", length = 500)
	public String getAntidiastole() {
		return this.antidiastole;
	}

	public void setAntidiastole(String antidiastole) {
		this.antidiastole = antidiastole;
	}

	@Column(name = "preliminaryDiagnosis", length = 500)
	public String getPreliminaryDiagnosis() {
		return this.preliminaryDiagnosis;
	}

	public void setPreliminaryDiagnosis(String preliminaryDiagnosis) {
		this.preliminaryDiagnosis = preliminaryDiagnosis;
	}

	@Column(name = "diagnosisPlan", length = 500)
	public String getDiagnosisPlan() {
		return this.diagnosisPlan;
	}

	public void setDiagnosisPlan(String diagnosisPlan) {
		this.diagnosisPlan = diagnosisPlan;
	}

	@Column(name = "treatmentPlan", length = 500)
	public String getTreatmentPlan() {
		return this.treatmentPlan;
	}

	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}