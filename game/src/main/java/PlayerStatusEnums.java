/**
* <h1>PlayerStatusEnums/h1>
* <p>ENUM to determain the player stauts within a running game.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum PlayerStatusEnums {

    SPAWNING,
	ONGRID,
	ELIMINATED;
	
	/**
	 * <h1><i>toString</i></h1>
	 * <p>Method converting Enums to string and return it.<p>
	 * @return String
	 */
	@Override
	public String toString() {
		switch(this) {
		case SPAWNING: return "spawning";
		case ONGRID: return "ongrid";
		case ELIMINATED: return "eliminated";
		default: return "";
		}
	}    
}
