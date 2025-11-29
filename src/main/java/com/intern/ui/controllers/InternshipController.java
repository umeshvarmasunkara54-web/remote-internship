package com.intern.ui.controllers;

import com.intern.ui.DataStore;
import com.intern.ui.models.Internship;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class InternshipController {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField titleField;

    @FXML
    private TextField mentorField;

    @FXML
    private TextField durationField;

    @FXML
    private Button saveBtn;

    @FXML
    private Button backBtn;

    @FXML
    private void onSave() throws IOException {
        String title = titleField.getText().trim();
        String mentor = mentorField.getText().trim();
        String duration = durationField.getText().trim();
        if (!title.isEmpty()) {
            Internship i = new Internship(title, mentor, duration);
            DataStore.internships.add(i);
            goBack();
        }
    }

    @FXML
    @SuppressWarnings("unused")
    private void onBack() throws IOException {
        goBack();
    }

    private void goBack() throws IOException {
        Parent dashboard = FXMLLoader.load(InternshipController.class.getResource("/fxml/dashboard.fxml"));
        if (rootPane == null || rootPane.getScene() == null) return;
        javafx.stage.Window w = rootPane.getScene().getWindow();
        if (!(w instanceof Stage)) return;
        Stage stage = (Stage) w;
        if (stage.getScene() == null) return;
        stage.getScene().setRoot(dashboard);
    }
}
