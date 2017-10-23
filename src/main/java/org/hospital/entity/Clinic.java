package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Clinic {
    private int clinicId;
    private long employeeId;
    private long creatorId;
    private String name;
    private String address;
    private String phone;
    private Timestamp createTime;

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        Clinic clinic = (Clinic) o;

        if (clinicId != clinic.clinicId) return false;
        if (employeeId != clinic.employeeId) return false;
        if (creatorId != clinic.creatorId) return false;
        if (name != null ? !name.equals(clinic.name) : clinic.name != null) return false;
        if (address != null ? !address.equals(clinic.address) : clinic.address != null) return false;
        if (phone != null ? !phone.equals(clinic.phone) : clinic.phone != null) return false;
        if (createTime != null ? !createTime.equals(clinic.createTime) : clinic.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clinicId;
        result = 31 * result + (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (int) (creatorId ^ (creatorId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
