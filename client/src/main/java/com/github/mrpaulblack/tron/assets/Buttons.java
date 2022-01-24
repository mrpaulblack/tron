
package com.github.mrpaulblack.tron.assets;

import javafx.scene.control.Button;
import com.github.mrpaulblack.tron.SceneManager;

/**
 * <h1>Buttons</h1>
 * <p>
 * Will Generate various Buttons.
 * </p>
 * 
 * @author: swt_lerngruppe_tron
 * @version 1.0
 * @since 2022-01-23
 */
public class Buttons {

    /**
     * <h1><i>CenterdLabeldButton</i></h1>
     * <p>
     * Displays a Centerd Button with Label .
     * </p>
     * 
     * @param name - The Name this Component will work with
     */
    public Button CenterdLabeldButton(String name) {
        Button join = new Button(name);
        join.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");
        // join.setOnAction(buttonHandler);

        return join;
    }

    /**
     * <h1><i>GoTo</i></h1>
     * <p>
     * This Button will push to a given Scene.
     * </p>
     * 
     * @param name - the Name of the Component
     * @param goTo - The Scene to push
     */
    public Button goTo(String name, String goTo) {

        SceneManager.pushTo(goTo);

        Button changeScene = new Button(name);
        changeScene.setStyle("-fx-padding: 10; -fx-border-radius: 20; -fx-pref-width: 9999; -fx-stroke-width: 1");

        return changeScene;
    }
}
