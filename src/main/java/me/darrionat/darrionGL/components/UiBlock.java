package me.darrionat.darrionGL.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import me.darrionat.darrionGL.events.interfaces.Clickable;

public class UiBlock extends UiComponent implements Clickable {

	private Rectangle2D rect;

	public UiBlock() {
		super();
	}

	@Override
	protected void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		rect = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
		g2d.setColor(uiColor.getColor());
		g2d.fill(rect);
		g2d.draw(rect);
	}

	public boolean shapeContainsPoint(double x, double y) {
		return rect.contains(x, y);
	}
}