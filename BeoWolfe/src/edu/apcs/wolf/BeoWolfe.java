package edu.apcs.wolf;

import edu.apcs.wolf.config.Config;
import edu.apcs.wolf.config.Config.State;
import edu.apcs.wolf.config.LiveData;
import edu.apcs.wolf.debug.Debugger;
import edu.apcs.wolf.keyboard.Keyboard;
import edu.apcs.wolf.keyboard.KeyboardKey;
import edu.apcs.wolf.physics.Walls;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Raycaster made using Java and PApplet(Processing)
 * @author Manpreet Singh 2016
 * @see <a href="http://www.openprocessing.org/user/36804">Andor Salga</a>
 * @see <a href="http://lodev.org/cgtutor/raycasting.html">Lode's Computer Graphics Tutorial</a>
 *
 */
public class BeoWolfe extends PApplet{
	public static void main(String[] args) {
		System.out.println();
		PApplet.main("edu.apcs.wolf.BeoWolfe");
	}
	
	float lastTime;
	float rot = 0.0f;
	Debugger debug;
	float camX;
	
	Walls walls = new Walls();
	
	public void settings() {
		size(Config.get().canvasWidth(), Config.get().canvasHeight(), P2D);
	}
	
	public void setup() {
		strokeCap(PROJECT);
		debug = new Debugger(this);
		debug.addString("Hello World");
		lastTime = 0f;
		LiveData.get().gameState = State.PAUSE;
	}
	
	public void draw() {
		update(millis() - lastTime);
		
		background(128);
		textFont(createFont("Source Code Pro", 25));
		fill(255);
		if(LiveData.get().gameState == State.PAUSE){
			text("PAUSED", width/2, height/2);
			System.out.println("PAUSED");
		}
		noStroke();
		
		
		if(LiveData.get().gameState == State.RUN) {
			
			fill(0);
			
			rect(	width/2 - Config.get().gameWidth()/2, 	//X position of game background
					height/2 - Config.get().gameHeight()/2, //Y Position of game background
					Config.get().gameWidth(), Config.get().gameHeight()); //width/height of game background
			
			debug.clearData();
			debug.addString("FPS: " + floor(frameRate));
			debug.addString("Arrow keys: movement");
		    debug.addString("D: toggle debug info");
		    debug.addString("Q & W: change dimensions");
		    debug.addString("E & R: change resolution");
		    	    
		    Config.get().setDirection(cos(rot), -sin(rot));
		    
		    Config.get().setRight(sin(rot), cos(rot));
		    
		    strokeWeight(Config.get().lineWeight());
		    
		    int startX = width/2 - Config.get().gameWidth()/2;
		    
		    for(int x = startX; x < width - startX; x += Config.get().lineWeight()) {
		    	camX = 2.0f * x / width - 1;
		    	LiveData.get().rayPos = new PVector(Config.get().position().x, Config.get().position().y);
		    	 LiveData.get().rayDir = new PVector(
		    			Config.get().direction().x + Config.get().right().x * camX,
		    			Config.get().direction().y + Config.get().right().y * camX);
		    	
		    	LiveData.get().mapX = (int)LiveData.get().rayPos.x;
		    	LiveData.get().mapY = (int)LiveData.get().rayPos.y;
		    		    	
		    	LiveData.get().scaleX = 1.0f / LiveData.get().rayDir.x;
		    	LiveData.get().scaleY = 1.0f / LiveData.get().rayDir.y;
		    	
		    	LiveData.get().deltaDistX = (new PVector(1, LiveData.get().rayDir.y * LiveData.get().scaleX)).mag();
		    	LiveData.get().deltaDistY = (new PVector(1, LiveData.get().rayDir.x * LiveData.get().scaleY)).mag();
		    	
	//	    	LiveData.get().wallDistance;
		    	
		    	int stepX, 
		    		stepY,
		    		hit = 0,
		    		side = 0;
		    	
		    	if(LiveData.get().rayDir.x < 0) {
		    		stepX = -1;
		    		LiveData.get().sideDistX = (LiveData.get().rayPos.x - LiveData.get().mapX) * LiveData.get().deltaDistX;
		    	}
		    	else {
		    		stepX = 1;
		    		LiveData.get().sideDistX = (LiveData.get().mapX + 1.0f - LiveData.get().rayPos.x) * LiveData.get().deltaDistX;
		    	}
		    	
		    	if(LiveData.get().rayDir.y < 0) {
		    		stepY = -1;
		    		LiveData.get().sideDistY = (LiveData.get().rayPos.y - LiveData.get().mapY) * LiveData.get().deltaDistY;
		    	}
		    	else {
		    		stepY = 1;
		    		LiveData.get().sideDistY = (LiveData.get().mapY + 1.0f - LiveData.get().rayPos.y) * LiveData.get().deltaDistY;
		    	}
		    	
		    	while (hit == 0) {
		    		if (LiveData.get().sideDistX < LiveData.get().sideDistY) {
		                LiveData.get().sideDistX += LiveData.get().deltaDistX;
		                LiveData.get().mapX += stepX;
		                side = 0;
		            } 
		    		else {
		                LiveData.get().sideDistY += LiveData.get().deltaDistY;
		                LiveData.get().mapY += stepY;
		                side = 1;
		            }
		    		
		            if (Config.get().worldMap()[LiveData.get().mapX][LiveData.get().mapY] > 0) {
		                hit = 1;
		            }
		    	}
		    	
		    	if(side == 0)
		    		LiveData.get().wallDistance = abs((LiveData.get().mapX - LiveData.get().rayPos.x + (1.0f - stepX) / 2.0f) / LiveData.get().rayDir.x);
		    	else
		    		LiveData.get().wallDistance = abs((LiveData.get().mapY - LiveData.get().rayPos.y + (1.0f - stepY) / 2.0f) / LiveData.get().rayDir.y);
		    		    	
		    	float lineHeight = abs(Config.get().gameHeight() / LiveData.get().wallDistance);
		    	lineHeight = min(lineHeight, Config.get().gameHeight());
		    	
		    	if(LiveData.get().mapX >= 0 && LiveData.get().mapY >= 0) {
		    		switch (Config.get().worldMap()[LiveData.get().mapX][LiveData.get().mapY]) {
					case 0:
						break;
					case 1:
						stroke(255,0,0);
					case 2:
						stroke(0,255,0);
						break;
					case 3:
						stroke(0,0,255);
						break;
					}
		    	}
		    	
		    	if(side == 1) {
		    		switch (Config.get().worldMap()[LiveData.get().mapX][LiveData.get().mapY]) {
					case 1:
						stroke(255/2, 0 ,0);
						break;
					case 2:
						stroke(0, 255/2, 0);
						break;
					case 3:
						stroke(0, 0, 255/2);
					}
		    	}
		    	
		    	float startY = height / 2 - lineHeight /2;
		    	line(x, startY, x, startY + lineHeight);
		    	
		    	
		    }
		    debug.addString("Wall Distance: " + LiveData.get().wallDistance);
		    debug.addString("Down Key: " + Keyboard.isKeyDown(KeyboardKey.get().KEY_DOWN));
		    
		    debug.addString("South Wall: " + walls.southWall());
		    debug.addString("North Wall: " + walls.northWall());
		    debug.addString("Right Wall: " + walls.rightWall());
		    debug.addString("Left Wall: " + walls.leftWall());
		    
		    debug.draw();
		}
	    lastTime = millis();
	}
	
