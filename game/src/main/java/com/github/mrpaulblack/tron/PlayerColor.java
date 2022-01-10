package com.github.mrpaulblack.tron;

/**
* <h1>PlayerColor</h1>
* <p>ENUMs to define player colors.</p>

* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public enum PlayerColor {
    RED(0),
	BLUE(1),
	GREEN(2),
	YELLOW(3),
    PURPLE(4),
    CYAN(5);

	private int index;

	PlayerColor(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}

	/**
	 * <h1><i>toString</i></h1>
	 * <p>Method converting Enums to string and return it supporting TRON spezifications.</p>
	 * @return String 
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
