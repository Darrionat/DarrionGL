package me.darrionat.darrionGL.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import me.darrionat.darrionGL.events.interfaces.Clickable;

public class UiEllipse extends UiComponent implements Clickable {

	private Ellipse2D ellipse;

	public UiEllipse() {
		super();
	}

	@Override
	protected void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D ellipse = new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight());
		g2d.setColor(uiColor.getColor());
		g2d.fill(ellipse);
		g2d.draw(ellipse);
	}

	public boolean shapeContainsPoint(double x, double y) {
		return ellipse.contains(x, y);
	}
}