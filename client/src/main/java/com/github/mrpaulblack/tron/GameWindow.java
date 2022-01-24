package com.github.mrpaulblack.tron;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameWindow extends SceneManager {
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

        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }
}
