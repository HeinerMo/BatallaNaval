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
    private InputHandler inputs;

    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
        
        inputs = InputHandler.getInstance();
        this.addKeyListener(inputs);
        this.addMouseMotionListener(inputs);
        this.addMouseListener(inputs);
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);
        this.requestFocusInWindow();
    }

    public void RunGame() {
        
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
