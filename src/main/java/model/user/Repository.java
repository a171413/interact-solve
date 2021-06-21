package model.user;

import lib.mysql.Client;

import java.sql.*;

public class Repository extends Client {
    public static void insertUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "insert into users "+
                    "(name, mail, pass, is_working, created_at, updated_at)"+
                    "values(?, ?, ?, ?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getMail());
            stmt.setString(3, user.getPass());
            stmt.setBoolean(4, user.getIsWorking());
            stmt.setTimestamp(5, currentTime);
            stmt.setTimestamp(6, currentTime);

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
                        rs.getBoolean("is_working"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
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
}
