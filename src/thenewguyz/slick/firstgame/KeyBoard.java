package thenewguyz.slick.firstgame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 * Class for managing keyboard input.
 * @author thenewguyz
 *
 */
public class KeyBoard implements KeyListener {

	private int code, x, y;
	private boolean[] board;
	private boolean pressed;
	
	public KeyBoard() {
		// Boolean array simulates keycodes.
		board = new boolean[256];
		
		// Load all elements as false in the "released" position.
		for (int i = 0; i < board.length; i++) {
			board[i] = false;
		}
		
		code = -1;
		x = 0;
		y = 0;
		pressed = false;
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

	public boolean isPressed() {
		
		return pressed;
	}
		
	@Override
	public void keyPressed(int key, char c) {
				
		pressed = true;
		
		// Sets element with corresponding keycode as "pressed".
		board[key] = true;		
		code = key;		
		setDirOnPress(key);
		
	}
	
	@Override
	public void keyReleased(int key, char c) {
				
		pressed = false;
		
		// Sets element with corresponding keycode as "released".
		board[key] = false;
		code = -1;	
		setDirOnRelease(key);
	}
	
	/**
	 * Method that prints current keycode, x coord, and y coord on the screen.
	 * @param 	g	Graphics to render
	 */
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
			
			if (k.getCode() == code && board[code]) {		// Flags keycode that is pressed.
				if (k.getDir() == 1) {
					x = k.getVal();			// Set direction.
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
			
			if (k.getCode() == code && !board[code]) {		// Flags keycode that is released.
				if (k.getDir() == 1) {
					x = 0;					// Reset direction.
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
