package edu.apcs.wolf.config;

public class KeyboardKey {
	private static KeyboardKey instance;
	public static KeyboardKey is() {
		if(instance == null)
			instance = new KeyboardKey();
		return instance;
	}
		
	public final int KEY_BACKSPACE = 8;
	public final int KEY_TAB       = 9;
	public final int KEY_ENTER     = 10;

	public final int KEY_SHIFT	= 16;
	public final int KEY_CTRL	= 17;
	public final int KEY_ALT	= 18;

	public final int KEY_CAPS	= 20;
	public final int KEY_ESC	= 27;

	public final int KEY_SPACE  = 32;
	public final int KEY_PGUP   = 33;
	public final int KEY_PGDN   = 34;
	public final int KEY_END    = 35;
	public final int KEY_HOME   = 36;

	public final int KEY_LEFT   = 37;
	public final int KEY_UP     = 38;
	public final int KEY_RIGHT  = 39;
	public final int KEY_DOWN   = 40;

	public final int KEY_0 = 48;
	public final int KEY_1 = 49;
	public final int KEY_2 = 50;
	public final int KEY_3 = 51;
	public final int KEY_4 = 52;
	public final int KEY_5 = 53;
	public final int KEY_6 = 54;
	public final int KEY_7 = 55;
	public final int KEY_8 = 56;
	public final int KEY_9 = 57;

	public final int KEY_A = 65;
	public final int KEY_B = 66;
	public final int KEY_C = 67;
	public final int KEY_D = 68;
	public final int KEY_E = 69;
	public final int KEY_F = 70;
	public final int KEY_G = 71;
	public final int KEY_H = 72;
	public final int KEY_I = 73;
	public final int KEY_J = 74;
	public final int KEY_K = 75;
	public final int KEY_L = 76;
	public final int KEY_M = 77;
	public final int KEY_N = 78;
	public final int KEY_O = 79;
	public final int KEY_P = 80;
	public final int KEY_Q = 81;
	public final int KEY_R = 82;
	public final int KEY_S = 83;
	public final int KEY_T = 84;
	public final int KEY_U = 85;
	public final int KEY_V = 86;
	public final int KEY_W = 87;
	public final int KEY_X = 88;
	public final int KEY_Y = 89;
	public final int KEY_Z = 90;

	// Function keys
	public final int KEY_F1  = 112;
	public final int KEY_F2  = 113;
	public final int KEY_F3  = 114;
	public final int KEY_F4  = 115;
	public final int KEY_F5  = 116;
	public final int KEY_F6  = 117;
	public final int KEY_F7  = 118;
	public final int KEY_F8  = 119;
	public final int KEY_F9  = 120;
	public final int KEY_F10 = 121;
	public final int KEY_F12 = 122;
}
