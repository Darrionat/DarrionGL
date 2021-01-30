package me.darrionat.darrionGL.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.MouseInputListener;

import me.darrionat.darrionGL.UI;
import me.darrionat.darrionGL.components.UiComponent;

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

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseWheelMoved(MouseWheelEvent e) {

	}
}