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
	private boolean rotate, justRotated;

	public Game() {
		if (Util.WIDTH <= Util.HEIGHT) {
			Util.tileSize = Util.WIDTH / tiles;
		} else {
			Util.tileSize = Util.HEIGHT / tiles;
		}

		ships = new ArrayList<>();
		ships.add(new SmallShip(2, 2, Util.tileSize));
		ships.add(new MediumShip(4, 2, Util.tileSize));
		ships.add(new LargeShip(6, 2, Util.tileSize));
		rotate = justRotated = false;
	}

	public void render(Graphics2D g) {

		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				g.drawImage(Util.images.get("water"), i * Util.tileSize, j * Util.tileSize, Util.tileSize, Util.tileSize, null);
			}
		}
		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				if (i * Util.tileSize < InputHandler.mouseX
						&& i * Util.tileSize + Util.tileSize > InputHandler.mouseX
						&& j * Util.tileSize < InputHandler.mouseY
						&& j * Util.tileSize + Util.tileSize > InputHandler.mouseY) {
					g.setColor(new Color(0, 255, 0, 100));
					g.fillRect(i * Util.tileSize, j * Util.tileSize, Util.tileSize, Util.tileSize);
					if (!rotate) {
						g.drawImage(Util.images.get("largeShip"), i * Util.tileSize, j * Util.tileSize, Util.tileSize, Util.tileSize * 4,
								null);
					} else {
						g.drawImage(Util.rotateImage(Util.images.get("largeShip")), i * Util.tileSize, j * Util.tileSize,
								Util.tileSize * 4, Util.tileSize,
								null);
					}
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
		
		if (InputHandler.keys[82] && !justRotated) {
			rotate = !rotate;
			justRotated = true;
		} else if (!InputHandler.keys[82] && justRotated){
			justRotated = false;
		}

		for (Ship s : ships) {
			s.update();
		}
	}
}
