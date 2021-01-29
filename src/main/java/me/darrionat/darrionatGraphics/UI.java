package me.darrionat.darrionatGraphics;

import javax.swing.JFrame;

public abstract class UI extends JFrame {

	private static final long serialVersionUID = 1L;

	public static int width;
	public static int height;

	private static UiContainer currentMenu;

	public UI() {

	}

	public static UiContainer getContainer() {
		return currentMenu;
	}

	public void initUI() {
		setVisible(true);
		width = getWidth();
		height = getHeight();
	}

	/**
	 * 
	 * @param container
	 */
	public void setCurrentUiContainer(UiContainer container) {
		currentMenu = container;
		add(container);
		pack();
		setVisible(true);
		container.setComponents();
		width = getWidth();
		height = getHeight();
	}
}