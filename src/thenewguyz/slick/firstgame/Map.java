package thenewguyz.slick.firstgame;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import thenewguyz.utils.Console;

public class Map {

	private TiledMap map;
	private KeyBoard kb;
	private int x, y, speed, tickCount, layerIndex, playerTileLeft, playerTileRight, playerTileTop, playerTileBottom;
	// Current direction
	private boolean cUp, cDown, cLeft, cRight, moving;
	
	public Map(KeyBoard k, int x, int y, int speed) throws SlickException {
		
		kb = k;
		
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.tickCount = 0;
		
		this.init();
		
		cDown = false;
		cUp = false;
		cLeft = false;
		cRight = false;

		moving = false;
	}
	
	private void init() throws SlickException {
		
		map = new TiledMap("tmx/overworld.tmx");		
		layerIndex = map.getLayerIndex("outter-cliff");		
		playerTileLeft = (int)GameConfig.SPRITE_TILE_X;
		playerTileRight = (int)(GameConfig.SPRITE_TILE_X + GameConfig.SPRITE_WIDTH * GameConfig.SCALE);
		playerTileTop = (int)GameConfig.SPRITE_TILE_Y;
		playerTileBottom = (int)(GameConfig.SPRITE_TILE_Y + GameConfig.SPRITE_HEIGHT * GameConfig.SCALE);
	}
	
	public void render() {
		
		map.render(x, y);
	}
	
	public void update() {
		
		moving = kb.getUp() || kb.getDown() || kb.getLeft() || kb.getRight();
		
		this.findDirection();
		
		if (moving) {			
			if (tickCount > 100 - speed) {
				
				tickCount = 0;				
				return;				
			}
			
			this.scroll();
			
			tickCount++;	
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
		
		Console.writeLine((playerTileTop-y-1)/map.getTileHeight());
		Console.writeLine(map.getTileId((int)(playerTileLeft-x)/map.getTileWidth(), (int)(playerTileTop-y-1)/map.getTileHeight(), layerIndex));
		
		// map.getTileId(0, 0, layerIndex);
		if (cUp && map.getTileId(this.getTileLocation(playerTileLeft, x, 0), this.getTileLocation(playerTileTop, y, -1), layerIndex) == 0) {
			y++;
		}
		if (cDown && map.getTileId(this.getTileLocation(playerTileLeft, x, 0), this.getTileLocation(playerTileBottom, y, 1), layerIndex) == 0) {
			y--;
		}
		if (cLeft && map.getTileId(this.getTileLocation(playerTileLeft, x, -1), this.getTileLocation(playerTileBottom, y, 0), layerIndex) == 0) {
			x++;
		}
		if (cRight && map.getTileId((int)this.getTileLocation(playerTileRight, x, 1), this.getTileLocation(playerTileBottom, y, 0), layerIndex) == 0) {
			x--;
		}		
	}
	
	private int getTileLocation(int pLoc, int mLoc, int off) {
		
		return (pLoc - mLoc + off) / map.getTileWidth();		
	}
	
}
