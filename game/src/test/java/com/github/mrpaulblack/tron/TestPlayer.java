package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
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
    public void testSetReadyPlayer1() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        PlayerColor tcolor = PlayerColor.YELLOW;
        testPlayer.setReadyPlayer("tname", tcolor);
        assertEquals(true, Player.class.getDeclaredField("ready"));
    }
    @Test
    public void testSetReadyPlayer2() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        PlayerColor tcolor = PlayerColor.YELLOW;
        String testString = "tname";
        testPlayer.setReadyPlayer(testString, tcolor);
        assertEquals(testString, Player.class.getDeclaredField("name"));
    }
    @Test
    public void testSetReadyPlayer3() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        PlayerColor tcolor = PlayerColor.YELLOW;
        testPlayer.setReadyPlayer("tname", tcolor);
        assertEquals(tcolor, Player.class.getDeclaredField("color"));
    }

    //Test setUnreadyPLayer
    @Test
    public void testSetUnreadyPlayer1() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setUnreadyPlayer();
        assertEquals(false, Player.class.getDeclaredField("ready"));
    }
    @Test
    public void testSetUnreadyPlayer2() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setUnreadyPlayer();
        assertEquals("", Player.class.getDeclaredField("name"));
    }
    @Test
    public void testSetUnreadyPlayer3() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setUnreadyPlayer();
        assertEquals(PlayerColor.UNDEFINED, Player.class.getDeclaredField("color"));
    }

    //Test setName und getName
    @Test
    public void testSetName() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        String tname = "Testname";
        testPlayer.setName(tname);
        assertEquals(tname, Player.class.getDeclaredField("name"));
    }

    //Test setClientName
    @Test
    public void testsetClientName() throws NoSuchFieldException, SecurityException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setclientName("newName");
        assertEquals("newName", Player.class.getDeclaredField("clientName"));
    }

    //Test getClientName
    @Test
    public void testgetClientName(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals("tclientname", testPlayer.getClientName());
    }

    //Test setClientVersion
    @Test
    public void testsetClientVersion() throws NoSuchFieldException, SecurityException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setClientVersion(1.20f);
        assertEquals(1.2f, Player.class.getDeclaredField("clientVersion"));
    }

    //Test getClientVersion
    @Test
    public void testgetClientVersion() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(1.0f, testPlayer.getClientVersion(), 0.00001);
    }

    //Test setPlayerID
    @Test
    public void testsetPlayerID() throws NoSuchFieldException, SecurityException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        UUID testID = UUID.fromString("2384f927-5e2f-3998-8baa-c768616287f5");
        testPlayer.setPlayerID(testID);
        assertEquals(testID, Player.class.getDeclaredField("playerID"));
    }

    //Test getPlayerID
    @Test
    public void testgetPlayerID() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"), testPlayer.getPlayerID());
    }

    //Test setTailLenght
    @Test
    public void testsetTailLenght() throws NoSuchFieldException, SecurityException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setTailLenght(200);
        assertEquals(200, Player.class.getDeclaredField("tailLenght"));
    }
    
    //Test getTailLenght
    @Test
    public void testgetTailLenght() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(100, testPlayer.getTailLenght(), 0);
    }
    
    //Test setColor
    @Test
    public void testsetColor() throws NoSuchFieldException, SecurityException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setColor(PlayerColor.YELLOW);
        assertEquals(PlayerColor.YELLOW, Player.class.getDeclaredField("color"));
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
    public void testsetAlive() throws NoSuchFieldException, SecurityException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setAlive(true);
        assertEquals(true, Player.class.getDeclaredField("aliver"));
    }
    
    //Test getAlive
    @Test
    public void testgetAlive() {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(false, testPlayer.getAlive());
    }
    
    //Test setReady
    @Test
    public void testsetReady() throws NoSuchFieldException, SecurityException {
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.setReady(true);
        assertEquals(true, Player.class.getDeclaredField("ready"));
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
