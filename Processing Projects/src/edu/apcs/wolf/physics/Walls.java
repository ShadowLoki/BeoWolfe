package edu.apcs.wolf.physics;

import edu.apcs.wolf.config.Config;

public class Walls {
	public boolean southWall() {
		return (Config.get().worldMap()[(int)(Config.get().position().x - (Config.get().direction().x * Config.get().walkSpeed()+1))][(int)Config.get().position().y] == 0);
	}
	
	public boolean northWall() {
		return (Config.get().worldMap()[(int)(Config.get().position().x + (Config.get().direction().x * Config.get().walkSpeed()+1))][(int)Config.get().position().y] == 0);
		}
	
	public boolean rightWall() {
		return (Config.get().worldMap()[(int)Config.get().position().x][(int)(Config.get().position().y + (Config.get().direction().y * Config.get().walkSpeed()+1))] == 0);
	}
	
	public boolean leftWall() {
		return (Config.get().worldMap()[(int)Config.get().position().x][(int)(Config.get().position().y - (Config.get().direction().y * Config.get().walkSpeed()+1))] == 0);
	}
}
