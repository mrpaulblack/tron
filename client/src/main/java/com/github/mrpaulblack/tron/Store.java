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

    // ___ALL___
    public String[] getEverything() {
        System.out.println("__STATE__");
        String[] arr = { currentSessionID, port, server };

        for (String string : arr) {
            System.out.println(string);
        }

        System.out.println(arr);
        StoreWindow.refreshStore(this);
        return arr;
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
        }
        System.out.println("param for dummyDataFabric does not exits");
        return "error";
    }
}
