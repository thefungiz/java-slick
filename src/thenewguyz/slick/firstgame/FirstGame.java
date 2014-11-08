package thenewguyz.slick.firstgame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class FirstGame implements Game {

	private final int SPRITE_x = GameConfig.WINDOW_WIDTH/2 - (GameConfig.SPRITE_WIDTH * GameConfig.SCALE)/2;
	private final int SPRITE_Y = GameConfig.WINDOW_HIGHT/2 - (GameConfig.SPRITE_HEIGHT * GameConfig.SCALE)/2;
	
	private String title;
	private KeyBoard kb;
	private ImageLoader il;
	private Image i;
	private SpriteSheet ss;
	
	public FirstGame(String title) {		
		
		this.title = title;
		
		kb = new KeyBoard();		

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		g.drawImage(ss.getSprite(0, 0), SPRITE_x, SPRITE_Y);
		
		kb.renderKeyboardInfo(g);
	}

	public void init(GameContainer gc) throws SlickException {
		
		try {
			GLContext.loadOpenGLLibrary();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		il = new ImageLoader("png/girl.png");
		i = il.getImage();
		ss = new SpriteSheet(i, GameConfig.SPRITE_WIDTH * GameConfig.SCALE, GameConfig.SPRITE_HEIGHT * GameConfig.SCALE, GameConfig.SPRITE_SPACING, GameConfig.SPRITE_MARGIN);
	}

	public void update(GameContainer gc, int c) throws SlickException {
		
		gc.getInput().addKeyListener(kb);
		
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
