package com.github.mrpaulblack.tron;

/**
* <p>ENUMs to define player colors.</p>
* @version 1.0
* @since   2021-12-29
*/
public enum PlayerColor {
    RED(0),
	BLUE(1),
	GREEN(2),
	YELLOW(3),
    PURPLE(4),
    CYAN(5),
	UNDEFINED(6);

	private int index;

	/**
	 * <p>This constrcuted i sgetting called, when a color gets created.
	 * It sets the index of a specific color as attribute./p>
	 */
	PlayerColor(int index) {
		this.index = index;
	}

	/**
	 * <p>This method returns the index of a color (self made tupel).</p>
	 * @return int of the index of the color 
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * <p>This method returns the PlayerColor matching a string.</p>
	 * @param color String of the PlayerColor
	 * @return PlayerColor 
	 */
	public static PlayerColor toPlayerColor(String color) {
		switch(color) {
			case "red": return RED;
			case "blue": return BLUE;
			case "green": return GREEN;
			case "yellow": return YELLOW;
			case "purple": return PURPLE;
       		case "cyan": return CYAN;
			case "undefined": return UNDEFINED;
			default: return null;
		}
	}

	/**
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
		case UNDEFINED: return "undefined";
		default: return "";
		}
	}
}
