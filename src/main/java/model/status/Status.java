package model.status;

import model.Default;

import java.sql.Timestamp;

public class Status extends Default {

    private String description;

    public Status(
            Integer id,
            String description,
            Timestamp createdAt,
            Timestamp updatedAt
    ){
        super(id, createdAt, updatedAt);
        this.description = description;
    }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() {
        return this.description;
    }

}
