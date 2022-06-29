package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import util.Util;

public class VanishingMessage extends Animation{

	private float step, lastTime;
	private int steps, x, y;
	private String text;
	private float alpha;
	
	public VanishingMessage(String message, float duration, int x, int y) {
		super(duration);
		steps = 10;
		step = duration / steps;
		startingTime = Util.getTime() + 2;
		lastTime = startingTime;
		finished = false;
		alpha = 255f;
		this.x = x;
		this.y = y;
		this.text = message;
	}
	
	@Override
	protected void onUpdate() {
		super.onUpdate();
		
		if (Util.getTime() - lastTime >= step) {
			alpha -= (255f / (float) steps);
			if (alpha <= 0) {
				alpha = 0;
				finished = true;
			}
		}
		
	}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(0, 0, 0, (int) alpha));
		g.setFont(new Font("Consolas", 1, 20));
		g.drawString(text, x, y);
	}

}
