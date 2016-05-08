package edu.apcs.pong;

import processing.core.PApplet;
import edu.apcs.pong.config.*;
import edu.apcs.pong.shapes.Ball;
import edu.apcs.pong.shapes.Paddle;

public class PongMain extends PApplet{
	
	//Game objects
//	private Paddle human = new Paddle(Config.get().getPADDLE_WIDTH()/2 ,Config.get().getDEF_PAD_Y());
		
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "pong.PongMain" });
	}
	
	public void settings(){
		size(Config.get().getGAME_WIDTH(), Config.get().getGAME_HEIGHT());
	}
	
	public void setup(){
		smooth();
		noStroke();
		//fill(255,0,0);
//		System.out.println(human.toString());
	}
	 
	public void draw(){
		background(0);
		fill(255);
//		drawShape(human);
	}
	
	/**
	 * TODO FIX this
	 */
//	public void keyPressed(){
//		if(key == 'w')
//			human.move(human.getPos().x, human.getPos().y - Config.get().getIncrement());
//		else if(key == 's')
//			human.move(human.getPos().x, human.getPos().y + Config.get().getIncrement());
//	}
	
	public void drawShape(Paddle paddle) {
		rect(paddle.getPos().x, paddle.getPos().y, Config.get().getPADDLE_WIDTH(), Config.get().getPADDLE_HEIGHT());
	}
	
	public void drawShape(Ball ball) {
		ellipse(ball.getPos().x, ball.getPos().y, ball.radius(), ball.radius());
	}
	
	public void drawField() {
		
	}
}
