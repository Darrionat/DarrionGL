package me.darrionat.darrionGL.components;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import me.darrionat.darrionGL.animations.UiAnimation;
import me.darrionat.darrionGL.constraints.UiConstraints;
import me.darrionat.darrionGL.events.interfaces.Clickable;
import me.darrionat.darrionGL.events.interfaces.Hoverable;

/**
 * Represents a component of the display such as a pop up GUI, a UiComponent can
 * consist of multiple components with their own set of constraints
 * 
 * @author Darrion Thornburgh
 */
public abstract class UiComponent {

	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * Color of this object; defaulted to Black
	 */
	protected UiColor uiColor;

	/**
	 * Constraints defined for this object
	 */
	protected UiConstraints constraints;

	/**
	 * A List of all subcomponents within this component
	 */
	protected List<UiComponent> components = new ArrayList<UiComponent>();

	/**
	 * The current state of the UiComponent being hovered. If the UiComponent isn't
	 * hoverable, this won't be changed.
	 */
	private boolean hovered = false;

	/**
	 * The current animation of a UiComponent
	 */
	private UiAnimation animation;

	/**
	 * Creates a UiComponent object without dimensions or constraints, and with a
	 * default color of black. Add constraints by making this a subcomponent of
	 * another component {@link #add(UiComponent, UiConstraints)} or by adding this
	 * component to a UiContainer object
	 */
	public UiComponent() {
		this.uiColor = UiColors.BLACK;
	}

	/**
	 * Gets the list of all sub UiComponents contained within this UiComponent
	 * 
	 * @return a list of UiComponents that are within this UiComponent
	 */
	public List<UiComponent> getSubComponents() {
		return components;
	}

	/**
	 * Gets the current color of this UiComponent
	 * 
	 * @return returns the current UiColor object within this object
	 */
	public UiColor getUiColor() {
		return uiColor;
	}

	/**
	 * Changes the set UiColor of this object
	 * 
	 * @param color the new color to set the UiComponent to
	 */
	public void setUiColor(UiColor color) {
		this.uiColor = color;
	}

	/**
	 * Calculate the X coordinate of the component with the given constraints
	 * 
	 * @return returns the X coordinate of the UiComponent
	 */
	public int getX() {
		x = constraints.getXConstraint().getX(this);
		return x;
	}

	/**
	 * Calculate the Y coordinate of the component with the given constraints
	 * 
	 * @return returns the Y coordinate of the UiComponent
	 */
	public int getY() {
		y = constraints.getYConstraint().getY(this);
		return y;
	}

	/**
	 * Calculate the width of the component with the given constraints
	 * 
	 * @return returns the width of the UiComponent
	 */
	public int getWidth() {
		width = constraints.getWidthConstraint().getWidth(this);
		return width;
	}

	/**
	 * Calculate the height of the component with the given constraints
	 * 
	 * @return returns the height of the UiComponent
	 */
	public int getHeight() {
		height = constraints.getHeightConstraint().getHeight(this);
		return height;
	}

	/**
	 * Adds a subcomponent to this object
	 * 
	 * @param component   the subcomponent being added
	 * @param constraints the constraints to add to the subcomponent
	 */
	public void add(UiComponent component, UiConstraints constraints) {
		component.setConstraints(constraints);
		components.add(component);
	}

	/**
	 * Get the constraints of the UiComponent
	 * 
	 * @return returns a UiConstraints objects; which holds constraints for x, y,
	 *         width, and height
	 */
	public UiConstraints getConstraints() {
		return constraints;
	}

	/**
	 * Sets the components of the object
	 * 
	 * @param constraints the given constraints to set
	 */
	public void setConstraints(UiConstraints constraints) {
		this.constraints = constraints;
	}

	/**
	 * Displays the component and all of its subcomponents
	 * 
	 * @param g2D the graphics to display the components on
	 */
	public void displayComponent(Graphics2D g2D) {
		addRenderingHints(g2D);
		draw(g2D);
		for (UiComponent component : components)
			component.displayComponent(g2D);
	}

	/**
	 * Improves graphics of the UiComponent with antialiasing
	 * 
	 * @param g2d the graphics to add the rendering hints to
	 */
	private void addRenderingHints(Graphics2D g2d) {
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
	}

	/**
	 * Draws the component on the graphics passed through the method
	 * 
	 * @param g graphics to utilize for drawing on
	 */
	protected abstract void draw(Graphics2D g2D);

	/**
	 * Checks to see if this component or any subcomponents contain the defined
	 * point. A component must implement the interface Clickable to be able to
	 * return {@code true}
	 * 
	 * @param x the X value of the point
	 * @param y the Y value of the point
	 * @return returns {@code true} if the UiComponent or any subcomponents contain
	 *         the defined point
	 */
	public boolean containsPoint(double x, double y) {
		if (this instanceof Clickable)
			if (((Clickable) this).shapeContainsPoint(x, y))
				return true;

		for (UiComponent subComponent : components) {
			if (subComponent instanceof Clickable)
				if (((Clickable) subComponent).shapeContainsPoint(x, y))
					return true;
		}
		return false;
	}

	/**
	 * Determines if the component is currently being hovered over
	 * 
	 * @return returns the state of the component being hovered
	 */
	public boolean isHovered() {
		if (hovered)
			return true;
		for (UiComponent subComponent : components) {
			if (subComponent instanceof Hoverable && subComponent.isHovered())
				return true;
		}
		return false;
	}

	/**
	 * Sets the status of being hovered to the given input. This will only change
	 * the status of being hovered if the UiComponent implements Hoverable.
	 * 
	 * @param hovered the state of the component being hovered
	 */
	public void setHovered(boolean hovered) {
		if (this instanceof Hoverable)
			this.hovered = hovered;
	}

	/**
	 * Gets the animation of the UiComponent, will return {@code null} if no
	 * animation is defined.
	 * 
	 * @return returns the current UiAnimation of the component
	 */
	public UiAnimation getAnimation() {
		return animation;
	}

	/**
	 * Sets the animation of the component. This will not run the animation.
	 * 
	 * @param animation the animation to set for the component
	 */
	public void setAnimation(UiAnimation animation) {
		this.animation = animation;
	}
}