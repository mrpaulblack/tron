package com.github.mrpaulblack.tron;

import org.json.*;

public interface GameController {

    //define game settings
    static public JSONArray getSettings() {
        JSONArray json = new JSONArray();
        JSONObject data[] = {new JSONObject(), new JSONObject(), new JSONObject(), new JSONObject()};

        // Board Size
        data[0].put("name", "Board Size in Pixel");
        data[0].put("key", "board_size");
        data[0].put("rangeMin", 10);
        data[0].put("rangeMax", 100);

        // Cell Size
        data[1].put("name", "Cell Size in Pixel");
        data[1].put("key", "cell_size");
        data[1].put("rangeMin", 1);
        data[1].put("rangeMax", 10);

        // Cell Size
        data[2].put("name", "Bicicle Tail Size in Pixel");
        data[2].put("key", "bicicle_tail_size");
        data[2].put("rangeMin", 5);
        data[2].put("rangeMax", 20);

        // Cell Size
        data[3].put("name", "Number of Player");
        data[3].put("key", "player_num");
        data[3].put("rangeMin", 2);
        data[3].put("rangeMax", 6);

        for (JSONObject value : data) {
            json.put(value);
        }
        return json;
    }

    public boolean setSettings(JSONObject settings);
    
}
