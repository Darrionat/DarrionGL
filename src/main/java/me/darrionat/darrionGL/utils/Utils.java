package me.darrionat.darrionGL.utils;

import me.darrionat.darrionGL.components.UiColor;

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

	/**
	 * Gets a hue between two colors with a ratio
	 * 
	 * @param menuButtonColor         the first color; 0% will be this color
	 * @param menuButtonColorExtended the second color; 100% will be this color
	 * @param numerator               the top of a fraction
	 * @param denominator             the bottom of a fraction
	 * @return a hue of the two colors with a percentage taken into account
	 */
	public static UiColor getColorByPercent(UiColor menuButtonColor, UiColor menuButtonColorExtended, int numerator,
			int denominator) {
		double ratio = (double) numerator / (double) denominator;
		return getColorByPercent(menuButtonColor, menuButtonColorExtended, ratio);
	}

	/**
	 * Gets a hue between two colors with a ratio
	 * 
	 * @param colorOne the first color; 0% will be this color
	 * @param colorTwo the second color; 100% will be this color
	 * @param percent  the ratio between two colors
	 * @return a hue of the two colors with a percentage taken into account
	 */
	public static UiColor getColorByPercent(UiColor colorOne, UiColor colorTwo, double percent) {
		int r = getIntByPercent(colorOne.getRed(), colorTwo.getRed(), percent);
		int g = getIntByPercent(colorOne.getGreen(), colorTwo.getGreen(), percent);
		int b = getIntByPercent(colorOne.getBlue(), colorTwo.getBlue(), percent);
		int a = getIntByPercent(colorOne.getAlpha(), colorTwo.getAlpha(), percent);
		return new UiColor(r, g, b, a);
	}

	/**
	 * Calculates an integer between two integers based on a percentage
	 * 
	 * @param start   the starting integer; 0% is this integer
	 * @param end     the ending integer; 100% is this integer
	 * @param percent the ratio between the two integers
	 * @return an integer between the starting and ending integers based on a
	 *         percent
	 */
	public static int getIntByPercent(int start, int end, double percent) {
		int diff = start - end;
		int ans = (int) (start - (diff * percent));
		if (ans > 255)
			ans = 255;
		if (ans < 0)
			ans = 0;
		return ans;
	}
}