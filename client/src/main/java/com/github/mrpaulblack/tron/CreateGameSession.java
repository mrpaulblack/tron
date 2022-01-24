
package com.github.mrpaulblack.tron;

import com.github.mrpaulblack.tron.assets.GameSettings;
import com.github.mrpaulblack.tron.assets.Inputs;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * <h1>CreateGameSession</h1>
 * <p>
 * The Window to create a gamesession.
 * </p>
 * 
 * @author: swt_lerngruppe_tron
 * @version 1.0
 * @since 2022-01-23
 */
public class CreateGameSession extends SceneManager {

        // Grid Init
        static GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));
        static Inputs session = new Inputs();
        static Button join = new Button("Create Session");

        /**
         * <h1><i>createGameySession</i></h1>
         * <p>
         * Displays the main section auf the CreateGameSession Screen.
         * </p>
         * 
         * @param stage     - needs the a given stage to handle the scene
         * @param isVisible - controlls if this scene should be shown or not
         */
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

        /**
         * <h1><i>update Label</i></h1>
         * <p>
         * Will update the Label if needed.
         * </p>
         * 
         * @param gridPane - Needs a given gridpane to print the data
         * @param session  - current sessionId
         * @param join     - join button to enable further proccess
         */
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

        /**
         * <h1><i>rePrintData</i></h1>
         * <p>
         * reprint a screen if the data changes.
         * </p>
         */
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
