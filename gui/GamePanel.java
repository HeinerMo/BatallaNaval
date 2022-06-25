package gui;

import java.awt.Dimension;

import javax.swing.JPanel;


import engine.GameEngine;
import game.Game;
import util.Util;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements MouseMotionListener {

    private GameEngine engine;
    private Game game;

    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
        this.setFocusable(true);
        this.addMouseMotionListener(this);
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

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        Util.updateMouse(e.getX(), e.getY());
    }

}
