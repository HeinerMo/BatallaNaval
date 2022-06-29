package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import engine.InputHandler;
import util.Util;

public class Board extends Entity {

	private ArrayList<Ship> ships;
	private boolean justRotated, hasSelected, justClicked;

	public Board(int x, int y, int small, int medium, int large) {
		super(x, y);
		ships = new ArrayList<>();
		for (int i = 0; i < small; i++) {
			ships.add(new SmallShip(11, 0));
		}
		for (int i = 0; i < medium; i++) {
			ships.add(new MediumShip(12, 0));
		}
		for (int i = 0; i < large; i++) {
			ships.add(new LargeShip(13, 0));
		}
		justRotated = justClicked = false;
	}

	@Override
	public void update() {
		boolean hasSelected = false;
		for (Ship s : ships) {
			if (s.isSelected) {
				hasSelected = true;
				break;
			}
		}
		for (Ship s : ships) {
			s.updateDrop(ships);
			if (InputHandler.mousePressed) {
				if (s.mouseOver() && !s.isSelected() && !justClicked && !hasSelected) {
					s.select();
					hasSelected = true;
					justClicked = true;
				} else if (s.isSelected() && !justClicked && hasSelected) {

					if (s.canDrop()) {
						s.drop();
					} // TODO (Se puede mostrar un mensaje de
						// error con animaciónes).
					hasSelected = false;
					justClicked = true;
				}
			} else {
				justClicked = false;
			}
			if (InputHandler.keys[82]) {
				if (!justRotated && s.isSelected()) {
					s.rotate();
					justRotated = true;
				} else if (!justRotated && s.isSelected()) {
					s.rotate();
					justRotated = true;
				}
			} else {
				justRotated = false;
			}
			s.update();
		}
	}

	@Override
	public void render(Graphics2D g) {
		for (int i = 0; i < Util.TILES; i++) {
			for (int j = 0; j < Util.TILES; j++) {
				g.drawImage(Util.images.get("water"), i * Util.tileSize, j * Util.tileSize, Util.tileSize,
						Util.tileSize, null);
			}
		}
		for (int i = 0; i < Util.TILES; i++) {
			for (int j = 0; j < Util.TILES; j++) {
				if (i * Util.tileSize < Util.mouseX && i * Util.tileSize + Util.tileSize > Util.mouseX
						&& j * Util.tileSize < Util.mouseY && j * Util.tileSize + Util.tileSize > Util.mouseY) {
				}

				g.setColor(new Color(0, 0, 0, 20));
				g.drawRect(i * Util.tileSize, j * Util.tileSize, Util.tileSize, Util.tileSize);
			}
		}
		for (Ship s : ships) {
			s.render(g);
		}
	}

}