	public void update(float dt) {
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_LEFT))
			rot += Config.get().turnSpeed();
			
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_RIGHT))
			rot -= Config.get().turnSpeed();
		
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_UP)) 
			Config.get().position().add(new PVector(
					Config.get().direction().x * Config.get().walkSpeed() * dt * walls.verticalCheck(),
					Config.get().direction().y * Config.get().walkSpeed() * dt * walls.horizontalCheck()));
		
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_DOWN))
			Config.get().position().add(new PVector(
					-Config.get().direction().x * Config.get().walkSpeed() * dt * walls.verticalCheck(),
					-Config.get().direction().y * Config.get().walkSpeed() * dt * walls.horizontalCheck()));
	}
	
	public void keyReleased() {
		Keyboard.setKeyDown(keyCode, false);
	}
	
	public void keyPressed() {
		Keyboard.setKeyDown(keyCode, true);
		
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_SPACE)){
			Config.get().togglePause(LiveData.get().gameState);
			text("SPACE", width/2, height/2 + 50);
		}
		
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_R))
			Config.get().incrementLineWeight(2);
		
		else if(Keyboard.isKeyDown(KeyboardKey.get().KEY_E)) {
			Config.get().incrementLineWeight(-2);
			Config.get().setLineWeight(max(1, Config.get().lineWeight()));
		}
		
		else if(Keyboard.isKeyDown(KeyboardKey.get().KEY_Q)) {
			Config.get().changeGameHeight(-50);
			Config.get().changeGameWidth(-50);
		}
		
		else if(Keyboard.isKeyDown(KeyboardKey.get().KEY_W)) {
			Config.get().changeGameHeight(50);
			Config.get().changeGameWidth(50);
		}
		
		else if(Keyboard.isKeyDown(KeyboardKey.get().KEY_D))
			debug.toggle();
	}
}
