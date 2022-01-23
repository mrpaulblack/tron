package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.UUID;

/**
* <h1>TestPlayer</h1>
* <p>Test class for Player found in Game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-21
*/
public class TestPlayer {

    //Test setStartDirection

    //Test getDirection

    //Test setReadyPLayer
    @Test
    public void testSetReadyPlayer1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        PlayerColor tcolor = PlayerColor.YELLOW;
        testPlayer.setReadyPlayer("tname", tcolor);

        Field pF= Player.class.getDeclaredField("ready");
        pF.setAccessible(true);
        boolean fV = (boolean) pF.get(testPlayer);

        assertEquals(true, fV);
    }
    @Test
    public void testSetReadyPlayer2() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        PlayerColor tcolor = PlayerColor.YELLOW;
        String testString = "tname";
        testPlayer.setReadyPlayer(testString, tcolor);

        Field pF= Player.class.getDeclaredField("name");
        pF.setAccessible(true);
        String fV = (String) pF.get(testPlayer);

        assertEquals(testString, fV);
    }
    @Test
    public void testSetReadyPlayer3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        PlayerColor tcolor = PlayerColor.YELLOW;
        testPlayer.setReadyPlayer("tname", tcolor);

        Field pF= Player.class.getDeclaredField("color");
        pF.setAccessible(true);
        PlayerColor fV = (PlayerColor) pF.get(testPlayer);

        assertEquals(tcolor, fV);
    }

    //Test setUnreadyPLayer
    @Test
    public void testSetUnreadyPlayer1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setUnreadyPlayer();

        Field pF= Player.class.getDeclaredField("ready");
        pF.setAccessible(true);
        boolean fV = (boolean) pF.get(testPlayer);

        assertEquals(false, fV);
    }
    @Test
    public void testSetUnreadyPlayer2() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setUnreadyPlayer();

        Field pF= Player.class.getDeclaredField("name");
        pF.setAccessible(true);
        String fV = (String) pF.get(testPlayer);

        assertEquals("", fV);
    }
    @Test
    public void testSetUnreadyPlayer3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setUnreadyPlayer();

        Field pF= Player.class.getDeclaredField("color");
        pF.setAccessible(true);
        PlayerColor fV = (PlayerColor) pF.get(testPlayer);
        
        assertEquals(PlayerColor.UNDEFINED, fV);
    }

    //Test setName und getName
    @Test
    public void testSetName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        String tname = "Testname";
        testPlayer.setName(tname);

        Field pF= Player.class.getDeclaredField("name");
        pF.setAccessible(true);
        String fV = (String) pF.get(testPlayer);

        assertEquals(tname, fV);
    }

    //Test setClientName
    @Test
    public void testsetClientName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setClientName("newName");

        Field pF= Player.class.getDeclaredField("clientName");
        pF.setAccessible(true);
        String fV = (String) pF.get(testPlayer);

        assertEquals("newName", fV);
    }

    //Test getClientName
    @Test
    public void testgetClientName(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals("tclientname", testPlayer.getClientName());
    }

    //Test setClientVersion
    @Test
    public void testsetClientVersion() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setClientVersion(1.20f);

        Field pF= Player.class.getDeclaredField("clientVersion");
        pF.setAccessible(true);
        Float fV = (Float) pF.get(testPlayer);

        assertEquals(1.2f, fV, 0);
    }

    //Test getClientVersion
    @Test
    public void testgetClientVersion() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(1.0f, testPlayer.getClientVersion(), 0.00001);
    }

    //Test setPlayerID
    @Test
    public void testsetPlayerID() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        UUID testID = UUID.fromString("2384f927-5e2f-3998-8baa-c768616287f5");
        testPlayer.setPlayerID(testID);

        Field pF= Player.class.getDeclaredField("playerID");
        pF.setAccessible(true);
        UUID fV = (UUID) pF.get(testPlayer);

        assertEquals(testID, fV);
    }

    //Test getPlayerID
    @Test
    public void testgetPlayerID() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"), testPlayer.getPlayerID());
    }

    //Test setTailLenght
    @Test
    public void testsetTailLenght() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setTailLenght(200);

        Field pF= Player.class.getDeclaredField("tailLenght");
        pF.setAccessible(true);
        Integer fV = (Integer) pF.get(testPlayer);

        assertEquals(200, fV, 0);
    }
    
    //Test getTailLenght
    @Test
    public void testgetTailLenght() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(100, testPlayer.getTailLenght(), 0);
    }
    
    //Test setColor
    @Test
    public void testsetColor() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setColor(PlayerColor.YELLOW);

        Field pF= Player.class.getDeclaredField("color");
        pF.setAccessible(true);
        PlayerColor fV = (PlayerColor) pF.get(testPlayer);

        assertEquals(PlayerColor.YELLOW, fV);
    }
    
    //Test getColor
    @Test
    public void testgetColor() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setColor(PlayerColor.YELLOW);
        assertEquals(PlayerColor.YELLOW, testPlayer.getColor());
    }
    
    //Test setAlive
    @Test
    public void testsetAlive() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setAlive(true);

        Field pF= Player.class.getDeclaredField("alive");
        pF.setAccessible(true);
        boolean fV = (boolean) pF.get(testPlayer);

        assertEquals(true, fV);
    }
    
    //Test getAlive
    @Test
    public void testgetAlive() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(false, testPlayer.getAlive());
    }
    
    //Test setReady
    @Test
    public void testsetReady() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setReady(true);

        Field pF= Player.class.getDeclaredField("ready");
        pF.setAccessible(true);
        boolean fV = (boolean) pF.get(testPlayer);

        assertEquals(true, fV);
    }
    
    //Test getReady
    @Test
    public void testgetReady() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(false, testPlayer.getReady());
    }
    
    //Test move
    
    //Test getPositionX
    
    //Test getPositionY



}
