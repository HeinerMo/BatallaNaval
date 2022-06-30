package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import util.Util;

public class HitMarker extends Entity{

	boolean hit;

	public HitMarker(int x, int y, boolean hit) {
		super(x, y);
		this.hit = hit;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics2D g) {
		if (hit) {
			g.setColor(new Color(255, 100, 100, 100));
		} else {
			g.setColor(new Color(255, 255, 255, 100));
		}
		g.fillOval(x * Util.tileSize, y * Util.tileSize, Util.tileSize, Util.tileSize);
	}
}
