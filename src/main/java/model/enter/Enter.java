package model.enter;

import model.Default;

import java.sql.Timestamp;

public class Enter extends Default {
    private Integer usersId;
    private Integer statusesId;

    public Enter(
            Integer id,
            Integer usersId,
            Integer statusesId,
            Timestamp createdAt,
            Timestamp updatedAt
    ){
        super(id, createdAt, updatedAt);
        this.usersId = usersId;
        this.statusesId = statusesId;
    }

    public void setUsersId(Integer usersId) { this.usersId = usersId; }
    public void setStatusesId(Integer statusesId) { this.statusesId = statusesId; }

    public Integer getUsersId() { return usersId; }
    public Integer getStatusesId() { return statusesId; }
}
