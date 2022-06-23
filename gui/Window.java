package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.InputHandler;
import engine.util.Util;
import java.awt.CardLayout;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private InputHandler inputs;


	public Window(InputHandler inputs) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.inputs = inputs;
		this.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		panel.setBackground(Color.BLUE);

		panel.addMouseListener(this.inputs);
		panel.addMouseWheelListener(this.inputs);
		panel.addKeyListener(this.inputs);
		panel.addMouseMotionListener(this.inputs);

		HomePanel home = new HomePanel();
		this.add(panel);
		this.add(home);
		

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//TODO move this to game panel
	public void drawFrame(BufferedImage img) {
		panel.getGraphics().drawImage(img, 0, 0, null);
	}
	
	public boolean isMousePressed() {
		return inputs.isMousePressed();
	}

}
