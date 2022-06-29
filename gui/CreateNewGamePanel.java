package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Util;


public class CreateNewGamePanel extends JPanel{

    private JButton jbtnVsPC,jbtnUnirse,jbtnCrear;
    private JLabel jlModo;


    public CreateNewGamePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
        this.setBackground(new Color(0x007b00) );
        this.setName("CreateNewGamePanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlModo=new JLabel("Elija el modo de juego");
        this.jlModo.setBounds(390,100, 200,30);
        this.jlModo.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlModo.setForeground(Color.WHITE);
        this.add(this.jlModo);


        this.jbtnVsPC = new JButton("Jugador vs PC");
        this.jbtnVsPC.setActionCommand("jugVSPc");
        this.jbtnVsPC.addActionListener(a);
        this.jbtnVsPC.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnVsPC.setBounds(390, 200, 200, 30);
        this.jbtnVsPC.setBackground(Color.WHITE);
        this.jbtnVsPC.setForeground(Color.BLACK);
        this.add(this.jbtnVsPC);

        this.jbtnUnirse = new JButton("Unirse a partida");
        this.jbtnUnirse.setActionCommand("unirse");
        this.jbtnUnirse.addActionListener(a);
        this.jbtnUnirse.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnUnirse.setBounds(390, 300, 200, 30);
        this.jbtnUnirse.setBackground(Color.WHITE);
        this.jbtnUnirse.setForeground(Color.BLACK);
        this.add(this.jbtnUnirse);

        this.jbtnCrear = new JButton("Crear Partida");
        this.jbtnCrear.setActionCommand("crear");
        this.jbtnCrear.addActionListener(a);
        this.jbtnCrear.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnCrear.setBounds(390, 400, 200, 30);
        this.jbtnCrear.setBackground(Color.WHITE);
        this.jbtnCrear.setForeground(Color.BLACK);
        this.add(this.jbtnCrear);

    }// initLabels
}

