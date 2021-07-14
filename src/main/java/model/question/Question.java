package model.question;

import model.Default;

import java.sql.Timestamp;

public class Question extends Default {

    private String content;

    public Question(
            Integer id,
            String content,
            Timestamp createdAt,
            Timestamp updatedAt
    ){
        super(id, createdAt, updatedAt);
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
