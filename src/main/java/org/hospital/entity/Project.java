package org.hospital.entity;

import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-23.
 */
public class Project {
    private long projectId;
    private long creatorId;
    private String category;
    private String name;
    private int unitPrice;
    private String introduction;
    private short suggestNumber;
    private short type;
    private short status;
    private Timestamp createTime;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public short getSuggestNumber() {
        return suggestNumber;
    }

    public void setSuggestNumber(short suggestNumber) {
        this.suggestNumber = suggestNumber;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projectId != project.projectId) return false;
        if (creatorId != project.creatorId) return false;
        if (unitPrice != project.unitPrice) return false;
        if (suggestNumber != project.suggestNumber) return false;
        if (type != project.type) return false;
        if (status != project.status) return false;
        if (category != null ? !category.equals(project.category) : project.category != null) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (introduction != null ? !introduction.equals(project.introduction) : project.introduction != null)
            return false;
        if (createTime != null ? !createTime.equals(project.createTime) : project.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (projectId ^ (projectId >>> 32));
        result = 31 * result + (int) (creatorId ^ (creatorId >>> 32));
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + unitPrice;
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (int) suggestNumber;
        result = 31 * result + (int) type;
        result = 31 * result + (int) status;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
