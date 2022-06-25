package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.Game;
import util.Util;

public class GameEngine extends Thread {

	private int fps = 0;
	private int ups = 0;
	private BufferedImage buffer;
	private Graphics graphics;
	private Game game;
	private boolean running;

	public GameEngine(Graphics graphics, Game game) {
		this.graphics = graphics;
		this.game = game;
		buffer = new BufferedImage(Util.WIDTH, Util.HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	public void run() {
		super.run();
		loop();
	}


	private void loop() {
		
		running = true;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		
		while (running) {
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
				//window.setTitle("Stats:   |  UPS: " + ups + " FPS: " + fps);
				System.out.println("Stats:   |  UPS: " + ups + " FPS: " + fps);
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
		graphics.drawImage(buffer, 0, 0, null);
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	private void clearFrame() {
		Graphics g = buffer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, Util.WIDTH, Util.HEIGHT);
	}

	public void setGraphics(Graphics g) {
		this.graphics = g;
	}
}
