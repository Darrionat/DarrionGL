package me.darrionat.darrionGL.events;

public abstract class UiEvent {

	/**
	 * The status on if the event is cancelled
	 */
	private boolean cancelled = false;

	/**
	 * Determines if the event can be called
	 * 
	 * @return returns if the event is cancelled.
	 */
	public boolean isCancelled() {
		return cancelled;
	}

	/**
	 * Sets the events status on cancellation to the passed argument. Passing
	 * {@code true} will cancel the event and prevent any further calling. Passing
	 * {@code false} will permit the event to be called.
	 * 
	 * @param cancelled the value of which the event will be cancelled or not.
	 */
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}