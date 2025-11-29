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
    public void onAddInternship() throws IOException {
        Parent form = FXMLLoader.load(DashboardController.class.getResource("/fxml/internship.fxml"));
        swapScene(form);
    }

    @FXML
    public void onManageTasks() throws IOException {
        Parent tasks = FXMLLoader.load(DashboardController.class.getResource("/fxml/task.fxml"));
        swapScene(tasks);
    }

    @FXML
    public void onShowStudents() throws IOException {
        Parent students = FXMLLoader.load(DashboardController.class.getResource("/fxml/students.fxml"));
        swapScene(students);
    }

    @FXML
    public void onShowMentors() throws IOException {
        Parent mentors = FXMLLoader.load(DashboardController.class.getResource("/fxml/mentors.fxml"));
        swapScene(mentors);
    }

    @FXML
    public void onShowEvaluations() throws IOException {
        Parent eval = FXMLLoader.load(DashboardController.class.getResource("/fxml/evaluation.fxml"));
        swapScene(eval);
    }

    @FXML
    public void onShowDashboard() throws IOException {
        Parent dashboard = FXMLLoader.load(DashboardController.class.getResource("/fxml/dashboard.fxml"));
        swapScene(dashboard);
    }

    private void swapScene(Parent newRoot) {
        if (rootPane == null || rootPane.getScene() == null) return;
        javafx.stage.Window w = rootPane.getScene().getWindow();
        if (!(w instanceof Stage)) return;
        Stage stage = (Stage) w;
        if (stage.getScene() == null) return;
        stage.getScene().setRoot(newRoot);
    }
}
