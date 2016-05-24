package edu.apcs.wolf;

import edu.apcs.wolf.config.Config;
import edu.apcs.wolf.debug.Debugger;
import edu.apcs.wolf.keyboard.Keyboard;
import edu.apcs.wolf.keyboard.KeyboardKey;

import processing.core.PApplet;
import processing.core.PVector;

public class BeoWolfe extends PApplet{
	public static void main(String[] args) {
		PApplet.main(new String[] {"--present", "edu.apcs.wolf.BeoWolfe"});
	}
	
	float lastTime;
	float rot = 0.0f;
	Debugger debug;
	float camX;
	public void settings() {
		size(Config.get().canvasWidth(), Config.get().canvasHeight(), P2D);
	}
	
	public void setup() {
		strokeCap(PROJECT);
		debug = new Debugger(this);
		debug.addString("Hello World");
		lastTime = 0f;
	}
	
	public void draw() {
		update(millis() - lastTime);
		
		background(128);
		
		noStroke();
		fill(0);
		
		rect(	width/2 - Config.get().gameWidth()/2, 	//X position of game background
				height/2 - Config.get().gameHeight()/2, //Y Position of game background
				Config.get().gameWidth(), Config.get().gameHeight()); //width/height of game background
		
		debug.clearData();
		debug.addString("FPS: " + floor(frameRate));
		debug.addString("Arrow keys: movement");
	    debug.addString("D: toggle debug info");
	    debug.addString("E & R: change resolution");
	    
	    debug.addString("PosX: " + Config.get().position().x);
	    debug.addString("posY: " + Config.get().position().y);
	    
	    debug.addString("dirX: " + Config.get().direction().x);
	    debug.addString("dirY: " + Config.get().direction().y);
	    
	    debug.addString("rightX: " + Config.get().right().x);
	    debug.addString("rightY: " + Config.get().right().y);
	    debug.addString("camX : " + camX);
	    
	    Config.get().setDirection(cos(rot), -sin(rot));
	    
	    Config.get().setRight(sin(rot), cos(rot));
	    
	    strokeWeight(Config.get().lineWeight());
	    
	    int startX = width/2 - Config.get().gameWidth()/2;
	    
	    for(int x = startX; x < width - startX; x += Config.get().lineWeight()) {
	    	camX = 2.0f * x / width - 1;
	    	PVector rayPos = new PVector(Config.get().position().x, Config.get().position().y);
	    	PVector rayDir = new PVector(
	    			Config.get().direction().x + Config.get().right().x * camX,
	    			Config.get().direction().y + Config.get().right().y * camX);
	    	
	    	int mapX = (int)rayPos.x;
	    	int mapY = (int)rayPos.y;
	    	
	    	float sideDistX, sideDistY;
	    	
	    	float scaleX = 1.0f / rayDir.x;
	    	float scaleY = 1.0f / rayDir.y;
	    	
	    	float deltaDistX = (new PVector(1, rayDir.y * scaleX)).mag();
	    	float deltaDistY = (new PVector(1, rayDir.x * scaleY)).mag();
	    	
	    	float wallDist;
	    	
	    	int stepX, 
	    		stepY,
	    		hit = 0,
	    		side = 0;
	    	
	    	if(rayDir.x < 0) {
	    		stepX = -1;
	    		sideDistX = (rayPos.x - mapX) * deltaDistX;
	    	}
	    	else {
	    		stepX = 1;
	    		sideDistX = (mapX + 1.0f - rayPos.x) * deltaDistX;
	    	}
	    	
	    	if(rayDir.y < 0) {
	    		stepY = -1;
	    		sideDistY = (rayPos.y - mapY) * deltaDistY;
	    	}
	    	else {
	    		stepY = 1;
	    		sideDistY = (mapY + 1.0f - rayPos.y) * deltaDistY;
	    	}
	    	
	    	while (hit == 0) {
	    		if (sideDistX < sideDistY) {
	                sideDistX += deltaDistX;
	                mapX += stepX;
	                side = 0;
	            } 
	    		else {
	                sideDistY += deltaDistY;
	                mapY += stepY;
	                side = 1;
	            }
	    		
	            if (Config.get().worldMap()[mapX][mapY] > 0) {
	                hit = 1;
	            }
	    	}
	    	
	    	if(side == 0)
	    		wallDist = abs((mapX - rayPos.x + (1.0f - stepX) / 2.0f) / rayDir.x);
	    	else
	    		wallDist = abs((mapY - rayPos.y + (1.0f - stepY) / 2.0f) / rayDir.y);
	    	
	    	float lineHeight = abs(Config.get().gameHeight() / wallDist);
	    	lineHeight = min(lineHeight, Config.get().gameHeight());
	    	
	    	if(mapX >= 0 && mapY >= 0) {
	    		switch (Config.get().worldMap()[mapX][mapY]) {
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
	    		switch (Config.get().worldMap()[mapX][mapY]) {
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
	    
	    debug.draw();
	    lastTime = millis();
	}
	
	public void update(float dt) {
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_LEFT))
			rot += Config.get().turnSpeed();
			
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_RIGHT))
			rot -= Config.get().turnSpeed();
		
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_UP)) 
			Config.get().position().add(new PVector(
					Config.get().direction().x * Config.get().walkSpeed() * dt,
					Config.get().direction().y * Config.get().walkSpeed() * dt));
			
		if(Keyboard.isKeyDown(KeyboardKey.get().KEY_DOWN))
			Config.get().direction().add(new PVector(
					-1 * Config.get().direction().x * Config.get().walkSpeed() * dt,
					-1 * Config.get().direction().y * Config.get().walkSpeed() * dt));
	}
	
	public void keyReleased() {
		Keyboard.setKeyDown(keyCode, false);
	}
	
	public void keyPressed() {
		Keyboard.setKeyDown(keyCode, true);
		
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
