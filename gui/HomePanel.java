package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.util.Util;

public class HomePanel extends JPanel{

    private JButton button;
    
    public HomePanel(ActionListener a) {
        setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
        setBackground(Color.GREEN);
        button = new JButton("Otro");
        button.addActionListener(a);
        button.setActionCommand("otro");
        this.add(button);
        this.setName("home");
    }
}
