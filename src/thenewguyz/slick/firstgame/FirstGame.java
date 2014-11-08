package thenewguyz.slick.firstgame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * Class for initialization of game.
 * @author thenewguyz
 *
 */
public class FirstGame implements Game {
	
	private Player player;
	private String title;
	private KeyBoard kb;

	
	public FirstGame(String title) {		
		
		this.title = title;
		
		kb = new KeyBoard();	
		player = new Player(kb);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {

		player.render(g);
		
		kb.renderKeyboardInfo(g);
	}

	public void init(GameContainer gc) throws SlickException {
		
		try {
			GLContext.loadOpenGLLibrary();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
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
