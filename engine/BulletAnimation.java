package engine;

import java.awt.Color;
import java.awt.Graphics2D;

import util.Util;

public class BulletAnimation extends Animation{

	private float step, lastTime;
	private int steps, x, y;
	
	public BulletAnimation(float duration, int x, int y) {
		super(duration);
		steps = 10;
		step = duration / steps;
		finished = false;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void start() {
		super.start();
		lastTime = startingTime;
	}
	
	@Override
	protected void onUpdate() {
		super.onUpdate();
	}
	
	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(new Color(255, 0 , 0, 150));
		g.fillRect(x * Util.tileSize, y * Util.tileSize, Util.tileSize, Util.tileSize);
	}
}
