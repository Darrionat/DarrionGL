package me.darrionat.darrionGL.events.interfaces;

public interface Clickable {
	/**
	 * Checks to see if a point is contained within a component
	 * 
	 * @param x the X value of the point
	 * @param y the Y value of the point
	 * @return returns {@code true} if the component contains the point
	 */
	public boolean shapeContainsPoint(double x, double y);
}