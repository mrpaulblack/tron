
package com.github.mrpaulblack.tron;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * <h1>Client</h1>
 * <p>
 * The Entry class for the client site of TRON.
 * </p>
 * 
 * @author: swt_lerngruppe_tron
 * @version 1.0
 * @since 2022-01-23
 */
public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Window predefinitions go here
        SceneManager sm = new SceneManager();
        sm.showDebugWindow();
        stage.setHeight(800);
        stage.setWidth(600);
        sm.windowControll(stage);
    }

    public static void main(String[] args) {
        try {
            // enable trace for debug
            LogController.setGlobalLogLvl(Log.TRACE);
            launch();
        } catch (Exception e) {
            LogController.log(Log.ERROR, e.toString());
        }
    }
}
