package me.darrionat.darrionatGraphics.constraints;

import me.darrionat.darrionatGraphics.UI;
import me.darrionat.darrionatGraphics.components.UiComponent;
import me.darrionat.darrionatGraphics.constraints.interfaces.XConstraint;
import me.darrionat.darrionatGraphics.constraints.interfaces.YConstraint;

public class CenterConstraint extends UiConstraints implements XConstraint, YConstraint {

	/**
	 * Initializes a UiConstraints object that centers the x or y value in the
	 * center of the UiContainer taking width or height, respectively, into account
	 */
	public CenterConstraint() {
	}

	public int getX(UiComponent component) {
		int midX = UI.width / 2;
		return midX - (component.getWidth() / 2);
	}

	public int getY(UiComponent component) {
		int midY = UI.height / 2;
		return midY - (component.getHeight() / 2);
	}
}