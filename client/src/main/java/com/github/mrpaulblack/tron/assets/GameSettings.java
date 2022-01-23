package com.github.mrpaulblack.tron.assets;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.github.mrpaulblack.tron.Store;
import javafx.geometry.HPos;

public class GameSettings {
    public static Node displaySettings(String[][] set, boolean showUserInput) {

        GridPane grid = new GridPane();

        if (set.length > 1) {

            Label name = new Label("Name   ");
            Label type = new Label("Type   ");
            Label min = new Label("Min   ");
            Label max = new Label("Max   ");

            GridPane.setHalignment(name, HPos.CENTER);
            GridPane.setHalignment(type, HPos.CENTER);
            GridPane.setHalignment(min, HPos.CENTER);
            GridPane.setHalignment(max, HPos.CENTER);

            grid.add(name, 0, 0, 1, 1);
            grid.add(type, 1, 0, 1, 1);
            grid.add(min, 2, 0, 1, 1);
            grid.add(max, 3, 0, 1, 1);

            GridPane.setHalignment(name, HPos.CENTER);
            GridPane.setHalignment(type, HPos.CENTER);
            GridPane.setHalignment(min, HPos.CENTER);
            GridPane.setHalignment(max, HPos.CENTER);

            for (int i = 0; i < set.length; i++) {

                final Integer thanksJavaForThisShit = i;

                GridPane innergrid = new GridPane();

                Label settname = new Label(set[i][0] + "    ");
                Label setttype = new Label(set[i][1] + "    ");
                Label settmin = new Label(set[i][2] + "    ");
                Label settmax = new Label(set[i][3] + "    ");

                GridPane.setHalignment(settname, HPos.CENTER);
                GridPane.setHalignment(setttype, HPos.CENTER);
                GridPane.setHalignment(settmin, HPos.CENTER);
                GridPane.setHalignment(settmax, HPos.CENTER);

                innergrid.add(settname, 0, 0, 1, 1);
                innergrid.add(setttype, 1, 0, 1, 1);
                innergrid.add(settmin, 2, 0, 1, 1);
                innergrid.add(settmax, 3, 0, 1, 1);

                switch (set[i][1]) {
                    case "String":
                        TextField stringI = new TextField();
                        stringI.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
                        stringI.textProperty().addListener((observable, oldValue, newValue) -> {
                            String[] setup = Store.getGameSetup();
                            setup[thanksJavaForThisShit] = stringI.getText();
                            Store.setGameSetup(setup);
                        });
                        if (showUserInput) {
                            innergrid.add(stringI, 0, 1, 2, 1);
                        }

                        break;
                    case "Int":
                        TextField numberI = new TextField();
                        numberI.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
                        numberI.textProperty().addListener((observable, oldValue, newValue) -> {
                            if (!newValue.matches("\\d*")) {
                                numberI.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                            String[] setup = Store.getGameSetup();
                            setup[thanksJavaForThisShit] = numberI.getText();
                            Store.setGameSetup(setup);
                        });
                        if (showUserInput) {
                            innergrid.add(numberI, 0, 1, 2, 1);
                        }
                        break;
                    case "Boolean":
                        TextField booleanI = new TextField();
                        booleanI.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
                        if (showUserInput) {
                            innergrid.add(booleanI, 0, 1, 2, 1);
                        }
                        break;
                }

                innergrid.setStyle(
                        "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

                grid.add(innergrid, 0, (i + 1), 3, 1);
            }
        }
        grid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        return grid;
    }
}
