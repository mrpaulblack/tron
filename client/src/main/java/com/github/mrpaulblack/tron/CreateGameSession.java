package com.github.mrpaulblack.tron;

import com.github.mrpaulblack.tron.assets.Inputs;
//import com.github.mrpaulblack.tron.assets.Buttons;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreateGameSession  extends SceneManager{

    public void createGameSession(Stage stage, Boolean isVisible) {

        Inputs session = new Inputs();
        // dont wok yet due stupid event handling #thanksjava
        // Buttons join = new Buttons();

        // Grid Init
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));

        //Button Init
        Button join = new Button("Create Session");

        // get values
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                event.consume();
                System.out.println("New Session: " + session.getValue());

                store.setcurrentSessionID(session.getValue());

                // debug
                System.out.println("Server: " + store.getserver());
                System.out.println("Port: " + store.getport());
                System.out.println("Session: " + store.getcurrentSessionID());
                updateLabel(gridPane, session, join);

                SceneManager.pushTo("gameReadyScreen");
            }
        };

        join.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
        join.setOnAction(buttonHandler);

        gridPane.setStyle("-fx-max-width: 500;");

        updateLabel(gridPane, session, join);

        System.out.println("Show gfs is: " + isVisible);
        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }

    //Is needed for better reprint and better ractivity
    private void updateLabel(GridPane gridPane, Inputs session, Button join) {
        gridPane.getChildren().clear();
        gridPane.add(
                session.CenterdLabeldInput(
                        "The Session '" + store.getcurrentSessionID() + "' dont exits, you can create one"),
                0, 0, 2, 1);

        gridPane.add(join, 0, 1, 2, 1);
        gridPane.setStyle("-fx-max-width: 500;");
    }
}
