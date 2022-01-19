package com.github.mrpaulblack.tron;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
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
        System.out.println(store.getcurrentSessionID());

        gridToShow.getChildren().clear();

        sessionID.setText(store.getcurrentSessionID());
        server.setText(store.getserver());
        port.setText(store.getport());
        chosenName.setText(store.getchosenName());
        chosenColor.setText(store.getchosenColor());

        gridToShow.add(new Label("sessionID"), 0, 0, 1, 1);
        gridToShow.add(new Label("server"), 0, 1, 1, 1);
        gridToShow.add(new Label("port"), 0, 2, 1, 1);
        gridToShow.add(new Label("chosenName"), 0, 3, 1, 1);
        gridToShow.add(new Label("chosenColor"), 0, 4, 1, 1);

        gridToShow.add(sessionID, 1, 0, 1, 1);
        gridToShow.add(server, 1, 1, 1, 1);
        gridToShow.add(port, 1, 2, 1, 1);
        gridToShow.add(chosenName, 1, 3, 1, 1);
        gridToShow.add(chosenColor, 1, 4, 1, 1);
        gridToShow.add(refresh, 0, 99, 1, 1);
    }
}
