package com.github.mrpaulblack.tron;

/**
* <h1>MsgType</h1>
* <p>ENUMs for message types supporting communication between server and client.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum MsgType { //ebenfalls Frage an Server-Gruppe: Was davon brauchen wir realistisch wirklich. 

    HELLO,
	WELCOME,
	REGISTER,
	SESSIONSETTINGS,
	SESSIONDATA,
	UPDATE,
	LOBBYDATA,
	MOVE,
	MESSAGE,
	ERROR;
	
	/**
	 * <h1><i>toString</i></h1>
	 * <p>Method converting Enums to string and return it supporting TRON spezifications..<p>
	 * @return String
	 */
	@Override
	public String toString() {
		switch(this) {
		case HELLO: return "hello";
		case WELCOME: return "welcome";
		case REGISTER: return "register";
		case SESSIONSETTINGS: return "sessionSettings";
		case SESSIONDATA: return "sessionData";
		case UPDATE: return "update";
		case LOBBYDATA: return "lobbyData";
		case MOVE: return "move";
		case MESSAGE: return "message";
		case ERROR: return "error";
		default: return "";
		}
	}    
}
