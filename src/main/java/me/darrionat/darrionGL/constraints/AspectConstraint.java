package me.darrionat.darrionGL.constraints;

import me.darrionat.darrionGL.components.UiComponent;
import me.darrionat.darrionGL.constraints.interfaces.HeightConstraint;
import me.darrionat.darrionGL.constraints.interfaces.WidthConstraint;

public class AspectConstraint extends UiConstraints implements WidthConstraint, HeightConstraint {

	private final double ratio;

	/**
	 * Initializes a UiConstraints object that defines the aspect ratio of a
	 * UiComponent
	 * 
	 * @param aspectRatio the aspect ratio to define using the ratio width:height
	 */
	public AspectConstraint(double aspectRatio) {
		this.ratio = aspectRatio;
	}

	public int getWidth(UiComponent component) {
		return (int) (component.getHeight() * ratio);
	}

	public int getHeight(UiComponent component) {
		return (int) (component.getWidth() / ratio);
	}
}