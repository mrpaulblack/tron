package com.github.mrpaulblack.tron;

import java.util.Random;

public class Store {

    private String currentSessionID = "";
    private String port = "";
    private String server = "";
    public String chosenName = "";
    private String chosenColor = "";
    private String[] otherPlayerName = {};
    private String[] otherPlayerColor = {};

    // ___SESSIONID___
    public void setcurrentSessionID(String value) {
        currentSessionID = value;
    }

    public String getcurrentSessionID() {
        return currentSessionID;
    }

    // ___PORT___
    public void setport(String value) {
        port = value;
    }

    public String getport() {
        return port;
    }

    // ___SERVER___
    public void setserver(String value) {
        server = value;
    }

    public String getserver() {
        return server;
    }

    // ___CHOSENNAME___
    public void setchosenName(String value) {
        chosenName = value;
    }

    public String getchosenName() {
        GameReadyScreen.reprintData();
        return chosenName;
    }

    // ___CHOSENCOLOR___
    public void setchosenColor(String value) {
        GameReadyScreen.reprintData();
        chosenColor = value;
    }

    public String getchosenColor() {
        return chosenColor;
    }

    // ___OTHERPLAYERNAME___
    public void setotherPlayerName(String[] value) {
        GameReadyScreen.reprintData();
        otherPlayerName = value;
    }

    public String[] getotherPlayerName() {
        return otherPlayerName;
    }

    // ___OTHERPLAYERCOLOR___
    public void setotherPlayerColor(String[] value) {
        GameReadyScreen.reprintData();
        otherPlayerColor = value;
    }

    public String[] getotherPlayerColor() {
        return otherPlayerColor;
    }

    // ___ALL___
    public String[] getEverything() {
        System.out.println("__STATE__");
        String[] arr = { currentSessionID, port, server };

        for (String string : arr) {
            System.out.println(string);
        }

        System.out.println(arr);
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
