package com.github.mrpaulblack.tron;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Window Contoller
        launcher(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    public void launcher(Stage stage) {

        // Server Input
        GridPane serverGrid = new GridPane();
        Label serverL = new Label("Server");
        TextField serverT = new TextField();
        serverT.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
        GridPane.setHalignment(serverL, HPos.CENTER);
        serverGrid.add(serverL, 0, 0, 1, 1);
        serverGrid.add(serverT, 0, 1, 1, 1);
        serverGrid.getStyleClass().addAll("pane1");
        serverGrid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;"); 

        // Port Input
        GridPane portGrid = new GridPane();
        Label portL = new Label("Port");
        TextField portT = new TextField();
        portT.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
        GridPane.setHalignment(portL, HPos.CENTER);
        portGrid.add(portL, 0, 0, 1, 1);
        portGrid.add(portT, 0, 1, 1, 1);
        portGrid.getStyleClass().addAll("pane2");
        portGrid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        // Session Input
        GridPane sessionGrid = new GridPane();
        Label sessionL = new Label("Session");
        TextField sessionT = new TextField();
        sessionT.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999");
        GridPane.setHalignment(sessionL, HPos.CENTER);
        sessionGrid.add(sessionL, 0, 0, 1, 1);
        sessionGrid.add(sessionT, 0, 1, 1, 1);
        sessionGrid.getStyleClass().addAll("pane3");
        sessionGrid.setStyle(
                "-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999;");

        //Evetn handler for Buttons
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                event.consume();
                //has to be chnaged to logController (not implemented yet)
                System.out.println("helllllo");
                System.out.println(serverT.getText());
                System.out.println(portT.getText());
                System.out.println(sessionT.getText());
            }
        };

        // join Button
        Button join = new Button("join");
        join.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
        join.setOnAction(buttonHandler);

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane), 300, 400);

        gridPane.add(serverGrid, 0, 0, 1, 1);
        gridPane.add(portGrid, 1, 0, 1, 1);
        gridPane.add(sessionGrid, 0, 1, 2, 1);
        gridPane.add(join, 0, 2, 2, 1);
        gridPane.setStyle("-fx-max-width: 500;");

        stage.setScene(scene);
        stage.show();
    }
}