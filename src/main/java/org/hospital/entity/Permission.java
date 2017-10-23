package org.hospital.entity;

/**
 * Created by pismery on 2017-10-23.
 */
public class Permission {
    private int permissionId;
    private String name;

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (permissionId != that.permissionId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
