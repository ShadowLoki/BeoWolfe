package edu.apcs.wolf.debug;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

public class Debugger {
	
	private PApplet _p;
	private ArrayList<String> _data;
	private PFont _font;
	private int _fontSize;
	private boolean _isOn;
	
	private int y;
	
	public Debugger(PApplet p) {
		this._p = p;
		_data = new ArrayList<String>();
		_isOn = true;
		_fontSize = 12;
		_font = p.createFont("Source Code Pro", _fontSize);
	}
	
	public void addString(String s) {
		if(_isOn)
			_data.add(s);
	}
	
	public void clearData() {
		_data.clear();
	}
	
	public void toggle() {
		_isOn = !_isOn;
	}
	
	public void draw() {
		if(_isOn) {
			y = 20;
			_p.fill(255);
			for (int i = 0; i < _data.size(); i++, y += _fontSize) {
				_p.textFont(_font);
				_p.text((String)(_data.get(i)), 0, y);
			}
		}
	}

}
