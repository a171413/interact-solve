package model.consultation;

import model.Default;
import model.user.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Consultation extends Default {

    //属性
    private String title;
    private String detail;
    private boolean isSolved;
    private Integer userId;
    private User contributor;

    //コンストラクタ
    public Consultation(
            Integer id,
            String title,
            String detail,
            Boolean isSolved,
            Timestamp createdAt,
            Timestamp updatedAt,
            Integer userId,
            User contributor
    ){
        super(id, createdAt, updatedAt);
        this.title = title;
        this.detail = detail;
        this.isSolved = isSolved;
        this.userId = userId;
        this.contributor = contributor;
    }

    public void setTitle(String title) { this.title = title; }
    public void setDetail(String detail) { this.detail = detail; }
    public void setIsSolved(Boolean isSolved) { this.isSolved = isSolved; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getTitle() { return this.title; }
    public String getDetail() { return this.detail; }
    public Boolean getIsSolved() { return this.isSolved; }
    public Integer getUserId() { return this.userId; }
    public User getContributor() { return this.contributor; }

    public void insertConsultation(){
        Repository.insertConsultation(this);
    }

    public static ArrayList<Consultation> selectConsultations() {
        return Repository.selectConsultations();
    }

    public static Consultation selectConsultationById(Integer id) {
        return Repository.selectConsultationById(id);
    }

    public static ArrayList<Consultation> selectConsultationsByUserId(Integer usersId) {
        return Repository.selectConsultationsByUserId(usersId);
    }


}
