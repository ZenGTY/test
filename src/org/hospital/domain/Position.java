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
 * Position entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "position", catalog = "hospitalsystem")
public class Position implements java.io.Serializable {

	// Fields

	private Integer positionId;
	private Employee employee;
	private String name;
	private String description;
	private Short rank;
	private Timestamp createTime;
	private Set<Employee> employees = new HashSet<Employee>(0);

	// Constructors

	/** default constructor */
	public Position() {
	}

	/** minimal constructor */
	public Position(Employee employee, String name, Short rank, Timestamp createTime) {
		this.employee = employee;
		this.name = name;
		this.rank = rank;
		this.createTime = createTime;
	}

	/** full constructor */
	public Position(Employee employee, String name, String description, Short rank,
			Timestamp createTime, Set<Employee> employees) {
		this.employee = employee;
		this.name = name;
		this.description = description;
		this.rank = rank;
		this.createTime = createTime;
		this.employees = employees;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "positionId", unique = true, nullable = false)
	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creatorId", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "rank", nullable = false)
	public Short getRank() {
		return this.rank;
	}

	public void setRank(Short rank) {
		this.rank = rank;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "position")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}