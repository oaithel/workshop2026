package com.example.workshop2026;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        //create two buttons call and send
        Button callBtn = new Button("Call");
        callBtn.setPrefHeight(10);
        callBtn.setPrefWidth(100);
        Button sendBtn = new Button("Send");
        sendBtn.prefHeight(10);
        sendBtn.setPrefWidth(100);
        //create a Vbox to put the buttons one on top of the other
        VBox boxBtn = new VBox();
        boxBtn.setSpacing(10);
        boxBtn.setAlignment(Pos.BASELINE_RIGHT);
        boxBtn.getChildren().addAll(callBtn, sendBtn);
        root.setCenter(boxBtn);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}