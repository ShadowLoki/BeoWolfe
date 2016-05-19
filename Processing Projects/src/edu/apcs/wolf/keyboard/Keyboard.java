package edu.apcs.wolf.keyboard;

public class Keyboard {
	private static final int NUM_KEYS = 128;
	
	private static boolean[] lockableKeys = new boolean[NUM_KEYS];
	
	private static char[] lockedKeyPresses = new char[NUM_KEYS];
	
	private static boolean[] keys = new boolean[NUM_KEYS];
	
	public static void lockKeys(int[] keys){
		for(int k : keys)
			if(isValidKey(k))
				lockableKeys[k] = true;
	}
	
	public static void unlockKeys(int[] keys) {
		for(int k : keys)
			if(isValidKey(k))
				lockableKeys[k] = false;
	}
	
	public static void setVirtualKeyDown(int key) {
		setKeyDown(key, true);
		setKeyDown(key, false);
	}
	
	public static boolean isValidKey(int key) {
		return (key > -1 && key < NUM_KEYS);
	}
	
	public static void setKeyDown(int key, boolean state) {
		if(isValidKey(key)) {
			if(lockableKeys[key]) {
				if(state == true && lockedKeyPresses[key] == 0) {
					lockedKeyPresses[key]++;
					keys[key] = true;
				}
				
				else if(state == true && lockedKeyPresses[key] == 2) 
					lockedKeyPresses[key]++;
				
				else if(state == false && lockedKeyPresses[key] == 3) {
					lockedKeyPresses[key] = 0;
					keys[key] = false;
				}
				
			}
			else
				keys[key] = state;
		}
	}
	
	public static boolean isKeyDown(int key) {
		return keys[key];
	}
}
