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

	private int pCode, rCode;
	private boolean pressed;
	private boolean up, down, left, right;
	
	public KeyBoard() {
		
		pCode = -1;
		rCode = -1;
		
		pressed = false;
		
		down = false;
		up = false;
		left = false;
		right = false;
	}

	@Override
	public void inputEnded() { }

	@Override
	public void inputStarted() { }

	@Override
	public boolean isAcceptingInput() {
		
		return true;
	}

	@Override
	public void setInput(Input arg0) { }

	public boolean isPressed() {
		
		return pressed;
	}
		
	@Override
	public void keyPressed(int key, char c) {
				
		pressed = true;
		
		pCode = key;	
		
		up = key == Keys.UP.getCode() ? true : up;
		down = key == Keys.DOWN.getCode() ? true : down;
		left = key == Keys.LEFT.getCode() ? true : left;
		right = key == Keys.RIGHT.getCode() ? true : right;		
	}
	
	@Override
	public void keyReleased(int key, char c) {
				
		pressed = false;

		rCode = key;	
		
		up = key == Keys.UP.getCode() ? false : up;
		down = key == Keys.DOWN.getCode() ? false : down;
		left = key == Keys.LEFT.getCode() ? false : left;
		right = key == Keys.RIGHT.getCode() ? false : right;
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
	}
	
	public int getPressedCode() {
		return pCode;
	}
	
	public int getReleasedCode() {
		return rCode;
	}
}
