package thenewguyz.slick.firstgame;

/**
 * Base class for loading files.
 * @author thenewguyz
 *
 */
public abstract class FileLoader {

	protected String URL;
	
	/**
	 * Constructor takes URL as a param.
	 * @param 	URL 	String - location of file
	 */
	public FileLoader(String URL) {
		
		this.URL = URL;		
	}
	
	/**
	 * Method returns URL String, really.
	 * @return 	String
	 */
	public String getURL() {
		
		return URL;
	}
}
