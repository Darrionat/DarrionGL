package me.darrionat.darrionGL.constraints;

import me.darrionat.darrionGL.constraints.interfaces.HeightConstraint;
import me.darrionat.darrionGL.constraints.interfaces.WidthConstraint;
import me.darrionat.darrionGL.constraints.interfaces.XConstraint;
import me.darrionat.darrionGL.constraints.interfaces.YConstraint;

public class UiConstraints {

	private XConstraint xConstraint;
	private YConstraint yConstraint;
	private WidthConstraint widthConstraint;
	private HeightConstraint heightConstraint;

	public UiConstraints() {

	}

	public UiConstraints(XConstraint xConstraint, YConstraint yConstraint, WidthConstraint widthConstraint,
			HeightConstraint heightConstraint) {
		this.xConstraint = xConstraint;
		this.yConstraint = yConstraint;
		this.widthConstraint = widthConstraint;
		this.heightConstraint = heightConstraint;
	}

	/**
	 * Sets the XConstraint of this UiConstraints to the provided constraint.
	 * 
	 * @param constraint the given constraint to be used for calculating a X value
	 *                   based upon the constraint
	 */
	public void setX(XConstraint constraint) {
		this.xConstraint = constraint;
	}

	/**
	 * Sets the YConstraint of this UiConstraints to the provided constraint.
	 * 
	 * @param constraint the given constraint to be used for calculating a Y value
	 *                   based upon the constraint
	 */
	public void setY(YConstraint constraint) {
		this.yConstraint = constraint;
	}

	/**
	 * Sets the WidthConstraint of this UiConstraints to the provided constraint.
	 * 
	 * @param constraint the given constraint to be used for calculating a width
	 *                   value based upon the constraint
	 */
	public void setWidth(WidthConstraint constraint) {
		this.widthConstraint = constraint;
	}

	/**
	 * Sets the HeightConstraint of this UiConstraints to the provided constraint.
	 * 
	 * @param constraint the given constraint to be used for calculating a height
	 *                   value based upon the constraint
	 */
	public void setHeight(HeightConstraint constraint) {
		this.heightConstraint = constraint;
	}

	/**
	 * Gets the XConstraint of the UiConstraints object
	 * 
	 * @return returns the XConstraint which can calculate a X value based upon the
	 *         type of constraint
	 */
	public XConstraint getXConstraint() {
		return xConstraint;
	}

	/**
	 * Gets the YConstraint of the UiConstraints object
	 * 
	 * @return returns the YConstraint which can calculate a Y value based upon the
	 *         type of constraint
	 */
	public YConstraint getYConstraint() {
		return yConstraint;
	}

	/**
	 * Gets the WidthConstraint of the UiConstraints object
	 * 
	 * @return returns the WidthConstraint which can calculate a width value based
	 *         upon the type of constraint
	 */
	public WidthConstraint getWidthConstraint() {
		return widthConstraint;
	}

	/**
	 * Gets the HeightConstraint of the UiConstraints object
	 * 
	 * @return returns the HeightConstraint which can calculate a height value based
	 *         upon the type of constraint
	 */
	public HeightConstraint getHeightConstraint() {
		return heightConstraint;
	}
}