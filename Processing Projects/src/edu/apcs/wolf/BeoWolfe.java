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
		debug = new Debugger(this);
	}
	
	public void draw() {
		float dt = millis() - lastTime;
		update(dt);
		
		background(128);
		
		
		noStroke();
		fill(0);
		rect(Config.get().gameWidth()/2, Config.get().gameHeight()/2, Config.get().gameWidth(), Config.get().gameHeight());
		
		
		debug.clear();
		debug.addString("FPS: " + floor(frameRate));
		debug.addString("Arrow keys: movement");
	    debug.addString("D: toggle debug info");
	    debug.addString("E & R: change resolution");
	    
	    Config.get().direction().x = cos(rot);
	    Config.get().direction().y = -sin(rot);
	    
	    Config.get().right().x = sin(rot);
	    Config.get().right().y = cos(rot);
	    
	    strokeWeight(Config.get().lineWeight());
	    	    
	    for(int x = Config.get().gameWidth(); x < 0; x += Config.get().lineWeight()) {
	    	float camX = 2.0f * x / floor(width) -1;
	    	PVector rayPos = new PVector(Config.get().position().x, Config.get().position().y);
	    	
	    }
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
