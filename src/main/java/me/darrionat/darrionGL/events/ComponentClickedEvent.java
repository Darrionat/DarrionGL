package me.darrionat.darrionGL.events;

import me.darrionat.darrionGL.components.UiComponent;

public class ComponentClickedEvent extends UiEvent {

	private UiComponent component;
	private double x;
	private double y;

	/**
	 * An event which is called when a UiComponent on the screen has been clicked
	 * on. Determining if a UiComponent has been clicked will also take
	 * subcomponents into account. If a subcomponent determined if the parent
	 * component was clicked, the parent component will be the one defined within
	 * the event.
	 * 
	 * @param component the component that was clicked
	 * @param x         the X coordinate of where the component was clicked
	 * @param y         the Y coordinate of where the component was clicked
	 */
	public ComponentClickedEvent(UiComponent component, double x, double y) {
		this.component = component;
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the clicked component
	 * 
	 * @return returns the clicked UiComponent
	 */
	public UiComponent getComponent() {
		return component;
	}

	/**
	 * Gets the clicked X coordinate
	 * 
	 * @return the clicked X coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the clicked Y coordinate
	 * 
	 * @return the clicked Y coordinate
	 */
	public double getY() {
		return y;
	}
}