package entity;

import java.awt.Graphics2D;

public abstract class Entity {

	protected double x, y;

	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public abstract void update();

	public abstract void render(Graphics2D g);

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
