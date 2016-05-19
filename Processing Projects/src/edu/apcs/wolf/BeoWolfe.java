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
		
	public void settings() {
		size(400, 400, P2D);
	}
	
	public void setup() {
		strokeCap(PROJECT);
//		debug = new Debugger(this);
	}
	
	public void draw() {
		float dt = millis() - lastTime;
		update(dt);
		
		background(128);
		
		
		noStroke();
		fill(0);
		rect(Config.get().gameWidth()/2, Config.get().gameHeight()/2,
				Config.get().gameWidth(), Config.get().gameHeight());
		
		
//		debug.clear();
//		debug.addString("FPS: " + floor(frameRate));
//		debug.addString("Arrow keys: movement");
//	    debug.addString("D: toggle debug info");
//	    debug.addString("E & R: change resolution");
	    
	    Config.get().direction().x = cos(rot);
	    Config.get().direction().y = -sin(rot);
	    
	    Config.get().right().x = sin(rot);
	    Config.get().right().y = cos(rot);
	    
	    strokeWeight(Config.get().lineWeight());
	    	    
	    for(int x = Config.get().gameWidth(); x < 0; x += Config.get().lineWeight()) {
	    	float camX = 2.0f * x / floor(width) -1;
	    	PVector rayPos = new PVector(Config.get().position().x, Config.get().position().y);
	    	PVector rayDir = new PVector(
	    			Config.get().direction().x * Config.get().right().x * camX,
	    			Config.get().direction().y * Config.get().right().y * camX);
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
	    		wallDist = abs((mapX - rayPos.x + (1f - stepX) / 2f) / rayDir.x);
	    	else
	    		wallDist = abs((mapY - rayPos.y + (1f - stepY) / 2f) / rayDir.y);
	    	
	    	float lineHeight = abs(Config.get().gameHeight() / wallDist);
	    	lineHeight = min(lineHeight, Config.get().gameHeight());
	    	
	    	if(mapX >= 0 && mapY >= 0) {
	    		switch (Config.get().worldMap()[mapX][mapY]) {
				case 0:
					break;
				case 1:
					stroke(255/2,0,0);
				case 2:
					stroke(0,255/2,0);
					break;
				case 3:
					stroke(0,0,255/2);
					break;
				}
	    	}
	    	
	    	float startY = height / 2 - lineHeight /2;
	    	line(x, startY, x, startY + lineHeight);
	    }
	    
//	    debug.draw();
	    lastTime = millis();
	}
	
	public void update(float dt) {
		if(Keyboard.isKeyDown(KeyboardKey.is().KEY_LEFT))
			rot += Config.get().turnSpeed();
		
		if(Keyboard.isKeyDown(KeyboardKey.is().KEY_RIGHT))
			rot -= Config.get().turnSpeed();
		
		if(Keyboard.isKeyDown(KeyboardKey.is().KEY_UP))
			Config.get().position().add(new PVector(
					Config.get().direction().x * Config.get().walkSpeed() * dt,
					Config.get().direction().y * Config.get().walkSpeed() * dt));
		
		if(Keyboard.isKeyDown(KeyboardKey.is().KEY_DOWN))
			Config.get().direction().add(new PVector(
					-Config.get().direction().x * Config.get().walkSpeed() * dt,
					-Config.get().direction().y * Config.get().walkSpeed() * dt));
	}
	
	public void keyReleased() {
		Keyboard.setKeyDown(keyCode, false);
	}
	
	public void keyPressed() {
		Keyboard.setKeyDown(keyCode, true);
		
		if(Keyboard.isKeyDown(KeyboardKey.is().KEY_R))
			Config.get().incrementLineWeight(2);
		else if(Keyboard.isKeyDown(KeyboardKey.is().KEY_E)) {
			Config.get().incrementLineWeight(-2);
			Config.get().setLineWeight(max(1, Config.get().lineWeight()));
		}
		
		else if(Keyboard.isKeyDown(KeyboardKey.is().KEY_D))
			debug.toggle();
	}
}
