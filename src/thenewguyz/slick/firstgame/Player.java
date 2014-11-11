package thenewguyz.slick.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import thenewguyz.utils.Console;

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
	
	// Current direction
	private boolean cUp, cDown, cLeft, cRight;

	private boolean moving;
	
	/**
	 * Constructor takes KeyBoard as a param to isolate player functionality from the rest of the game.
	 * @param 	kb	KeyBoard to use for input	
	 */
	public Player(KeyBoard kb) {
		
		this.kb = kb;
		
		// Start in the down position
		cDown = false;
		cUp = false;
		cLeft = false;
		cRight = false;

		moving = false;
	}
	
	public void init() throws SlickException {
		
		il = new ImageLoader(GameConfig.CHARACTER_SPRITE_SHEET_URL);
		i = il.getImage(true);
		ss = new SpriteSheet(i, GameConfig.SPRITE_WIDTH * GameConfig.SCALE, GameConfig.SPRITE_HEIGHT * GameConfig.SCALE, GameConfig.SPRITE_SPACING, GameConfig.SPRITE_MARGIN);
		s = ss.getSprite(1, 1);
	}
	
	public void update(GameContainer gc, int c) throws SlickException {
		
		this.move();
	}
	
	private void updateSprite() {
		
		moving = kb.getUp() || kb.getDown() || kb.getLeft() || kb.getRight();	
		
		Console.write("hit");
		
		this.findDirection();
		
		if (cUp) {
			s = ss.getSprite(1, 0);			
		} else if (cDown) {
			s =  ss.getSprite(1, 1);			
		} else if (cRight) {			
			s = ss.getSprite(4, 1);			
		} else if (cLeft) {
			s = ss.getSprite(4, 0);
		}
	}
	
	private void move() {		
		
		this.updateSprite();		
	}
	
	private void findDirection() {

		// If none of the other keys are pressed down and the key is pressed
		cUp = (!(cDown || cLeft || cRight)) && kb.getUp();
		cDown = (!(cLeft || cRight || cUp)) && kb.getDown();
		cLeft = (!(cRight || cUp || cDown)) && kb.getLeft();
		cRight = (!(cUp || cDown || cLeft)) && kb.getRight();		
	
	}
	
	public void render(Graphics g) throws SlickException {

		g.drawImage(s, SPRITE_x, SPRITE_Y);
		
	}
	
}
