package org.hospital.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class Employee {

    private long employeeId;

    private Position position;
    private Department department;
    private Clinic clinic;

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
    private short isOnJob;
    private Timestamp loginTime;
    private short status;
    private Timestamp registerTime;

    @Id
    @javax.persistence.Column(name = "employeeId", nullable = false, insertable = true, updatable = true)
    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @ManyToOne
    @JoinColumn(name = "positionId")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
    @javax.persistence.Column(name = "account", nullable = false, insertable = true, updatable = true, length = 50)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    @Basic
    @javax.persistence.Column(name = "pwd", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Basic
    @javax.persistence.Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @javax.persistence.Column(name = "identity", nullable = true, insertable = true, updatable = true, length = 18)
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


    @Basic
    @javax.persistence.Column(name = "age", nullable = true, insertable = true, updatable = true)
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }


    @Basic
    @javax.persistence.Column(name = "sex", nullable = true, insertable = true, updatable = true)
    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }


    @Basic
    @javax.persistence.Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Basic
    @javax.persistence.Column(name = "address", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Basic
    @javax.persistence.Column(name = "birthdate", nullable = true, insertable = true, updatable = true)
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    @Basic
    @javax.persistence.Column(name = "birthplace", nullable = true, insertable = true, updatable = true, length = 255)
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }


    @Basic
    @javax.persistence.Column(name = "nation", nullable = true, insertable = true, updatable = true, length = 50)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }


    @Basic
    @javax.persistence.Column(name = "marriage", nullable = true, insertable = true, updatable = true)
    public Short getMarriage() {
        return marriage;
    }

    public void setMarriage(Short marriage) {
        this.marriage = marriage;
    }


    @Basic
    @javax.persistence.Column(name = "billCost", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getBillCost() {
        return billCost;
    }

    public void setBillCost(Double billCost) {
        this.billCost = billCost;
    }

    @Basic
    @javax.persistence.Column(name = "registerTime", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Basic
    @javax.persistence.Column(name = "loginTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @javax.persistence.Column(name = "status", nullable = false, insertable = true, updatable = true)
    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }


    @Basic
    @javax.persistence.Column(name = "isOnJob", nullable = false, insertable = true, updatable = true)
    public short getIsOnJob() {
        return isOnJob;
    }

    public void setIsOnJob(short isOnJob) {
        this.isOnJob = isOnJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) return false;
        if (position.getPositionId() != employee.position.getPositionId()) return false;
        if (status != employee.status) return false;
        if (isOnJob != employee.isOnJob) return false;
        if (clinic.getClinicId() != employee.clinic.getClinicId()) return false;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + position.getPositionId();
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (clinic != null ? clinic.hashCode() : 0);
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
        result = 31 * result + (int) status;
        result = 31 * result + (int) isOnJob;
        return result;
    }
}
