package com.example.attendancetracker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin(ActionEvent event) {
        if ("admin".equals(usernameField.getText()) && "admin123".equals(passwordField.getText())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/attendancetracker/attendance-view.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Attendance Dashboard");
            } catch (Exception e) {
                errorLabel.setText("Could not load dashboard file.");
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("Invalid credentials.");
        }
    }
}