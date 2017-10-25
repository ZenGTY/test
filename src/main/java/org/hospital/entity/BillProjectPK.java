package org.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by pismery on 2017-10-24.
 */
public class BillProjectPK implements Serializable {
    private long billId;
    private long projectId;

    @Column(name = "billId", nullable = false, insertable = true, updatable = true)
    @Id
    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    @Column(name = "projectId", nullable = false, insertable = true, updatable = true)
    @Id
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
