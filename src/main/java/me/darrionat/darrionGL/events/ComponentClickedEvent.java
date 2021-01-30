package me.darrionat.darrionGL.events;

import me.darrionat.darrionGL.components.UiComponent;

public class ComponentClickedEvent extends UiEvent {

	private UiComponent component;
	private double x;
	private double y;

	public ComponentClickedEvent(UiComponent component, double x, double y) {
		this.component = component;
		this.x = x;
		this.y = y;
	}

	public UiComponent getComponent() {
		return component;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}