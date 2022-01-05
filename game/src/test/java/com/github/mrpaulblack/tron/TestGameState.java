package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* <h1>TestGameSate/h1>
* <p>Test class for GameState Enum found in Game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-04
*/
public class TestGameState {
    //Test if SETTINGUP is not null
     @Test
     public void testingSETTINGUPNotNull(){
        GameState testEnum = GameState.SETTINGUP;
        assertNotNull(testEnum);
     }

    //Testing right use of toString method for case SETTINGUP
    @Test 
    public void testingSETTINGUPToString() {
        GameState testEnum = GameState.SETTINGUP;        
        String testString = "settingUp";
        assertEquals(testString, testEnum.toString());
    }

    //Test if RUNNING is not null
     @Test
     public void testingRUNNINGNotNull(){
        GameState testEnum = GameState.RUNNING;
        assertNotNull(testEnum);
     }

    //Testing right use of toString method for case RUNNING
    @Test 
    public void testingRUNNINGToString() {   
        GameState testEnum = GameState.RUNNING;        
        String testString = "running";
        assertEquals(testString, testEnum.toString());
    }

    //Test if FINISHED is not null
    @Test
    public void testingFINISHEDNotNull(){
        GameState testEnum = GameState.FINISHED;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case RUNNING
    @Test 
    public void testingFINISHEDToString() {   
        GameState testEnum = GameState.FINISHED;           
        String testString = "finished";
        assertEquals(testString, testEnum.toString());
    }
}
