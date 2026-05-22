module com.example.attendancetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc; // Adds the missing module requirement

    opens com.example.attendancetracker.controller to javafx.fxml;
    opens com.example.attendancetracker.model to javafx.base;

    exports com.example.attendancetracker;
}