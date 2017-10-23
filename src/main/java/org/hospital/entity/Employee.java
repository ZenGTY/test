package org.hospital.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Employee {
    private long employeeId;
    private int positionId;
    private Integer departmentId;
    private Integer clinicId;
    private String account;
    private String pwd;
    private String name;
    private String identity;
    private Short age;
    private Short sex;
    private String phone;
    private String address;
    private Date birthdate;
    private String birthplace;
    private String nation;
    private Short marriage;
    private Double billCost;
    private Timestamp registerTime;
    private Timestamp loginTime;
    private Short status;
    private Short isOnJob;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Short getMarriage() {
        return marriage;
    }

    public void setMarriage(Short marriage) {
        this.marriage = marriage;
    }

    public Double getBillCost() {
        return billCost;
    }

    public void setBillCost(Double billCost) {
        this.billCost = billCost;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getIsOnJob() {
        return isOnJob;
    }

    public void setIsOnJob(Short isOnJob) {
        this.isOnJob = isOnJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) return false;
        if (positionId != employee.positionId) return false;
        if (departmentId != null ? !departmentId.equals(employee.departmentId) : employee.departmentId != null)
            return false;
        if (clinicId != null ? !clinicId.equals(employee.clinicId) : employee.clinicId != null) return false;
        if (account != null ? !account.equals(employee.account) : employee.account != null) return false;
        if (pwd != null ? !pwd.equals(employee.pwd) : employee.pwd != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (identity != null ? !identity.equals(employee.identity) : employee.identity != null) return false;
        if (age != null ? !age.equals(employee.age) : employee.age != null) return false;
        if (sex != null ? !sex.equals(employee.sex) : employee.sex != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (birthdate != null ? !birthdate.equals(employee.birthdate) : employee.birthdate != null) return false;
        if (birthplace != null ? !birthplace.equals(employee.birthplace) : employee.birthplace != null) return false;
        if (nation != null ? !nation.equals(employee.nation) : employee.nation != null) return false;
        if (marriage != null ? !marriage.equals(employee.marriage) : employee.marriage != null) return false;
        if (billCost != null ? !billCost.equals(employee.billCost) : employee.billCost != null) return false;
        if (registerTime != null ? !registerTime.equals(employee.registerTime) : employee.registerTime != null)
            return false;
        if (loginTime != null ? !loginTime.equals(employee.loginTime) : employee.loginTime != null) return false;
        if (status != null ? !status.equals(employee.status) : employee.status != null) return false;
        if (isOnJob != null ? !isOnJob.equals(employee.isOnJob) : employee.isOnJob != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + positionId;
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (clinicId != null ? clinicId.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (birthplace != null ? birthplace.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (marriage != null ? marriage.hashCode() : 0);
        result = 31 * result + (billCost != null ? billCost.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isOnJob != null ? isOnJob.hashCode() : 0);
        return result;
    }
}
