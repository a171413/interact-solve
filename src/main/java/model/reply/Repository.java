package model.reply;

import model.Default;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insertReply(Reply reply) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "insert into replies "+
                    "(content, created_at, updated_at, consultations_id, users_id)"+
                    "values(?, ?, ?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, reply.getContent());
            stmt.setTimestamp(2, currentTime);
            stmt.setTimestamp(3, currentTime);
            stmt.setInt(4, reply.getConsultationsId());
            stmt.setInt(5, reply.getUsersId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static ArrayList<Reply> selectRepliesByConsultationsId(Integer consultationsId) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from users inner join (select * from replies where consultations_id = ?)as rep on rep.users_id=users.id";

            connection = create();
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, consultationsId);

            ArrayList<Reply> replies = new ArrayList<>();
            rs = stmt.executeQuery();

            while(rs.next()){
                Reply reply = new Reply(
                        rs.getInt("rep.id"),
                        rs.getString("rep.content"),
                        rs.getTimestamp("rep.created_at"),
                        rs.getTimestamp("rep.updated_at"),
                        rs.getInt("rep.consultations_id"),
                        rs.getInt("rep.users_id"),
                        new User(
                                rs.getInt("users.id"),
                                rs.getString("users.name"),
                                null,
                                null,
                                rs.getBoolean("users.is_working"),
                                rs.getInt("users.status"),
                                null,
                                null,
                                null
                        )
                );
                replies.add(reply);
            }
            return replies;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}
