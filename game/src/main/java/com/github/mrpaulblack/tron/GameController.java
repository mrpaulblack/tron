package com.github.mrpaulblack.tron;

import java.util.UUID;
import org.json.*;

/**
* <h1>Player</h1>
* <p>This interface ensures all necessary methods as well as the payload-structure for game-server communication.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-17
*/
public interface GameController {

    /**
	 * <h1><i>getSettings/i></h1>
	 * <p>Ensures that all necessary information for client to server to game communication is implemented.</p>
	 */
    static public JSONArray getSettings() {
        JSONArray json = new JSONArray();
        JSONObject data[] = {new JSONObject(), new JSONObject(), new JSONObject(), new JSONObject()};

        // Board Size
        data[0].put("name", "Board Size in Pixel");
        data[0].put("key", "board_size");
        data[0].put("type", "int");
        data[0].put("rangeMin", 10);
        data[0].put("rangeMax", 100);

        // Cell Size
        data[1].put("name", "Cell Size in Pixel");
        data[1].put("key", "cell_size");
        data[1].put("type", "int");
        data[1].put("rangeMin", 1);
        data[1].put("rangeMax", 10);

        // tail length
        data[2].put("name", "Bicicle Tail Size in Pixel");
        data[2].put("key", "bicicle_tail_size");
        data[2].put("type", "int");
        data[2].put("rangeMin", 5);
        data[2].put("rangeMax", 20);

        // number of players
        data[3].put("name", "Number of Player");
        data[3].put("key", "player_num");
        data[3].put("type", "int");
        data[3].put("rangeMin", 2);
        data[3].put("rangeMax", 6);

        for (JSONObject value : data) {
            json.put(value);
        }
        return json;
    }

    public boolean setSettings(JSONObject settings);
    public JSONObject toJSON();
    public boolean register(UUID playerID, String clientName, Float clientVersion);
    public boolean ready(UUID playerID, PlayerColor color, String playerName);
    public void unready(UUID playerID);
    public void getStartPosition(Integer hasStartPosi);
    public void disconnect(UUID playerID);
    public void executeMove(UUID playerID, int moveChange);
    public PlayerColor colorCheck(PlayerColor color);
    public void collisionCheckerWall();
    public void collisionCheckerTail();
    public void collisionCheckerFrontal();
    public void collectTailPositions();
    public void collectHeadPositions();
    public void clearObstacleArrays();
    public void clearDriverHeads();
    public void setDriverHeads(int userNumber);
    public UUID endGame();
    
}
