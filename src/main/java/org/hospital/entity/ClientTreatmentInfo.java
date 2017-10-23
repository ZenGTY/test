package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class ClientTreatmentInfo {
    private long clientTreatmentInfoId;
    private long clientTreatmentProjectId;
    private long clientId;
    private long employeeId;
    private int departmentId;
    private int clinicId;
    private Timestamp treatTime;

    public long getClientTreatmentInfoId() {
        return clientTreatmentInfoId;
    }

    public void setClientTreatmentInfoId(long clientTreatmentInfoId) {
        this.clientTreatmentInfoId = clientTreatmentInfoId;
    }

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

    public Timestamp getTreatTime() {
        return treatTime;
    }

    public void setTreatTime(Timestamp treatTime) {
        this.treatTime = treatTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientTreatmentInfo that = (ClientTreatmentInfo) o;

        if (clientTreatmentInfoId != that.clientTreatmentInfoId) return false;
        if (clientTreatmentProjectId != that.clientTreatmentProjectId) return false;
        if (clientId != that.clientId) return false;
        if (employeeId != that.employeeId) return false;
        if (departmentId != that.departmentId) return false;
        if (clinicId != that.clinicId) return false;
        if (treatTime != null ? !treatTime.equals(that.treatTime) : that.treatTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (clientTreatmentInfoId ^ (clientTreatmentInfoId >>> 32));
        result = 31 * result + (int) (clientTreatmentProjectId ^ (clientTreatmentProjectId >>> 32));
        result = 31 * result + (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + departmentId;
        result = 31 * result + clinicId;
        result = 31 * result + (treatTime != null ? treatTime.hashCode() : 0);
        return result;
    }
}
