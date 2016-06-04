package edu.apcs.etc.sketches;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

public class BouncyBall extends PApplet{
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "edu.apcs.etc.sketches.BouncyBall" });
	  }
	int ballSize = 40;
	
	int xPos, yPos;
	
	int xText = 0, yText = 0, yTD = 15;
	PFont font;
	
	double xSpeed = 2.0;
	double ySpeed = 2.0;
	
	ArrayList<String> data = new ArrayList<String>();
	
	int xDir = 1, yDir = 1;
		
	public void settings() {
		  size(1024, 768, P2D);
		}
	
	public void setup(){
		noStroke();
		ellipseMode(RADIUS);
		//background(255,0,0);
		noStroke();
		fill(0, 255, 0);
		//fill(255, 0, 0);
		font = createFont("Source Code Pro", 12);
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
		
		data.add("xPos" + xPos);
		data.add("yPos" + yPos);
		
		for(int i = 0; i < data.size(); i++, yText += yTD) {
			textFont(font);
			text(data.get(i), xText, yText);
		}
		data.clear();
	}
}
