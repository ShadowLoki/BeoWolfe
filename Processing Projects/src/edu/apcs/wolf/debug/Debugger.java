package edu.apcs.wolf.debug;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

public class Debugger {
	
	private PApplet p;
	private ArrayList<String> strings;
	private PFont font;
	private int fontSize;
	private boolean isOn;
	
	private int y;
	
	public Debugger(PApplet p) {
		this.p = p;
		isOn = true;
		fontSize = 15;
		font = p.createFont("Source Code Pro", fontSize);
	}
	
	public void addString(String s) {
		if(isOn)
			strings.add(s);
	}
	
	public void clear() {
		strings.clear();
	}
	
	public void toggle() {
		isOn = !isOn;
	}
	
	public void draw() {
		if(isOn) {
			y = 20;
			p.fill(255);
			for (int i = 0; i < strings.size(); i++, y += fontSize) {
				p.textFont(font);
				p.text((String)(strings.get(i)), 0, y);
			}
		}
	}

}
