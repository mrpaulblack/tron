package com.github.mrpaulblack.tron;

import javafx.stage.Stage;

public class SceneManager {
    public void windowControll(Stage stage) {
        Launcher l = new Launcher();
        // l.launcher(stage, isVisible);
        // Second Parameter will controll the visability
        l.launcher(stage, true);
    }
}
