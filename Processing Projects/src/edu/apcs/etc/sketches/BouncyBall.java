package edu.apcs.etc.sketches;

import processing.core.PApplet;

public class BouncyBall extends PApplet{
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "edu.apcs.etc.sketches.BouncyBall" });
	  }
	int ballSize = 40;
	
	int xPos, yPos;
	
	double xSpeed = 2.0;
	double ySpeed = 2.0;
	
	int xDir = 1, yDir = 1;
		
	public void settings() {
		  size(1024, 768, P3D);
		}
	
	public void setup(){
		noStroke();
		ellipseMode(RADIUS);
		//background(255,0,0);
		noStroke();
		fill(0, 255, 0);
		//fill(255, 0, 0);
		
		xPos = width/2;
		yPos = height/2;
	}
	
	public void draw(){
		background(0);
		
		xPos = xPos + (int)(xSpeed * xDir);
		yPos = yPos + (int)(ySpeed * yDir); 
		
		if(xPos > width-ballSize || xPos < ballSize){
			xDir *= -1;
		}
		if(yPos > width-ballSize || yPos < ballSize){
			yDir *= -1;
		}
		
		ellipse(xPos, yPos, ballSize, ballSize);
	}
}
