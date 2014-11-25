package thenewguyz.slick.firstgame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Class for initialization of game.
 * @author thenewguyz
 *
 */
public class FirstGame implements Game {
	
	private Player player;
	private TiledMap map;
	private String title;
	private KeyBoard kb;
	private int mapX, mapY;
	
	public FirstGame(String title) throws SlickException {		
		
		this.title = title;
		
		kb = new KeyBoard();	
		player = new Player(kb);
		mapX = 0;
		mapY = 0;
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {

		map.render(mapX, mapY);
		
		player.render(g);
		
		kb.renderKeyboardInfo(g);
	}

	public void init(GameContainer gc) throws SlickException {
		
		try {
			GLContext.loadOpenGLLibrary();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		map = new TiledMap("tmx/test2.tmx");
		
		player.init();
		

	}

	public void update(GameContainer gc, int c) throws SlickException {
		
		gc.getInput().addKeyListener(kb);
		
		player.update(gc, c);
		
	}

	@Override
	public boolean closeRequested() {
		return true;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
