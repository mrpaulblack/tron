
package com.github.mrpaulblack.tron;

import java.net.*;
import java.nio.charset.Charset;
import org.json.*;

/**
 * <h1>ClientController</h1>
 * <p>
 * Controlls the Input/Output for the client.
 * </p>
 * 
 * @author: swt_lerngruppe_tron
 * @version 1.0
 * @since 2022-01-23
 */
public class ClientController extends Thread {

    private static int port;
    private static InetAddress ip;
    private static Store store;
    private static DatagramSocket socket;
    private MsgType serverstate;

    public ClientController(int port, String ip, Store store) throws UnknownHostException, SocketException {

        this.port = port;
        this.ip = InetAddress.getByName(ip);
        this.store = store;
        socket = new DatagramSocket();

    }

    /**
     * <h1><i>run</i></h1>
     * <p>
     * Start method for the JAVA Thread to "run along" the UI.
     * </p>
     */
    public void run() {
        try {
            sendHello();
            while (true) {
                DatagramPacket request = new DatagramPacket(new byte[512], 512);
                socket.receive(request);
                String payload = new String(request.getData(), Charset.forName("utf-8"));
                LogController.log(Log.TRACE, "RX: " + payload);
                decode(payload);
            }
        } catch (Exception e) {
            LogController.log(Log.ERROR, e.toString());
        }
    }

    /**
     * <h1><i>send</i></h1>
     * <p>
     * Sends the Packe to the given Server.
     * </p>
     * 
     * @param payload - the Data to be send
     */
    private static void send(String payload) throws Exception {
        LogController.log(Log.TRACE, "TX: " + payload);
        socket.send(new DatagramPacket(payload.getBytes(), payload.getBytes().length, ip, port));
    }

    private void sendHello() throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        json.put("type", MsgType.HELLO.toString());
        data.put("clientName", "tronclient");
        data.put("clientVersion", 0.1f);
        data.put("protocolVersion", 1);
        json.put("data", data);
        this.send(json.toString());
    }

    public void sendRegister() throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        json.put("type", MsgType.REGISTER.toString());
        data.put("sessionID", store.getcurrentSessionID());
        json.put("data", data);
        this.send(json.toString());
    }

    public static void sendSessionData() throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        json.put("type", MsgType.SESSIONDATA.toString());

        JSONArray toSend = new JSONArray();
        for (int i = 0; i < store.getSettings().length; i++) {
            JSONObject block = new JSONObject();
            block.put("key", store.getSettings()[i][4]);
            block.put("value", Store.getGameSetup()[i]);
            toSend.put(block);
        }
        data.put("settings", toSend);
        json.put("data", data);
        ClientController.send(json.toString());
    }

    private void sendMove() throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        json.put("type", MsgType.MOVE.toString());
        // TODO @Chikseen add store value for move event
        data.put("move", 0);
        json.put("data", data);
        this.send(json.toString());
    }

    private void sendError(MsgError error, String message) throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        if (message != null) {
            json.put("message", message);
        }
        json.put("type", MsgType.ERROR.toString());
        data.put("error", error.toString());
        json.put("data", data);
        send(json.toString());
    }



    private void decode(String payload) {
        try {
            JSONObject json = new JSONObject(payload);
            JSONObject data = new JSONObject(json.get("data").toString());
            if (json.has("type")) {
                //server welcome
                if (json.getString("type").equals(MsgType.WELCOME.toString())) {
                    if (data.has("serverName") && data.has("serverVersion")) {
                        if (data.getFloat("serverVersion") > 0.0f) {
                            serverstate = MsgType.WELCOME;
                            sendRegister();
                        }
                        else {
                            sendError(MsgError.UNSUPPORTEDMESSAGETYPE, "wrong server version.");
                            throw new IllegalArgumentException("wrong server version.");
                        }
                    }
                    else {
                        sendError(MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing at least one required keys: serverName, serverVersion.");
                        throw new IllegalArgumentException("Your payload is missing at least one required keys: serverName, serverVersion.");
                    }
                }

                //server sessionssettings
                else if (json.getString("type").equals(MsgType.SESSIONSETTINGS.toString()) && serverstate == MsgType.WELCOME) {
                    if (data.has("settings")) { 
                        Boolean ok = true;                      
                        for (int i = 0; i < data.getJSONArray("settings").length(); i++) {
                            JSONObject tempSettings = new JSONObject(data.getJSONArray("settings").get(i).toString());
                            if (!tempSettings.has("name") || !(tempSettings.has("key") || !tempSettings.has("type") || !tempSettings.has("rangeMin") || !tempSettings.has("rangeMax"))) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok == true) {
                            serverstate = MsgType.SESSIONSETTINGS;
                            JSONArray array = new JSONArray(data.get("settings").toString());

                            String[][] toStore = new String[array.length()][5];
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject setting = array.getJSONObject(i);

                                toStore[i][0] = setting.get("name").toString();
                                toStore[i][1] = setting.get("type").toString();
                                toStore[i][2] = setting.get("rangeMin").toString();
                                toStore[i][3] = setting.get("rangeMin").toString();
                                toStore[i][4] = setting.get("key").toString();
                            }
                            store.setSettings(toStore);
                        }
                        else {
                            sendError(MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing at least one of the required keys in at least one index of the settings array: name, key, type, rangeMin, rangeMax.");
                            throw new IllegalArgumentException("settings payload is missing at least one key: name, key, type, rangeMin, rangeMax.");
                        }
                    }
                    else {
                        sendError(MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing the required key: settings.");
                        throw new IllegalArgumentException("Your payload is missing the required key: settings.");
                    }
                }

                //server update 
                else if (json.getString("type").equals(MsgType.UPDATE.toString()) && serverstate == MsgType.SESSIONSETTINGS){
                    if(data.has(""))
                    serverstate = MsgType.UPDATE;
                    sendMove();
                }
            }
            else {
                sendError(MsgError.UNKNOWN, "Your payload is missing the type key.");
                throw new IllegalArgumentException("Type key is missing from request");
            }
        } catch (Exception e) {
            LogController.log(Log.ERROR, e.toString());
        }
    }

    private Thread t;

    /**
     * <h1><i>start</i></h1>
     * <p>
     * Start a Thread for the controller.
     * </p>
     */
    public void start() {
        t = new Thread(this, "ClientController");
        t.start();
    }
}


