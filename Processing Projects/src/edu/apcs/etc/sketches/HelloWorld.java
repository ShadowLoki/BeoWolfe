/*
 * Temporary file to make sure that processing works with java.
 */
package edu.apcs.etc.sketches;

import processing.core.PApplet;

public class HelloWorld extends PApplet{
	
	float posY = 650/2;
	float posX = (650/2) - (375);
	int speed = 3;
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "edu.apcs.etc.sketches.HelloWorld" });
	  }
	
	public void settings() {
		  size(650, 650);
		}
	
	public void setup(){
	}
	
	public void draw(){
		background(0);
//		if(mousePressed){
//			fill(0);
//		} else {
//			fill(random(0, 255), random(0, 255), random(0, 255));;
//		}
//		
//		ellipse(mouseX, mouseY, random(10,80), random(10,80));
		
		fill(255,0,0);
		rect(posX ,posY,100,50);
	}
	
	public void keyPressed(){
//		if (key == CODED) {
//		    if (keyCode == UP) 
//		      posY = (float) (posY - speed);
//		    else if (keyCode == DOWN) 
//		    	posY = (float) (posY + speed);
//		    else if(keyCode == LEFT)
//		    	posX = (float)(posX - speed);
//		    else if(keyCode == RIGHT)
//		    	posX = (float)(posX + speed);
		if (key == 'a')
			posX = (float)(posX - speed);
		else if(key == 'd')
			posX = (float)(posX + speed);
		else if(key == 'j')
			posY = (float)(posY + speed);
		else if(key == 'l')
			posY = (float)(posY - speed);
	    else if(key == 'w')
	    	speed++;
	    else if(key == 's')
	    	speed--;
		//} 
	}
}
