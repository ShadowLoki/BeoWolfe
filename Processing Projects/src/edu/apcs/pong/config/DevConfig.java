package edu.apcs.pong.config;

public class DevConfig extends Config{
	private static final int PADDLE_WIDTH = 25;
	private static final int PADDLE_HEIGHT = 100;
	
	private static final int GAME_WIDTH = 400;
	private static final int GAME_HEIGHT = 400;
	
	private static final float BALL_RADIUS = 10.f;
	
	private static final float DEF_PAD_Y = (float)(GAME_HEIGHT / 2);
	
	private static final double INCREMENT = 10;
	
	@Override
	public int getPADDLE_HEIGHT(){
		return PADDLE_HEIGHT;
	}
	
	@Override
	public int getPADDLE_WIDTH(){
		return PADDLE_WIDTH;
	}
	
	@Override
	public int getGAME_WIDTH(){
		return  GAME_WIDTH;
	}
	
	@Override
	public int getGAME_HEIGHT(){
		return GAME_HEIGHT;
	}
	
	@Override
	public float getBALL_RADIUS(){
		return BALL_RADIUS;
	}

	@Override
	public float getDEF_PAD_Y() {
		return DEF_PAD_Y;
	}

	@Override
	public double getIncrement() {
		// TODO Auto-generated method stub
		return INCREMENT;
	}
	
}
