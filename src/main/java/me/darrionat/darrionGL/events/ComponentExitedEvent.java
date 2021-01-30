package me.darrionat.darrionGL.events;

import me.darrionat.darrionGL.components.UiComponent;

public class ComponentExitedEvent extends UiEvent {

	private UiComponent component;

	public ComponentExitedEvent(UiComponent component) {
		this.component = component;
	}

	public UiComponent getComponent() {
		return component;
	}
}