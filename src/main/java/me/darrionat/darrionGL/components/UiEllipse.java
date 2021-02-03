package me.darrionat.darrionGL.components;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import me.darrionat.darrionGL.events.interfaces.Clickable;
import me.darrionat.darrionGL.events.interfaces.Hoverable;

public class UiEllipse extends UiComponent implements Clickable, Hoverable {

	private Ellipse2D ellipse;

	public UiEllipse() {
		super();
	}

	@Override
	protected void draw(Graphics2D g2d) {
		Ellipse2D ellipse = new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight());
		g2d.setColor(uiColor.getColor());
		g2d.fill(ellipse);
		g2d.draw(ellipse);
	}

	public boolean shapeContainsPoint(double x, double y) {
		if (ellipse == null)
			return false;
		return ellipse.contains(x, y);
	}
}