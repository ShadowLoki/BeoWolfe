package edu.apcs.etc.sketches;

import processing.core.PApplet;

public class Stuff3D extends PApplet{
	public static void main(String[] args) {
		PApplet.main(new String[] {"--present", "edu.apcs.etc.sketches.Stuff3D"});
	}
	
	public void setting() {
		size(640, 480, P3D);
	}
	
	public void setup() {
		noFill();
		smooth();
	}
	
	public void draw() {
		background(20);
	}
}
