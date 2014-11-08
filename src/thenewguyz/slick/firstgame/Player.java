package thenewguyz.slick.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player {

	private final int SPRITE_x = GameConfig.WINDOW_WIDTH/2 - (GameConfig.SPRITE_WIDTH * GameConfig.SCALE)/2;
	private final int SPRITE_Y = GameConfig.WINDOW_HIGHT/2 - (GameConfig.SPRITE_HEIGHT * GameConfig.SCALE)/2;
	
	private KeyBoard kb;
	private Image i;
	private SpriteSheet ss;
	private ImageLoader il;
	private Image s;
	
	public Player(KeyBoard kb) {
		this.kb = kb;
	}
	
	public void init() throws SlickException {
		
		il = new ImageLoader("png/girl.png");
		i = il.getImage();
		ss = new SpriteSheet(i, GameConfig.SPRITE_WIDTH * GameConfig.SCALE, GameConfig.SPRITE_HEIGHT * GameConfig.SCALE, GameConfig.SPRITE_SPACING, GameConfig.SPRITE_MARGIN);
		s = ss.getSprite(1, 1);
	}
	
	public void update(GameContainer gc, int c) throws SlickException {
		
		this.updateSprite();
		
	}
	
	private void updateSprite() {
		
		if (kb.getX() == 0 && kb.getY() == 0) {
			return;
		}
		
		if (kb.getX() == 1) {			
			s = kb.getY() == 1 ? ss.getSprite(1, 1) : ss.getSprite(4, 1);
		} else {			
			s = kb.getY() == 1 ? ss.getSprite(4, 0) : ss.getSprite(1, 0);			
		}		
	}
	
	public void render(Graphics g) throws SlickException {

		g.drawImage(s, SPRITE_x, SPRITE_Y);
		
	}
	
}
