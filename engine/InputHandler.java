package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import util.Util;

public class InputHandler implements MouseListener, KeyListener, MouseMotionListener {

	public static boolean mousePressed;
	private static InputHandler inputs;
	public static boolean[] keys;

	private InputHandler() {
		mousePressed = false;
		keys = new boolean[350];
	}

	/**
	 * Singleton.
	 * 
	 * @return Intance of inputhandler
	 */
	public static InputHandler getInstance() {
		if (inputs == null) {
			inputs = new InputHandler();
		}
		return inputs;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Util.updateMouse(e.getX(), e.getY());
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed: " + e.getKeyCode());
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released: " + e.getKeyCode());
		keys[e.getKeyCode()] = false;
	}

}
