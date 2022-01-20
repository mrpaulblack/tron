package com.github.mrpaulblack.tron;

import com.github.mrpaulblack.tron.assets.ShowPlayerStats;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class GameReadyScreen extends SceneManager {
    static ShowPlayerStats sps = new ShowPlayerStats();
    static GridPane gridPane = new GridPane();
    static Label header = new Label("Waiting for players");

    public void gameReadyScreen(Stage stage, Boolean isVisible) {

        // Grid Init
        Scene scene = new Scene(new StackPane(gridPane));

        reprintData();

        gridPane.setStyle("-fx-max-width: 500;");

        System.out.println("Show gfs is: " + isVisible);
        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void reprintData() {
        gridPane.getChildren().clear();
        gridPane.add(header, 0, 0, 1, 1);
        gridPane.add(sps.showOwn(store), 0, 1, 1, 1);

        String[] DUMMY1 = { store.dummyDataFabric("name"), store.dummyDataFabric("color"),
                store.dummyDataFabric("isReady") };
        String[] DUMMY2 = { store.dummyDataFabric("name"), store.dummyDataFabric("color"),
                store.dummyDataFabric("isReady") };
        String[] DUMMY3 = { store.dummyDataFabric("name"), store.dummyDataFabric("color"),
                store.dummyDataFabric("isReady") };
        String[] DUMMY4 = { store.dummyDataFabric("name"), store.dummyDataFabric("color"),
                store.dummyDataFabric("isReady") };
        String[] DUMMY5 = { store.dummyDataFabric("name"), store.dummyDataFabric("color"),
                store.dummyDataFabric("isReady") };
        String[] DUMMY6 = { store.dummyDataFabric("name"), store.dummyDataFabric("color"),
                store.dummyDataFabric("isReady") };
        String[][] DUMMYDATA = { DUMMY1, DUMMY2, DUMMY3, DUMMY4, DUMMY5, DUMMY6 };

        gridPane.add(sps.showOther(DUMMYDATA), 0, 2, 1, 1);
    }
}
