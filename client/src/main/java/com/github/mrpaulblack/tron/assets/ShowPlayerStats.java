package com.github.mrpaulblack.tron.assets;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.github.mrpaulblack.tron.Store;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;

public class ShowPlayerStats {
    private String value = "";

    public String getValue() {
        return value;
    }

    public Node showOwn(Store store) {

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

                store.setchosenName(setName.getValue());
                store.setchosenColor(setColor.getValue());
            }
        };

        ready.setOnAction(buttonHandler);
        return grid;
    }

    public static Node showOther(String[][] data) {

        GridPane grid = new GridPane();

        if (data.length > 0) {

            for (Integer i = 0; i < data[0].length; i++) {
                GridPane innerGrid = new GridPane();

                // Label Init
                Label playerName = new Label(data[0][i]);
                Label playerColor = new Label(data[1][i]);
                Label playerReady = new Label(data[2][i]);

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
        }
        grid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        return grid;
    }
}

/*
 * import javafx.scene.shape.SVGPath;
 * 
 * public class Inputs {
 * 
 * private String value = "";
 * 
 * public String getValue() {
 * return value;
 * }
 * 
 * public Node CenterdLabeldInput(String name) {
 * 
 * GridPane grid = new GridPane();
 * Label label = new Label(name);
 * TextField input = new TextField();
 * input.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
 * GridPane.setHalignment(label, HPos.CENTER);
 * 
 * SVGPath svg = new SVGPath();
 * svg.
 * setContent("m12 .5c-6.63 0-12 5.28-12 11.792 0 5.211 3.438 9.63 8.205 11.188.6.111.82-.254.82-.567 0-.28-.01-1.022-.015-2.005-3.338.711-4.042-1.582-4.042-1.582-.546-1.361-1.335-1.725-1.335-1.725-1.087-.731.084-.716.084-.716 1.205.082 1.838 1.215 1.838 1.215 1.07 1.803 2.809 1.282 3.495.981.108-.763.417-1.282.76-1.577-2.665-.295-5.466-1.309-5.466-5.827 0-1.287.465-2.339 1.235-3.164-.135-.298-.54-1.497.105-3.121 0 0 1.005-.316 3.3 1.209.96-.262 1.98-.392 3-.398 1.02.006 2.04.136 3 .398 2.28-1.525 3.285-1.209 3.285-1.209.645 1.624.24 2.823.12 3.121.765.825 1.23 1.877 1.23 3.164 0 4.53-2.805 5.527-5.475 5.817.42.354.81 1.077.81 2.182 0 1.578-.015 2.846-.015 3.229 0 .309.21.678.825.56 4.801-1.548 8.236-5.97 8.236-11.173 0-6.512-5.373-11.792-12-11.792z"
 * );
 * 
 * grid.add(label, 0, 0, 1, 1);
 * grid.add(input, 0, 1, 1, 1);
 * grid.add(svg, 0, 2, 1, 1);
 */