package thenewguyz.slick.firstgame;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import thenewguyz.utils.Console;

public class Map {

	private TiledMap map;
	private KeyBoard kb;
	private int x, y, s, tickCount, distance, direction;
	// Current direction
	private boolean cUp, cDown, cLeft, cRight, moving;
	
	public Map(KeyBoard k, int x, int y, int speed) throws SlickException {
		
		kb = k;
		
		this.x = x;
		this.y = y;
		this.s = speed;
		this.tickCount = 0;
		this.distance = 0;
		this.direction = 0;
		
		this.init();
		
		cDown = false;
		cUp = false;
		cLeft = false;
		cRight = false;

		moving = false;
	}
	
	private void init() throws SlickException {
		
		map = new TiledMap("tmx/test2.tmx");
		
	}
	
	public void render() {
		
		map.render(x, y);
		
	}
	
	public void update(boolean isMoving) {
		
		moving = kb.getUp() || kb.getDown() || kb.getLeft() || kb.getRight();
		
		this.findDirection();
		
		//Console.writeLine(FirstGame.getPlayerInstance().isPlayerAnimationStopped());
		
		if (isMoving) {
			
			if (tickCount <= s) {
				
				tickCount++;
				distance++;
				return;				
			}
			
			this.scroll();
			
			tickCount = 0;	
		}
		
	}
	
	private void findDirection() {
		
		// If none of the other keys are pressed down and the key is pressed
		cUp = (!(cDown || cLeft || cRight)) && kb.getUp();
		cDown = (!(cLeft || cRight || cUp)) && kb.getDown();
		cLeft = (!(cRight || cUp || cDown)) && kb.getLeft();
		cRight = (!(cUp || cDown || cLeft)) && kb.getRight();			
	}
	
	private void scroll() {
		
		
		
		x = cLeft ? ++x : x;
		x = cRight ? --x : x;
		y = cUp ? ++y : y;
		y = cDown ? --y : y;
		
	}
	
}
