package pong.shapes;

import processing.core.PVector;

public class Ball extends Shape{
	
	private float radius;
	
	public Ball(String name, float x, float y, float radius){
		super(name, new PVector(x, y));
		this.radius = radius;
	}
	
	public float radius() {
		return radius;
	}
}
