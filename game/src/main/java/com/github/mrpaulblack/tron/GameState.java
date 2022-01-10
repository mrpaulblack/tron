package com.github.mrpaulblack.tron;

/**
* <h1>PlayerStatus</h1>
* <p>ENUM to determain the overall state of the game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum GameState {
    
    SETTINGUP,
	RUNNING,
	FINISHED;
	
    /**
    * <h1><i>toString</i></h1>
    * <p>Method converting Enums to string and return it supporting TRON spezifications..<p>
    * @return String 
    */
	@Override
	public String toString() {
		switch(this) {
		case SETTINGUP: return "settingUp";
		case RUNNING: return "running";
		case FINISHED: return "finished";
		default: return "";
		}
	}
}
