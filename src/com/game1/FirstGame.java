package com.game1;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class FirstGame implements Game {

	private String title;
	private boolean[] board;
	private KeyBoard kb;
	private ImageLoader il;
	private Image i;
	private SpriteSheet ss;
	
	public FirstGame(String title) {		
		
		this.title = title;
		
		board = new boolean[256];
		
		for (int i = 0; i < board.length; i++) {
			board[i] = false;
		}
		
		kb = new KeyBoard();		

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		g.drawImage(ss.getSprite(kb.getX() + 1, kb.getY() + 1), 100, 100);
		
		kb.renderKeyboardInfo(g);
	}

	public void init(GameContainer gc) throws SlickException {
		
		try {
			GLContext.loadOpenGLLibrary();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		il = new ImageLoader("TestSpriteSheet.png");
		i = il.getImage();
		ss = new SpriteSheet(i, 32, 32, 0, 0);
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
