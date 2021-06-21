package model;

import java.sql.Timestamp;

public class Default {
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updateAt;

    public Default(Integer id, Timestamp createdAt, Timestamp updateAt){
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }
}
