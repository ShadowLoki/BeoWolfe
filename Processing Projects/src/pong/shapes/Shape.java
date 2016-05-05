package pong.shapes;

import processing.core.PVector;

public class Shape {
	
	String name;
	PVector pos;
	
	public Shape(String name, PVector pos) {
		this.name = name;
		this.pos = pos;
	}
	
	public PVector getPos() {
		return pos;
	}
	
	public void move(float x, float y){
		this.pos.set(x, y);
	}
	
	public String toString() {
		return name + " " + "xPos= " + pos.x + " yPos= " + pos.y;
	}
}
