package model.reply;

import model.Default;
import model.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Reply extends Default {

    private String content;
    private Integer consultationsId;
    private Integer usersId;
    private User replier;

    public Reply(Integer id, String content, Timestamp createdAt, Timestamp updatedAt, Integer consultationsId, Integer usersId, User replier){
        super(id, createdAt, updatedAt);
        this.content = content;
        this.consultationsId = consultationsId;
        this.usersId = usersId;
        this.replier = replier;
    }

    public void setContent(String content) { this.content = content; }
    public void setConsultationsId(Integer consultationId) { this.consultationsId = consultationsId; }
    public void setUsersId(Integer usersId) { this.usersId = usersId; }

    public String getContent() { return this.content; }
    public Integer getUsersId() { return this.usersId; }
    public Integer getConsultationsId() { return consultationsId; }
    public User getReplier() { return replier; }

    public void insertReply() { Repository.insertReply(this); }
    public static ArrayList<Reply> selectRepliesByConsultationsId(Integer consultations_id) { return Repository.selectRepliesByConsultationsId(consultations_id); }

}
