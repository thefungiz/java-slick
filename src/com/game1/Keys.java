package com.game1;

public enum Keys {

	UP(200, 0, -1),
	DOWN(208, 0, 1),
	LEFT(203, 1, -1),
	RIGHT(205, 1, 1);
	
	private int code, dir, val;
	
	private Keys(int code, int dir, int val) {
		this.code = code;
		this.dir = dir;
		this.val = val;
	}
	
	public int getCode() {
		return code;
	}
	
	public int getDir() {
		return dir;
	}
	
	public int getVal() {
		return val;
	}
}
