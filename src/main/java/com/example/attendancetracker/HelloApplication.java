package com.example.attendancetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/attendancetracker/login-view.fxml"));
        stage.setTitle("Admin Authentication Portal");
        stage.setScene(new Scene(root));
        stage.show();
    }
}