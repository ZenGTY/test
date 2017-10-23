package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Client {
    private long clientId;
    private String name;
    private String identity;
    private Short age;
    private Short sex;
    private String phone;
    private String address;
    private Timestamp birthdate;
    private String birthplace;
    private String nation;
    private Short marriage;
    private String occupation;
    private String company;
    private Timestamp registerTime;
    private short status;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

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

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (status != client.status) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (identity != null ? !identity.equals(client.identity) : client.identity != null) return false;
        if (age != null ? !age.equals(client.age) : client.age != null) return false;
        if (sex != null ? !sex.equals(client.sex) : client.sex != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (birthdate != null ? !birthdate.equals(client.birthdate) : client.birthdate != null) return false;
        if (birthplace != null ? !birthplace.equals(client.birthplace) : client.birthplace != null) return false;
        if (nation != null ? !nation.equals(client.nation) : client.nation != null) return false;
        if (marriage != null ? !marriage.equals(client.marriage) : client.marriage != null) return false;
        if (occupation != null ? !occupation.equals(client.occupation) : client.occupation != null) return false;
        if (company != null ? !company.equals(client.company) : client.company != null) return false;
        if (registerTime != null ? !registerTime.equals(client.registerTime) : client.registerTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (clientId ^ (clientId >>> 32));
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
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (int) status;
        return result;
    }
}
