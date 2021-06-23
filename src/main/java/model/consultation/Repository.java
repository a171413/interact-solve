package model.consultation;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insertConsultation(Consultation consultation) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQL文
            String sql = "insert into consultations (title, detail, is_solved, created_at, updated_at, users_id)"
                    +"values (?, ?, ?, ?, ?, ?)";

            connection = create();
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, consultation.getTitle());
            stmt.setString(2, consultation.getDetail());
            stmt.setBoolean(3, consultation.getIsSolved());
            stmt.setTimestamp(4, currentTime);
            stmt.setTimestamp(5, currentTime);
            stmt.setInt(6, consultation.getUserId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static Consultation selectConsultationById(Integer id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from (select * from consultations where id = ?)as consul inner join users";

            connection = create();
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            Consultation consultation = null;
            if(rs.next()){
                consultation = new Consultation(
                        rs.getInt("consul.id"),
                        rs.getString("consul.title"),
                        rs.getString("consul.detail"),
                        rs.getBoolean("consul.is_solved"),
                        rs.getTimestamp("consul.created_at"),
                        rs.getTimestamp("consul.updated_at"),
                        rs.getInt("consul.users_id"),
                        new User(
                                rs.getInt("users.id"),
                                rs.getString("users.name"),
                                null,
                                null,
                                rs.getBoolean("users.is_working"),
                                rs.getInt("users.statuses_id"),
                                null,
                                null,
                                null
                        )
                );
            }
            return consultation;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static ArrayList<Consultation> selectConsultations() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from consultations inner join users on (consultations.users_id=users.id) order by consultations.updated_at limit 0, 30";

            connection = create();
            stmt = connection.prepareStatement(sql);

            //結果を格納するようのリストを作成
            ArrayList<Consultation> consultations = new ArrayList<>();
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consultation consultation = new Consultation(
                        rs.getInt("consultations.id"),
                        rs.getString("consultations.title"),
                        rs.getString("consultations.detail"),
                        rs.getBoolean("consultations.is_solved"),
                        rs.getTimestamp("consultations.created_at"),
                        rs.getTimestamp("consultations.updated_at"),
                        rs.getInt("consultations.users_id"),
                        new User(
                                rs.getInt("users.id"),
                                rs.getString("users.name"),
                                null,
                                null,
                                rs.getBoolean("users.is_working"),
                                rs.getInt("users.statuses_id"),
                                null,
                                null,
                                null
                    )
                );
                consultations.add(consultation);
            }
            return consultations;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static ArrayList<Consultation> selectConsultationsByUserId(Integer usersId) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from consultations where users_id=?";

            connection = create();
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, usersId);

            rs = stmt.executeQuery();

            ArrayList<Consultation> consultations = new ArrayList<>();
            while (rs.next()){
                Consultation consultation = new Consultation(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("detail"),
                        rs.getBoolean("is_solved"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getInt("users_id"),
                       null
                );
                consultations.add(consultation);
            }
            return consultations;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}
