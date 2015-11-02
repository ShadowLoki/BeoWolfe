package pong.config;

public class DevConfig implements Config{
	private static final int PADDLE_WIDTH = 25;
	private static final int PADDLE_HEIGHT = 100;
	
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 600;
	
	private static final float BALL_RADIUS = 10.f;
	
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
}
