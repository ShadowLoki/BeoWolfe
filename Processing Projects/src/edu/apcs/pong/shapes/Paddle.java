package edu.apcs.pong.shapes;

import edu.apcs.pong.config.Config;
import processing.core.PVector;

public class Paddle extends Shape{
		
	public Paddle(){
		super("Paddle", new PVector(0,Config.get().getDEF_PAD_Y()));
	}
	
	public Paddle(String name, float x, float y, float width, float height) {
		super(name, new PVector(x, y));
		
	}
}
