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

	private int tileSize;
	private int tiles = 10;
	private ArrayList<Ship> ships;
	private boolean rotate;

	public Game() {
		if (Util.WIDTH <= Util.HEIGHT) {
			tileSize = Util.WIDTH / tiles;
		} else {
			tileSize = Util.HEIGHT / tiles;
		}

		ships = new ArrayList<>();
		ships.add(new SmallShip(2, 2, tileSize));
		ships.add(new MediumShip(4, 2, tileSize));
		ships.add(new LargeShip(6, 2, tileSize));
		rotate = false;
	}

	public void render(Graphics2D g) {

		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				g.drawImage(Util.images.get("water"), i * tileSize, j * tileSize, tileSize, tileSize, null);
			}
		}
		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				if (i * tileSize < InputHandler.mouseX
						&& i * tileSize + tileSize > InputHandler.mouseX
						&& j * tileSize < InputHandler.mouseY
						&& j * tileSize + tileSize > InputHandler.mouseY) {
					g.setColor(Color.green);
					g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					if (!rotate) {
						g.drawImage(Util.images.get("largeShip"), i * tileSize, j * tileSize, tileSize, tileSize * 4,
								null);
					} else {
						g.drawImage(Util.rotateImage(Util.images.get("largeShip")), i * tileSize, j * tileSize,
								tileSize * 4, tileSize,
								null);
					}
				}

				g.setColor(Color.black);
				g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
			}
		}

		for (Ship s : ships) {
			s.render(g);
		}

	}

	public void update() {

		for (Ship s : ships) {
			s.update();
		}
	}
}
