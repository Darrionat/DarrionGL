package me.darrionat.darrionGL.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import me.darrionat.darrionGL.events.interfaces.Clickable;
import me.darrionat.darrionGL.events.interfaces.Hoverable;

public class UiBlock extends UiComponent implements Clickable, Hoverable {

	private RoundRectangle2D rect;
	private float radius = 0;

	public UiBlock() {
		super();
	}

	public void setRoundedCorners(float radius) {
		this.radius = radius;
	}

	@Override
	protected void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		rect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), radius, radius);
		g2d.setColor(uiColor.getColor());
		g2d.fill(rect);
		g2d.draw(rect);
	}

	public boolean shapeContainsPoint(double x, double y) {
		if (rect == null)
			return false;
		return rect.contains(x, y);
	}
}