package me.darrionat.darrionGL.events;

import me.darrionat.darrionGL.components.UiComponent;

public class ComponentEnteredEvent extends UiEvent {

	private UiComponent component;

	public ComponentEnteredEvent(UiComponent component) {
		this.component = component;
	}

	public UiComponent getComponent() {
		return component;
	}
}