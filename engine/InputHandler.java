package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputHandler implements MouseListener, KeyListener, MouseMotionListener {

	public static int mouseX;
	public static int mouseY;
	public boolean mousePressed;
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
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Pressed");
		mousePressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		InputHandler.mouseX = e.getX();
		InputHandler.mouseY = e.getY();
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		keys[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyCode());
		keys[e.getKeyCode()] = false;

	}

}
