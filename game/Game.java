package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import entity.LargeShip;
import entity.MediumShip;
import entity.Ship;
import entity.SmallShip;
import util.Util;

public class Game {

	private int tileSize;
	private int tiles = 10;
	private ArrayList<Ship> ships;

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
	}

	public void render(Graphics2D g) {

		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				g.drawImage(Util.images.get("water"), i * tileSize, j * tileSize, tileSize, tileSize, null);
			}
		}
		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				if (i * tileSize < Util.mouseX 
				&& i * tileSize + tileSize > Util.mouseX 
				&& j * tileSize < Util.mouseY
				&& j * tileSize + tileSize > Util.mouseY) {
					g.setColor(Color.green);
					//g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					g.drawImage(Util.images.get("largeShip"), i * tileSize, j * tileSize, tileSize, tileSize * 4,null);
				}
				
				g.setColor(Color.black);
				g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
			}
		}

		for (Ship s: ships) {
			s.render(g);
		}

	}

	public void update() {

	}
}
