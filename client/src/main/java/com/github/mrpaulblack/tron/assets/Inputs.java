package com.github.mrpaulblack.tron.assets;

import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Inputs {

    private String value = "";

    public String getValue() {
        return value;
    }

    public Node CenterdLabeldInput(String name) {

        GridPane grid = new GridPane();
        Label label = new Label(name);
        TextField input = new TextField();
        input.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
        GridPane.setHalignment(label, HPos.CENTER);
        grid.add(label, 0, 0, 1, 1);
        grid.add(input, 0, 1, 1, 1);
        grid.getStyleClass().addAll("pane1");
        grid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        input.textProperty().addListener((observable, oldValue, newValue) -> {
           // System.out.println("Check Text in '" + name + "' New Value '" + newValue + "'");
            value = newValue;
        });

        return grid;
    }
}
