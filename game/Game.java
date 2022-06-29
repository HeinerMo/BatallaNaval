package game;

import java.awt.Graphics2D;

import entity.Board;
import util.Util;

public class Game {

	private Board board;

	public Game(int small, int medium, int large) {
		if (Util.WIDTH <= Util.HEIGHT) {
			Util.tileSize = Util.WIDTH / Util.TILES;
		} else {
			Util.tileSize = Util.HEIGHT / Util.TILES;
		}


		board = new Board(0, 0, small, medium, large);
	}

	public void render(Graphics2D g) {
		board.render(g);
	}

	public void update() {
		board.update();
	}

}
