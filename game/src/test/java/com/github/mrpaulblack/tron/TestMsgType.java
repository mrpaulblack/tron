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
    //Test if HELLO is not null
    @Test
    public void testingHELLONotNull(){
        MsgType testEnum = MsgType.HELLO;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case HELLO
    @Test 
    public void testingHELLOToString() {    
        MsgType testEnum = MsgType.HELLO;        
        String testString = "hello";
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

    //Test if SESSIONSETTINGS is not null
    @Test
    public void testingSESSIONSETTINGSNotNull(){
        MsgType testEnum = MsgType.SESSIONSETTINGS;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case SESSIONSETTINGS
    @Test 
    public void testingSESSIONSETTINGSToString() {    
        MsgType testEnum = MsgType.SESSIONSETTINGS;        
        String testString = "sessionSettings";
        assertEquals(testString, testEnum.toString());
    }    

    //Test if SESSIONDATA is not null
    @Test
    public void testingSESSIONDATANotNull(){
        MsgType testEnum = MsgType.SESSIONDATA;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case SESSIONDATA
    @Test 
    public void testingSESSIONDATAToString() {    
        MsgType testEnum = MsgType.SESSIONDATA;        
        String testString = "sessionData";
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

    //Test if LOBBYDATA is not null
    @Test
    public void testingLOBBYDATANotNull(){
        MsgType testEnum = MsgType.LOBBYDATA;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case LOBBYDATA
    @Test 
    public void testingLOBBYDATAToString() {    
        MsgType testEnum = MsgType.LOBBYDATA;        
        String testString = "lobbyData";
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
