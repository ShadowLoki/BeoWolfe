package edu.apcs.pong.shapes;

import edu.apcs.pong.config.Config;
import processing.core.PApplet;
import processing.core.PVector;

public class Paddle extends Shape{
	
	public Paddle(PApplet p){
		super(p, "Paddle", new PVector(0,Config.get().getDEF_PAD_Y()));
	}
	
	public Paddle(PApplet p,String name, float x, float y, float width, float height) {
		super(p, name, new PVector(x, y));
		
	}

	@Override
	public void draw() {
		
	}
}
