package com.github.mrpaulblack.tron;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Timer;
import java.util.UUID;
import java.util.Map.Entry;

import org.json.*;



/**
 * <p>ServerController that supports the tron API spec. This Class basically gets JSON
 * payloads and decodes them and returns the correct payloads back to the clients. It also
 * sits between clients and the Game lib an sanitizes payloads.</p>
 *
 * example paylods:
 * ### client hello
 * {"type":"hello","data":{"protocolVersion":1}}
 * {"type":"hello","data":{"protocolVersion":-1,"clientName":"tron_cli_client","clientVersion":0.1}}
 * {"type":"hello","data":{"protocolVersion":1,"clientName":"tron_cli_client","clientVersion":0.1}}
 * 
 * ### client register
 * {"type":"register","data":{"protocolVersion":1}}
 * {"type":"register","data":{"sessionID":""}}
 * {"type":"register","data":{"sessionID":"test"}}
 *
 * ### client sessionData
 * {"type":"sessionData","data":{"settings":[{"key":"board_size","valueInt":10}]}}
 * {"type":"sessionData","data":{"settings":[{"key":"board_size","valueInt":10},{"key":"player_num","valueInt":2},{"key":"cell_size","valueInt":10},{"key":"bicicle_tail_size","valueInt":3}]}}
 * 
 * ### client lobbyData
 * {"type":"lobbyData","data":{"name":"Marie","color":"red","ready":"true"}}
 * {"type":"lobbyData","data":{"name":"Marie","color":"blue","ready":"false"}}
 * {"type":"lobbyData","data":{"name":"Marie","color":"blue","ready":"true"}}
 * {"type":"lobbyData","data":{"name":"Alex","color":"red","ready":"false"}}
 * {"type":"lobbyData","data":{"name":"Alex","color":"red","ready":"true"}}
 * 
 * ### client move
 * {"type":"move","data":{"move":0}}
 * {"type":"move","data":{"move":1}}
 * {"type":"move","data":{"move":2}}
 * {"type":"move","data":{"move":-1}}
 * 
 * ### type errors
 * {"type":"test","data":{"test":1}}
 * {"data":{"protocolVersion":1}}
 * 
 * @version 1.0
 * @since   2021-12-29
 */
public class ServerController {
    private Server server;
    private HashMap<URI, UUID> clientID = new HashMap<URI, UUID>();
    private HashMap<URI, LocalDateTime> clientTimeout = new HashMap<URI, LocalDateTime>();
    private HashMap<URI, MsgType> clientState = new HashMap<URI, MsgType>();
    private HashMap<URI, String> clientSession = new HashMap<URI, String>();
    private HashMap<String, GameController> session = new HashMap<String, GameController>();
    private Timer timer = new Timer();
    private String serverName = "tron_server";
    private float serverVersion = 0.1f;
    private int protocolVersion = 1;



    /**
	 * <p>This contructor creates the ServerController and a timeout timer. It sets the default
     * timeout for clients and also sets the server with which the ServerController interacts.</p>
	 * @param server - Server that can send and recieve data
	 * @param timeout_s - long of the timeout for each client in seconds
     * @param period_ms - long of the time in ms when the timeout timer checks if a client reached a timeout
	 */
    public ServerController(Server server, long timeout_s, long period_ms) {
        this.server = server;
        this.timer.schedule(new TimeoutTimer(this, timeout_s), 0, period_ms);
    }



    /**
	 * <p>This method sends the welcome defined in the Tron API spec
     * to the client passed as the first argument.</p>
	 * @param client - URI of the client where the data is send to
     * @throws Exception - generic Exception
	 */
    private void sendWelcome(URI client) throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();

        json.put("type", MsgType.WELCOME.toString());
        data.put("serverName", serverName);
        data.put("serverVersion", serverVersion);
        json.put("data", data);

