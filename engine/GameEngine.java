package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.util.Util;
import game.Game;
import gui.Window;

public class GameEngine extends Thread {

	private int fps = 0;
	private int ups = 0;
	private BufferedImage buffer;
	private Window window;
	private Game game;

	public GameEngine(Window window, Game game) {
		this.window = window;
		this.game = game;
		buffer = new BufferedImage(Util.WIDTH, Util.HEIGHT, BufferedImage.TYPE_INT_RGB);
	}

	@Override
	public synchronized void start() {
		super.start();
		loop();
	}

	private void loop() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis(); //timer to count up to one second
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				ups++;
				delta--;
			}
			render();
			fps++;
			
			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				window.setTitle("Peggle Clone   |  UPS: " + ups + " FPS: " + fps);
				ups = 0;
				fps = 0;
			}
		}
	}

	private void update() {
		//Inputs
		
		
		//updates
		game.update();
	}

	private void render() {
		clearFrame();
		game.render((Graphics2D) buffer.getGraphics());
		window.drawFrame(buffer);
	}

	private void clearFrame() {
		Graphics g = buffer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, Util.WIDTH, Util.HEIGHT);
	}

}
