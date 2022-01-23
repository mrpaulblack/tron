package com.github.mrpaulblack.tron;
import java.net.*;
import java.nio.charset.Charset;
import org.json.*;
 

public class ClientController {
 
    private int port;
    private InetAddress ip;
    private Store store;
    private DatagramSocket socket;
    private MsgType serverstate;

    public ClientController(int port, String ip, Store store) throws UnknownHostException, SocketException {
        
        this.port = port;
        this.ip = InetAddress.getByName(ip);
        this.store = store;
        socket = new DatagramSocket();

    }

    protected void receive() {	
        try {
            sendHello();
            while (true) {
                DatagramPacket request = new DatagramPacket(new byte[512], 512);
                socket.receive(request);
                String payload = new String(request.getData(), Charset.forName("utf-8"));
                LogController.log(Log.TRACE,"RX: " + payload);
                decode(payload);
            }
        } catch (Exception e) {
            LogController.log(Log.ERROR, e.toString());
        }
	}

    private void send(String payload) throws Exception {
        LogController.log(Log.TRACE,"TX: " + payload);
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

    private void sendRegister() throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        json.put("type", MsgType.REGISTER.toString());
        // TODO @Chikseen add store value for tron session
        data.put("sessionID", "tronsession");
        json.put("data", data);
        this.send(json.toString());
    }

    private void sendSessionData() throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        json.put("type", MsgType.SESSIONDATA.toString());
        // TODO @Chikseen add settings JSONArray with settings from client -> see tron spec
        data.put("dataSettings", "settings"); // Store.getSettings(); ?
        json.put("data", data);
        this.send(json.toString());
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

    private void decode(String payload) throws Exception {
        JSONObject json = new JSONObject(payload);
        JSONObject data = new JSONObject(json.get("data").toString());
        if (json.has("type")) {
            //server welcome
            if (json.getString("type").equals(MsgType.WELCOME.toString())) {
                if (data.has("serverName") && data.has("serverVersion")) {
                serverstate = MsgType.WELCOME;
                sendRegister();               
                }


            }
            //server sessionssettings
            else if (json.getString("type").equals(MsgType.SESSIONSETTINGS.toString()) && serverstate == MsgType.WELCOME){
                serverstate = MsgType.SESSIONSETTINGS;
                sendSessionData();
            }
            //server update 
            else if (json.getString("type").equals(MsgType.UPDATE.toString()) && serverstate == MsgType.SESSIONSETTINGS){
                serverstate = MsgType.UPDATE;
                sendMove();

            }

        }
    }
}
