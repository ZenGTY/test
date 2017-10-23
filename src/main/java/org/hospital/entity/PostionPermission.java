package org.hospital.entity;

/**
 * Created by pismery on 2017-10-23.
 */
public class PostionPermission {
    private int positionId;
    private int permissionId;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

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

        PostionPermission that = (PostionPermission) o;

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
