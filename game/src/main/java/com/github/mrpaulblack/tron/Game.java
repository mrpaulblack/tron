package com.github.mrpaulblack.tron;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

/**
* <h1>Game</h1>
* <p>This class contains all methods and data that is necessary for a running game. It controlls all movement, checks for winning
conditinos, acts as a hub for communication of all game related information to the server and all collision-detection. It acts like a 
library for the server to controll the main game-loop.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-22
*/
public class Game implements GameController {
    private Integer boardSize;
    private Integer tailLenght;
    private Integer playerNumber;
    private Integer cellSize;
    private UUID winner;
    private Player[] user;
    private GameState gameState;
    private Integer driverHeadX;
    private Integer driverHeadY;
    private List<Integer> obstaclePositionsX = new ArrayList<Integer>();
    private List<Integer> obstaclePositionsY = new ArrayList<Integer>();
    private HashMap <UUID, Player> participants =  new HashMap<UUID, Player>();
    private HashMap <UUID, PlayerColor> colorToID = new HashMap<UUID, PlayerColor>();


    /**
	 * <h1><i>Game/i></h1>
	 * <p>Initial registration of each player and document player and UUID in a HashMap</p>
	 * @param settings - JSONArray with the settings payload following the tron API spec.
	 */
    public Game(JSONArray settings) throws Exception {
        for (int i = 0; i < settings.length(); i++) {
            JSONObject setting = settings.getJSONObject(i);
            if (setting.has("key") && setting.has("valueInt") && setting.getString("key").equals("board_size")) {
                boardSize = setting.getInt("valueInt");
            }
            else if (setting.has("key") && setting.has("valueInt") && setting.getString("key").equals("cell_size")) {
                cellSize = setting.getInt("valueInt");
            }
            else if (setting.has("key") && setting.has("valueInt") && setting.getString("key").equals("player_num")) {
                playerNumber = setting.getInt("valueInt");
            }
            else if (setting.has("key") && setting.has("valueInt") && setting.getString("key").equals("bicicle_tail_size")) {
                tailLenght = setting.getInt("valueInt");
            }
            else { throw new IllegalArgumentException("The setting does not exist: " + setting.getString("key")); }
        }
        this.winner = null;
        this.gameState = GameState.SETTINGUP;
    }
    
    /**
	 * <h1><i>register</i></h1>
	 * <p>Initial registration of each player and document player and UUID in a HashMap</p>
	 * @param UUID - Main identifier for each player.
     * @param clientName - String self chosen name of the player.
     * @param clientVersion - Float identifying the client Version used.
	 */
    @Override
    public boolean register(UUID playerID, String clientName, Float clientVersion){
        if (participants.size() < playerNumber || gameState != GameState.SETTINGUP) {
            participants.put(playerID, new Player(clientName, clientVersion, playerID, tailLenght)); 
            return true;
        }
        else { return false; }     
    }

    /**
	 * <h1><i>toJSON/i></h1>
	 * <p>Creates a payload for a standard update for communication between game and server.</p>
	 */
    @Override
    public JSONObject toJSON(){
        JSONObject payload = new JSONObject();
        JSONArray substance = new JSONArray();
        payload.put("state", gameState.toString());
        payload.put("winner", winner);
        for (Entry <UUID, Player>clientEntry: participants.entrySet()){
            substance.put(clientEntry.getValue().playerToJSON()); 
        }
        payload.put("players", substance);
        return payload;
    }

    /**
	 * <h1><i>executeMove/i></h1>
	 * <p>Changes direction if needed depending on moveChange and executing the move within the player movement arrays</p>
	 * @param UUID - Main identifier for each player.
     * @param moveChange - Int indicating the change in direction relative to current direction.
	 */
    @Override
    public void executeMove(UUID player, int moveChange){
        participants.get(player).changeDirection(moveChange);
        participants.get(player).move();
        collisionCheckerTail();
        collisionCheckerFrontal();
        collisionCheckerWall();
    }

    /**
	 * <h1>Checks if the requested color is available and return ether UNDEFINED if taken or chosen color.<i>colorCheck</i></h1>
	 * <p></p>
	 * @param PlayerColor - Enum indicating the color asked for.
	 */
    @Override
    public PlayerColor colorCheck(PlayerColor color){
        
        if(colorToID.containsValue(color)){
            return PlayerColor.UNDEFINED;
        };
        return color;
    }

