package sketches;

import processing.core.PApplet;

public class P3DTest extends PApplet{
	public static void main(String[] args) {
		PApplet.main(new String[] {"--present", "sketches.P3DTest"});
	}
	
	float x,y,z;
	
	public void settings() {
		  size(200, 200, P3D);
	}
	
	public void setup() {
		x = width/2;
		y = height/2;
		z = 0;
		
		background(100);
		fill(51);
		stroke(255);
	}
	
	public void draw() {
	}
}
