package com.intern.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(Main.class.getResource("/fxml/dashboard.fxml"));
        Scene scene = new Scene(fxml.load());
        scene.getStylesheets().add(Main.class.getResource("/css/style.css").toExternalForm());
        stage.setTitle("Remote Internship Platform");
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(700);
        stage.show();
    }

    public static void main(String[] args) {
        javafx.application.Application.launch(Main.class, args);
    }
}
