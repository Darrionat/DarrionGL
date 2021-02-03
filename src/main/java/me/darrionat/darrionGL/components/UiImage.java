package me.darrionat.darrionGL.components;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class UiImage extends UiComponent {

	private ImageIcon icon;

	public UiImage(String imageUrl) {
		this.icon = new ImageIcon(imageUrl);
	}

	@Override
	protected void draw(Graphics2D g2D) {
		g2D.drawImage(icon.getImage(), getX(), getY(), getWidth(), getHeight(), null, null);
	}
}