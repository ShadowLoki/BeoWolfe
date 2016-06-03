package edu.apcs.wolf.physics;

import edu.apcs.wolf.config.Config;
import processing.core.PApplet;



public class Walls {	
	
	private float _dx;
	private float _dy;
		
	public void detectWalls(float wallDist) {
			
			_dx = PApplet.sin(Config.get().direction().x) * wallDist;
			_dy = PApplet.cos(Config.get().direction().y) * wallDist;
			
			if(Config.get().worldMap()[(int)(Config.get().position().x + _dx)][(int)Config.get().position().y] > 0)
				Config.get().setPosition(Config.get().position().x - _dx, Config.get().position().y);
//				Config.get().position().add(Config.get().position().x + _dx, Config.get().position().y);
			
			if(Config.get().worldMap()[(int)(Config.get().position().x)][(int)(Config.get().position().y + _dy)] > 0)
				Config.get().setPosition(Config.get().position().x, Config.get().position().y - _dy);
//				Config.get().position().add(Config.get().position().x, Config.get().position().y + _dy);
		
	}
}
