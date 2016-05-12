package edu.apcs.pong;

import processing.core.PApplet;

import javax.swing.SwingUtilities;

import edu.apcs.control.ControlWindow;
import edu.apcs.pong.config.*;

public class PongMain extends PApplet{
	
	//Game objects
//	private Paddle human = new Paddle(Config.get().getPADDLE_WIDTH()/2 ,Config.get().getDEF_PAD_Y());
		
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "edu.apcs.pong.PongMain" });
	}
	
	public void settings(){
		size(Config.get().getGAME_WIDTH(), Config.get().getGAME_HEIGHT(), P2D);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ControlWindow().setVisible(true);
			}
		});
	}
	
	public void setup(){
		smooth();
		noStroke();
		//fill(255,0,0);
//		System.out.println(human.toString());
	}
	 
	public void draw(){
		background(20);
		fill(50);
//		drawShape(human);;
		ellipse(width/2, height/2, 200, 200);
		rect(width/2 - 100, height/2 - 100, 100,100);
	}
}
