package edu.apcs.pong.shapes;

import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Shape{
	
	private float radius;
	
	public Ball(PApplet p,String name, float x, float y, float radius){
		super(p, name, new PVector(x, y));
		this.radius = radius;
	}
	
	public float radius() {
		return radius;
	}

	@Override
	public void draw() {
	}
}
