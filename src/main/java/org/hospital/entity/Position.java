package org.hospital.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pismery on 2017-10-24.
 */
@Entity
public class Position {
    private int positionId;

    private Employee creator;

    private String name;
    private String description;
    private short rank;
    private Timestamp createTime;

    @Id
    @Column(name = "positionId", nullable = false, insertable = true, updatable = true)
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @ManyToOne
    @JoinColumn(name = "creatorId")
    public Employee getCreator() {
        return creator;
    }

    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rank", nullable = false, insertable = true, updatable = true)
    public short getRank() {
        return rank;
    }

    public void setRank(short rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "createTime", nullable = false, insertable = true, updatable = true)
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

        Position position = (Position) o;

        if (positionId != position.positionId) return false;
        if (creator.getEmployeeId() != position.creator.getEmployeeId()) return false;
        if (rank != position.rank) return false;
        if (name != null ? !name.equals(position.name) : position.name != null) return false;
        if (description != null ? !description.equals(position.description) : position.description != null)
            return false;
        if (createTime != null ? !createTime.equals(position.createTime) : position.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = positionId;
        result = 31 * result + (int) (creator.getEmployeeId() ^ (creator.getEmployeeId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) rank;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
