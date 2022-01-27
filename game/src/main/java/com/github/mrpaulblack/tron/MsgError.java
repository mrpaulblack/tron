package com.github.mrpaulblack.tron;

/**
* <p>ENUM for error-types used in server and client </p>
* @version 1.0
* @since   2021-12-29
*/
public enum MsgError {

    UNSUPPORTEDMESSAGETYPE,
	UNSUPPORTEDPROTOCOLVERSION,
	SERVERFULL,
	ILLEGALMOVE,
	INSPECTATE,
	UNKNOWN;

    /**
    * <p>Method converting Enums to string and return it supporting TRON spezifications..<p>
    * @return String 
    */
    @Override
    public String toString() {
        switch(this) {
        case UNSUPPORTEDMESSAGETYPE: return "unsupportedMessageType";
        case UNSUPPORTEDPROTOCOLVERSION: return "unsupportedProtocolVersion";
        case SERVERFULL: return "serverFull";
        case ILLEGALMOVE: return "illegalMove";
        case INSPECTATE: return "inSpectate";
        case UNKNOWN: return "unknown";
        default: return "";    
        }       
    }
}
