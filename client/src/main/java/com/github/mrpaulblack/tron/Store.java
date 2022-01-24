
package com.github.mrpaulblack.tron;

import java.util.Random;

/**
 * <h1>Store</h1>
 * <p>
 * Will handle all data to be computed in some way.
 * </p>
 * 
 * @author: swt_lerngruppe_tron
 * @version 1.0
 * @since 2022-01-23
 */

public class Store {

    private String currentSessionID = "";
    private String port = "";
    private String server = "";
    private String chosenName = "";
    private String chosenColor = "";
    private String[] otherPlayerName = {};
    private String[] otherPlayerColor = {};
    private String[] otherPlayerReady = {};
    private static String[][] settings = { {} };
    private static String[] gameSetup = {};

    // ___SESSIONID___
    public void setcurrentSessionID(String value) {
        LogController.log(Log.TRACE, "{ " + "Set Session ID: " + value + " } ");
        currentSessionID = value;
    }

    public String getcurrentSessionID() {
        LogController.log(Log.TRACE, "{ " + "Get Session ID: " + currentSessionID + " } ");
        return currentSessionID;
    }

    // ___PORT___
    public void setport(String value) {
        LogController.log(Log.TRACE, "{ " + "Set Port: " + value + " } ");
        port = value;
    }

    public String getport() {
        LogController.log(Log.TRACE, "{ " + "Get Port: " + port + " } ");
        return port;
    }

    // ___SERVER___
    public void setserver(String value) {
        LogController.log(Log.TRACE, "{ " + "Set Server: " + value + " } ");
        server = value;
    }

    public String getserver() {
        LogController.log(Log.TRACE, "{ " + "Get Server: " + server + " } ");
        return server;
    }

    // ___CHOSENNAME___
    public void setchosenName(String value) {
        LogController.log(Log.TRACE, "{ " + "Set Own Name: " + value + " } ");
        chosenName = value;
    }

    public String getchosenName() {
        LogController.log(Log.TRACE, "{ " + "Get Own Name: " + chosenName + " } ");
        return chosenName;
    }

    // ___CHOSENCOLOR___
    public void setchosenColor(String value) {
        LogController.log(Log.TRACE, "{ " + "Set Own Color: " + value + " } ");
        chosenColor = value;
        GameReadyScreen.reprintData();
    }

    public String getchosenColor() {
        LogController.log(Log.TRACE, "{ " + "Get Own Color: " + chosenColor + " } ");
        return chosenColor;
    }

    // ___OTHERPLAYERNAME___
    public void setotherPlayerName(String[] value) {
        otherPlayerName = value;
        GameReadyScreen.reprintData();
    }

    public String[] getotherPlayerName() {

        String[] dummy = { dummyDataFabric("name"),
                dummyDataFabric("name"),
                dummyDataFabric("name"), dummyDataFabric("name"),
                dummyDataFabric("name"), dummyDataFabric("name") };
        otherPlayerName = dummy;
        return otherPlayerName;
    }

    // ___OTHERPLAYERCOLOR___
    public void setotherPlayerColor(String[] value) {
        otherPlayerColor = value;
        GameReadyScreen.reprintData();
    }

    public String[] getotherPlayerColor() {
        String[] dummy = { dummyDataFabric("color"),
                dummyDataFabric("color"),
                dummyDataFabric("color"), dummyDataFabric("color"),
                dummyDataFabric("color"), dummyDataFabric("color") };
        otherPlayerColor = dummy;
        return otherPlayerColor;
    }

    // ___OTHERPLAYERREADY___
    public void setotherPlayerReady(String[] value) {
        otherPlayerReady = value;
        GameReadyScreen.reprintData();
    }

    public String[] getotherPlayerReady() {
        String[] dummy = { dummyDataFabric("isReady"),
                dummyDataFabric("isReady"),
                dummyDataFabric("isReady"), dummyDataFabric("isReady"),
                dummyDataFabric("isReady"), dummyDataFabric("isReady") };
        otherPlayerReady = dummy;
        return otherPlayerReady;
    }

    // ___AVALSETTINGS___
    public void setSettings(String[][] data) {
        settings = data;
        if (gameSetup.length == 0) {
            gameSetup = new String[data.length];
        }
        // SceneManager.pushTo("");
    }

    public String[][] getSettings() {
        return settings;
    }

    // ___GAMESETUP___
    public static void setGameSetup(String[] value) {
        gameSetup = value;
    }

    public static String[] getGameSetup() {
        return gameSetup;
    }

    // ___ALL___
    public String[] getEverything() {
        String[] arr = { currentSessionID, port, server };
        return arr;
    }

    public void reprintStoreWindow() {
        StoreWindow.refreshStore(this);
    }

    /**
     * <h1><i>dummyFabricator</i></h1>
     * <p>
     * generats random data for debug and test purposes.
     * </p>
     * 
     * @param logLvl  - Log ENUM sets the log level of that line
     * @param logLine - String is the actual log line (you can use
     *                [object].toString() when calling this method)
     */
    public String dummyDataFabric(String arg) {
        Random rand = new Random();

        switch (arg) {
            case "name":
                String[] namearr = { "Konrad", "Paul", "Tim", "Georg", "Oskar", "Erik", "Merkel", "ABC", "123" };
                int namerandom = rand.nextInt(namearr.length);
                return namearr[namerandom];
            case "color":
                String[] colorarr = { "Schwarz", "Weiß", "Rot", "Grün", "Blau", "Gelb", "Lila", "Farbe123",
                        "BuchstabenFarbe" };
                int colorrandom = rand.nextInt(colorarr.length);
                return colorarr[colorrandom];
            case "isReady":
                String[] isReadyarr = { "true", "false" };
                int isReadyrandom = rand.nextInt(isReadyarr.length);
                return isReadyarr[isReadyrandom];
            case "settingname":
                String[] settingnamearr = { "Borderkollison", "Color", "Player", "Number", "isTrue", "isFalse" };
                int settingnamerandom = rand.nextInt(settingnamearr.length);
                return settingnamearr[settingnamerandom];
            case "type":
                String[] typearr = { "Boolean", "String", "Int" };
                int typerandom = rand.nextInt(typearr.length);
                return typearr[typerandom];
            case "min":
                String[] minarr = { "1", "2", "4", "7" };
                int minrandom = rand.nextInt(minarr.length);
                return minarr[minrandom];
            case "max":
                String[] maxarr = { "9", "10", "12", "20" };
                int maxrandom = rand.nextInt(maxarr.length);
                return maxarr[maxrandom];
        }
        return "error";
    }
}
