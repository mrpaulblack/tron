package com.github.mrpaulblack.tron;

import javafx.stage.Stage;

public class SceneManager {
    // To set the Stage for all windows
    static Stage global = null;

    static Store store = new Store();
    static Launcher l = new Launcher();
    static CreateGameSession cgs = new CreateGameSession();
    static GameReadyScreen grs = new GameReadyScreen();
    static GameWindow gw = new GameWindow();

    public void showDebugWindow() {
        // Debug Window for Store
        if ((LogController.getGlobalLogLvl() == Log.DEBUG) || LogController.getGlobalLogLvl() == Log.TRACE) {
            Stage secondStage = new Stage();
            StoreWindow sw = new StoreWindow();
            sw.showStore(secondStage, store);
            LogController.log(Log.TRACE, "{ " + "Open Store DebugWindow" + " } ");
        }
    }

    public void windowControll(Stage stage) {
        global = stage;
        // the Window Logic will happen here
        // window(stage, isVisible); <- Second Parameter will controll the visability

        l.launcher(global, true);
        cgs.createGameSession(stage, false);
        LogController.log(Log.TRACE, "{ " + "Open Launcher" + " } ");
    }

    static public void pushTo(String pushto) {

        l.launcher(global, false);
        cgs.createGameSession(global, false);
        grs.gameReadyScreen(global, false);
        gw.gameWindow(global, false);

        LogController.log(Log.TRACE, "{ " + "Try to set Scene " + pushto + " } ");
        switch (pushto) {
            case "launcher":
                l.launcher(global, true);
                break;
            case "createGame":
                cgs.createGameSession(global, true);
                break;
            case "gameReadyScreen":
                grs.gameReadyScreen(global, true);
                break;
            case "gamewindow":
                gw.gameWindow(global, true);
                break;
            default:
        }
    }
}
