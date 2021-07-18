package model.user;

import lib.mysql.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class Repository extends Client {
    public static void insertUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "insert into users "+
                    "(name, mail, pass, birthday, answer, created_at, updated_at, questions_id)"+
                    "values(?, ?, ?, ?, ?, ?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getMail());
            stmt.setString(3, user.getPass());
            stmt.setDate(4, user.getBirthday());
            stmt.setString(5, user.getAnswer());
            stmt.setTimestamp(6, currentTime);
            stmt.setTimestamp(7, currentTime);
            stmt.setInt(8, user.getQuestionId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static User selectUserByMail(String mail) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from users where mail = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, mail);

            rs = stmt.executeQuery();

            //スコープの問題があるので一旦外で定義
            User user = null;
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("mail"),
                        rs.getString("pass"),
                        rs.getDate("birthday"),
                        rs.getString("answer"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getInt("questions_id")
                );
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }

   public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return  (User) session.getAttribute(User.currentUserKey);
    }

    public static void updatePassword(User user){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "UPDATE users SET pass = ?, updated_at = ? where id = ?";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, user.getPass());
            stmt.setTimestamp(2, currentTime);
            stmt.setInt(3, user.getId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

}
