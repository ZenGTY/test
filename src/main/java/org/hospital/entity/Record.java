package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Record {
    private long recordId;
    private long employeeId;
    private long clientId;
    private String complain;
    private String presentIllness;
    private String pastIllness;
    private String physicalExamination;
    private String basis;
    private String antidiastole;
    private String preliminaryDiagnosis;
    private String diagnosisPlan;
    private String treatmentPlan;
    private Timestamp createTime;

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public String getPresentIllness() {
        return presentIllness;
    }

    public void setPresentIllness(String presentIllness) {
        this.presentIllness = presentIllness;
    }

    public String getPastIllness() {
        return pastIllness;
    }

    public void setPastIllness(String pastIllness) {
        this.pastIllness = pastIllness;
    }

    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getAntidiastole() {
        return antidiastole;
    }

    public void setAntidiastole(String antidiastole) {
        this.antidiastole = antidiastole;
    }

    public String getPreliminaryDiagnosis() {
        return preliminaryDiagnosis;
    }

    public void setPreliminaryDiagnosis(String preliminaryDiagnosis) {
        this.preliminaryDiagnosis = preliminaryDiagnosis;
    }

    public String getDiagnosisPlan() {
        return diagnosisPlan;
    }

    public void setDiagnosisPlan(String diagnosisPlan) {
        this.diagnosisPlan = diagnosisPlan;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (recordId != record.recordId) return false;
        if (employeeId != record.employeeId) return false;
        if (clientId != record.clientId) return false;
        if (complain != null ? !complain.equals(record.complain) : record.complain != null) return false;
        if (presentIllness != null ? !presentIllness.equals(record.presentIllness) : record.presentIllness != null)
            return false;
        if (pastIllness != null ? !pastIllness.equals(record.pastIllness) : record.pastIllness != null) return false;
        if (physicalExamination != null ? !physicalExamination.equals(record.physicalExamination) : record.physicalExamination != null)
            return false;
        if (basis != null ? !basis.equals(record.basis) : record.basis != null) return false;
        if (antidiastole != null ? !antidiastole.equals(record.antidiastole) : record.antidiastole != null)
            return false;
        if (preliminaryDiagnosis != null ? !preliminaryDiagnosis.equals(record.preliminaryDiagnosis) : record.preliminaryDiagnosis != null)
            return false;
        if (diagnosisPlan != null ? !diagnosisPlan.equals(record.diagnosisPlan) : record.diagnosisPlan != null)
            return false;
        if (treatmentPlan != null ? !treatmentPlan.equals(record.treatmentPlan) : record.treatmentPlan != null)
            return false;
        if (createTime != null ? !createTime.equals(record.createTime) : record.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (recordId ^ (recordId >>> 32));
        result = 31 * result + (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (complain != null ? complain.hashCode() : 0);
        result = 31 * result + (presentIllness != null ? presentIllness.hashCode() : 0);
        result = 31 * result + (pastIllness != null ? pastIllness.hashCode() : 0);
        result = 31 * result + (physicalExamination != null ? physicalExamination.hashCode() : 0);
        result = 31 * result + (basis != null ? basis.hashCode() : 0);
        result = 31 * result + (antidiastole != null ? antidiastole.hashCode() : 0);
        result = 31 * result + (preliminaryDiagnosis != null ? preliminaryDiagnosis.hashCode() : 0);
        result = 31 * result + (diagnosisPlan != null ? diagnosisPlan.hashCode() : 0);
        result = 31 * result + (treatmentPlan != null ? treatmentPlan.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
