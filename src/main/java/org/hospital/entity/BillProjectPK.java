package org.hospital.entity;

import java.io.Serializable;

/**
 * Created by pismery on 2017-10-23.
 */
public class BillProjectPK implements Serializable {
    private long billId;
    private long projectId;

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillProjectPK that = (BillProjectPK) o;

        if (billId != that.billId) return false;
        if (projectId != that.projectId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (billId ^ (billId >>> 32));
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        return result;
    }
}
