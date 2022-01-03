/**
* <h1>PlayerStatusEnums/h1>
* <p>ENUMs to define player colors.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum PlayerColor {   //Ich habe mal die weiteren Funktionen nicht mit hinzugefügt, da ich mich erstmal auf die Enums konzentriere und da noch nicht ganz klar ist, wie die Farben miteinander interagieren. 
    RED,
	BLUE,
	GREEN,
	YELLOW,
    PURPLE,
    CYAN;

	/**
	 * <h1><i>toString</i></h1>
	 * <p>This method is converting the ENUM to strings that are supported
	 * by the MAEDN specification.</p>
	 * @return String - return string supported by MAEDN specification
	 */
	@Override
	public String toString() {
		switch(this) {
		case RED: return "red";
		case BLUE: return "blue";
		case GREEN: return "green";
		case YELLOW: return "yellow";
        case PURPLE: return "purple";
        case CYAN: return "cyan";
		default: return "";
		}
	}    
}
