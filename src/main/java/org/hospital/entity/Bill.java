package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Bill {
    private long billId;
    private long clintId;
    private long employeeId;
    private int departmentId;
    private int clinicId;
    private String category;
    private double totalCost;
    private double totalPrice;
    private Timestamp datetime;
    private short status;

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getClintId() {
        return clintId;
    }

    public void setClintId(long clintId) {
        this.clintId = clintId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

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
        if (clintId != bill.clintId) return false;
        if (employeeId != bill.employeeId) return false;
        if (departmentId != bill.departmentId) return false;
        if (clinicId != bill.clinicId) return false;
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
        result = 31 * result + (int) (clintId ^ (clintId >>> 32));
        result = 31 * result + (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + departmentId;
        result = 31 * result + clinicId;
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
