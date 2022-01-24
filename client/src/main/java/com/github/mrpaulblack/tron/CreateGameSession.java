package com.github.mrpaulblack.tron;

import com.github.mrpaulblack.tron.assets.GameSettings;
import com.github.mrpaulblack.tron.assets.Inputs;
//import com.github.mrpaulblack.tron.assets.Buttons;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreateGameSession extends SceneManager {

        // Grid Init
        static GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));
        static Inputs session = new Inputs();
        static Button join = new Button("Create Session");

        public void createGameSession(Stage stage, Boolean isVisible) {

                // dont wok yet due stupid event handling #thanksjava
                // Buttons join = new Buttons();

                // Button Init

                // get values
                EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                LogController.log(Log.TRACE, "{ " + "Join game" + " } ");
                                event.consume();
                                store.setcurrentSessionID(session.getValue());
                                updateLabel(gridPane, session, join);

                                SceneManager.pushTo("gameReadyScreen");
                                try {
                                        ClientController.sendSessionData();
                                } catch (Exception e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }

                        }
                };

                join.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
                join.setOnAction(buttonHandler);

                gridPane.setStyle("-fx-max-width: 500;");

                updateLabel(gridPane, session, join);

                gridPane.setStyle(
                                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

                /*
                 * String[][] DUMMY = {
                 * { store.dummyDataFabric("settingname"), store.dummyDataFabric("type"),
                 * store.dummyDataFabric("min"),
                 * store.dummyDataFabric("max") },
                 * { store.dummyDataFabric("settingname"), store.dummyDataFabric("type"),
                 * store.dummyDataFabric("min"),
                 * store.dummyDataFabric("max") },
                 * { store.dummyDataFabric("settingname"), store.dummyDataFabric("type"),
                 * store.dummyDataFabric("min"),
                 * store.dummyDataFabric("max") },
                 * { store.dummyDataFabric("settingname"), store.dummyDataFabric("type"),
                 * store.dummyDataFabric("min"),
                 * store.dummyDataFabric("max") },
                 * { store.dummyDataFabric("settingname"), store.dummyDataFabric("type"),
                 * store.dummyDataFabric("min"),
                 * store.dummyDataFabric("max") }, };
                 * store.setSettings(DUMMY);
                 */

                reprintData();

                if (isVisible) {
                        stage.setScene(scene);
                        stage.show();
                }
        }

        // Is needed for better reprint and better ractivity
        private void updateLabel(GridPane gridPane, Inputs session, Button join) {
                LogController.log(Log.TRACE, "{ " + "Update Label in Create Game Session Screen" + " } ");
                gridPane.getChildren().clear();
                gridPane.add(
                                session.CenterdLabeldInput(
                                                "The Session '" + store.getcurrentSessionID()
                                                                + "' dont exits, you can create one"),
                                0, 0, 2, 1);

                gridPane.add(join, 0, 99, 2, 1);
                gridPane.setStyle("-fx-max-width: 500;");
        }

        public static void reprintData() {

                LogController.log(Log.TRACE, "{ " + "Reprint Create Game Session Screen" + " } ");

                gridPane.getChildren().clear();
                gridPane.add(new Label("Game Settings"), 0, 0, 1, 1);
                gridPane.add(GameSettings.displaySettings(store.getSettings(), true), 0, 1, 1, 1);
                gridPane.setStyle(
                                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");
                gridPane.add(
                                session.CenterdLabeldInput(
                                                "The Session '" + store.getcurrentSessionID()
                                                                + "' dont exits, you can create one"),
                                0, 98, 2, 1);

                gridPane.add(join, 0, 99, 2, 1);
        }
}
