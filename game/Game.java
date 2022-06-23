package game;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.InputHandler;

public class Game {

	public Game() {

	}

	public void render(Graphics2D g) {
		g.setColor(Color.white);
		g.fillOval(InputHandler.mouseX - 5, InputHandler.mouseY - 5, 10, 10);
	}

	public void update() {

	}

	public void mouseClicked() {
		System.out.println("Game got mouse event");
	}
}
