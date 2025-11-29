package com.intern.ui.controllers;

import com.intern.ui.DataStore;
import com.intern.ui.models.Evaluation;
import com.intern.ui.models.Internship;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EvaluationController {
    @FXML private AnchorPane rootPane;
    @FXML private ComboBox<Internship> internshipCombo;
    @FXML private TextField scoreField;
    @FXML private TextArea commentsArea;
    @FXML private ListView<Evaluation> evaluationListView;

    @FXML
    public void initialize() {
        internshipCombo.setItems(DataStore.internships);
        evaluationListView.setItems(DataStore.evaluations);
        if (!DataStore.internships.isEmpty()) internshipCombo.getSelectionModel().selectFirst();
    }

    @FXML
    private void onSaveEvaluation() {
        Internship selected = internshipCombo.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        int score = 0;
        try { score = Integer.parseInt(scoreField.getText().trim()); } catch (NumberFormatException ignored) {}
        String comments = commentsArea.getText().trim();
        Evaluation e = new Evaluation(selected.getId(), score, comments);
        DataStore.evaluations.add(e);
        scoreField.clear();
        commentsArea.clear();
    }

    @FXML
    private void onBack() throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.getScene().setRoot(dashboard);
    }
}
