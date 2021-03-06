package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import engine.Animation;
import entity.Board;
import gui.Button;
import util.Util;

public class Game implements ActionListener{

	private Board board;
	private Button button;

	public Game(int small, int medium, int large) {
		if (Util.WIDTH <= Util.HEIGHT) {
			Util.tileSize = Util.WIDTH / Util.TILES;
		} else {
			Util.tileSize = Util.HEIGHT / Util.TILES;
		}
		board = new Board(0, 0, small, medium, large);
		button = new Button((Util.WIDTH - 40 - 200), (Util.HEIGHT - 40) - 50, "iniciarJuego");
		button.setWidth(200);
		button.setHeight(50);
		button.setListener(this);
		button.setRadius(5);
		button.setBorderWidth(2);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setBorder(Color.white);
		button.setHover(Color.gray);
		button.setPressed(Color.cyan);
		button.setText("Iniciar Juego");
	}

	public void render(Graphics2D g) {
		board.render(g);
		button.render(g);
	}

	public void update() {
		board.update();
		button.update();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("iniciarJuego")) {
			if (board.isGameReady()) {
				this.board.isGameStarted(true);
			} else {
				JOptionPane.showMessageDialog(null, "Debe colocar todos los barcos.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		System.out.println(e.getActionCommand());
	}
	
	public boolean hasEnded() {
		return board.hasEnded();
	}

	public void setWinner(String name){
		this.board.setWinner(name);
	}
}
