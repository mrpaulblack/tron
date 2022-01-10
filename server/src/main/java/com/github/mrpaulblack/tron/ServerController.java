/*
 * can be tested with nc -u 127.0.0.1 3000 and sending data by typing in terminal and pressing return
 * TODO write docs
 * 
 * example paylods:
 * ### client hello
 * {"type":"hello","data":{"protocolVersion":1}}
 * {"type":"hello","data":{"protocolVersion":-1,"clientName":"tron_cli_client","clientVersion":0.1}}
 * {"type":"hello","data":{"protocolVersion":1,"clientName":"tron_cli_client","clientVersion":0.1}}
 *
 * ### type errors
 * {"type":"test","data":{"test":1}}
 * {"data":{"protocolVersion":1}}
 */
package com.github.mrpaulblack.tron;

import java.net.URI;
import java.util.HashMap;
import org.json.*;



public class ServerController {
    private Server server;
    // TODO this is basically the definition of a memory leak since clients do not get deleted; maybe fixable with a timer that deletes clients!?
    private HashMap<URI, MsgType> clientState = new HashMap<URI, MsgType>();
    private HashMap<URI, String> clientSession = new HashMap<URI, String>();
    private HashMap<String, Game> session = new HashMap<String, Game>();
    private String serverName = "tron_server";
    private float serverVersion = 0.1f;
    private int protocolVersion = 1;



    // server to support sending messages to clients
    public ServerController(Server server) {
        this.server = server;
    }



    // send welcome to client
    private void sendWelcome(URI client) throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();

        json.put("type", MsgType.WELCOME.toString());
        data.put("serverName", serverName);
        data.put("serverVersion", serverVersion);
        json.put("data", data);

        server.send(client, json.toString());
    }



    // send error with optional error message to client
    private void sendError(URI client, MsgError error, String message) throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();

        if (message != null) {
            json.put("message", message);
        }

        json.put("type", MsgType.ERROR.toString());
        data.put("error", error.toString());
        json.put("data", data);

        server.send(client, json.toString());
    }



    // decode payload from a client
    protected void decode(URI client, String payload) {
        try {
            JSONObject json = new JSONObject(payload);
            JSONObject data = new JSONObject(json.get("data").toString());

            if (json.has("type")) {
                // client hello
                if (json.getString("type").equals(MsgType.HELLO.toString())) {
                    if (data.has("protocolVersion") && data.has("clientName") && data.has("clientVersion")) {
                        if (data.getInt("protocolVersion") <= protocolVersion && data.getInt("protocolVersion") > 0) {
                            clientState.put(client, MsgType.HELLO);
                            sendWelcome(client);
                        }
                        else {
                            sendError(client, MsgError.UNSUPPORTEDPROTOCOLVERSION, "Your protocol version is not supported by the server. The server supports version " + protocolVersion + ".");
                            throw new IllegalArgumentException("Protocol version not supported by server");
                        }
                    }
                    else {
                        sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing at least one required keys: protocolVersion, clientName, clientVersion.");
                        throw new IllegalArgumentException("Payload is missing required keys");
                    }
                }

                // client register
                else if (json.getString("type").equals(MsgType.REGISTER.toString()) && clientState.get(client) == MsgType.HELLO) {
                    if (data.has("sessionID")) {
                        if (data.getString("sessionID").length() <= 64) {
                            // create new session if it does not exist already
                            if (session.get(data.getString("sessionID")) == null) {
                                clientSession.put(client, data.getString("sessionID"));
                                // TODO call static game method to return sessionSettings to client
                            }
                            // otherwise register in existing session
                            else {
                                // TODO impl error handl. when client tries to connect to session that is not set up yet by first client; or when client tries to connect to running game
                                // TODO impl register in each actual game
                                // TODO handeling of register in between session create and session status waiting for players
                            }
                            clientState.put(client, MsgType.REGISTER);
                        }
                        else {
                            sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your session ID is to long. The sever alows a maximum length of 64 char.");
                            throw new IllegalArgumentException("Session ID allows a maximum of 64 char");
                        }
                    }
                    else {
                        sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing the required key: sessionID.");
                        throw new IllegalArgumentException("Payload is missing required keys");
                    }
                }

                // client session settings
                else if (json.getString("type").equals(MsgType.SESSIONDATA.toString()) && clientState.get(client) == MsgType.REGISTER) {
                    //start sessiondata by client
                }

                // client lobby settings
                else if (json.getString("type").equals(MsgType.LOBBYDATA.toString()) && clientState.get(client) == MsgType.REGISTER) {
                    //start lobbydata by client
                }

                // client move
                else if (json.getString("type").equals(MsgType.MOVE.toString()) && clientState.get(client) == MsgType.REGISTER) {
                    //start move by client
                }

                // client message
                else if (json.getString("type").equals(MsgType.MESSAGE.toString())) {
                    if (data.getBoolean("broadcast")) {
                        // TODO impl. broadcast of message
                        LogController.log(Log.INFO, "Message from " + client + ": " + json.getString("message"));
                    }
                    else { LogController.log(Log.INFO, "Message from " + client + ": " + json.getString("message")); }
                }

                // client error
                else if (json.getString("type").equals(MsgType.ERROR.toString())) {
                    LogController.log(Log.ERROR, "{" + client + "} Error from client: " + data.get("message"));
                    throw new IllegalArgumentException("Error message from client recieved");
                }

                else {
                    sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your message type is not supported by the server or API request out of order.");
                    throw new IllegalArgumentException("Unsupported message type or out of order");
                }
            }
            else {
                sendError(client, MsgError.UNKNOWN, "Your payload is missing the type key.");
                throw new IllegalArgumentException("Type key is missing from request");
            }
        } catch (Exception e) {
            LogController.log(Log.ERROR, "{" + client + "} " + e.toString());
            //TODO remove client from session if exception
        }
    }
}
