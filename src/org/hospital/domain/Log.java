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
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "hospitalsystem")
public class Log implements java.io.Serializable {

	// Fields

	private Long logId;
	private Employee employee;
	private String content;
	private String operate;
	private Timestamp operateTime;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(Employee employee, String content, String operate, Timestamp operateTime) {
		this.employee = employee;
		this.content = content;
		this.operate = operate;
		this.operateTime = operateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "logId", unique = true, nullable = false)
	public Long getLogId() {
		return this.logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "content", nullable = false, length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "operate", nullable = false, length = 50)
	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	@Column(name = "operateTime", nullable = false, length = 19)
	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

}