        server.send(client, json.toString());
    }



    /**
	 * <p>This method sends the session settings defined in the Tron API spec
     * to the client passed as the first argument.</p>
	 * @param client - URI of the client where the data is send to
     * @throws Exception - generic Exception
	 */
    private void sendSessionSettings(URI client) throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();

        json.put("type", MsgType.SESSIONSETTINGS.toString());
        data.put("settings", GameController.getSettings());
        json.put("data", data);

        server.send(client, json.toString());
    }



    /**
	 * <p>This method returns a specific error with an optional string
     * message to a specific client.</p>
	 * @param client - URI of the client where the data is send to
     * @param error - MsgError of the specific error type
     * @param message - String is an optional message returned to the client
     * @throws Exception - generic Exception
	 */
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



    /**
	 * <p>This method sends the update from the game to all client in
     * a session ID.</p>
	 * @param sessionID - String of the session id of the specific game
     * @throws Exception - generic Exception
	 */
    private void broadcastUpdate(String sessionID) throws Exception {
        JSONObject json = new JSONObject();
    
        json.put("type", MsgType.UPDATE.toString());
        json.put("data", session.get(sessionID).toJSON());

        for (Entry<URI, String> entry : clientSession.entrySet()) {
            if (entry.getValue().equals(sessionID)) {
                server.send(entry.getKey(), json.toString());
            }
        }
    }



    /**
	 * <p>This method broadcasts a String message from a specfic client to eacht client in a
     * session ID.</p>
	 * @param sessionID - String of the session ID where the message is getting broadcast to
     * @param sender - URI of the origin client of the message
     * @param message - String is the actual message broadcasted to the clients in a session
     * @throws Exception - generic Exception
	 */
    private void broadcastMessage(String sessionID, URI sender, String message) throws Exception {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
    
        json.put("type", MsgType.UPDATE.toString());
        json.put("message", message);
        data.put("sender", clientID.get(sender));
        json.put("data", data);

        for (Entry<URI, String> entry : clientSession.entrySet()) {
            if (entry.getValue().equals(sessionID) && entry.getKey() != sender) {
                server.send(entry.getKey(), json.toString());
            }
        }
    }



    /**
	 * <p>This is the main decoder method. It recieves a String payload from a client
     * and parses and sanitizes it, following the Tron API spec. This method also calls other methods
     * that return data to the client as well as updated the game lib with sanitized data from the client.</p>
	 * @param client - URI of the client that send the payload
     * @param payload - String of the payload recieved by client
	 */
    protected void decode(URI client, String payload) {
        clientTimeout.put(client, LocalDateTime.now());
        try {
            JSONObject json = new JSONObject(payload);
            JSONObject data = new JSONObject(json.get("data").toString());

            if (json.has("type")) {
                // client hello
                if (json.getString("type").equals(MsgType.HELLO.toString())) {
                    if (data.has("protocolVersion") && data.has("clientName") && data.has("clientVersion")) {
                        if (data.getInt("protocolVersion") <= protocolVersion && data.getInt("protocolVersion") > 0) {
                            clientID.put(client, UUID.randomUUID());
                            clientState.put(client, MsgType.HELLO);
                            LogController.log(Log.DEBUG, "{" + clientID.get(client) + "} has send HELLO");
                            sendWelcome(client);
                        }
                        else {
                            sendError(client, MsgError.UNSUPPORTEDPROTOCOLVERSION, "Your protocol version is not supported by the server. The server supports version " + protocolVersion + ".");
                            throw new IllegalArgumentException("Protocol version not supported by server");
                        }
                    }
                    else {
                        sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing at least one required keys: protocolVersion, clientName, clientVersion.");
                        throw new IllegalArgumentException("payload is missing at least one required keys: protocolVersion, clientName, clientVersion");
                    }
                }

                // client register
                else if (json.getString("type").equals(MsgType.REGISTER.toString()) && clientState.get(client) == MsgType.HELLO) {
                    if (data.has("sessionID")) {
                        if (data.getString("sessionID").length() <= 64 && data.getString("sessionID").length() >= 1) {
                            // create new session if it does not exist already
                            if (!session.containsKey(data.getString("sessionID"))) {
                                session.put(data.getString("sessionID"), null);
                                clientSession.put(client, data.getString("sessionID"));
                                LogController.log(Log.DEBUG, "{" + clientID.get(client) + "} created new session with session ID: " + clientSession.get(client));
                                clientState.put(client, MsgType.SESSIONDATA);
                                sendSessionSettings(client);
                            }
                            // otherwise register in existing session
                            else if (session.get(data.getString("sessionID")) != null) {
                                // TODO fill name and version with name and version from hello payload
                                if (session.get(data.getString("sessionID")).register(clientID.get(client), "dummy name", 0.1f)) {
                                    clientSession.put(client, data.getString("sessionID"));
                                    LogController.log(Log.DEBUG, "{" + clientID.get(client) + "} has registred to existing session with ID: " + clientSession.get(client));
                                    clientState.put(client, MsgType.REGISTER);
                                    broadcastUpdate(clientSession.get(client));
                                }
                                else {
                                    sendError(client, MsgError.SERVERFULL, "The session is already full or has already started.");
                                    throw new IllegalArgumentException("session full");
                                }
                            }
                            else {
                                sendError(client, MsgError.UNKNOWN, "The session is still getting configured.");
                                throw new IllegalArgumentException("session is not configured yet");
                            }
                        }
                        else {
                            sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your session ID is to long or to small. The server allows between 1 and 64 char.");
                            throw new IllegalArgumentException("session ID needs to be between 1 and 64 char");
                        }
                    }
                    else {
                        sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing the required key: sessionID.");
                        throw new IllegalArgumentException("payload is missing the required key: sessionID");
                    }
                }

                // client session data
                else if (json.getString("type").equals(MsgType.SESSIONDATA.toString()) && clientState.get(client) == MsgType.SESSIONDATA) {
                    if (data.has("settings")) {
                        Boolean ok = true;
                        for (int i = 0; i < data.getJSONArray("settings").length(); i++) {
                            JSONObject tempSettings = new JSONObject(data.getJSONArray("settings").get(i).toString());
                            if (!tempSettings.has("key") && !(tempSettings.has("valueInt") || tempSettings.has("valueBool") || tempSettings.has("valueFloat") || tempSettings.has("valueString"))) {
                                ok = false;
                                break;
                            }
                        }
                        // create GameController if all keys are present
                        if (ok) {
                            GameController tempGame = new Game(data.getJSONArray("settings"));
                            session.replace(clientSession.get(client), tempGame);
                            session.get(clientSession.get(client)).register(clientID.get(client), "dummy name", 0.1f);
                            LogController.log(Log.DEBUG, "{" + clientID.get(client) + "} has send SESSIONDATA and successfully created new game");
                            clientState.put(client, MsgType.REGISTER);
                            broadcastUpdate(clientSession.get(client));
                        }
                        else {
                            sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing at least one of the required keys in at least one index of the settings array: key, (valueInt or valueString or valueFloat or valueBool).");
                            throw new IllegalArgumentException("settings payload is missing at least one key: key, (valueInt or valueString or valueFloat or valueBool)");
                        }
                    }
                    else {
                        sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing the required key: settings.");
                        throw new IllegalArgumentException("payload is missing the required key: settings");
                    }
                }

                // client lobby data
                else if (json.getString("type").equals(MsgType.LOBBYDATA.toString()) && clientState.get(client) == MsgType.REGISTER) {
                    if (data.has("ready")) {
                        // player state ready
                        if (data.getBoolean("ready")) {
                            if (data.has("name") && data.has("color")) {
                                if (data.getString("name").length() <= 64 && data.getString("name").length() >= 1) {
                                    if (PlayerColor.toPlayerColor(data.getString("color")) != null && PlayerColor.toPlayerColor(data.getString("color")) != PlayerColor.UNDEFINED && session.get(clientSession.get(client)).colorCheck(PlayerColor.toPlayerColor(data.getString("color"))) != PlayerColor.UNDEFINED) {
                                        if (session.get(clientSession.get(client)).ready(clientID.get(client), PlayerColor.toPlayerColor(data.getString("color")), data.getString("name"))) {
                                            for (Entry<URI, String> entry : clientSession.entrySet()) {
                                                if (entry.getValue().equals(clientSession.get(client))) {
                                                    clientState.put(entry.getKey(), MsgType.LOBBYDATA);
                                                }
                                            }
                                            // TODO start game by starting SessionTimer which is going to call broadcast update in a specific interval until the game ends
                                            LogController.log(Log.INFO, "Game started with session ID " + clientSession.get(client));
                                            // TODO bug the start position gets updated in player class, but not send to clients in update!?
                                            broadcastUpdate(clientSession.get(client));
                                        }
                                        else {
                                            LogController.log(Log.DEBUG, "{" + clientID.get(client) + "} has send REGISTER");
                                            broadcastUpdate(clientSession.get(client));
                                        }
                                    }
                                    else {
                                        sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your defined player color does not exist on the server as an option or is already taken.");
                                        throw new IllegalArgumentException("player color does not exist or already taken");
                                    }
                                }
                                else {
                                    sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your name is to long or to small. The server allows between 1 and 64 char.");
                                    throw new IllegalArgumentException("name needs to be between 1 and 64 char");
                                }
                            }
                            else {
                                sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing at least one required keys: name, color.");
                                throw new IllegalArgumentException("payload is missing at least one required keys: name, color");
                            }
                        }
                        // player state unready
                        else {
                            session.get(clientSession.get(client)).unready(clientID.get(client));
                            LogController.log(Log.DEBUG, "{" + clientID.get(client) + "} has send UNREGISTER");
                            broadcastUpdate(clientSession.get(client));
                        }
                    }
                    else {
                        sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your payload is missing the required keys: ready.");
                        throw new IllegalArgumentException("payload is missing the required keys: ready");
                    }
                }

                // client move
                else if (json.getString("type").equals(MsgType.MOVE.toString()) && clientState.get(client) == MsgType.LOBBYDATA) {
                    // TODO move exec and collision detection hookup in game
                    session.get(clientSession.get(client)).executeMove(clientID.get(client), data.getInt("move"));
                }

                // client message
                else if (json.getString("type").equals(MsgType.MESSAGE.toString())) {
                    if (data.getBoolean("broadcast")) {
                        LogController.log(Log.INFO, "Message from " + clientID.get(client) + ": " + json.getString("message"));
                        broadcastMessage(clientSession.get(client), client, json.getString("message"));
                    }
                    else { LogController.log(Log.INFO, "Message from " + clientID.get(client) + ": " + json.getString("message")); }
                }

                // client error
                else if (json.getString("type").equals(MsgType.ERROR.toString())) {
                    LogController.log(Log.ERROR, "{" + clientID.get(client) + "} Error from client: " + data.get("message"));
                    throw new IllegalArgumentException("Error message from client recieved");
                }

                // type is not defined in API spec error
                else {
                    sendError(client, MsgError.UNSUPPORTEDMESSAGETYPE, "Your message type is not supported by the server or API request out of order.");
                    throw new IllegalArgumentException("Unsupported message type or out of order");
                }
            }

            // payload is missing type key error
            else {
                sendError(client, MsgError.UNKNOWN, "Your payload is missing the type key.");
                throw new IllegalArgumentException("Type key is missing from request");
            }

        // remove client from session if exception
        } catch (Exception e) {
            LogController.log(Log.ERROR, "{" + clientID.get(client) + "} " + e.toString());
            remove(client);
            
        }
    }



    /**
	 * <p>This method is a helper for the TimeoutTimer. It returns the last seen
     * time for each client. The timeout timer checks the hashmap and removes clients,
     * if they time out. This is important, since there are no sessions in UDP and clients need
     * to be removed to not create a memory leak.</p>
	 * @return HashMap of the last recieved data froma client
	 */
    protected HashMap<URI, LocalDateTime> getClientTimeout() {
        return clientTimeout;
    }



    /**
	 * <p>This method removes a client from the server. It does thit by clearing
     * any reference to the client from all HashMaps on the backend. It also removes the game,
     * if there are no clients in a session and broadcasts an update to all other clients in a session.</p>
	 * @param client - URI of the client that is going to get removed
	 */
    protected void remove(URI client) {
        String tempSessionID = clientSession.get(client);
        LogController.log(Log.DEBUG, "{" + clientID.get(client) + "} Removed client");
        if (tempSessionID != null && session.get(tempSessionID) != null) {
            session.get(tempSessionID).disconnect(clientID.get(client));
        }
        clientID.remove(client);
        clientState.remove(client);
        clientSession.remove(client);
        clientTimeout.remove(client);
        if (tempSessionID != null && clientSession.containsValue(tempSessionID)) {
            try {
                broadcastUpdate(tempSessionID);
            } catch (Exception e) {
                LogController.log(Log.ERROR, e.toString());
            }
        }
        if (!clientSession.containsValue(tempSessionID)) {
            session.remove(tempSessionID);
            LogController.log(Log.INFO, "Removed game with session ID " + tempSessionID);
        }
    }
}
