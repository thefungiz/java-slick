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
	private SpriteSheet ss;
	private ImageLoader il;
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
		
		cDown = false;
		cUp = false;
		cLeft = false;
		cRight = false;

		moving = false;
	}
	
	public void init() throws SlickException {
		
		il = new ImageLoader(GameConfig.CHARACTER_SPRITE_SHEET_URL);
		ss = new SpriteSheet(il.getImage(true), GameConfig.SPRITE_WIDTH * GameConfig.SCALE, GameConfig.SPRITE_HEIGHT * GameConfig.SCALE, GameConfig.SPRITE_SPACING, GameConfig.SPRITE_MARGIN);
		
		animateLeft = new Animation();
		animateLeft.addFrame(ss.getSprite(4, 0), GameConfig.WALK_DURATION);
		animateLeft.addFrame(ss.getSprite(3, 0), GameConfig.WALK_DURATION);
		animateLeft.addFrame(ss.getSprite(4, 0), GameConfig.WALK_DURATION);
		animateLeft.addFrame(ss.getSprite(5, 0), GameConfig.WALK_DURATION);
		animateLeft.setLooping(true);
		this.animateLeft.start();
		animateLeft.setPingPong(true);
		
		
		animateRight = new Animation();
		animateRight.addFrame(ss.getSprite(4, 1), GameConfig.WALK_DURATION);
		animateRight.addFrame(ss.getSprite(3, 1), GameConfig.WALK_DURATION);
		animateRight.addFrame(ss.getSprite(4, 1), GameConfig.WALK_DURATION);
		animateRight.addFrame(ss.getSprite(5, 1), GameConfig.WALK_DURATION);
		animateRight.setLooping(true);
		this.animateRight.start();
		animateRight.setPingPong(true);
		
		animateUp = new Animation();
		animateUp.addFrame(ss.getSprite(1, 0), GameConfig.WALK_DURATION);
		animateUp.addFrame(ss.getSprite(0, 0), GameConfig.WALK_DURATION);
		animateUp.addFrame(ss.getSprite(1, 0), GameConfig.WALK_DURATION);
		animateUp.addFrame(ss.getSprite(2, 0), GameConfig.WALK_DURATION);
		animateUp.setLooping(true);
		this.animateUp.start();
		animateUp.setPingPong(true);
		
		animateDown = new Animation();
		animateDown.addFrame(ss.getSprite(1, 1), GameConfig.WALK_DURATION);
		animateDown.addFrame(ss.getSprite(0, 1), GameConfig.WALK_DURATION);
		animateDown.addFrame(ss.getSprite(1, 1), GameConfig.WALK_DURATION);
		animateDown.addFrame(ss.getSprite(2, 1), GameConfig.WALK_DURATION);
		animateDown.setLooping(true);
		this.animateDown.start();
		animateDown.setPingPong(true);
		
		playerAnimation = animateDown;
	}
	
	public void update(GameContainer gc, int c) throws SlickException {		
		
		this.move();
	}
	
	private void move() {		
		
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
		
		this.playerAnimation.draw(SPRITE_x, SPRITE_Y);		
	}
	
	public boolean isPlayerAnimationStopped() {
		
		return playerAnimation.isStopped();
		
	}
	
	private void animate() {
		
		moving = kb.getUp() || kb.getDown() || kb.getLeft() || kb.getRight();	
		
		if (!moving) {
			// If previous animation has not finished, return.
			if (playerAnimation.getFrame() != 0) {
				return;
			}
			// Stop animation if not moving and previous animation is finished.
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
// The end bra.