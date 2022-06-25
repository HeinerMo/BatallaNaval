package entity;

import java.awt.Graphics2D;

public abstract class Entity {

	protected int x, y;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void update();

	public abstract void render(Graphics2D g);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
