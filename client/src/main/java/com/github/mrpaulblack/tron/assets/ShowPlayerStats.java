package com.github.mrpaulblack.tron.assets;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ShowPlayerStats {
    private String value = "";

    public String getValue() {
        return value;
    }

    public Node showOwn() {

        GridPane grid = new GridPane();

        // field Init
        Inputs setName = new Inputs();
        Inputs setColor = new Inputs();
        Button ready = new Button("Ready");

        ready.setStyle("-fx-min-width: 50;");

        grid.add(setName.CenterdLabeldInput("Name"), 0, 0, 1, 1);
        grid.add(setColor.CenterdLabeldInput("Color"), 1, 0, 1, 1);
        // grid.add(null, 2, 0, 1, 1);
        grid.add(ready, 3, 0, 1, 1);

        grid.getStyleClass().addAll("pane1");
        grid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        // btn event handler
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                event.consume();
                System.out.println("hi");
            }
        };

        ready.setOnAction(buttonHandler);
        return grid;
    }

    public Node showOther(String[][] data) {

        GridPane grid = new GridPane();

        for (Integer i = 0; i < data.length; i++) {
            GridPane innerGrid = new GridPane();

            // Label Init
            Label playerName = new Label(data[i][0]);
            Label playerColor = new Label(data[i][1]);
            Label playerReady = new Label(data[i][2]);

            // Label align center (Why not in fxcss #thxjavafx)
            GridPane.setHalignment(playerName, HPos.CENTER);
            GridPane.setHalignment(playerColor, HPos.CENTER);
            GridPane.setHalignment(playerReady, HPos.CENTER);

            // css styleing
            playerName.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
            playerColor.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
            playerReady.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");

            // add label to grid
            innerGrid.add(playerName, 0, 0, 1, 1);
            innerGrid.add(playerColor, 1, 0, 1, 1);
            innerGrid.add(playerReady, 2, 0, 1, 1);

            innerGrid.getStyleClass().addAll("pane1");
            innerGrid.setStyle(
                    "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

            grid.add(innerGrid, 0, i, 1, 1);
        }
        grid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        return grid;
    }
}
