package model.user;

import lib.mysql.Client;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insertUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "insert into users "+
                    "(name, mail, pass, is_working, created_at, updated_at, statuses_id)"+
                    "values(?, ?, ?, ?, ?, ?, 1)";

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
                        rs.getInt("statuses_id"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        null
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

    public static ArrayList<User> selectActiveUsers() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from users where statuses_id <> 1";

            connection = create();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            //スコープの問題があるので一旦外で定義
            ArrayList<User> activeUsers = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        null,
                        null,
                        rs.getBoolean("is_working"),
                        rs.getInt("statuses_id"),
                        null,
                        null,
                        null
                );
                activeUsers.add(user);
            }
            return activeUsers;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static ArrayList<User> selectUsersIsWorkingNotActive() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from users where (is_working = 1 and statuses_id = 1)";

            connection = create();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            //スコープの問題があるので一旦外で定義
            ArrayList<User> isWorkingUsers = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        null,
                        null,
                        rs.getBoolean("is_working"),
                        null,
                        null,
                        null,
                        null
                );
                isWorkingUsers.add(user);
            }
            return isWorkingUsers;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static void switchIsWorking(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文
            String sql = "update users set is_working = ? where id = ?";

            connection = create();

            stmt = connection.prepareStatement(sql);

            stmt.setBoolean(1, user.getIsWorking());
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static void changeStatus(Integer usersId, Integer statusesId) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文
            String sql = "update users set statuses_id = ? where id = ?";

            connection = create();

            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, statusesId);
            stmt.setInt(2, usersId);

            System.out.println(sql);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, rs);
        }
    }
}
