package com.game1;


public abstract class FileLoader {

	protected String URL;
	
	public FileLoader(String URL) {
		this.URL = URL;		

	}
	
	public String getURL() {
		return URL;
	}
}
