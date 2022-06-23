package gui;

import engine.InputHandler;

public class Clickable {
	
	protected final int x, y, width, height;

	public Clickable(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public boolean mouseOver() {
		if (x < InputHandler.mouseX && x + width > InputHandler.mouseX 
				&& y < InputHandler.mouseY && y + height > InputHandler.mouseY) {
			return true;
		}
		return false;
	}
	
	
}
