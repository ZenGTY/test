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
 * Clienttreatmentproject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clienttreatmentproject", catalog = "hospitalsystem")
public class ClientTreatmentProject implements java.io.Serializable {

	// Fields

	private Long clientTreatmentProjectId;
	private Bill bill;
	private Project project;
	private Client client;
	private Double unitPrice;
	private Short totalNumber;
	private Short restNumber;
	private Timestamp startTime;
	private Date deadline;
	private Short status;
	private Set<ClientTreatmentInfo> clienttreatmentinfos = new HashSet<ClientTreatmentInfo>(0);

	// Constructors

	/** default constructor */
	public ClientTreatmentProject() {
	}

	/** minimal constructor */
	public ClientTreatmentProject(Bill bill, Project project, Client client, Double unitPrice,
			Short totalNumber, Short restNumber, Timestamp startTime, Date deadline, Short status) {
		this.bill = bill;
		this.project = project;
		this.client = client;
		this.unitPrice = unitPrice;
		this.totalNumber = totalNumber;
		this.restNumber = restNumber;
		this.startTime = startTime;
		this.deadline = deadline;
		this.status = status;
	}

	/** full constructor */
	public ClientTreatmentProject(Bill bill, Project project, Client client, Double unitPrice,
			Short totalNumber, Short restNumber, Timestamp startTime, Date deadline, Short status,
			Set<ClientTreatmentInfo> clienttreatmentinfos) {
		this.bill = bill;
		this.project = project;
		this.client = client;
		this.unitPrice = unitPrice;
		this.totalNumber = totalNumber;
		this.restNumber = restNumber;
		this.startTime = startTime;
		this.deadline = deadline;
		this.status = status;
		this.clienttreatmentinfos = clienttreatmentinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "clientTreatmentProjectId", unique = true, nullable = false)
	public Long getClientTreatmentProjectId() {
		return this.clientTreatmentProjectId;
	}

	public void setClientTreatmentProjectId(Long clientTreatmentProjectId) {
		this.clientTreatmentProjectId = clientTreatmentProjectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "billId", nullable = false)
	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientId", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "unitPrice", nullable = false, precision = 22, scale = 0)
	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "totalNumber", nullable = false)
	public Short getTotalNumber() {
		return this.totalNumber;
	}

	public void setTotalNumber(Short totalNumber) {
		this.totalNumber = totalNumber;
	}

	@Column(name = "restNumber", nullable = false)
	public Short getRestNumber() {
		return this.restNumber;
	}

	public void setRestNumber(Short restNumber) {
		this.restNumber = restNumber;
	}

	@Column(name = "startTime", nullable = false, length = 19)
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "deadline", nullable = false, length = 10)
	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clienttreatmentproject")
	public Set<ClientTreatmentInfo> getClienttreatmentinfos() {
		return this.clienttreatmentinfos;
	}

	public void setClienttreatmentinfos(Set<ClientTreatmentInfo> clienttreatmentinfos) {
		this.clienttreatmentinfos = clienttreatmentinfos;
	}

}