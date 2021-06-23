package model.status;

import lib.mysql.Client;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insertStatus(Status status) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文
            String sql = "insert into statuses (description, created_at, updated_at) values (?, ?, ?)";

            connection = create();
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, status.getDescription());
            stmt.setTimestamp(2, currentTime);
            stmt.setTimestamp(3, currentTime);

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static ArrayList<Status> indexStatuses() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文
            String sql = "select * from statuses";
            connection = create();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            ArrayList<Status> statuses = new ArrayList<>();
            while (rs.next()){
                Status status = new Status(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                statuses.add(status);
            }
            return statuses;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}
