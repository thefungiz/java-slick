package thenewguyz.slick.firstgame;

import org.newdawn.slick.Animation;
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
	private Animation playerAnimation;
	private Animation animateLeft;
	private Animation animateRight;
	private Animation animateUp;
	private Animation animateDown;
	
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
		
		animateLeft = new Animation();
		animateLeft.addFrame(ss.getSprite(4, 0), 400);
		animateLeft.addFrame(ss.getSprite(3, 0), 400);
		animateLeft.addFrame(ss.getSprite(4, 0), 400);
		animateLeft.addFrame(ss.getSprite(5, 0), 400);
		animateLeft.setLooping(true);
		this.animateLeft.start();
		animateLeft.setPingPong(true);
		
		
		animateRight = new Animation();
		animateRight.addFrame(ss.getSprite(4, 1), 400);
		animateRight.addFrame(ss.getSprite(3, 1), 400);
		animateRight.addFrame(ss.getSprite(4, 1), 400);
		animateRight.addFrame(ss.getSprite(5, 1), 400);
		animateRight.setLooping(true);
		this.animateRight.start();
		animateRight.setPingPong(true);
		
		animateUp = new Animation();
		animateUp.addFrame(ss.getSprite(1, 0), 400);
		animateUp.addFrame(ss.getSprite(0, 0), 400);
		animateUp.addFrame(ss.getSprite(1, 0), 400);
		animateUp.addFrame(ss.getSprite(2, 0), 400);
		animateUp.setLooping(true);
		this.animateUp.start();
		animateUp.setPingPong(true);
		
		animateDown = new Animation();
		animateDown.addFrame(ss.getSprite(1, 1), 400);
		animateDown.addFrame(ss.getSprite(0, 1), 400);
		animateDown.addFrame(ss.getSprite(1, 1), 400);
		animateDown.addFrame(ss.getSprite(2, 1), 400);
		animateDown.setLooping(true);
		this.animateDown.start();
		animateDown.setPingPong(true);
		
		playerAnimation = animateDown;
	}
	
	public void update(GameContainer gc, int c) throws SlickException {
		
		this.move();
	}
	
	private void updateSprite() {
		
		moving = kb.getUp() || kb.getDown() || kb.getLeft() || kb.getRight();	
		
		this.findDirection();
		
		if (cUp) {
			s = ss.getSprite(1, 0);			
		} else if (cDown) {
			s =  ss.getSprite(1, 1);			
		} else if (cRight) {			
			s =  ss.getSprite(4, 1);	
		} else if (cLeft) {
			s =  ss.getSprite(4, 0);		
		}
	}
	
	private void move() {		
		
		this.updateSprite();		
		this.animate();
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
		
		playerAnimation.draw(200, 200);
		
	}
	
	private void animate() {
		
		moving = kb.getUp() || kb.getDown() || kb.getLeft() || kb.getRight();	
		
		if (!moving && playerAnimation.getFrame() != 0) {
			return;
		}
		
		if (!moving) {
			playerAnimation.stop();
		}
		
		this.findDirection();
		
		if (cUp) {
			playerAnimation = animateUp;		
		} else if (cDown) {
			playerAnimation = animateDown;				
		} else if (cRight) {			
			playerAnimation = animateRight;		
		} else if (cLeft) {
			playerAnimation = animateLeft;		
		}
		
		if (playerAnimation.isStopped()) {
			playerAnimation.restart();
		}
		
	}
	
}
