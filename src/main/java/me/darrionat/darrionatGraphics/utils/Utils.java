package me.darrionat.darrionatGraphics.utils;

public class Utils {
	/**
	 * Constrains an integer into a range
	 * 
	 * @param x   the integer being constrained
	 * @param min minimum value
	 * @param max maximum value
	 * @return the integer constrained within the minimum and maximum value
	 */
	public static int constrain(int x, int min, int max) {
		if (x < min) {
			x = min;
		} else if (x > max) {
			x = max;
		}
		return x;
	}
}