package com.github.mrpaulblack.tron;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import com.github.mrpaulblack.tron.assets.Inputs;
//import com.github.mrpaulblack.tron.assets.Buttons;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Launcher extends SceneManager {

    public void launcher(Stage stage, Boolean isVisible) {

        Inputs server = new Inputs();
        Inputs port = new Inputs();
        Inputs session = new Inputs();
        // dont wok yet due stupid event handling #thanksjava
        // Buttons join = new Buttons();
        // get values

        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                event.consume();

                store.setserver(server.getValue());
                store.setport(port.getValue());
                store.setcurrentSessionID(session.getValue());
                LogController.log(Log.DEBUG, "{ " + "Join Game with" + " } ");
                LogController.log(Log.DEBUG, "{ " + "Port   : " + store.getport() + " } ");
                LogController.log(Log.DEBUG, "{ " + "Server : " + store.getserver() + " } ");

                try {
                    ClientController cc = new ClientController(Integer.parseInt(store.getport()), store.getserver(),
                            store);

                    cc.start();

                    try {
                        cc.sendRegister();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                        SceneManager.pushTo("createGame");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        SceneManager.pushTo("");
                    }
                } catch (UnknownHostException | SocketException e) {
                    SceneManager.pushTo("");
                    e.printStackTrace();
                }

            }
        };
        Button join = new Button("join");
        join.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
        join.setOnAction(buttonHandler);

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));

        gridPane.setStyle("-fx-max-width: 500;");

        gridPane.add(server.CenterdLabeldInput("Server"), 0, 0, 1, 1);
        gridPane.add(port.CenterdLabeldInput("Port"), 1, 0, 1, 1);
        gridPane.add(session.CenterdLabeldInput("Session"), 0, 1, 2, 1);
        gridPane.add(join, 0, 2, 2, 1);
        gridPane.setStyle("-fx-max-width: 500;");

        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }
}
