package com.github.mrpaulblack.tron;

import com.github.mrpaulblack.tron.assets.ShowPlayerStats;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GameReadyScreen extends SceneManager {
        static ShowPlayerStats sps = new ShowPlayerStats();
        static GridPane gridPane = new GridPane();
        static Label header = new Label("Waiting for players");

        public void gameReadyScreen(Stage stage, Boolean isVisible) {

                // Grid Init
                Scene scene = new Scene(new StackPane(gridPane));

                reprintData();

                gridPane.setStyle("-fx-max-width: 500;");

                if (isVisible) {
                        stage.setScene(scene);
                        stage.show();
                }
        }

        public static void reprintData() {
                gridPane.getChildren().clear();
                gridPane.add(header, 0, 0, 1, 1);
                gridPane.add(sps.showOwn(store), 0, 1, 1, 1);

                String[][] DUMMYDATA = { store.getotherPlayerColor(), store.getotherPlayerName(),
                                store.getotherPlayerReady() };

                gridPane.add(ShowPlayerStats.showOther(DUMMYDATA), 0, 2, 1, 1);

                EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                SceneManager.pushTo("gamewindow");
                        }
                };
                Button proceed = new Button("DUMMY FORCE START");
                proceed.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
                proceed.setOnAction(buttonHandler);
                gridPane.add( proceed, 0, 3, 1, 1);

        }
}
