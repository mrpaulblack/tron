package com.github.mrpaulblack.tron;

/**
* <p>ENUM to determain the player stauts within a running game.</p>
* @version 1.0
* @since   2021-12-29
*/
public enum PlayerStatus {

    SPAWNING,
	ONGRID,
	ELIMINATED;
	
	/**
	 * <p>Method converting Enums to string and return it supporting TRON spezifications.<p>
	 * @return String
	 */
	@Override
	public String toString() {
		switch(this) {
		case SPAWNING: return "spawning";
		case ONGRID: return "onGrid";
		case ELIMINATED: return "eliminated";
		default: return "";
		}
	}    
}
