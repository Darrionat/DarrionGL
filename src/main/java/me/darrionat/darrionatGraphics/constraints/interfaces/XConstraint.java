package me.darrionat.darrionatGraphics.constraints.interfaces;

import me.darrionat.darrionatGraphics.components.UiComponent;

public interface XConstraint {
	/**
	 * Calculates the X coordinate of a UiComponent
	 * 
	 * @param uiComponent the UiComponent to calculate the X value of
	 * @return returns the X coordinate of the UiComponent utilizing the
	 *         constraint's method
	 */
	int getX(UiComponent uiComponent);
}