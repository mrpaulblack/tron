package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* <h1>TestPlayerColor/h1>
* <p>Test class for PlayerColor Enum found in Game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-04
*/
public class TestPlayerColor {
    //Test if RED is not null
    @Test
    public void testingREDNotNull(){
        PlayerColor testEnum = PlayerColor.RED;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case RED
    @Test 
    public void testingREDToString() {    
        PlayerColor testEnum = PlayerColor.RED;       
        String testString = "red";
        assertEquals(testString, testEnum.toString());
    }

    //Test if BLUE is not null
    @Test
    public void testingBLUENotNull(){
        PlayerColor testEnum = PlayerColor.BLUE;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case BLUE
    @Test 
    public void testingBLUEToString() {    
        PlayerColor testEnum = PlayerColor.BLUE;       
        String testString = "blue";
        assertEquals(testString, testEnum.toString());
    }

    //Test if GREEN is not null
    @Test
    public void testingGREENNotNull(){
        PlayerColor testEnum = PlayerColor.GREEN;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case GREEN
    @Test 
    public void testingGREENToString() {    
        PlayerColor testEnum = PlayerColor.GREEN;       
        String testString = "green";
        assertEquals(testString, testEnum.toString());
    }

    //Test if YELLOW is not null
    @Test
    public void testingYELLOWNotNull(){
        PlayerColor testEnum = PlayerColor.YELLOW;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case YELLOW
    @Test 
    public void testingYELLOWToString() {    
        PlayerColor testEnum = PlayerColor.YELLOW;       
        String testString = "yellow";
        assertEquals(testString, testEnum.toString());
    }

    //Test if PURPLE is not null
    @Test
    public void testingPURPLENotNull(){
        PlayerColor testEnum = PlayerColor.PURPLE;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case PURPLE
    @Test 
    public void testingPURPLEToString() {    
        PlayerColor testEnum = PlayerColor.PURPLE;       
        String testString = "purple";
        assertEquals(testString, testEnum.toString());
    }

    //Test if CYAN is not null
    @Test
    public void testingCYANNotNull(){
        PlayerColor testEnum = PlayerColor.CYAN;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case CYAN
    @Test 
    public void testingCYANToString() {    
        PlayerColor testEnum = PlayerColor.CYAN;       
        String testString = "cyan";
        assertEquals(testString, testEnum.toString());
    }
}
