package edu.apcs.doom.config;

public class Config {
	private static Config instance;
	public static Config get() {
		if(instance == null)
			instance = new Config();
		return instance;
	}
	
	private final int GAME_WIDTH = 400;
	private final int GAME_HEIGHT = 400;
	
	private final float WALK_SPEED = 0.0f;
	private final float TURN_SPEED = 0.0f;
	
}
