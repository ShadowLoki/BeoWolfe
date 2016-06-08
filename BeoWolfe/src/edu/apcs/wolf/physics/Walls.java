package edu.apcs.wolf.physics;

import edu.apcs.wolf.config.Config;

public class Walls {
	
	private static float _tolerance = 0.25f;
	
	public boolean southWall() {
		return (Config.get().worldMap()[(int)(Config.get().position().x - (Config.get().direction().x * Config.get().walkSpeed()+_tolerance))][(int)Config.get().position().y] == 0);
	}
	
	public boolean northWall() {
		return (Config.get().worldMap()[(int)(Config.get().position().x + (Config.get().direction().x * Config.get().walkSpeed()+_tolerance))][(int)Config.get().position().y] == 0);
		}
	
	public boolean rightWall() {
		return (Config.get().worldMap()[(int)Config.get().position().x][(int)(Config.get().position().y + (Config.get().direction().y * Config.get().walkSpeed()+_tolerance))] == 0);
	}
	
	public boolean leftWall() {
		return (Config.get().worldMap()[(int)Config.get().position().x][(int)(Config.get().position().y - (Config.get().direction().y * Config.get().walkSpeed()+_tolerance))] == 0);
	}
	
	public int verticalCheck() {
		if(!southWall() || !northWall())
			return 0;
		else return 1;
	}
	
	public int horizontalCheck() {
		if(!leftWall() || !rightWall())
			return 0;
		else return 1;
	}
}
