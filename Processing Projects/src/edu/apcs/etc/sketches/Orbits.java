package edu.apcs.etc.sketches;

import processing.core.PApplet;

public class Orbits extends PApplet{
	public static void main(String[] args) {
		PApplet.main(new String[] {"--present", "edu.apcs.etc.sketches.Orbits"});
	}
		
	private float posX, posY;
	private float radiusX, radiusY;
	private float theta;
	
	private float delta;
	
	private int defTextSize = 20;
	private int defTextX = -400;
	
	public void settings() {
		size(850,850);
	}
	
	public void setup() {	
		
		posX = 0;
		posY = radiusY * sin((float).02);
		
		radiusX = 50;
		radiusY = 150;
		
		delta = 0;
		
		theta = (float) 0.02;
	}
	
	public void draw() {
		background(0);
		
		delta = getDelta(posY);
		theta += 0.02f;
		
		posX = radiusX * cos(theta);
		posY = radiusY * sin(theta);
		
		translate(width/2, height/2);
		fill(255);
		ellipse(posX, posY, 10, 10);
		fill(255, 0, 0);
		ellipse(0, 0, 15, 15);
		
		textSize(defTextSize);
		text("theta=" + theta, defTextX, -350);
		
		fill(255,255,255);
		text("posX=" + posX, defTextX, -330);
		
		fill(0,171,255);
		text("posY=" + posY, defTextX, -310);
		
		fill(255,51,255);
		text("delta=" + delta, defTextX, -290);
	}
	
	public float calculateDelta(float posY){
		return (float)(-(1/1000000)*Math.pow(posY, 2)+.02);
	}
	
	public float getDelta(float foo) {
		return (float)(-(Math.pow(foo, 2)/750000)+(99/100));
	}
	
}
