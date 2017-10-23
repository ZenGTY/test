package org.hospital.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class ClientTreatmentProject {
    private long clientTreatmentProjectId;
    private long clientId;
    private long billId;
    private long projectId;
    private double unitPrice;
    private short totalNumber;
    private short restNumber;
    private Timestamp startTime;
    private Date deadline;
    private short status;

    public long getClientTreatmentProjectId() {
        return clientTreatmentProjectId;
    }

    public void setClientTreatmentProjectId(long clientTreatmentProjectId) {
        this.clientTreatmentProjectId = clientTreatmentProjectId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(short totalNumber) {
        this.totalNumber = totalNumber;
    }

    public short getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(short restNumber) {
        this.restNumber = restNumber;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

        ClientTreatmentProject that = (ClientTreatmentProject) o;

        if (clientTreatmentProjectId != that.clientTreatmentProjectId) return false;
        if (clientId != that.clientId) return false;
        if (billId != that.billId) return false;
        if (projectId != that.projectId) return false;
        if (Double.compare(that.unitPrice, unitPrice) != 0) return false;
        if (totalNumber != that.totalNumber) return false;
        if (restNumber != that.restNumber) return false;
        if (status != that.status) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (clientTreatmentProjectId ^ (clientTreatmentProjectId >>> 32));
        result = 31 * result + (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (int) (billId ^ (billId >>> 32));
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) totalNumber;
        result = 31 * result + (int) restNumber;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (int) status;
        return result;
    }
}
