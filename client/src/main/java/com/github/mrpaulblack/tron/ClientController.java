
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

    /**
     * <h1><i>decoder</i></h1>
     * <p>
     * Listens and decode incomming data from the server.
     * </p>
     * 
     * @param payload - Data to be decoded
     */
    private void decode(String payload) throws Exception {
        JSONObject json = new JSONObject(payload);
        JSONObject data = new JSONObject(json.get("data").toString());
        if (json.has("type")) {
            // server welcome
            if (json.getString("type").equals(MsgType.WELCOME.toString())) {
                if (data.has("serverName") && data.has("serverVersion")) {
                    serverstate = MsgType.WELCOME;
                    sendRegister();
                }

            }
            // server sessionssettings
            else if (json.getString("type").equals(MsgType.SESSIONSETTINGS.toString())
                    && serverstate == MsgType.WELCOME) {
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
            // server update
            else if (json.getString("type").equals(MsgType.UPDATE.toString())
                    && serverstate == MsgType.SESSIONSETTINGS) {
                serverstate = MsgType.UPDATE;
                // sendMove();

            }
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
