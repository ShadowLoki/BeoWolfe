package edu.apcs.wolf.physics;

import edu.apcs.wolf.config.Config;

public class Walls {	
	private boolean touchingWall() {
		return !(Config.get().worldMap()[(int)Config.get().position().x][(int)Config.get().position().y] == 0);
	}
	
	public void takeAction() {
		if(touchingWall()) {
			//TODO: What happens when we touch a wall
		}
	}
}
