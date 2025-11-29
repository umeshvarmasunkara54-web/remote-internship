package com.intern.ui.controllers;

import com.intern.ui.DataStore;
import com.intern.ui.models.Task;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskController {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField taskField;

    @FXML
    private Button addTaskBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ListView<Task> taskListView;

    @FXML
    public void initialize() {
        ObservableList<Task> tasks = DataStore.tasks;
        taskListView.setItems(tasks);

        taskListView.setCellFactory(lv -> new TaskCell());
    }

    private static class TaskCell extends ListCell<Task> {
        private final javafx.scene.control.CheckBox check = new javafx.scene.control.CheckBox();
        private final javafx.scene.text.Text txt = new javafx.scene.text.Text();
        private final javafx.scene.layout.HBox box = new javafx.scene.layout.HBox(8, check, txt);

        TaskCell() {
            box.setStyle("-fx-alignment: CENTER_LEFT;");
        }

        @Override
        protected void updateItem(Task item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setGraphic(null);
            } else {
                check.setSelected(item.isCompleted());
                txt.setText(item.getDescription());
                txt.setStrikethrough(item.isCompleted());
                check.setOnAction(e -> {
                    item.setCompleted(check.isSelected());
                    txt.setStrikethrough(item.isCompleted());
                });
                setGraphic(box);
            }
        }
    }

    @FXML
    public void onAddTask() {
        String text = taskField.getText().trim();
        if (!text.isEmpty()) {
            Task t = new Task(text);
            DataStore.tasks.add(t);
            taskField.clear();
        }
    }

    @FXML
    public void onDeleteSelected() {
        Task sel = taskListView.getSelectionModel().getSelectedItem();
        if (sel != null) {
            DataStore.tasks.remove(sel);
        }
    }

    @FXML
    public void onBack() throws IOException {
        Parent dashboard = FXMLLoader.load(TaskController.class.getResource("/fxml/dashboard.fxml"));
        if (rootPane == null || rootPane.getScene() == null) return;
        javafx.stage.Window w = rootPane.getScene().getWindow();
        if (!(w instanceof Stage)) return;
        Stage stage = (Stage) w;
        if (stage == null || stage.getScene() == null) return;
        stage.getScene().setRoot(dashboard);
    }
}
