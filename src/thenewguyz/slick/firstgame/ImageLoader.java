package thenewguyz.slick.firstgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader extends FileLoader {

	public ImageLoader(String URL) {
		super(URL);
	}
	
	public Image getImage() {
		try {
			return new Image(URL).getScaledCopy(GameConfig.SCALE);
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}	
}