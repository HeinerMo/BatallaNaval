package main;

import engine.GameEngine;
import engine.InputHandler;
import game.Game;
import gui.Window;

public class Main {

	public static void main(String[] args) {
		int width = 700;
		int height = 700;
		InputHandler inputs = new InputHandler();
		Window window = new Window(width, height, inputs);
		Game game = new Game();
		GameEngine engine = new GameEngine(width, height, window, game);
		engine.start();
	}

}