package com.intern.ui.controllers;

import com.intern.ui.DataStore;
import com.intern.ui.models.Mentor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MentorController {
    @FXML private AnchorPane rootPane;
    @FXML private ListView<Mentor> mentorListView;
    @FXML private Label nameLabel;
    @FXML private Label emailLabel;

    @FXML
    public void initialize() {
        mentorListView.setItems(DataStore.mentors);
        mentorListView.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> showProfile(newV));
        if (!DataStore.mentors.isEmpty()) mentorListView.getSelectionModel().selectFirst();
    }

    private void showProfile(Mentor m) {
        if (m == null) {
            nameLabel.setText("");
            emailLabel.setText("");
        } else {
            nameLabel.setText(m.getName());
            emailLabel.setText(m.getEmail());
        }
    }

    @FXML
    public void onBack() throws IOException {
        Parent dashboard = FXMLLoader.load(MentorController.class.getResource("/fxml/dashboard.fxml"));
        if (rootPane == null || rootPane.getScene() == null) return;
        javafx.stage.Window w = rootPane.getScene().getWindow();
        if (!(w instanceof Stage)) return;
        Stage stage = (Stage) w;
        if (stage.getScene() == null) return;
        stage.getScene().setRoot(dashboard);
    }
}
