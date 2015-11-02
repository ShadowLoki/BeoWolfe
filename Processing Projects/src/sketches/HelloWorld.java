/*
 * Temporary file to make sure that processing works with java.
 */
package sketches;

import processing.core.PApplet;

public class HelloWorld extends PApplet{
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "sketches.HelloWorld" });
	  }
	
	public void settings() {
		  size(650, 650);
		}
	
	public void setup(){
	}
	
	public void draw(){
		if(mousePressed){
			fill(0);
		} else {
			fill(255);
		}
		
		ellipse(mouseX, mouseY, 80, 80);
	}
}
