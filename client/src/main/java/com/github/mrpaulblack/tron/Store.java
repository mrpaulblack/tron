package com.github.mrpaulblack.tron;

public class Store {

    // currentSessionID
    private String currentSessionID = "";

    public void setcurrentSessionID(String value) {
        currentSessionID = value;
    }

    public String getcurrentSessionID() {
        return currentSessionID;
    }

    // port
    private String port = "";

    public void setport(String value) {
        port = value;
    }

    public String getport() {
        return port;
    }

    // server
    private String server = "";

    public void setserver(String value) {
        server = value;
    }

    public String getserver() {
        return server;
    }
}
