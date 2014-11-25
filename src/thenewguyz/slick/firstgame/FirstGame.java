package thenewguyz.slick.firstgame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Class for initialization of game.
 * @author thenewguyz
 *
 */
public class FirstGame implements Game {
	
	private Player player;
	private String title;
	private KeyBoard kb;
	private Music music;
	private Map map;
	
	public FirstGame(String title) throws SlickException {		
		
		this.title = title;
		
		kb = new KeyBoard();	
		player = new Player(kb);
		
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {

		map.render();
		
		player.render(g);
		
		kb.renderKeyboardInfo(g);
	}

	public void init(GameContainer gc) throws SlickException {
		
		try {
			GLContext.loadOpenGLLibrary();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		map = new Map(kb, 0, 0, 8);
		music = new Music("audio/test.ogg");
		music.play();
		player.init();
		
	}

	public void update(GameContainer gc, int c) throws SlickException {
		
		gc.getInput().addKeyListener(kb);
		
		map.update(this.isPlayerMoving());
		
		player.update(gc, c);
		
	}
	
	public boolean isPlayerMoving() {
		
		return !player.isPlayerAnimationStopped();
		
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
