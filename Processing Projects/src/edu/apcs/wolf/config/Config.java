package edu.apcs.wolf.config;

import processing.core.PVector;

public class Config {
	private static Config instance;
	
	public static Config get() {
		if(instance == null)
			instance = new Config();
		return instance;
	}
	
	private final int[][] WORLD_MAP = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		    {1,2,0,2,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,2,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,3,3,2,2,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,3,3,3,3,3,3,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,3,3,3,3,3,3,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,0,0,2,0,0,3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	
	//Contants
	private final int GAME_WIDTH 	= 400;
	private final int GAME_HEIGHT 	= 400;
	
	private final float WALK_SPEED = 0.005f;
	private final float TURN_SPEED = 0.025f;
	
	private final float FOV = 0.6f;
	
	//Dynamic data
	private PVector _position;
	private PVector _direction;
	private PVector _right;
	
	private int _line_weight;
	
	
	
	public Config() {
		_position 	= new PVector(4, 4);
		_direction 	= new PVector(0, 1);
		_right 		= new PVector(1, 0);
		
		_line_weight = 1;
	}
	
	public int[][] worldMap() {
		return WORLD_MAP;
	}
	
	public int gameWidth() {
		return GAME_WIDTH;
	}
	
	public int gameHeight() {
		return GAME_HEIGHT;
	}
	
	public float walkSpeed() {
		return WALK_SPEED;
	}
	
	public float turnSpeed() {
		return TURN_SPEED;
	}

	public PVector position() {
		return _position;
	}
	
	public PVector direction() {
		return _direction;
	}
	
	public PVector right() {
		return _right;
	}
	
	public int lineWeight() {
		return _line_weight;
	}
	
	public void incrementLineWeight(int weight) {
		if(weight < 0)
			_line_weight -= weight;
		else
			_line_weight += weight;
	}
	
	public void setLineWeight(int weight) {
		_line_weight = weight;
	}

	public float fov() {
		return FOV;
	}

}
