package com.github.mrpaulblack.tron;

import javafx.stage.Stage;

public class SceneManager {
    public void windowControll(Stage stage) {

        Store store = new Store();

        // the Window Logic will happen here

        // window(stage, isVisible); <- Second Parameter will controll the visability

        Launcher l = new Launcher(store);
        //CreateGameSession cgs = new CreateGameSession(store);

        l.launcher(stage, true);
        // cgs.createGameSession(stage, false);
    }
}
