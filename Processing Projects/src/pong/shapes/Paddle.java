package pong.shapes;

import processing.core.PVector;

public class Paddle implements Shapes{
	
	private PVector currentPosition;
	
	@Override
	public void move(PVector pos) {
		this.currentPosition = pos;		
	}

	@Override
	public PVector getPosition() {
		return currentPosition;
	}
	
}
