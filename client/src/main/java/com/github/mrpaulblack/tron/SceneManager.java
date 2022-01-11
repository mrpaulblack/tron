package com.github.mrpaulblack.tron;

import javafx.stage.Stage;

public class SceneManager {
    // To set the Stage for all windows
    static Stage global = null;

    static Store store = new Store();
    static Launcher l = new Launcher(store);
    static CreateGameSession cgs = new CreateGameSession(store);

    
    public void windowControll(Stage stage) {
        global = stage;
        // the Window Logic will happen here
        // window(stage, isVisible); <- Second Parameter will controll the visability

        l.launcher(global, true);
        cgs.createGameSession(stage, false);
    }

    static public void pushTo(String pushto) {

        l.launcher(global, false);
        cgs.createGameSession(global, false);

        System.out.println("try push: " + pushto);
        switch (pushto) {
            case "launcher":
                System.out.println("push to 'Launcher'");
                l.launcher(global, true);
                break;
            case "createGame":
                System.out.println("push to 'createGame'");
                cgs.createGameSession(global, true);
                break;
        }
    }
}
