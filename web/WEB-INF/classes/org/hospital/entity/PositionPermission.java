package org.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
@IdClass(PositionPermissionPK.class)
public class PositionPermission {
    private int positionId;
    private int permissionId;

    @Id
    @Column(name = "positionId", nullable = false, insertable = true, updatable = true)
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Id
    @Column(name = "permissionId", nullable = false, insertable = true, updatable = true)
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

        PositionPermission that = (PositionPermission) o;

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