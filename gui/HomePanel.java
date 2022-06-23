package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import engine.util.Util;

public class HomePanel extends JPanel{
    
    public HomePanel() {
        setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
        setBackground(Color.GREEN);
    }
}
