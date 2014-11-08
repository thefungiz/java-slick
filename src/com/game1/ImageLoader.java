package com.game1;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader extends FileLoader {

	public ImageLoader(String URL) {
		super(URL);
	}
	
	public Image getImage() {
		try {
			return new Image(URL);
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}	
}