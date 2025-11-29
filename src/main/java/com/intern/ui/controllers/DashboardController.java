package com.intern.ui.controllers;

import com.intern.ui.DataStore;
import com.intern.ui.models.Internship;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private ListView<Internship> internshipListView;

    @FXML
    private Button addInternshipBtn;

    @FXML
    private Button manageTasksBtn;

    @FXML
    public void initialize() {
        internshipListView.setItems(DataStore.internships);
    }

    @FXML
    private void onAddInternship() throws IOException {
        Parent form = FXMLLoader.load(getClass().getResource("/fxml/internship.fxml"));
        swapScene(form);
    }

    @FXML
    private void onManageTasks() throws IOException {
        Parent tasks = FXMLLoader.load(getClass().getResource("/fxml/task.fxml"));
        swapScene(tasks);
    }

    @FXML
    private void onShowStudents() throws IOException {
        Parent students = FXMLLoader.load(getClass().getResource("/fxml/students.fxml"));
        swapScene(students);
    }

    @FXML
    private void onShowMentors() throws IOException {
        Parent mentors = FXMLLoader.load(getClass().getResource("/fxml/mentors.fxml"));
        swapScene(mentors);
    }

    @FXML
    private void onShowEvaluations() throws IOException {
        Parent eval = FXMLLoader.load(getClass().getResource("/fxml/evaluation.fxml"));
        swapScene(eval);
    }

    @FXML
    private void onShowDashboard() throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
        swapScene(dashboard);
    }

    private void swapScene(Parent newRoot) {
        if (rootPane == null || rootPane.getScene() == null) return;
        Stage stage = (Stage) rootPane.getScene().getWindow();
        if (stage == null || stage.getScene() == null) return;
        stage.getScene().setRoot(newRoot);
    }
}
