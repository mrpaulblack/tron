package com.github.mrpaulblack.tron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* <h1>TestPlayerStatus/h1>
* <p>Test class for PlayerStatus Enum found in Game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2022-01-04
*/
public class TestPlayerStatus {
    //Test if SPAWNING is not null
    @Test
    public void testingSPAWNINGNotNull(){
        PlayerStatus testEnum = PlayerStatus.SPAWNING;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case SPAWNING
    @Test 
    public void testingSPAWNINGToString() {    
        PlayerStatus testEnum = PlayerStatus.SPAWNING;     
        String testString = "spawning";
        assertEquals(testString, testEnum.toString());
    }

    //Test if ONGRID is not null
    @Test
    public void testingONGRIDNotNull(){
        PlayerStatus testEnum = PlayerStatus.ONGRID;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case ONGRID
    @Test 
    public void testingONGRIDToString() {    
        PlayerStatus testEnum = PlayerStatus.ONGRID;     
        String testString = "onGrid";
        assertEquals(testString, testEnum.toString());
    }

    //Test if ELIMINATED is not null
    @Test
    public void testingELIMINATEDNotNull(){
        PlayerStatus testEnum = PlayerStatus.ELIMINATED;
        assertNotNull(testEnum);
    }
   
    //Testing right use of toString method for case ELIMINATED
    @Test 
    public void testingELIMINATEDToString() {    
        PlayerStatus testEnum = PlayerStatus.ELIMINATED;     
        String testString = "eliminated";
        assertEquals(testString, testEnum.toString());
    }
}
