package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

import util.Util;

public class GamePanel extends JPanel{

    public GamePanel() {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
        this.setFocusable(true);
    }
    
}
