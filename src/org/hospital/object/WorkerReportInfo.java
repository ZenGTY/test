package org.hospital.object;

public class WorkerReportInfo {
	private Long employeeId;
	private Long sumNumber;
	private Double sumPrice;
	private String employeeName;

	public WorkerReportInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkerReportInfo(Long employeeId, Long sumNumber, Double sumPrice, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.sumNumber = sumNumber;
		this.sumPrice = sumPrice;
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getSumNumber() {
		return sumNumber;
	}

	public void setSumNumber(Long sumNumber) {
		this.sumNumber = sumNumber;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}

}
