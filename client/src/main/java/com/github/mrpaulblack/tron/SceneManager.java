package com.github.mrpaulblack.tron;

import javafx.stage.Stage;

public class SceneManager {
    // To set the Stage for all windows
    static Stage global = null;

    static Store store = new Store();
    static Launcher l = new Launcher();
    static CreateGameSession cgs = new CreateGameSession();
    static GameReadyScreen grs = new GameReadyScreen();

    public void showDebugWindow() {
        // Debug Window for Store
        Stage secondStage = new Stage();
        StoreWindow sw = new StoreWindow();
        sw.showStore(secondStage, store);
    }

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
        grs.gameReadyScreen(global, false);

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
            case "gameReadyScreen":
                System.out.println("push to 'gamReadyScreen'");
                grs.gameReadyScreen(global, true);
                break;
        }
    }
}
