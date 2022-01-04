package com.github.mrpaulblack.tron;

/**
* <h1>PlayerStatusEnums/h1>
* <p>ENUM to determain the overall state of the game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum GameStateEnums {
    
    SETTINGUP,
	RUNNING,
	FINISHED;
	
    /**
    * <h1><i>toString</i></h1>
    * <p>Method converting Enums to string and return it.<p>
    * @return String 
    */
	@Override
	public String toString() {
		switch(this) {
		case SETTINGUP: return "settingup";
		case RUNNING: return "running";
		case FINISHED: return "finished";
		default: return "";
		}
	}
}
