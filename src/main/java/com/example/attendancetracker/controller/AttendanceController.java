package com.example.attendancetracker.controller;

import com.example.attendancetracker.model.Attendance;
import com.example.attendancetracker.repository.AttendanceRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;
import java.time.LocalDate;

public class AttendanceController {
    @FXML private TableView<Attendance> attendanceTable;
    @FXML private TableColumn<Attendance, Integer> colId;
    @FXML private TableColumn<Attendance, String> colName;
    @FXML private TableColumn<Attendance, String> colStatus;
    @FXML private TableColumn<Attendance, LocalDate> colDate;

    @FXML private TextField nameField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private DatePicker datePicker;

    private final AttendanceRepository repository = new AttendanceRepository();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        statusComboBox.setItems(FXCollections.observableArrayList("Present", "Late", "Absent"));
        datePicker.setValue(LocalDate.now());

        refreshTable();
    }

    private void refreshTable() {
        try {
            attendanceTable.setItems(FXCollections.observableArrayList(repository.getAllRecords()));
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }

    @FXML
    private void handleSave() {
        String name = nameField.getText();
        String status = statusComboBox.getValue();
        LocalDate date = datePicker.getValue();

        if (name.isEmpty() || status == null || date == null) return;

        try {
            repository.saveRecord(name, status, date);
            nameField.clear();
            statusComboBox.setValue(null);
            refreshTable();
        } catch (SQLException e) {
            System.err.println("Error saving record: " + e.getMessage());
        }
    }

    @FXML
    private void handleDelete() {
        Attendance selected = attendanceTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        try {
            repository.deleteRecord(selected.getId());
            refreshTable();
        } catch (SQLException e) {
            System.err.println("Error deleting record: " + e.getMessage());
        }
    }
}
