package gui;

import java.awt.Color;
import java.awt.Graphics2D;

public class Button extends Clickable {

	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void render(Graphics2D g) {
		if (super.mouseOver()) {
			g.setColor(Color.cyan);
		} else {
			g.setColor(Color.red);
		}
		g.fillRect(x, y, width, height);
	}

}
