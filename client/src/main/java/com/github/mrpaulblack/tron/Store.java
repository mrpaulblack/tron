package com.github.mrpaulblack.tron;

public class Store {

    private String currentSessionID = "";
    private String port = "";
    private String server = "";
    private String chosenName = "";
    private String chosenColor = "";

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
        return chosenName;
    }

    // ___CHOSENCOLOR___
    public void setchosenColor(String value) {
        chosenColor = value;
    }

    public String getchosenColor() {
        return chosenColor;
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
}
