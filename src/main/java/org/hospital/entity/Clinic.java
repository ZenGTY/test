package org.hospital.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class Clinic {
    private int clinicId;

    private Employee employee;
    private Employee creator;

    private String name;
    private String address;
    private String phone;
    private Timestamp createTime;

    @Id
    @Column(name = "clinicId", nullable = false, insertable = true, updatable = true)
    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
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
    @JoinColumn(name = "creatorId")
    public Employee getCreator() {
        return creator;
    }

    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "createTime", nullable = false, insertable = true, updatable = true)
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

        Clinic clinic = (Clinic) o;

        if (clinicId != clinic.clinicId) return false;
        if (employee.getEmployeeId() != clinic.employee.getEmployeeId()) return false;
        if (creator.getEmployeeId() != clinic.creator.getEmployeeId()) return false;
        if (name != null ? !name.equals(clinic.name) : clinic.name != null) return false;
        if (address != null ? !address.equals(clinic.address) : clinic.address != null) return false;
        if (phone != null ? !phone.equals(clinic.phone) : clinic.phone != null) return false;
        if (createTime != null ? !createTime.equals(clinic.createTime) : clinic.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clinicId;
        result = 31 * result + (int) (employee.getEmployeeId() ^ (employee.getEmployeeId() >>> 32));
        result = 31 * result + (int) (creator.getEmployeeId() ^ (creator.getEmployeeId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
