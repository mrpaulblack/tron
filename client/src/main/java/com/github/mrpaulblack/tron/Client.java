package com.github.mrpaulblack.tron;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Window predefinitions go here
        SceneManager sm = new SceneManager();
        sm.windowControll(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}