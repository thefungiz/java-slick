package com.game1;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class KeyBoard implements KeyListener {

	private int code, x, y;
	private boolean[] board;
	
	public KeyBoard() {
		board = new boolean[256];
		
		for (int i = 0; i < board.length; i++) {
			board[i] = false;
		}
		
		code = -1;
		x = 0;
		y = 0;
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

	
	//@Override
	public void keyPressed(int key, char c) {
				
		board[key] = true;		
		code = key;		
		setDirOnPress(key);
		
	}
	
	@Override
	public void keyReleased(int key, char c) {
						
		board[key] = false;
		code = -1;	
		setDirOnRelease(key);
	}
	
	public void renderKeyboardInfo(Graphics g) {
		
		g.drawString(String.format("# = %1.0f", (float)getCode()), 10, 30);
		g.drawString(String.format("X = %1.0f", (float)getX()), 10, 50);
		g.drawString(String.format("Y = %1.0f", (float)getY()), 10, 70);
	}
	
	public int getCode() {
		return code;
	}
	
	public int getX() {		
		return x;
	}

	public int getY() {		
		return y;
	}
	
	private void setDirOnPress(int code) {
		
		for (Keys k : Keys.values()) {
			
			if (k.getCode() == code && board[code]) {
				if (k.getDir() == 1) {
					x = k.getVal();
					break;
				}
				else if (k.getDir() == 0) {
					y = k.getVal();
					break;
				}
			}
		}
	}
	
	private void setDirOnRelease(int code) {

		for (Keys k : Keys.values()) {
			
			if (k.getCode() == code && !board[code]) {
				if (k.getDir() == 1) {
					x = 0;
					break;
				}
				if (k.getDir() == 0) {
					y = 0;
					break;
				}
			}
		}
	}
	
}