    /**
	 * <h1><i>getStartPosition</i></h1>
	 * <p>Sets the starting posiion on the grid based on amount of players to ensure fair starting positions as well as start direction.
     * In case playernumber till 4 each player starts in the middle of the each boarder line. For 4+ players the west and east spawns are adjusted.</p>
	 */
    @Override
    public void getStartPosition(Integer hasStartPosi){
        if ((playerNumber < 5) && (playerNumber > 0)){
            switch (hasStartPosi){
                case 0:
                user[hasStartPosi].positionX[0] = (boardSize / 2);
                user[hasStartPosi].positionY[0] = 0;
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 1:
                user[hasStartPosi].positionX[0] = 0;
                user[hasStartPosi].positionY[0] = (boardSize / 2);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 2:
                user[hasStartPosi].positionX[0] = boardSize;
                user[hasStartPosi].positionY[0] = (boardSize / 2);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 3:
                user[hasStartPosi].positionX[0] = (boardSize / 2);
                user[hasStartPosi].positionY[0] = boardSize;
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi = 0;
                break;
            }
        }

        else if (playerNumber == 5){
            switch (hasStartPosi){
                case 0:
                user[hasStartPosi].positionX[0] = (boardSize / 2);
                user[hasStartPosi].positionY[0] = 0;
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 1:
                user[hasStartPosi].positionX[0] = 0;
                user[hasStartPosi].positionY[0] = (boardSize / 3);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 2:
                user[hasStartPosi].positionX[0] = 0;
                user[hasStartPosi].positionY[0] = ((boardSize / 3)*2);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 3:
                user[hasStartPosi].positionX[0] = boardSize;
                user[hasStartPosi].positionY[0] = (boardSize / 2);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;   
                break;

                case 4:
                user[hasStartPosi].positionX[0] = (boardSize / 2);
                user[hasStartPosi].positionY[0] = boardSize;
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi = 0;
                break;
            }
        }

        else if (playerNumber == 6){

            switch (hasStartPosi){
                case 0:
                user[hasStartPosi].positionX[0] = (boardSize / 2);
                user[hasStartPosi].positionY[0] = 0;
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 1:
                user[hasStartPosi].positionX[0] = 0;
                user[hasStartPosi].positionY[0] = (boardSize / 3);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 2:
                user[hasStartPosi].positionX[0] = 0;
                user[hasStartPosi].positionY[0] = ((boardSize / 3)*2);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;
                break;

                case 3:
                user[hasStartPosi].positionX[0] = boardSize;
                user[hasStartPosi].positionY[0] = (boardSize / 3);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;   
                break;

                case 4:
                user[hasStartPosi].positionX[0] = boardSize;
                user[hasStartPosi].positionY[0] = ((boardSize / 3)*2);
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi++;   
                break;

                case 5:
                user[hasStartPosi].positionX[0] = (boardSize / 2);
                user[hasStartPosi].positionY[0] = boardSize;
                user[hasStartPosi].setStartDirection(boardSize);
                hasStartPosi = 0;
                break;
            }
        }
    }

    /**
	 * <h1><i>ready/i></h1>
	 * <p>Does a client send a ready payload, this method registers the newly joined players in the HashMap mapping UUID and Player object.
     * Should all players indicate a ready, all players are mapped in an array for easier navigation as well as defining start positions & directions.</p>
     * @param UUID - Main identifier for each player.
     * @param color - Enum that indicates the players chosen color.
     * @param name - String that contains the chosen playername.
	 */
    @Override
    public boolean ready(UUID playerID, PlayerColor color, String playerName){
        int readyCount = 0;
        participants.get(playerID).setReadyPlayer(playerName, color);
        colorToID.put(playerID, color);

        for (Entry <UUID, Player>clientEntry: participants.entrySet()){
            if(clientEntry.getValue().getReady()){
                readyCount++;
            }
        }

        if(readyCount >= playerNumber){
            Collection<Player> values = participants.values();
            user = values.toArray(new Player[0]);
            gameState = GameState.RUNNING;
            for(int i = 0; i < playerNumber; i++){
                getStartPosition(i);
            }
            gameState = GameState.RUNNING;
            return true;
        }
        else{return false;}
    }

    /**
	 * <h1><i>unready</i></h1>
	 * <p>Should a player take his ready signal back, the previously chosen color and name are made available again.</p>
     * @param UUID - Main identifier for each player.
	 */
    @Override
    public void unready(UUID playerID){
        colorToID.remove(playerID);        
        participants.get(playerID).setUnreadyPlayer();
    }

    /**
	 * <h1><i>disconnect</i></h1>
	 * <p>In case of a disconnect while in lobby-phase the player will be removed from the HashMap. Is a game running and a 
     * disconnect occurs, the players gets set do dead.</p>
     * @param UUID - Main identifier for each player.
	 */
    @Override
    public void disconnect(UUID playerID){
 
        if(gameState == GameState.SETTINGUP){
            colorToID.remove(playerID);
            participants.remove(playerID);
        }
        else{
            participants.get(playerID).setAlive(false);
        }
    }

