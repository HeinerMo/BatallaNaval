package entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class Peg extends Entity {

	private double radius;

	public Peg(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.pink);
		g.fillOval((int) x, (int) y, (int) radius, (int) radius);
	}

	public double getRadius() {
		return radius;
	}

}
