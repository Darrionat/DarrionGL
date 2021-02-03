package me.darrionat.darrionGL.constraints;

public class ConstraintFactory {

	/**
	 * Creates a UiConstraints object that is completely made of
	 * RelativeConstraints.
	 * 
	 * @param x      the X ratio
	 * @param y      the Y ratio
	 * @param width  the width ratio
	 * @param height the height ratio
	 * @return returns constraints that are completely relative 
	 */
	public static UiConstraints getRelative(float x, float y, float width, float height) {
		return new UiConstraints(new RelativeConstraint(x), new RelativeConstraint(y), new RelativeConstraint(width),
				new RelativeConstraint(height));
	}
}