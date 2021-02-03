package me.darrionat.darrionGL.components;

import java.awt.Graphics;

/**
 * A simple class to hold subcomponents
 */
public class UiGroup extends UiComponent {

	public void add(UiComponent component) {
		components.add(component);
	}

	@Override
	protected void draw(Graphics g) {
	}
}