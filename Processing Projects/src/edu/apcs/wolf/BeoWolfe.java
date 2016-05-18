package edu.apcs.wolf;

import edu.apcs.wolf.config.KeyboardKey;
import edu.apcs.wolf.config.Config;

import processing.core.PApplet;

public class BeoWolfe extends PApplet{
	public static void main(String[] args) {
		PApplet.main(new String[] {"--present", "edu.apcs.wolf.BeoWolfe"});
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
