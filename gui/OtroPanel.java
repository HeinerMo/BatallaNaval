package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.util.Util;

public class OtroPanel extends JPanel{
   
    private JButton jbtnJugar;

    public OtroPanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));

		this.setLayout(null);
		this.initLabels(a);
		this.setBackground(Color.gray);
        this.setName("otro");
	}// constructor

    void initLabels(ActionListener a) {

        this.jbtnJugar = new JButton("Home");
        jbtnJugar.setActionCommand("home");
        this.jbtnJugar.addActionListener(a);
        this.jbtnJugar.setBounds(350, 500, 100, 30);
        this.add(this.jbtnJugar);

    }// initLabels

}
