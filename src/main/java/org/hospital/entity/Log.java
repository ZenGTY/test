package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Log {
    private long logId;
    private long employeeId;
    private String content;
    private String operate;
    private Timestamp operateTime;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

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
        if (employeeId != log.employeeId) return false;
        if (content != null ? !content.equals(log.content) : log.content != null) return false;
        if (operate != null ? !operate.equals(log.operate) : log.operate != null) return false;
        if (operateTime != null ? !operateTime.equals(log.operateTime) : log.operateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (logId ^ (logId >>> 32));
        result = 31 * result + (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (operate != null ? operate.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        return result;
    }
}
