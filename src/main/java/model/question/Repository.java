package model.question;

import lib.mysql.Client;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static Question getQuestion(Integer id){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = create();

            String sql = "select * from questions where id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            Question question = null;
            if(rs.next()){
                question = new Question(
                        rs.getInt("id"),
                        rs.getString("content"),
                        null,
                        null
                );
            }
            return question;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            close(connection, stmt, rs);
        }
    }

    public static ArrayList<Question> indexQuestions() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from questions";

            connection = create();
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();

            ArrayList<Question> questions = new ArrayList<>();
            while (rs.next()){
                Question question = new Question(
                        rs.getInt("id"),
                        rs.getString("content"),
                        null,
                        null
                );
                questions.add(question);
            }
            return questions;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            close(connection, stmt, rs);
        }
    }

}
