
package com.github.mrpaulblack.tron;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * <h1><i>ErrorScreen</i></h1>
 * <p>
 * Go to Screen if exeptions are thrown
 * </p>
 * 
 * @param store - Needs the connet store
 */
public class ErrorScreen {

    /**
     * <h1><i>show</i></h1>
     * <p>
     * shows the window.
     * </p>
     * 
     * @param stage     - needs the a given stage to handle the scene
     * @param isVisible - controlls if this scene should be shown or not
     */
    public void show(Stage stage, Boolean isVisible) {

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));

        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // SceneManager.pushTo("launcher");
                SceneManager.pushTo("launcher");
            };
        };
        Button goBack = new Button("Go Back");
        goBack.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
        goBack.setOnAction(buttonHandler);

        gridPane.add(new Label("Someting went wrong"), 0, 0, 1, 1);
        gridPane.add(goBack, 0, 1, 1, 1);

        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }
}
