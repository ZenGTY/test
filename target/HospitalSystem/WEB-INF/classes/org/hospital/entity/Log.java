package org.hospital.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class Log {
    private long logId;

    private Employee employee;

    private String content;
    private String operate;
    private Timestamp operateTime;

    @Id
    @Column(name = "logId", nullable = false, insertable = true, updatable = true)
    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    @ManyToOne
    @JoinColumn(name = "employeeId")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "content", nullable = false, insertable = true, updatable = true, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "operate", nullable = false, insertable = true, updatable = true, length = 50)
    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    @Basic
    @Column(name = "operateTime", nullable = false, insertable = true, updatable = true)
    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (logId != log.logId) return false;
        if (employee.getEmployeeId() != log.employee.getEmployeeId()) return false;
        if (content != null ? !content.equals(log.content) : log.content != null) return false;
        if (operate != null ? !operate.equals(log.operate) : log.operate != null) return false;
        if (operateTime != null ? !operateTime.equals(log.operateTime) : log.operateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (logId ^ (logId >>> 32));
        result = 31 * result + (int) (employee.getEmployeeId() ^ (employee.getEmployeeId() >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (operate != null ? operate.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        return result;
    }
}
