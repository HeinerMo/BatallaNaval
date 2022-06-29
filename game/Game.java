package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import engine.InputHandler;
import entity.LargeShip;
import entity.MediumShip;
import entity.Ship;
import entity.SmallShip;
import util.Util;

public class Game {

	private int tiles = 10;
	private ArrayList<Ship> ships;
	private boolean justRotated, hasSelected, justClicked;

	public Game() {
		if (Util.WIDTH <= Util.HEIGHT) {
			Util.tileSize = Util.WIDTH / tiles;
		} else {
			Util.tileSize = Util.HEIGHT / tiles;
		}

		ships = new ArrayList<>();
		ships.add(new SmallShip(2, 2));
		ships.add(new MediumShip(4, 2));
		ships.add(new LargeShip(6, 2));
		justRotated = hasSelected = justClicked = false;
	}

	public void render(Graphics2D g) {

		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				g.drawImage(Util.images.get("water"), i * Util.tileSize, j * Util.tileSize, Util.tileSize,
						Util.tileSize, null);
			}
		}
		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				if (i * Util.tileSize < Util.mouseX && i * Util.tileSize + Util.tileSize > Util.mouseX
						&& j * Util.tileSize < Util.mouseY && j * Util.tileSize + Util.tileSize > Util.mouseY) {
				}

				g.setColor(Color.black);
				g.drawRect(i * Util.tileSize, j * Util.tileSize, Util.tileSize, Util.tileSize);
			}
		}

		for (Ship s : ships) {
			s.render(g);
		}

	}

	public void update() {

		for (Ship s : ships) {
			if (InputHandler.mousePressed) {
				if (s.mouseOver() && !s.isSelected() && !justClicked && !hasSelected) {
					s.select();
					hasSelected = true;
					justClicked = true;
				} else if (s.isSelected() && !justClicked && hasSelected) {
					s.drop(); //TODO implementar colisiones con otros barcos. (Se puede mostrar un mensaje de error con animaciónes).
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

}
