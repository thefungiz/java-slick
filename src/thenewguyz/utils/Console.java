package thenewguyz.utils;

/**
 * Util class to simulate Console class in .NET.
 * System.out is too redundant.. sorry.
 * @author thenewguyz
 *
 */
public class Console {

	/**
	 * Method prints object to console as a String.
	 * @param 	o	Object - generic
	 */
	public static void write(Object o) {
		
		System.out.print(o.toString());
	}
	
	/**
	 * Method prints object to console as a String followed by a new line.
	 * @param	o	Object - generic
	 */
	public static void writeLine(Object o) {
		
		System.out.println(o.toString());
	}
}
