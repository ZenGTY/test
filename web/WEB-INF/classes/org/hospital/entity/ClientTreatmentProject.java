package org.hospital.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class ClientTreatmentProject {
    private long clientTreatmentProjectId;

    private Client client;
    private Bill bill;
    private Project project;

    private double unitPrice;
    private short totalNumber;
    private short restNumber;
    private Timestamp startTime;
    private Date deadline;
    private short status;

    @Id
    @Column(name = "clientTreatmentProjectId", nullable = false, insertable = true, updatable = true)
    public long getClientTreatmentProjectId() {
        return clientTreatmentProjectId;
    }

    public void setClientTreatmentProjectId(long clientTreatmentProjectId) {
        this.clientTreatmentProjectId = clientTreatmentProjectId;
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
    @JoinColumn(name = "billId")
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @ManyToOne
    @JoinColumn(name = "projectId")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Basic
    @Column(name = "unitPrice", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "totalNumber", nullable = false, insertable = true, updatable = true)
    public short getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(short totalNumber) {
        this.totalNumber = totalNumber;
    }

    @Basic
    @Column(name = "restNumber", nullable = false, insertable = true, updatable = true)
    public short getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(short restNumber) {
        this.restNumber = restNumber;
    }

    @Basic
    @Column(name = "startTime", nullable = false, insertable = true, updatable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "deadline", nullable = false, insertable = true, updatable = true)
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

        ClientTreatmentProject that = (ClientTreatmentProject) o;

        if (clientTreatmentProjectId != that.clientTreatmentProjectId) return false;
        if (client.getClientId() != that.client.getClientId()) return false;
        if (bill.getBillId() != that.bill.getBillId()) return false;
        if (project.getProjectId() != that.project.getProjectId()) return false;
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
        result = 31 * result + (int) (client.getClientId() ^ (client.getClientId() >>> 32));
        result = 31 * result + (int) (bill.getBillId() ^ (bill.getBillId() >>> 32));
        result = 31 * result + (int) (project.getProjectId() ^ (project.getProjectId() >>> 32));
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
