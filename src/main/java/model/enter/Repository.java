package model.enter;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insertEnter(Enter enter) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "insert into enters "+
                    "(users_id, statuses_id, created_at, updated_at)"+
                    "values(?, ?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, enter.getUsersId());
            stmt.setInt(2, enter.getStatusesId());
            stmt.setTimestamp(3, currentTime);
            stmt.setTimestamp(4, currentTime);

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static void changeEnter(Enter enter) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "update enters set statuses_id = ? where users_id = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, enter.getStatusesId());
            stmt.setInt(2, enter.getUsersId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static void deleteEnter(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
            String sql = "delete from enters where users_id = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static ArrayList<Integer> indexEnters() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
//            String sql = "select statuses_id, count(statuses_id) from enters group by statuses_id";
            String  sql = "select sub.statuses_id, count(*) from(select statuses_id from enters group by statuses_id)as sub";

            connection = create();
            stmt = connection.prepareStatement(sql);

            ArrayList<Integer> enters = new ArrayList<>();
            rs = stmt.executeQuery();
            while(rs.next()) {
                enters.add(rs.getInt("count(*)"));
            }
            return enters;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}
