package thenewguyz.slick.firstgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Class for loading images. Duh
 * @author thenewguyz
 *
 */
public class ImageLoader extends FileLoader {

	/**
	 * Constructor accepting URL to image as a String
	 * @param	URL		String - location of image file
	 */
	public ImageLoader(String URL) {
		super(URL);
	}
	
	/**
	 * Returns image loaded from URL.
	 * Scale is used based on param.
	 * @param 	scale	boolean - switch for scalemode
	 * @return 	Image
	 */
	public Image getImage(boolean scale) {
		try {
			return scale ? new Image(URL).getScaledCopy(GameConfig.SCALE) : new Image(URL);
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}	
}