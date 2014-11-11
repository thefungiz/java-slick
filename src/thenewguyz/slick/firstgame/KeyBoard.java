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

	private int pCode, rCode; //, x, y;
	// private boolean[] board;
	private boolean pressed;
	private boolean up, down, left, right;
	
	public KeyBoard() {
		// Boolean array simulates keycodes.
//		board = new boolean[256];
//		
//		// Load all elements as false in the "released" position.
//		for (int i = 0; i < board.length; i++) {
//			board[i] = false;
//		}
		
		pCode = -1;
		rCode = -1;
//		x = 0;
//		y = 0;
		
		pressed = false;
		
		down = false;
		up = false;
		left = false;
		right = false;
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
//		board[key] = true;		
		pCode = key;	
		
		up = key == Keys.UP.getCode() ? true : up;
		down = key == Keys.DOWN.getCode() ? true : down;
		left = key == Keys.LEFT.getCode() ? true : left;
		right = key == Keys.RIGHT.getCode() ? true : right;
		
		// this.setDirOnPress(key);
		
	}
	
	@Override
	public void keyReleased(int key, char c) {
				
		pressed = false;
		
//		// Sets element with corresponding keycode as "released".
//		board[key] = false;
		rCode = key;	
		
		up = key == Keys.UP.getCode() ? false : up;
		down = key == Keys.DOWN.getCode() ? false : down;
		left = key == Keys.LEFT.getCode() ? false : left;
		right = key == Keys.RIGHT.getCode() ? false : right;
		
		
		// this.setDirOnRelease(key);
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public boolean getUp() {
		return up;
	}
	
	public boolean getDown() {
		return down;
	}
	
	/**
	 * Method that prints current keycode, x coord, and y coord on the screen.
	 * @param 	g	Graphics to render
	 */
	public void renderKeyboardInfo(Graphics g) {
		
		g.drawString(String.format("# = %1.0f", (float) this.getPressedCode()), 10, 30);
//		g.drawString(String.format("X = %1.0f", (float)getX()), 10, 50);
//		g.drawString(String.format("Y = %1.0f", (float)getY()), 10, 70);
	}
	
	public int getPressedCode() {
		return pCode;
	}
	
	public int getReleasedCode() {
		return rCode;
	}
//	
//	public int getX() {		
//		return x;
//	}
//
//	public int getY() {		
//		return y;
//	}
	
//	private void setDirOnPress(int code) {
////		
////		for (Keys k : Keys.values()) {
////			
////			if (k.getCode() == code && board[code]) {		// Flags keycode that is pressed.
////				if (k.getDir() == 1) {
////					x = k.getVal();			// Set direction.
////					break;
////				}
////				else if (k.getDir() == 0) {
////					y = k.getVal();
////					break;
////				}
////			}
////		}
//	}
	
//	private void setDirOnRelease(int code) {
////
////		for (Keys k : Keys.values()) {
////			
////			if (k.getCode() == code && !board[code]) {		// Flags keycode that is released.
////				if (k.getDir() == 1) {
////					x = 0;					// Reset direction.
////					break;
////				}
////				if (k.getDir() == 0) {
////					y = 0;
////					break;
////				}
////			}
////		}
//	}
	
}
