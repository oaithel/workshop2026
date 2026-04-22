package com.example.workshop2026;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ExampleJavaFX {
    private BorderPane root;

    public ExampleJavaFX(){
        root = new BorderPane();
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
        //create a grid and add the textfields and labels to it.
        Label nameLabel = new Label("Name: ");
        Label addressLabel = new Label("Address: ");
        //create a textfield for the name and address
        TextField nameTxt = new TextField();
        TextField addressTxt = new TextField();
        //create a grid
        GridPane grid = new GridPane();
        grid.add(nameLabel, 0, 0);
        grid.add(nameTxt, 1, 0);
        grid.add(addressLabel, 0, 1);
        grid.add(addressTxt, 1, 1);
        grid.setHgap(5);
        grid.setVgap(10);
        //create a horizontal box to put everything one next to the other
        HBox lastBox = new HBox();
        lastBox.setAlignment(Pos.BASELINE_RIGHT);
        lastBox.setSpacing(40);
        lastBox.getChildren().addAll(grid, boxBtn);
        root.setCenter(lastBox);
    }
    public BorderPane getRoot(){
        return root;
    }
}
