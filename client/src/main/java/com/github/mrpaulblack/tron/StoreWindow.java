package com.github.mrpaulblack.tron;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StoreWindow {
    public void showStore(Stage stage, Store store) {

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));

        gridPane.setStyle("-fx-max-width: 500;");

        Label test = new Label("store.get: " + store.getcurrentSessionID());

        gridPane.add(test , 0, 0, 1, 1);
        gridPane.setStyle("-fx-max-width: 500;");

        System.out.println("Show debug Window");

        stage.setScene(scene);
        stage.show();
    }
}
