package me.darrionat.darrionGL.constraints.interfaces;

import me.darrionat.darrionGL.components.UiComponent;

public interface HeightConstraint {
	/**
	 * Calculates the height value of a UiComponent
	 * 
	 * @param component the UiComponent to calculate the height of
	 * @return returns the height of the UiComponent utilizing the constraint's
	 *         method
	 */
	int getHeight(UiComponent component);
}