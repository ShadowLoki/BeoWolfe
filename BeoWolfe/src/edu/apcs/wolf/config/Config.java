package edu.apcs.wolf.config;

import java.awt.Toolkit;

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
		    {1,2,0,2,0,0,0,0,3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,0,2,0,0,0,3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,2,0,2,2,2,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
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
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,3,0,0,0,0,0,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,3,0,0,0,0,0,0,1},
		    {1,0,0,0,2,3,0,0,0,0,0,0,0,0,0,0,3,3,0,0,0,0,0,0,0,1},
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
	private final int CANVAS_WIDTH 	= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 40;
	private final int CANVAS_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 70;
	
	private final float WALK_SPEED = 0.003f;
	private final float TURN_SPEED = 0.02f;
	
	private final float FOV = 0.6f;
	
	//Dynamic data
	private PVector _position;
	private PVector _direction;
	private PVector _right;
	
	private int _game_height;
	private int _game_width;
	
	private int _line_weight;
	
	
	
	public Config() {
		_position 	= new PVector(4, 4);
		_direction 	= new PVector(0, 1);
		_right 		= new PVector(1, 0);
		
		_game_height = CANVAS_HEIGHT;
		_game_width = CANVAS_WIDTH;
		
		_line_weight = 1;
	}
	
	public int[][] worldMap() {
		return WORLD_MAP;
	}
	
	public int canvasWidth() {
		return CANVAS_WIDTH;
	}
	
	public int canvasHeight() {
		return CANVAS_HEIGHT;
	}
	
	public float walkSpeed() {
		return WALK_SPEED;
	}
	
	public float turnSpeed() {
		return TURN_SPEED;
	}

	public float fov() {
		return FOV;
	}
	
	public PVector position() {
		return _position;
	}
	
	public void setPosition(float x, float y) {
		_position.set(x, y);
	}
	
	public PVector direction() {
		return _direction;
	}
	
	public void setDirection(float x, float y) {
		_direction.set(x, y);
	}
	
	public PVector right() {
		return _right;
	}
	
	public void setRight(float x, float y) {
		_right.set(x, y);
	}
	
	public int lineWeight() {
		return _line_weight;
	}
	
	public int gameHeight() {
		return _game_height;
	}
	
	public void changeGameHeight(int increment) {
		_game_height += increment;
	}
	
	public int gameWidth() {
		return _game_width;
	}
	
	public void changeGameWidth(int increment) {
		_game_width += increment;
	}
	
	public void incrementLineWeight(int weight) {
		_line_weight += weight;
	}
	
	public void setLineWeight(int weight) {
		_line_weight = weight;
	}
}
