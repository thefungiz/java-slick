package thenewguyz.slick.firstgame;

/**
 * Class for game configuration.
 * Game data should be edited HERE, not in individual classes. It helps a lot, trust me.
 * @author thenewguyz
 *
 */
public class GameConfig {

	public static final String GAME_TITLE = "Awesume Game";
	public static final String TEST_SPRITE_SHEET_URL = "TestSpriteSheet.png";
	public static final String CHARACTER_SPRITE_SHEET_URL = "png/girl.png";
	public static final String WORLD_SPRITE_SHEET_URL = "tmx/overworld.tmx";
	public static final int WALK_DURATION = 200;
	public static final int MAP_START_X_TILE = 10;
	public static final int MAP_START_Y_TILE = 10;
	public static final int MAP_SPEED = 45;
	public static final int TILE_SIZE = 32;
	public static final int SPRITE_WIDTH = 18;
	public static final int SPRITE_HEIGHT = 20;
	public static final int SPRITE_X = (GameConfig.WINDOW_WIDTH * GameConfig.TILE_SIZE * GameConfig.SCALE)/2 - (GameConfig.SPRITE_WIDTH * GameConfig.SCALE)/2;
	public static final int SPRITE_Y = (GameConfig.WINDOW_HEIGHT * GameConfig.TILE_SIZE * GameConfig.SCALE)/2 - (GameConfig.SPRITE_HEIGHT * GameConfig.SCALE)/2;	
	public static final int SPRITE_TILE_X = (GameConfig.WINDOW_WIDTH * GameConfig.TILE_SIZE * GameConfig.SCALE)/2 - (GameConfig.SPRITE_WIDTH * GameConfig.SCALE)/2;
	public static final int SPRITE_TILE_Y = (GameConfig.WINDOW_HEIGHT * GameConfig.TILE_SIZE * GameConfig.SCALE)/2 - (GameConfig.SPRITE_HEIGHT * GameConfig.SCALE)/2;
	public static final int SPRITE_SPACING = 0;
	public static final int SPRITE_MARGIN = 0;
	public static final int SCALE = 2;
	public static final int WINDOW_WIDTH = 15;
	public static final int WINDOW_HEIGHT = 9;	
}
