package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

import engine.GameEngine;
import engine.InputHandler;
import game.Game;
import util.Util;

public class GamePanel extends JPanel {

    private GameEngine engine;
    private Game game;

    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
        this.addKeyListener(InputHandler.getInstance());
        this.addMouseMotionListener(InputHandler.getInstance());
        this.addMouseListener(InputHandler.getInstance());
        this.setFocusable(true);
    }

    public void RunGame() {
    	this.requestFocus();
        
        if (game == null) {
            game = new Game();
        }
        stopGame();
        engine = new GameEngine(this.getGraphics(), game);
        engine.setGraphics(this.getGraphics());
        engine.start();
    }

    public void stopGame() {
        if (engine != null) {
            engine.setRunning(false);
        }
    }

}
