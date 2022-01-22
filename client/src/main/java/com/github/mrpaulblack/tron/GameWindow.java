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
                System.out.println("Moving Up");
            }
            if ((e.getCode() == KeyCode.D) || (e.getCode() == KeyCode.RIGHT)) {
                System.out.println("Moving Rigth");
            }
            if ((e.getCode() == KeyCode.S) || (e.getCode() == KeyCode.DOWN)) {
                System.out.println("Moving Down");
            }
            if ((e.getCode() == KeyCode.A) || (e.getCode() == KeyCode.LEFT)) {
                System.out.println("Moving Left");
            }

        });

        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }
}
