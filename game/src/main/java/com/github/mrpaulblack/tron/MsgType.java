package com.github.mrpaulblack.tron;

/**
* <h1>MsgTypeEnums</h1>
* <p>ENUMs for message types supporting communication between server and client.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum MsgType { //ebenfalls Frage an Server-Gruppe: Was davon brauchen wir realistisch wirklich. 

    REGISTER,
	READY,
	MOVE,
	WELCOME,
	ASSIGNCOLOR,
	UPDATE,
	TURN,
	PLAYERDISCONNECTED,
	MESSAGE,
	ERROR;
	
	/**
	 * <h1><i>toString</i></h1>
	 * <p>Method converting Enums to string and return it.<p>
	 * @return String
	 */
	@Override
	public String toString() {
		switch(this) {
		case REGISTER: return "register";
		case READY: return "ready";
		case MOVE: return "move";
		case WELCOME: return "welcome";
		case ASSIGNCOLOR: return "assignColor";
		case UPDATE: return "update";
		case TURN: return "turn";
		case PLAYERDISCONNECTED: return "playerDisconnected";
		case MESSAGE: return "message";
		case ERROR: return "error";
		default: return "";
		}
	}    
}
