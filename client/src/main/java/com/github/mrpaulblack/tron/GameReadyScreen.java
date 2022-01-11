package com.github.mrpaulblack.tron;

import com.github.mrpaulblack.tron.assets.ShowPlayerStats;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class GameReadyScreen extends SceneManager {
    public void gameReadyScreen(Stage stage, Boolean isVisible) {

        ShowPlayerStats sps = new ShowPlayerStats();

        // Grid Init
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new StackPane(gridPane));

        Label header = new Label("Waiting for players");


        String[] DUMMY1 = {"Konrad", "Rot", "Ready"};  
        String[] DUMMY2 = {"PaulGeorg", "Blau", "Not Ready"};  
        String[] DUMMY3 = {"Tim", "Gelb", "Ready"};  
        String[][] DUMMYDATA = {DUMMY1, DUMMY2, DUMMY3};  

        gridPane.add(header, 0, 0, 1, 1);
        gridPane.add(sps.showOwn(), 0, 1, 1, 1);
        gridPane.add(sps.showOther(DUMMYDATA), 0, 2, 1, 1);



        gridPane.setStyle("-fx-max-width: 500;");
        
        System.out.println("Show gfs is: " + isVisible);
        if (isVisible) {
            stage.setScene(scene);
            stage.show();
        }
    }
}
