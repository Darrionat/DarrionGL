package me.darrionat.darrionatGraphics.constraints;

import me.darrionat.darrionatGraphics.components.UiComponent;
import me.darrionat.darrionatGraphics.constraints.interfaces.HeightConstraint;
import me.darrionat.darrionatGraphics.constraints.interfaces.WidthConstraint;
import me.darrionat.darrionatGraphics.constraints.interfaces.XConstraint;
import me.darrionat.darrionatGraphics.constraints.interfaces.YConstraint;

public class PixelConstraint extends UiConstraints
		implements XConstraint, YConstraint, WidthConstraint, HeightConstraint {

	private final int px;

	/**
	 * Initializes a UiConstraints object that sets x, y, width, or height to the
	 * defined value
	 * 
	 * @param pixels the amount of pixels to constrain by
	 */
	public PixelConstraint(int pixels) {
		px = pixels;
	}

	public int getX(UiComponent uiComponent) {
		return px;
	}

	public int getY(UiComponent uiComponent) {
		return px;
	}

	public int getWidth(UiComponent uiComponent) {
		return px;
	}

	public int getHeight(UiComponent uiComponent) {
		return px;
	}

}