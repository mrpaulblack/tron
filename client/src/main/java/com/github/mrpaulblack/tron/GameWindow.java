
package com.github.mrpaulblack.tron;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * <h1>GameWindow</h1>
 * <p>
 * Displays the GameWindow.
 * </p>
 * 
 * @author: swt_lerngruppe_tron
 * @version 1.0
 * @since 2022-01-23
 */
public class GameWindow extends SceneManager {

    /**
     * <h1><i>gameWindow</i></h1>
     * <p>
     * Print the mainWindow.
     * </p>
     * 
     * @param stage     - needs the a given stage to handle the scene
     * @param isVisible - controlls if this scene should be shown or not
     */
    public void gameWindow(Stage stage, Boolean isVisible) {

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));
        scene.setOnKeyPressed(e -> {
            if ((e.getCode() == KeyCode.W) || (e.getCode() == KeyCode.UP)) {
                LogController.log(Log.TRACE, "{ " + "Move Up" + " } ");
            }
            if ((e.getCode() == KeyCode.D) || (e.getCode() == KeyCode.RIGHT)) {
                LogController.log(Log.TRACE, "{ " + "Move Right" + " } ");
            }
            if ((e.getCode() == KeyCode.S) || (e.getCode() == KeyCode.DOWN)) {
                LogController.log(Log.TRACE, "{ " + "Move Down" + " } ");
            }
            if ((e.getCode() == KeyCode.A) || (e.getCode() == KeyCode.LEFT)) {
                LogController.log(Log.TRACE, "{ " + "Move Left" + " } ");
            }

        });

        int xPixel = 40;
        int yPixel = 40;

        for (int i = 0; i < xPixel; i++) {
            for (int j = 0; j < yPixel; j++) {
                Button PIXEL = new Button("");
                PIXEL.setStyle("-fx-min-width: 15; -fx-max-width: 15; -fx-min-height: 15; -fx-max-height: 15;");
                gridPane.setFillWidth(PIXEL, true);
                gridPane.setFillHeight(PIXEL, true);
                gridPane.add(PIXEL, i, j, 1, 1);
                gridPane.setStyle(
                        "-fx-padding: 10; -fx-border-radius: 20; min-width: 200;-fx-pref-width: 9999;");
            }
        }

        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }
}
