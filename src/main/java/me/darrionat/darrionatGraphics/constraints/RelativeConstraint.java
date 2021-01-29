package me.darrionat.darrionatGraphics.constraints;

import me.darrionat.darrionatGraphics.UI;
import me.darrionat.darrionatGraphics.components.UiComponent;
import me.darrionat.darrionatGraphics.constraints.interfaces.HeightConstraint;
import me.darrionat.darrionatGraphics.constraints.interfaces.WidthConstraint;
import me.darrionat.darrionatGraphics.constraints.interfaces.XConstraint;
import me.darrionat.darrionatGraphics.constraints.interfaces.YConstraint;

public class RelativeConstraint extends UiConstraints
		implements XConstraint, YConstraint, WidthConstraint, HeightConstraint {

	private final float ratio;

	/**
	 * Initializes a UiConstraints object that sets the x, y, width, or height to a
	 * ratio of the screen
	 * 
	 * @param ratio percentage of the screen to occupy; should be between 0f and 1f
	 */
	public RelativeConstraint(float ratio) {
		this.ratio = ratio;
	}

	public int getX(UiComponent uiComponent) {
		return (int) (UI.width * ratio);
	}

	public int getY(UiComponent uiComponent) {
		return (int) (UI.height * ratio);
	}

	public int getWidth(UiComponent uiComponent) {
		return (int) (UI.width * ratio);
	}

	public int getHeight(UiComponent uiComponent) {
		return (int) (UI.height * ratio);
	}
}