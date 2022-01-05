package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* <h1>TestGameSate/h1>
* <p>Test class for Log Enum found in Game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-04
*/
public class TestLog {
    //Test if ERROR is not null
    @Test
    public void testingERRORNotNull(){
        Log testEnum = Log.ERROR;
        assertNotNull(testEnum);
    }

    //Test if INFO is not null
    @Test
    public void testingINFONotNull(){
        Log testEnum = Log.INFO;
        assertNotNull(testEnum);
    }

    //Test if DEBUG is not null
    @Test
    public void testingDEBUGNotNull(){
        Log testEnum = Log.DEBUG;
        assertNotNull(testEnum);
    }

    //Test if TRACE is not null
    @Test
    public void testingTRACENotNull(){
        Log testEnum = Log.TRACE;
        assertNotNull(testEnum);
    }    
}
