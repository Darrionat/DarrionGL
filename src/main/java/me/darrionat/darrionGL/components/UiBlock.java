package me.darrionat.darrionGL.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class UiBlock extends UiComponent {

	public UiBlock() {
		super();
	}

	@Override
	protected void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
		g2d.setColor(uiColor.getColor());
		g2d.fill(rect);
		g2d.draw(rect);
	}
}