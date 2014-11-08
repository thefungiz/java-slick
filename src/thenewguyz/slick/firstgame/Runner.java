package thenewguyz.slick.firstgame;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Runner {

	
	public static void main(String[] args) throws LWJGLException {
		
		FirstGame g = new FirstGame(GameConfig.GAME_TITLE);

		try {
			AppGameContainer agc = new AppGameContainer(g);
			agc.setDisplayMode(GameConfig.WINDOW_WIDTH, GameConfig.WINDOW_HIGHT, false);
			
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
