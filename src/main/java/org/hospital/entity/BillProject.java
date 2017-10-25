package org.hospital.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
@IdClass(BillProjectPK.class)
public class BillProject {
    private long billId;
    private long projectId;
    private short number;
    private double price;
    private Timestamp deadline;
    private String extraInfo;

    @Id
    @Column(name = "billId", nullable = false, insertable = true, updatable = true)
    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    @Id
    @Column(name = "projectId", nullable = false, insertable = true, updatable = true)
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "number", nullable = false, insertable = true, updatable = true)
    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "deadline", nullable = true, insertable = true, updatable = true)
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "extraInfo", nullable = true, insertable = true, updatable = true, length = 255)
    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillProject that = (BillProject) o;

        if (billId != that.billId) return false;
        if (projectId != that.projectId) return false;
        if (number != that.number) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (extraInfo != null ? !extraInfo.equals(that.extraInfo) : that.extraInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (billId ^ (billId >>> 32));
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        result = 31 * result + (int) number;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (extraInfo != null ? extraInfo.hashCode() : 0);
        return result;
    }
}
