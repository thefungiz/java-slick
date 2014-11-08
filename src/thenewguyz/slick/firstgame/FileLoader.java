package thenewguyz.slick.firstgame;


public abstract class FileLoader {

	protected String URL;
	
	public FileLoader(String URL) {
		this.URL = URL;		

	}
	
	public String getURL() {
		return URL;
	}
}
