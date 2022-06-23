package game;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.InputHandler;
import entity.Ball;
import entity.Peg;

public class Game {

	private Ball balls[];
	public static int WIDTH, HEIGHT;
	private Peg pegs[];

	public Game() {
		balls = new Ball[1];
		pegs = new Peg[1];

		for (int i = 0; i < pegs.length; i++) {
			pegs[i] = new Peg(340, 440, 20);
		}

		for (int i = 0; i < balls.length; i++) {
			balls[i] = new Ball((int) (200), (int) (300), 5);
			balls[i].setMoving(true);
		}
	}

	public void render(Graphics2D g) {
		g.setColor(Color.white);
		g.fillOval(InputHandler.mouseX - 5, InputHandler.mouseY - 5, 10, 10);

		for (Peg peg: pegs) {
			peg.render(g);
		}
		
		for (Ball ball : balls) {
			ball.render(g);
		}
	}

	public void update() {
		for (Ball ball : balls) {
			ball.update();
			ball.checkPegs(pegs);
		}
	}

	public void mouseClicked() {
		System.out.println("Game got mouse event");
	}
}
