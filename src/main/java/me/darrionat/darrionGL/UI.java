package me.darrionat.darrionGL;

import javax.swing.JFrame;

import me.darrionat.darrionGL.events.MouseEvents;

public abstract class UI extends JFrame {

	private static final long serialVersionUID = 1L;

	public static int width;
	public static int height;
	private static UiContainer currentMenu;
	private MouseEvents events;

	public UI() {

	}

	public static UiContainer getContainer() {
		return currentMenu;
	}

	public void initUI() {
		setVisible(true);
		width = getWidth();
		height = getHeight();
		events = new MouseEvents();
	}

	/**
	 * Changes the current UiContainer of the UI
	 * 
	 * @param container the container to display
	 */
	public void setCurrentContainer(UiContainer container) {
		if (currentMenu != null && events != null) {
			currentMenu.removeMouseListener(events);
			currentMenu.removeMouseWheelListener(events);
		}
		currentMenu = container;
		add(container);
		pack();
		setVisible(true);
		container.setComponents();
		width = getWidth();
		height = getHeight();
		container.addMouseListener(events);
		container.addMouseMotionListener(events);
		container.addMouseWheelListener(events);
	}
}