    /**
	 * <h1><i>endGame</i></h1>
	 * <p>Checks the current game state for a win condition. In case of a draw, no winner gets returned.</p>
	 */
    // TODO refactor to use attribute and call when move gets executed
    @Override
    public UUID endGame(){
        UUID winner = null;
        int aliveCounter = 0;
        for (int i = 0; i < playerNumber; i++){
            if(user[i].getAlive() == true){
                winner = user[i].getPlayerID();
                aliveCounter++;
            }
        }
        if(aliveCounter == 1){            
            return winner;
        }
        else if (aliveCounter == 0){
            gameState = GameState.FINISHED;
            return null;
        }
        else{
            gameState = GameState.RUNNING;
            return null;
        }     
    }

    /**
	 * <h1><i>setSettings</i></h1>
	 * <p>Used for communication between server and game.</p>
	 */
    @Override
    public boolean setSettings(JSONObject settings) {
        return false;
    }

    /**
	 * <h1><i>collisionCheckerWall</i></h1>
	 * <p>Checks for collision with a wall / border of the grid for each player.</p>
	 */
    @Override
    public void collisionCheckerWall(){        
        for (int i = 0; i < playerNumber; i++){
            setDriverHeads(i);
            if((driverHeadX < 0) || (driverHeadX > (boardSize-1))){
                user[i].eliminatePlayer();
            }
            else if ((driverHeadY < 0) || (driverHeadY > (boardSize-1))){
                user[i].eliminatePlayer();
            }
            else{}
        }
        clearObstacleArrays();          
    }

    /**
	 * <h1><i>collisionCheckerTail</i></h1>
	 * <p>Checks for collision with another players tail of the grid for each player.</p>
	 */
    @Override
    public void collisionCheckerTail(){
        collectTailPositions();
        for(int driver = 0; driver < playerNumber; driver++){
            setDriverHeads(driver);
            for(int tails = 0; tails < obstaclePositionsX.size(); tails++){
                if ((driverHeadX == obstaclePositionsX.get(tails) && (driverHeadY == obstaclePositionsY.get(tails)))){
                    user[tails / (tailLenght-1)].eliminatePlayer();
                }
            }clearDriverHeads();
        }clearObstacleArrays();
    }

    /**
	 * <h1><i>collisionCheckerFrontal/i></h1>
	 * <p>Checks for collision with a frontal collision (head to head) for each player.</p>
	 */
    @Override
    public void collisionCheckerFrontal(){
        collectHeadPositions();
        for(int driver = 0; driver < playerNumber; driver++){
            for (int others = 1; others < playerNumber; others++){
                if ((obstaclePositionsX.get(driver) == obstaclePositionsX.get(others)) && obstaclePositionsY.get(driver) == obstaclePositionsY.get(others)){
                    user[driver].eliminatePlayer();
                    user[others].eliminatePlayer();
                }
            }
        }
        clearObstacleArrays();
    }

    /**
	 * <h1><i>setDriverHeads</i></h1>
	 * <p>Sets the value for a chosen players head in the respected integers.</p>
	 */
    @Override
    public void setDriverHeads(int userNumber){
        driverHeadX = user[userNumber].positionX[0];
        driverHeadY = user[userNumber].positionY[0];
    }

    /**
	 * <h1><i>collectTailPositions</i></h1>
	 * <p>Collects all the positions of tails from all players and adds them in the respected list.</p>
	 */
    @Override
    public void collectTailPositions(){
        for (int i = 0; i < playerNumber; i++){
            for(int k = 1; k < tailLenght; k++){
                obstaclePositionsX.add(user[i].positionX[k]);
                obstaclePositionsY.add(user[i].positionY[k]);
            }
        }
    }

    /**
	 * <h1><i>clearDriverHeads</i></h1>
	 * <p>Clears all data stored in the head integers.</p>
	 */
    @Override
    public void clearDriverHeads(){
        driverHeadX = null;
        driverHeadY = null;
    }

    /**
	 * <h1><i>clearObstacleArrays</i></h1>
	 * <p>Clears all data in the tail-position lists.</p>
	 */
    @Override
    public void clearObstacleArrays(){
        obstaclePositionsX.clear();
        obstaclePositionsY.clear();
    }

    /**
	 * <h1><i>collectHeadPositions</i></h1>
	 * <p>Collects the position of each players head in respected list.</p>
	 */
    @Override
    public void collectHeadPositions(){
        for(int i = 0; i < playerNumber; i++){
            obstaclePositionsX.add(user[i].positionX[0]);
            obstaclePositionsY.add(user[i].positionY[0]);
        }
    }
}
