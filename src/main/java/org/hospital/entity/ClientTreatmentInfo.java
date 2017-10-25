package org.hospital.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class ClientTreatmentInfo {
    private long clientTreatmentInfoId;

    private ClientTreatmentProject clientTreatmentProject;
    private Client client;
    private Employee employee;
    private Department department;
    private Clinic clinic;

    private Timestamp treatTime;

    @Id
    @Column(name = "clientTreatmentInfoId", nullable = false, insertable = true, updatable = true)
    public long getClientTreatmentInfoId() {
        return clientTreatmentInfoId;
    }

    public void setClientTreatmentInfoId(long clientTreatmentInfoId) {
        this.clientTreatmentInfoId = clientTreatmentInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "clientTreatmentProjectId")
    public ClientTreatmentProject getClientTreatmentProject() {
        return clientTreatmentProject;
    }

    public void setClientTreatmentProject(ClientTreatmentProject clientTreatmentProject) {
        this.clientTreatmentProject = clientTreatmentProject;
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
    @Column(name = "treatTime", nullable = false, insertable = true, updatable = true)
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
        if (clientTreatmentProject != that.clientTreatmentProject) return false;
        if (client.getClientId() != that.client.getClientId()) return false;
        if (employee.getEmployeeId() != that.employee.getEmployeeId()) return false;
        if (department.getDepartmentId() != that.department.getDepartmentId()) return false;
        if (clinic.getClinicId() != that.clinic.getClinicId()) return false;
        if (treatTime != null ? !treatTime.equals(that.treatTime) : that.treatTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (clientTreatmentInfoId ^ (clientTreatmentInfoId >>> 32));
        result = 31 * result + (int) (clientTreatmentProject.getClientTreatmentProjectId() ^ (clientTreatmentProject.getClientTreatmentProjectId() >>> 32));
        result = 31 * result + (int) (client.getClientId() ^ (client.getClientId() >>> 32));
        result = 31 * result + (int) (employee.getEmployeeId() ^ (employee.getEmployeeId() >>> 32));
        result = 31 * result + department.getDepartmentId();
        result = 31 * result + clinic.getClinicId();
        result = 31 * result + (treatTime != null ? treatTime.hashCode() : 0);
        return result;
    }
}
