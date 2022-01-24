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
    @Test
    public void testSetStartDirection1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.positionX[0] = 0;
        testPlayer.setStartDirection(100);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('E', fV);
    }
    @Test
    public void testSetStartDirection2() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.positionX[0] = 100;
        testPlayer.setStartDirection(100);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('W', fV);
    }
    @Test
    public void testSetStartDirection3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.positionY[0] = 0;
        testPlayer.positionX[0] = 5;
        testPlayer.setStartDirection(100);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('S', fV);
    }
    @Test
    public void testSetStartDirection4() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.positionY[0] = 100;
        testPlayer.positionX[0] = 5;
        testPlayer.setStartDirection(100);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('N', fV);
    }

    //Test changeDirection
    @Test
    public void testChangeDirection1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'E'
        testPlayer.positionX[0] = 0;
        testPlayer.setStartDirection(100);

        testPlayer.changeDirection(0);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('E', fV);
    }
    @Test
    public void testChangeDirection2() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'E'
        testPlayer.positionX[0] = 0;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(1);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('N', fV);
    }
    @Test
    public void testChangeDirection3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'E'
        testPlayer.positionX[0] = 0;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(2);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('S', fV);
    }
    @Test
    public void testChangeDirection4() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'W'
        testPlayer.positionX[0] = 100;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(1);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('S', fV);
    }
    @Test
    public void testChangeDirection5() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'W'
        testPlayer.positionX[0] = 100;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(2);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('N', fV);
    }
    @Test
    public void testChangeDirection6() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'S'
        testPlayer.positionX[0] = 5;
        testPlayer.positionY[0] = 0;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(1);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('E', fV);
    }
    @Test
    public void testChangeDirection7() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'S'
        testPlayer.positionX[0] = 5;
        testPlayer.positionY[0] = 0;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(2);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('W', fV);
    }
    @Test
    public void testChangeDirection8() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'N'
        testPlayer.positionY[0] = 100;
        testPlayer.positionX[0] = 5;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(1);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('W', fV);
    }
    @Test
    public void testChangeDirection9() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        //set direction to 'N'
        testPlayer.positionY[0] = 100;
        testPlayer.positionX[0] = 5;
        testPlayer.setStartDirection(100);
        
        testPlayer.changeDirection(2);

        Field pF= Player.class.getDeclaredField("direction");
        pF.setAccessible(true);
        char fV = (char) pF.get(testPlayer);

        assertEquals('E', fV);
    }

    //Test getDirection
    @Test
    public void testgetDirection1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.positionX[0] = 0;
        testPlayer.setStartDirection(100);

        assertEquals('E', testPlayer.getDirection());
    }

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
        Integer t = 100;
        assertEquals(t-1, testPlayer.getTailLenght(), 0);
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
    @Test
    public void testMove1(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(null, testPlayer.positionX[0]);
    }
    @Test
    public void testMove2(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        assertEquals(null, testPlayer.positionY[0]);
    }
    @Test
    public void testMove3(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),7);
        testPlayer.setAlive(true);
        //set direction to 'S'
        testPlayer.positionX[0] = 5;
        testPlayer.positionY[0] = 0;
        testPlayer.setStartDirection(100);
        //direction to 'E'
        testPlayer.changeDirection(1);

        testPlayer.move();

        assertEquals(6, testPlayer.positionX[0], 0);
    }
    @Test
    public void testMove4(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),7);
        testPlayer.setAlive(true);
        //set direction to 'S'
        testPlayer.positionX[0] = 5;
        testPlayer.positionY[0] = 0;
        testPlayer.setStartDirection(100);
        //direction to 'E'
        testPlayer.changeDirection(1);

        testPlayer.move();
        testPlayer.move();

        assertEquals(6, testPlayer.positionX[1], 0);
    }
    
    //Test getPositionX
    @Test
    public void testgetPositionX(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.positionX[4] = 10;

        assertEquals(10, testPlayer.getPositionX(4), 0);
    }
    
    //Test getPositionY
    @Test
    public void testgetPositionY(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        testPlayer.positionY[4] = 10;

        assertEquals(10, testPlayer.getPositionY(4), 0);
    }

    //Test setPositionXY
    @Test
    public void testSetPositionXY1(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        int[] n = {10,10};
        testPlayer.setPositionXY(n);
        
        assertEquals(10, testPlayer.positionX[0], 0);
    }
    @Test
    public void testSetPositionXY2(){
        Player testPlayer = new Player("tclientname",1.0f,UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"),100);
        int[] n = {10,10};
        testPlayer.setPositionXY(n);
        
        assertEquals(10, testPlayer.positionY[0], 0);
    }

}
