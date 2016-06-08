package edu.apcs.wolf.config;

import processing.core.PVector;

/**
 * A class to live data/variables that get changed constantly.
 * Just trying to keep random variables out of the main class
 * @author Manpreet Singh
 */
public class LiveData {
	
	private static LiveData instance;
	
	/**
	 * Static Access to live data
	 * @return
	 */
	public static LiveData get() {
		if(instance == null)
			instance = new LiveData();
		return instance;
	}
	
	public float wallDistance;
	
	public float sideDistX, sideDistY;
	
	public PVector rayPos, rayDir;
	
	public float scaleX, scaleY;
	
	public float deltaDistX, deltaDistY;
	
	public int mapX, mapY;
}
