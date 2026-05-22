package com.example.attendancetracker.model;


import java.time.LocalDate;

public class Attendance {
    private int id;
    private String studentName;
    private String status;
    private LocalDate date;

    public Attendance(int id, String studentName, String status, LocalDate date) {
        this.id = id;
        this.studentName = studentName;
        this.status = status;
        this.date = date;
    }

    public int getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getStatus() { return status; }
    public LocalDate getDate() { return date; }
}