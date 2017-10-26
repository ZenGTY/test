package org.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by pismery on 2017-10-24.
 */
public class PositionPermissionPK implements Serializable {
    private int positionId;
    private int permissionId;

    @Column(name = "positionId", nullable = false, insertable = true, updatable = true)
    @Id
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Column(name = "permissionId", nullable = false, insertable = true, updatable = true)
    @Id
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionPermissionPK that = (PositionPermissionPK) o;

        if (positionId != that.positionId) return false;
        if (permissionId != that.permissionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = positionId;
        result = 31 * result + permissionId;
        return result;
    }
}
