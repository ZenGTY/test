package org.hospital.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class Department {
    private int departmentId;

    private Clinic clinic;
    private Employee employee;
    private Employee creator;

    private String name;
    private String phone;
    private Timestamp createTime;

    @Id
    @Column(name = "departmentId", nullable = false, insertable = true, updatable = true)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @ManyToOne
    @JoinColumn(name = "clinicId")
    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
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

        Department that = (Department) o;

        if (departmentId != that.departmentId) return false;
        if (clinic.getClinicId() != that.clinic.getClinicId()) return false;
        if (employee.getEmployeeId() != that.employee.getEmployeeId()) return false;
        if (creator.getEmployeeId() != that.creator.getEmployeeId()) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId;
        result = 31 * result + clinic.getClinicId();
        result = 31 * result + (int) (employee.getEmployeeId() ^ (employee.getEmployeeId() >>> 32));
        result = 31 * result + (int) (creator.getEmployeeId() ^ (creator.getEmployeeId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
