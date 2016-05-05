package pong.config;

public abstract class Config {
	
	private static Config instance;
	public static Config get(){
		if(instance == null)
			instance = new DevConfig();
		return instance;
	}
	
	public abstract int getPADDLE_HEIGHT();
	
	public abstract int getPADDLE_WIDTH();
	
	public abstract int getGAME_WIDTH();
	
	public abstract int getGAME_HEIGHT();
	
	public abstract float getBALL_RADIUS();
	
	public abstract float getDEF_PAD_Y();
	
	public abstract double getIncrement();
}
