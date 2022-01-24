package com.github.mrpaulblack.tron;

import javafx.application.Application;
import javafx.stage.Stage;

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
			//enable trace for debug
			LogController.setGlobalLogLvl(Log.DEBUG);
            launch();
		} catch (Exception e) {
			LogController.log(Log.ERROR, e.toString());
		}
    }
}
