package com.example.workshop2026;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.text.NumberFormat;

public class PortfolioManager {
    private BorderPane root;
    private Text marketValueTxt, plTxt;
    private DoubleProperty marketValue, profitLoss;
    private ExampleThread myThread;
    private TableView<Position> positionView;

    public PortfolioManager(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        marketValue = new SimpleDoubleProperty();
        //marketValue.set(Double.parseDouble(currencyFormat.format(22434.5)));

        marketValue.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                marketValueTxt.setText(currencyFormat.format(t1.doubleValue()));
            }
        });
        profitLoss = new SimpleDoubleProperty();
        profitLoss.set(2342.123);
           profitLoss.addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    plTxt.setText(""+currencyFormat.format(t1.doubleValue()));
                }
            });
        root = new BorderPane();
        VBox bVbox = bottomBox();
        VBox tBox = topBox();
        root.setBottom(bVbox);
        root.setTop(tBox);
        //create a tableView
        positionView = makeTableView();
        root.setCenter(positionView);
        //create a thread
        myThread = new ExampleThread("ReaderTest", this);
        myThread.start();

    }
    public BorderPane getRoot(){
        return root;
    }
    private TableView<Position> makeTableView(){

    }
    public double getMarketValue() {
        return marketValue.get();
    }

    public DoubleProperty marketValueProperty() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue.set(marketValue);
    }

    public double getProfitLoss() {
        return profitLoss.get();
    }

    public DoubleProperty profitLossProperty() {
        return profitLoss;
    }

    public void setProfitLoss(double profitLoss) {
        this.profitLoss.set(profitLoss);
    }

    private VBox topBox(){
        Label marketValueLabel = new Label("Marker Value");
        marketValueTxt = new Text();
        marketValueTxt.setText("" + marketValue.getValue());
        Label plLabel = new Label("P&L");
        plTxt = new Text();
        plTxt.setText("" + profitLoss.getValue());
        VBox mktValueBox = new VBox();
        mktValueBox.getChildren().addAll(marketValueLabel, marketValueTxt);
        VBox plBox = new VBox();
        plBox.getChildren().addAll(plLabel, plTxt);
        plBox.setSpacing(10);
        plBox.setAlignment(Pos.BASELINE_RIGHT);
        mktValueBox.setSpacing(10);
        mktValueBox.setAlignment(Pos.BASELINE_LEFT);
        HBox plMktBox = new HBox();
        plMktBox.setSpacing(10);
        plMktBox.getChildren().addAll(mktValueBox, plBox);

        MenuBar topMenu = new MenuBar();
        Menu file = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem closeItem = new MenuItem("Close");
        file.getItems().addAll(openItem, closeItem);
        topMenu.getMenus().addAll(file);
        VBox topBox = new VBox();
        topBox.getChildren().addAll(topMenu, plMktBox);
        return topBox;

    }
    private VBox bottomBox(){
        GridPane grid = new GridPane();
        Label symbolLabel = new Label("Symbol");
        Label sharesLabel = new Label("Shares");
        Label priceLabel = new Label("Price");
        TextField symbolTxt = new TextField();
        TextField sharesTxt = new TextField();
        TextField priceTxt = new TextField();
        grid.add(symbolLabel, 0, 0);
        grid.add(symbolTxt, 0, 1);
        grid.add(sharesLabel, 1, 0);
        grid.add(sharesTxt, 1, 1);
        grid.add(priceLabel, 2, 0);
        grid.add(priceTxt, 2, 1);
        grid.setVgap(5);
        grid.setHgap(10);
        //create a buy and sell buttons
        Button buyBtn = new Button("Buy");
        Button sellBtn = new Button("Sell");
        buyBtn.prefHeight(10);
        buyBtn.prefWidth(100);
        buyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               // marketValue.set(marketValue.get() + 10);
                myThread.stopIt();
            }
        });
        //buyBtn.setBackground(new Background(new BackgroundFill(Color.GREEN), null, null, null);
        sellBtn.prefHeight(10);
        sellBtn.prefWidth(100);
        sellBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                profitLoss.set(profitLoss.get() +12);
            }
        });
        ButtonBar btnBar = new ButtonBar();
        btnBar.getButtons().addAll(buyBtn, sellBtn);
        HBox hbtnBox = new HBox();
        hbtnBox.getChildren().addAll(btnBar);
        hbtnBox.setAlignment(Pos.BASELINE_RIGHT);
        VBox retBox = new VBox();
        retBox.setSpacing(10);
        //retBox.setAlignment(Pos.BASELINE_RIGHT);
        VBox gridBox = new VBox();
        //gridBox.setAlignment(Pos.BASELINE_RIGHT);
        gridBox.getChildren().addAll(grid);
        retBox.getChildren().addAll(gridBox, hbtnBox);
        return retBox;
    }

}
