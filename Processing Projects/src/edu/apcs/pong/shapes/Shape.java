package edu.apcs.pong.shapes;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Shape {
	
	private String name;
	private PVector pos;
	
	private PApplet p;
	
	public Shape(PApplet p, String name, PVector pos) {
		this.name = name;
		this.pos = pos;
		this.p = p;
	}
	
	public PVector getPos() {
		return pos;
	}
	
	public void move(float x, float y){
		this.pos.set(x, y);
	}
	
	public abstract void draw();
	
	public String toString() {
		return name + " " + "xPos= " + pos.x + " yPos= " + pos.y;
	}
}
