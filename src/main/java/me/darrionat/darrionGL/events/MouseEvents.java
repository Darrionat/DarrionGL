package me.darrionat.darrionGL.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.MouseInputListener;

import me.darrionat.darrionGL.UI;
import me.darrionat.darrionGL.components.UiComponent;
import me.darrionat.darrionGL.events.interfaces.Hoverable;

public class MouseEvents implements MouseInputListener, MouseWheelListener {

	/**
	 * Used for calling ComponentClickedEvent
	 * 
	 * @param e the MouseEvent being passed
	 */
	public void mouseClicked(MouseEvent e) {
		for (UiComponent component : UI.getContainer().getComponenets()) {
			double x = e.getX();
			double y = e.getY();
			if (component.containsPoint(x, y)) {
				EventManager.callEvent(new ComponentClickedEvent(component, x, y));
			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {

	}

	/**
	 * Used for calling ComponentEnteredEvent and ComponentExitedEvent
	 * 
	 * @param e the MouseEvent being passed
	 */
	public void mouseMoved(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		for (UiComponent component : UI.getContainer().getComponenets()) {
			checkForComponentEnteredOrExit(component, x, y);
			for (UiComponent subComponent : component.getSubComponents()) {
				checkForComponentEnteredOrExit(subComponent, x, y);
			}
		}
	}

	/**
	 * Checks to see if the component is in a state where the mouse entered or
	 * exited the UiComponent
	 * 
	 * @param component the component to check the status of
	 * @param x         the X coordinate of the mouse
	 * @param y         the Y coordinate of the mouse
	 */
	private void checkForComponentEnteredOrExit(UiComponent component, double x, double y) {
		if (!(component instanceof Hoverable))
			return;
		if (component.containsPoint(x, y)) {
			if (component.isHovered())
				return;
			component.setHovered(true);
			EventManager.callEvent(new ComponentEnteredEvent(component));
		} else if (component.isHovered()) {
			component.setHovered(false);
			EventManager.callEvent(new ComponentExitedEvent(component));
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {

	}
}