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

public class CreateGameSession {
    private Store store;

    public CreateGameSession(Store store) {
        this.store = store;
    }

    public void createGameSession(Stage stage, Boolean isVisible) {

        Inputs session = new Inputs();
        // dont wok yet due stupid event handling #thanksjava
        // Buttons join = new Buttons();

        // get values
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                event.consume();
                System.out.println("New Session: " + session.getValue());

                // debug
                System.out.println("Server: " + store.getserver());
                System.out.println("Port: " + store.getport());
                System.out.println("Session: " + store.getcurrentSessionID());

                store.setcurrentSessionID(session.getValue());
            }
        };

        Button join = new Button("Create Session");
        join.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
        join.setOnAction(buttonHandler);

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane), 300, 400);

        gridPane.setStyle("-fx-max-width: 500;");

        gridPane.add(
                session.CenterdLabeldInput(
                        "The Session '" + store.getcurrentSessionID() + "' dont exits, you can create one"),
                0, 0, 2, 1);
        gridPane.add(join, 0, 1, 2, 1);
        gridPane.setStyle("-fx-max-width: 500;");

        stage.setScene(scene);
        if (isVisible) {
            stage.show();
        }
    }
}
