package me.darrionat.darrionGL.components;

import java.awt.Color;

import me.darrionat.darrionGL.utils.Utils;

public class UiColor {

	private int r;
	private int g;
	private int b;
	private int a;

	private final int min = 0;
	private final int max = 255;

	public UiColor(int red, int green, int blue) {
		new UiColor(red, green, blue, 255);
	}

	public UiColor(int red, int green, int blue, int alpha) {
		this.r = red;
		this.g = green;
		this.b = blue;
		this.a = alpha;
	}

	public Color getColor() {
		r = Utils.constrain(r, min, max);
		g = Utils.constrain(g, min, max);
		b = Utils.constrain(b, min, max);
		a = Utils.constrain(a, min, max);
		return new Color(r, g, b, a);
	}

	public void setOpacity(float percent) {
		this.a = (int) (percent * 256) - 1;
	}

	public int getRed() {
		return r;
	}

	public int getGreen() {
		return g;
	}

	public int getBlue() {
		return b;
	}

	public int getAlpha() {
		return a;
	}
}