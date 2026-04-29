package com.example.workshop2026;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        PortfolioManager ex = new PortfolioManager();
        BorderPane root = ex.getRoot();
        Scene scene = new Scene(root, 620, 340);
        stage.setTitle("Example JavaFX!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}