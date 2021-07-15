package model.enter;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static boolean checkEnter(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //SQL文の用意
            boolean ans = false;
            String sql = "select * from enters where statuses_id = ? and users_id = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setInt(2, user.getId());
            if(Objects.nonNull(stmt.executeQuery())){
                ans = true;
            }
        return ans;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static HashMap<Integer, Integer> indexEnters() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文の用意
//            String sql = "select statuses_id, count(statuses_id) from enters group by statuses_id";
            String  sql = "select statuses_id, count(users_id) from enters group by statuses_id";

            connection = create();
            stmt = connection.prepareStatement(sql);

            HashMap<Integer, Integer> enters = new HashMap<>();
            enters.put(0,0);    //この後ArrayListに変換すると先頭が0番目になってしまうので
            enters.put(1,0);    //未手続きも一応
            enters.put(2,0);
            enters.put(3,0);
            enters.put(4,0);

            rs = stmt.executeQuery();
            while(rs.next()) {
                enters.put(rs.getInt("statuses_id"), rs.getInt("count(users_id)"));
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
