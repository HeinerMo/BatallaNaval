package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.InputHandler;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private InputHandler inputs;
	public Window(int width, int height, InputHandler inputs) {
		//setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.inputs = inputs;
		
		
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		add(panel);
		panel.setBackground(Color.BLUE);

		panel.addMouseListener(this.inputs);
		panel.addMouseWheelListener(this.inputs);
		panel.addKeyListener(this.inputs);
		panel.addMouseMotionListener(this.inputs);
		

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void drawFrame(BufferedImage img) {
		panel.getGraphics().drawImage(img, 0, 0, null);
	}
	
	public boolean isMousePressed() {
		return inputs.isMousePressed();
	}

}
