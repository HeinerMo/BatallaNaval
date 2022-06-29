package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.InputHandler;
import util.Util;

public class Ship extends Entity {

	protected ShipSection[] sections;
	protected boolean isSelected = false;
    protected boolean rotated = false;

	public Ship(int x, int y) {
		super(x, y);
	}

	@Override
	public void update() {

		if (isSelected) {
			moveToMouse();
		}
		for (ShipSection ss : sections) {
			ss.update();
		}
	}

	@Override
	public void render(Graphics2D g) {
		for (ShipSection ss : sections) {
			if (isSelected) {
				g.setColor(new Color(0, 255, 0, 100));
				g.fillRect(ss.getX() * Util.tileSize, ss.getY() * Util.tileSize, Util.tileSize, Util.tileSize);
			}
			ss.render(g);
		}
	}

	public boolean mouseOver() {
		for (ShipSection s : sections) {
			if (s.getX() * Util.tileSize < Util.mouseX && s.getX() * Util.tileSize + Util.tileSize > Util.mouseX
					&& s.getY() * Util.tileSize < Util.mouseY
					&& s.getY() * Util.tileSize + Util.tileSize > Util.mouseY) {
				return true;
			}
		}
		return false;
	}

	public void select() {
		isSelected = true;

	}

	public void drop() {
		isSelected = false;
	}

	public boolean isSelected() {
		return isSelected;
	}
	
	protected void moveToMouse() {
		x = (Util.mouseX * 10) / Util.HEIGHT;
		y = (Util.mouseY * 10) / Util.HEIGHT;
		sections[0].updatePosition(x, y);
		
		for (int i = 1; i < sections.length; i++) {
			if (!rotated) {
				sections[i].updatePosition(sections[i -1].x, sections[i - 1].y + 1);
			} else {
				sections[i].updatePosition(sections[i -1].x + 1, sections[i - 1].y);
			}
		}	
	}
	
	public void rotate() {
		rotated = !rotated;
	}

}
