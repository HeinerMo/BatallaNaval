package main;

import engine.GameEngine;
import engine.InputHandler;
import game.Game;
import gui.Window;

public class Main {

	public static void main(String[] args) {
		InputHandler inputs = new InputHandler();
		Window window = new Window(inputs);
		Game game = new Game();
		GameEngine engine = new GameEngine(window, game);
		engine.start();
	}

}