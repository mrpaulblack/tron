package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* <h1>TestGameSate/h1>
* <p>Test class for MsgError Enum found in Game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-04
*/
public class TestMsgError {
    //Test if UNSUPPORTEDMESSAGETYPE is not null
    @Test
    public void testingUNSUPPORTEDMESSAGETYPENotNull(){
        MsgError testEnum = MsgError.UNSUPPORTEDMESSAGETYPE;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case UNSUPPORTEDMESSAGETYPE
    @Test 
    public void testingUNSUPPORTEDMESSAGETYPEToString() {    
        MsgError testEnum = MsgError.UNSUPPORTEDMESSAGETYPE;        
        String testString = "unsupportedMessageType";
        assertEquals(testString, testEnum.toString());
    }

    //Test if UNSUPPORTEDPROTOCOLVERSION is not null
    @Test
    public void testingUNSUPPORTEDPROTOCOLVERSIONNotNull(){
        MsgError testEnum = MsgError.UNSUPPORTEDPROTOCOLVERSION;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case UNSUPPORTEDPROTOCOLVERSION
    @Test 
    public void testingUNSUPPORTEDPROTOCOLVERSIONToString() {      
        MsgError testEnum = MsgError.UNSUPPORTEDPROTOCOLVERSION;        
        String testString = "unsupportedProtocolVersion";
        assertEquals(testString, testEnum.toString());
    }

    //Test if SERVERFULL is not null
    @Test
    public void testingSERVERFULLNotNull(){
        MsgError testEnum = MsgError.SERVERFULL;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case SERVERFULL
    @Test 
    public void testingSERVERFULLToString() {      
        MsgError testEnum = MsgError.SERVERFULL;        
        String testString = "serverFull";
        assertEquals(testString, testEnum.toString());
    }

     //Test if ILLEGALMOVE is not null
     @Test
     public void testingILLEGALMOVENotNull(){
         MsgError testEnum = MsgError.ILLEGALMOVE;
         assertNotNull(testEnum);
     }
    
     //Testing right use of toString method for case ILLEGALMOVE
     @Test 
     public void testingILLEGALMOVEToString() {       
         MsgError testEnum = MsgError.ILLEGALMOVE;        
         String testString = "illegalMove";
         assertEquals(testString, testEnum.toString());
     }

     //Test if INSPECTATE is not null
     @Test
     public void testingINSPECTATENotNull(){
         MsgError testEnum = MsgError.INSPECTATE;
         assertNotNull(testEnum);
     }
    
     //Testing right use of toString method for case INSPECTATE
     @Test 
     public void testingINSPECTATEToString() {       
         MsgError testEnum = MsgError.INSPECTATE;        
         String testString = "inSpectate";
         assertEquals(testString, testEnum.toString());
     }

     //Test if UNKNOWN is not null
     @Test
     public void testingUNKNOWNNotNull(){
         MsgError testEnum = MsgError.UNKNOWN;
         assertNotNull(testEnum);
     }
    
     //Testing right use of toString method for case UNKNOWN
     @Test 
     public void testingUNKNOWNToString() {       
         MsgError testEnum = MsgError.UNKNOWN;        
         String testString = "unknown";
         assertEquals(testString, testEnum.toString());
     }    
}
