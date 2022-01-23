package com.github.mrpaulblack.tron;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import com.github.mrpaulblack.tron.assets.ShowPlayerStats;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StoreWindow {

    static GridPane gridToShow = new GridPane();
    static Button refresh = new Button();
    static Label sessionID = new Label();
    static Label server = new Label();
    static Label port = new Label();
    static Label chosenName = new Label();
    static Label chosenColor = new Label();

    public void showStore(Stage stage, Store store) {

        Scene scene = new Scene(new StackPane(gridToShow));

        gridToShow.setStyle("-fx-max-width: 500;");
        gridToShow.setStyle("-fx-min-width: 100;");

        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                refreshStore(store);
                GameReadyScreen.reprintData();
            }
        };

        refresh.setOnAction(buttonHandler);
        refresh.setText("Refresh");

        refreshStore(store);

        stage.setHeight(400);
        stage.setWidth(400);
        stage.setX(400);
        stage.setY(400);
        stage.setTitle("STORE");
        stage.setScene(scene);
        stage.show();
    }

    public static void refreshStore(Store store) {
        System.out.println("STORE REPRINT");
        System.out.println(store.getcurrentSessionID());

        gridToShow.getChildren().clear();

        GridPane innerGrid = new GridPane();

        sessionID.setText(store.getcurrentSessionID());
        server.setText(store.getserver());
        port.setText(store.getport());
        chosenName.setText(store.getchosenName());
        chosenColor.setText(store.getchosenColor());

        gridToShow.add(new Label("PLAYERDATA"), 0, 0, 2, 1);
        gridToShow.add(new Label("OTHERDATA"), 4, 0, 2, 1);

        innerGrid.add(new Label("sessionID "), 0, 1, 1, 1);
        innerGrid.add(new Label("server "), 0, 2, 1, 1);
        innerGrid.add(new Label("port "), 0, 3, 1, 1);
        innerGrid.add(new Label("chosenName "), 0, 4, 1, 1);
        innerGrid.add(new Label("chosenColor "), 0, 5, 1, 1);

        innerGrid.add(sessionID, 1, 1, 1, 1);
        innerGrid.add(server, 1, 2, 1, 1);
        innerGrid.add(port, 1, 3, 1, 1);
        innerGrid.add(chosenName, 1, 4, 1, 1);
        innerGrid.add(chosenColor, 1, 5, 1, 1);
        innerGrid.add(refresh, 0, 99, 1, 1);
        innerGrid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        gridToShow.add(innerGrid, 0, 1, 1, 1);
        String[][] DUMMYDATA = { store.getotherPlayerColor(), store.getotherPlayerName(),
                store.getotherPlayerReady() };
        gridToShow.add(new Label("OTHERDATA"), 4, 0, 2, 1);
        gridToShow.add(ShowPlayerStats.showOther(DUMMYDATA), 4, 1, 1, 1);
    }
}
