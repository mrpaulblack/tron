package com.github.mrpaulblack.tron;

/**
* <h1>MsgErrorEnums/h1>
* <p>ENUM for error-types used in server & client (log?)</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum MsgError {

    UNSUPPORTEDMESSAGETYPE,
	UNSUPPORTEDPROTOCOLVERSION,
	SERVERFULL,
	ILLEGALMOVE,    //brauchen wir diesen Typen überhaupt?
	NOTYOURTURN,
	UNKNOWN;

    /**
    * <h1><i>toString</i></h1>
    * <p>Method converting Enums to string and return it.<p>
    * @return String 
    */
    @Override
    public String toString() {
        switch(this) {
        case UNSUPPORTEDMESSAGETYPE: return "unsupportedMessageType";
        case UNSUPPORTEDPROTOCOLVERSION: return "unsupportedProtocolVersion";
        case SERVERFULL: return "serverFull";
        case ILLEGALMOVE: return "illegalMove";
        case NOTYOURTURN: return "notYourTurn";
        case UNKNOWN: return "unknown";
        default: return "";    
        }       
    }
}
