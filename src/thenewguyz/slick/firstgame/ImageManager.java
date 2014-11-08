package thenewguyz.slick.firstgame;

import java.util.HashMap;

import org.newdawn.slick.Image;

public class ImageManager {

	private HashMap<String, Image> map;
	
	public ImageManager() {
		map = new HashMap<String, Image>();
	}
	
	public void addImage(String name, Image image) {
		map.put(name, image);
	}
	
	public Image getImage(String name) {
		
		return map.get(name);		
	}	
}
