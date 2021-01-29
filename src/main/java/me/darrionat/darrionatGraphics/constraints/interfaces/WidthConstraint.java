package me.darrionat.darrionatGraphics.constraints.interfaces;

import me.darrionat.darrionatGraphics.components.UiComponent;

public interface WidthConstraint {
	/**
	 * Calculates the width value of a UiComponent
	 * 
	 * @param component the UiComponent to calculate the width of
	 * @return returns the width of the UiComponent utilizing the constraint's
	 *         method
	 */
	int getWidth(UiComponent component);
}