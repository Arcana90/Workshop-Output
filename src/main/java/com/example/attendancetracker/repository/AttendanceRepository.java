package com.example.attendancetracker.repository;

import com.example.attendancetracker.model.Attendance;
import com.example.attendancetracker.util.Database;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository {

    public List<Attendance> getAllRecords() throws SQLException {
        List<Attendance> records = new ArrayList<>();
        String sql = "SELECT id, student_name, status, date FROM public.attendance ORDER BY id DESC";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                records.add(new Attendance(
                        rs.getInt("id"),
                        rs.getString("student_name"),
                        rs.getString("status"),
                        rs.getDate("date").toLocalDate()
                ));
            }
        }
        return records;
    }

    public void saveRecord(String name, String status, LocalDate date) throws SQLException {
        String sql = "INSERT INTO public.attendance (student_name, status, date) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, status);
            pstmt.setDate(3, Date.valueOf(date));
            pstmt.executeUpdate();
        }
    }

    public void deleteRecord(int id) throws SQLException {
        String sql = "DELETE FROM public.attendance WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}