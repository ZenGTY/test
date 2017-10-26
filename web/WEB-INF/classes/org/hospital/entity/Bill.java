package org.hospital.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class Bill {
    private long billId;

    private Client client;
    private Employee employee;
    private Department department;
    private Clinic clinic;

    private String category;
    private double totalCost;
    private double totalPrice;
    private Timestamp datetime;
    private short status;

    @Id
    @Column(name = "billId", nullable = false, insertable = true, updatable = true)
    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    @ManyToOne
    @JoinColumn(name = "clientId")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "employeeId")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "departmentId")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "clinicId")
    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Basic
    @Column(name = "category", nullable = false, insertable = true, updatable = true, length = 50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "totalCost", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Basic
    @Column(name = "totalPrice", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "datetime", nullable = false, insertable = true, updatable = true)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "status", nullable = false, insertable = true, updatable = true)
    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (billId != bill.billId) return false;
        if (client.getClientId() != bill.client.getClientId()) return false;
        if (employee.getEmployeeId() != bill.employee.getEmployeeId()) return false;
        if (department.getDepartmentId() != bill.department.getDepartmentId()) return false;
        if (clinic.getClinicId() != bill.clinic.getClinicId()) return false;
        if (Double.compare(bill.totalCost, totalCost) != 0) return false;
        if (Double.compare(bill.totalPrice, totalPrice) != 0) return false;
        if (status != bill.status) return false;
        if (category != null ? !category.equals(bill.category) : bill.category != null) return false;
        if (datetime != null ? !datetime.equals(bill.datetime) : bill.datetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (billId ^ (billId >>> 32));
        result = 31 * result + (int) (client.getClientId() ^ (client.getClientId() >>> 32));
        result = 31 * result + (int) (employee.getEmployeeId() ^ (employee.getEmployeeId() >>> 32));
        result = 31 * result + department.getDepartmentId();
        result = 31 * result + clinic.getClinicId();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        temp = Double.doubleToLongBits(totalCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (int) status;
        return result;
    }
}
