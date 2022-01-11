package com.github.mrpaulblack.tron.assets;

import javafx.scene.control.Button;

public class Buttons {

    public Button CenterdLabeldButton(String name) {

        /*
         * EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
         * 
         * @Override
         * public void handle(ActionEvent event) {
         * event.consume();
         * System.out.println("Button '" + name + "'' has been triggerd");
         * 
         * }
         * };
         */

        Button join = new Button(name);
        join.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
        // join.setOnAction(buttonHandler);

        return join;
    }
}
