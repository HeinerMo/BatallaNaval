package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Ship;
import util.Util;

public class Game {

	private int tileSize;
	private int tiles = 10;
	private Image img;
	private Ship ship;

	public Game() {
		if (Util.WIDTH <= Util.HEIGHT) {
			tileSize = Util.WIDTH / tiles;
		} else {
			tileSize = Util.HEIGHT / tiles;
		}

		try {
			img = ImageIO.read(new File("resources/imgs/water.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ship = new Ship(4, 4, tileSize);
	}

	public void render(Graphics2D g) {

		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				g.drawImage(img, i * tileSize, j * tileSize, tileSize, tileSize, null);
			}
		}
		for (int i = 0; i < tiles; i++) {
			for (int j = 0; j < tiles; j++) {
				if (i * tileSize < Util.mouseX 
				&& i * tileSize + tileSize > Util.mouseX 
				&& j * tileSize < Util.mouseY
				&& j * tileSize + tileSize > Util.mouseY) {
					g.setColor(Color.green);
					g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
				}
				
				g.setColor(Color.black);
				g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
			}
		}

		ship.render(g);
	}

	public void update() {

	}
}
