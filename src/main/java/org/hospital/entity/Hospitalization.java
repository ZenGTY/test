package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Hospitalization {
    private long hospitalizationId;
    private long clientId;
    private int departmentId;
    private String codeIcd;
    private String enterDiagnosis;
    private String leaveDiagnosis;
    private String enterSituation;
    private String leaveSituation;
    private Timestamp enterTime;
    private Timestamp leaveTime;

    public long getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(long hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getCodeIcd() {
        return codeIcd;
    }

    public void setCodeIcd(String codeIcd) {
        this.codeIcd = codeIcd;
    }

    public String getEnterDiagnosis() {
        return enterDiagnosis;
    }

    public void setEnterDiagnosis(String enterDiagnosis) {
        this.enterDiagnosis = enterDiagnosis;
    }

    public String getLeaveDiagnosis() {
        return leaveDiagnosis;
    }

    public void setLeaveDiagnosis(String leaveDiagnosis) {
        this.leaveDiagnosis = leaveDiagnosis;
    }

    public String getEnterSituation() {
        return enterSituation;
    }

    public void setEnterSituation(String enterSituation) {
        this.enterSituation = enterSituation;
    }

    public String getLeaveSituation() {
        return leaveSituation;
    }

    public void setLeaveSituation(String leaveSituation) {
        this.leaveSituation = leaveSituation;
    }

    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    public Timestamp getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospitalization that = (Hospitalization) o;

        if (hospitalizationId != that.hospitalizationId) return false;
        if (clientId != that.clientId) return false;
        if (departmentId != that.departmentId) return false;
        if (codeIcd != null ? !codeIcd.equals(that.codeIcd) : that.codeIcd != null) return false;
        if (enterDiagnosis != null ? !enterDiagnosis.equals(that.enterDiagnosis) : that.enterDiagnosis != null)
            return false;
        if (leaveDiagnosis != null ? !leaveDiagnosis.equals(that.leaveDiagnosis) : that.leaveDiagnosis != null)
            return false;
        if (enterSituation != null ? !enterSituation.equals(that.enterSituation) : that.enterSituation != null)
            return false;
        if (leaveSituation != null ? !leaveSituation.equals(that.leaveSituation) : that.leaveSituation != null)
            return false;
        if (enterTime != null ? !enterTime.equals(that.enterTime) : that.enterTime != null) return false;
        if (leaveTime != null ? !leaveTime.equals(that.leaveTime) : that.leaveTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (hospitalizationId ^ (hospitalizationId >>> 32));
        result = 31 * result + (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + departmentId;
        result = 31 * result + (codeIcd != null ? codeIcd.hashCode() : 0);
        result = 31 * result + (enterDiagnosis != null ? enterDiagnosis.hashCode() : 0);
        result = 31 * result + (leaveDiagnosis != null ? leaveDiagnosis.hashCode() : 0);
        result = 31 * result + (enterSituation != null ? enterSituation.hashCode() : 0);
        result = 31 * result + (leaveSituation != null ? leaveSituation.hashCode() : 0);
        result = 31 * result + (enterTime != null ? enterTime.hashCode() : 0);
        result = 31 * result + (leaveTime != null ? leaveTime.hashCode() : 0);
        return result;
    }
}
