package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.InputHandler;
import entity.Entity;
import util.Util;

public class Button extends Entity {

	private int width, height, radius;
	private Color foreground, background, border, hover, current, pressed;
	private float borderWidth;
	private String text;
	private ActionEvent event;
	private ActionListener listener;
	private boolean justPressed;

	public Button(int x, int y, String command) {
		super(x, y);
		width = 10;
		height = 10;
		foreground = Color.black;
		background = Color.white;
		border = Color.black;
		hover = Color.cyan;
		pressed = Color.orange;
		borderWidth = 2;
		text = "Button";
		listener = null;
		radius = 0;
		event = new ActionEvent(this, 1, command);
	}

	@Override
	public void update() {
		if (mouseOver()) {
			current = hover;
		} else {
			current = background;
		}

		if (mouseOver() && InputHandler.mousePressed) {
			current = pressed;
			if (!justPressed && listener != null) {
				listener.actionPerformed(event);
			}
			justPressed = true;
		} else {
			justPressed = false;
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(current);
		g.fillRoundRect(x, y, width, height, radius, radius);
		g.setColor(foreground);
		g.setStroke(new BasicStroke(borderWidth));
		g.drawRoundRect(x, y, width, height, radius, radius);
		g.setFont(new Font("", 1, 18));
		g.drawString(text, x + width / 4, y + height / 2);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public Color getBorder() {
		return border;
	}

	public void setBorder(Color border) {
		this.border = border;
	}

	public float getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(float borderWidth) {
		this.borderWidth = borderWidth;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ActionEvent getEvent() {
		return event;
	}

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}

	public Color getHover() {
		return hover;
	}

	public void setHover(Color hover) {
		this.hover = hover;
	}

	public Color getPressed() {
		return pressed;
	}

	public void setPressed(Color pressed) {
		this.pressed = pressed;
	}

	public boolean mouseOver() {
		if (x < Util.mouseX && x + width > Util.mouseX && y < Util.mouseY && y + height > Util.mouseY) {
			return true;
		}
		return false;
	}

}
