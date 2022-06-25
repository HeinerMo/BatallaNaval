package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.Util;


public class CreateNewGamePanel extends JPanel{

    private JButton jbtnVsPC,jbtnUnirse,jbtnCrear;


    public CreateNewGamePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
		this.setBackground(new Color(27,138,150));
        this.setName("CreateNewGamePanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jbtnVsPC = new JButton("Jugador vs PC");
        this.jbtnVsPC.setActionCommand("jugVSPc");
        this.jbtnVsPC.addActionListener(a);
        this.jbtnVsPC.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnVsPC.setBounds(290, 300, 200, 30);
        this.jbtnVsPC.setBackground(new Color(138,157,159));
        this.add(this.jbtnVsPC);

        this.jbtnUnirse = new JButton("Unirse a partida");
        this.jbtnUnirse.setActionCommand("Unirse");
        this.jbtnUnirse.addActionListener(a);
        this.jbtnUnirse.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnUnirse.setBounds(290, 400, 200, 30);
        this.jbtnUnirse.setBackground(new Color(138,157,159));
        this.add(this.jbtnUnirse);

        this.jbtnCrear = new JButton("Crear Partida");
        this.jbtnCrear.setActionCommand("Crear");
        this.jbtnCrear.addActionListener(a);
        this.jbtnCrear.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnCrear.setBounds(290, 500, 200, 30);
        this.jbtnCrear.setBackground(new Color(138,157,159));
        this.add(this.jbtnCrear);

    }// initLabels
}

