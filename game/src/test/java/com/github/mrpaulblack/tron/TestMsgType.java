package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* <h1>TestMsgType/h1>
* <p>Test class for MsgType Enum found in Game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-04
*/
public class TestMsgType {
    //Test if REGISTER is not null
    @Test
    public void testingREGISTERNotNull(){
        MsgType testEnum = MsgType.REGISTER;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case REGISTER
    @Test 
    public void testingREGISTERToString() {    
        MsgType testEnum = MsgType.REGISTER;        
        String testString = "register";
        assertEquals(testString, testEnum.toString());
    }

    //Test if READY is not null
    @Test
    public void testingREADYNotNull(){
        MsgType testEnum = MsgType.READY;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case READY
    @Test 
    public void testingREADYToString() {    
        MsgType testEnum = MsgType.READY;        
        String testString = "ready";
        assertEquals(testString, testEnum.toString());
    }

    //Test if MOVE is not null
    @Test
    public void testingMOVENotNull(){
        MsgType testEnum = MsgType.MOVE;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case MOVE
    @Test 
    public void testingMOVEToString() {    
        MsgType testEnum = MsgType.MOVE;        
        String testString = "move";
        assertEquals(testString, testEnum.toString());
    }

    //Test if WELCOME is not null
    @Test
    public void testingWELCOMENotNull(){
        MsgType testEnum = MsgType.WELCOME;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case WELCOME
    @Test 
    public void testingWELCOMEToString() {    
        MsgType testEnum = MsgType.WELCOME;        
        String testString = "welcome";
        assertEquals(testString, testEnum.toString());
    }    

    //Test if ASSIGNCOLOR is not null
    @Test
    public void testingASSIGNCOLORNotNull(){
        MsgType testEnum = MsgType.ASSIGNCOLOR;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case ASSIGNCOLOR
    @Test 
    public void testingASSIGNCOLORToString() {    
        MsgType testEnum = MsgType.ASSIGNCOLOR;        
        String testString = "assignColor";
        assertEquals(testString, testEnum.toString());
    }

    //Test if UPDATE is not null
    @Test
    public void testingUPDATENotNull(){
        MsgType testEnum = MsgType.UPDATE;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case UPDATE
    @Test 
    public void testingUPDATEToString() {    
        MsgType testEnum = MsgType.UPDATE;        
        String testString = "update";
        assertEquals(testString, testEnum.toString());
    }

    //Test if TURN is not null
    @Test
    public void testingTURNNotNull(){
        MsgType testEnum = MsgType.TURN;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case TURN
    @Test 
    public void testingTURNToString() {    
        MsgType testEnum = MsgType.TURN;        
        String testString = "turn";
        assertEquals(testString, testEnum.toString());
    }

    //Test if PLAYERDISCONNECTED is not null
    @Test
    public void testingPLAYERDISCONNECTEDNotNull(){
        MsgType testEnum = MsgType.PLAYERDISCONNECTED;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case PLAYERDISCONNECTED
    @Test 
    public void testingPLAYERDISCONNECTEDToString() {    
        MsgType testEnum = MsgType.PLAYERDISCONNECTED;        
        String testString = "playerDisconnected";
        assertEquals(testString, testEnum.toString());
    }

    //Test if MESSAGE is not null
    @Test
    public void testingMESSAGENotNull(){
        MsgType testEnum = MsgType.MESSAGE;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case MESSAGE
    @Test 
    public void testingMESSAGEToString() {    
        MsgType testEnum = MsgType.MESSAGE;        
        String testString = "message";
        assertEquals(testString, testEnum.toString());
    }

    //Test if ERROR is not null
    @Test
    public void testingERRORNotNull(){
        MsgType testEnum = MsgType.ERROR;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case ERROR
    @Test 
    public void testingERRORToString() {    
        MsgType testEnum = MsgType.ERROR;        
        String testString = "error";
        assertEquals(testString, testEnum.toString());
    }    
}
