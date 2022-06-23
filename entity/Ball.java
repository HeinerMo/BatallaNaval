package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import game.Game;
import math.VectorR2;

public class Ball extends Entity {

	private boolean moving;
	private int radius;
	private VectorR2 speed;
	private double mass;

	public Ball(double x, double y, int radius) {
		super(x, y);
		this.radius = radius;
		speed = new VectorR2(5, 5);
	}

	@Override
	public void update() {
		if (moving) {
			collitionWithBox();
			move();
		}
	}

	private void move() {
		x += speed.getX();
		y += speed.getY();
	}

	private void collitionWithBox() {
		if (x - radius <= 0) {
			speed.setX(-speed.getX());
		} else if (x + radius >= Game.WIDTH) {
			speed.setX(-speed.getX());
		}

		if (y - radius <= 0) {
			speed.setY(-speed.getY());
		} else if (y + radius >= Game.WIDTH) {
			speed.setY(-speed.getY());
		}
	}

	private void drawPrediction(Graphics2D g) {
		g.setColor(Color.GREEN);
	}

	public void checkPegs(Peg pegs[]) {
		for (Peg peg : pegs) {
			if (isColliding(peg)) {
				collide(peg);
			}
		}
	}

	private void collide(Peg peg) {
		
	}

	private boolean isColliding(Peg peg) {
		double distance = (peg.getX() - x) * (peg.getX() - x) + (peg.getY() - y) * (peg.getY() - y);

		return (radius + peg.getRadius()) * (radius + peg.getRadius()) > distance;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.cyan);
		g.fillOval((int) (x - radius), (int) (y - radius), (int) radius * 2, (int) radius * 2);

		g.setColor(Color.red);
		g.fillOval((int) x - 2, (int) y - 2, 4, 4);

		drawPrediction(g);

	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

}
