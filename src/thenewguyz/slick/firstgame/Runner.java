package thenewguyz.slick.firstgame;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * Generic runner class. WOW.
 * @author thenewguyz
 *
 */
public class Runner {
	
	public static void main(String[] args) throws LWJGLException, SlickException {
		
		FirstGame g = new FirstGame(GameConfig.GAME_TITLE);

		try {
			AppGameContainer agc = new AppGameContainer(g);
			agc.setDisplayMode(GameConfig.WINDOW_WIDTH * GameConfig.SCALE * GameConfig.TILE_SIZE, GameConfig.WINDOW_HEIGHT * GameConfig.SCALE * GameConfig.TILE_SIZE, false);
			
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
