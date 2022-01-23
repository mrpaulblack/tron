package com.github.mrpaulblack.tron;

import java.util.Random;

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

    /*
     * private String[] otherPlayerName = { dummyDataFabric("name"),
     * dummyDataFabric("name"),
     * dummyDataFabric("name"), dummyDataFabric("name"),
     * dummyDataFabric("name"), dummyDataFabric("name") };
     * private String[] otherPlayerColor = { dummyDataFabric("color"),
     * dummyDataFabric("color"),
     * dummyDataFabric("color"), dummyDataFabric("color"),
     * dummyDataFabric("color"), dummyDataFabric("color") };
     * private String[] otherPlayerReady = { dummyDataFabric("isReady"),
     * dummyDataFabric("isReady"),
     * dummyDataFabric("isReady"), dummyDataFabric("isReady"),
     * dummyDataFabric("isReady"), dummyDataFabric("isReady") };
     */
    // ___SESSIONID___
    public void setcurrentSessionID(String value) {
        currentSessionID = value;
        StoreWindow.refreshStore(this);
    }

    public String getcurrentSessionID() {
        return currentSessionID;
    }

    // ___PORT___
    public void setport(String value) {
        port = value;
        StoreWindow.refreshStore(this);
    }

    public String getport() {
        return port;
    }

    // ___SERVER___
    public void setserver(String value) {
        server = value;
        StoreWindow.refreshStore(this);
    }

    public String getserver() {
        return server;
    }

    // ___CHOSENNAME___
    public void setchosenName(String value) {
        chosenName = value;
        StoreWindow.refreshStore(this);
    }

    public String getchosenName() {

        return chosenName;
    }

    // ___CHOSENCOLOR___
    public void setchosenColor(String value) {
        chosenColor = value;
        GameReadyScreen.reprintData();
        StoreWindow.refreshStore(this);
    }

    public String getchosenColor() {
        return chosenColor;
    }

    // ___OTHERPLAYERNAME___
    public void setotherPlayerName(String[] value) {
        otherPlayerName = value;
        GameReadyScreen.reprintData();
        StoreWindow.refreshStore(this);
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
        StoreWindow.refreshStore(this);
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
        StoreWindow.refreshStore(this);
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
    public void setSettings(String[][] value) {
        settings = value;

        if (gameSetup.length == 0) {
            gameSetup = new String[value.length];
        }
        CreateGameSession.reprintData();
        StoreWindow.refreshStore(this);
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
        System.out.println("__STATE__");
        String[] arr = { currentSessionID, port, server };

        for (String string : arr) {
            System.out.println(string);
        }
        StoreWindow.refreshStore(this);
        return arr;
    }

    public void reprintStoreWindow() {
        StoreWindow.refreshStore(this);
    }

    // DEBUG
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
        System.out.println("param for dummyDataFabric does not exits");
        return "error";
    }
}
