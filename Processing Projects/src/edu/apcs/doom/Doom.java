package edu.apcs.doom;

import processing.core.PApplet;

public class Doom extends PApplet{
	public static void main(String[] args) {
		PApplet.main(new String[] {"--present", "edu.apcs.doom.Doom"});
	}
	
	public void settings() {
		size(400, 400, P2D);
	}
	
	public void setup() {
		strokeCap(PROJECT);
	}
	
	public void draw() {
	}
}
