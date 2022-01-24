
package com.github.mrpaulblack.tron.assets;

import com.github.mrpaulblack.tron.Log;
import com.github.mrpaulblack.tron.LogController;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * <h1>Inputs</h1>
 * <p>
 * Show Various Inputs.
 * </p>
 * 
 * @author: swt_lerngruppe_tron
 * @version 1.0
 * @since 2022-01-23
 */
public class Inputs {

    private String value = "";

    public String getValue() {
        return value;
    }

    /**
     * <h1><i>Centerdlabeldinput</i></h1>
     * <p>
     * Shows a Centerd Input with Label Above.
     * </p>
     * 
     * @param name - Shows the name of the Input
     */
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
            value = newValue;
            LogController.log(Log.TRACE, "{ " + "Input from Currenz Field" + value + " } ");
        });

        return grid;
    }
}
