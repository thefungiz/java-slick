package thenewguyz.slick.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * Class for managing the player.
 * All of player functionality should go here.
 * @author thenewguyz
 *
 */
public class Player {

	// Coords to center the player on the board.
	private final int SPRITE_x = GameConfig.WINDOW_WIDTH/2 - (GameConfig.SPRITE_WIDTH * GameConfig.SCALE)/2;
	private final int SPRITE_Y = GameConfig.WINDOW_HIGHT/2 - (GameConfig.SPRITE_HEIGHT * GameConfig.SCALE)/2;
	
	private KeyBoard kb;
	private Image i;
	private SpriteSheet ss;
	private ImageLoader il;
	private Image s;
	
	/**
	 * Constructor takes KeyBoard as a param to isolate player functionality from the rest of the game.
	 * @param 	kb	KeyBoard to use for input	
	 */
	public Player(KeyBoard kb) {
		this.kb = kb;
	}
	
	public void init() throws SlickException {
		
		il = new ImageLoader(GameConfig.CHARACTER_SPRITE_SHEET_URL);
		i = il.getImage(true);
		ss = new SpriteSheet(i, GameConfig.SPRITE_WIDTH * GameConfig.SCALE, GameConfig.SPRITE_HEIGHT * GameConfig.SCALE, GameConfig.SPRITE_SPACING, GameConfig.SPRITE_MARGIN);
		s = ss.getSprite(1, 1);
	}
	
	public void update(GameContainer gc, int c) throws SlickException {
		
		this.updateSprite();
		
	}
	
	private void updateSprite() {
		
		// TODO 
		// Logic needs to be changed for 2D movement
		
		if (kb.getX() == 0 && kb.getY() == 0) {			// Return of nothing is changed.
			return;										// Keeps the player from changing directions
		}												// once a key is released.
		
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
