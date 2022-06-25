package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Util;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;

public class HomePanel extends JPanel{

    private JLabel jlName;
    private JTextField jtfName;
    private JButton jbtnCreate,jbtnLoad;


    public HomePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
		this.setBackground(new Color(27,138,150));
        this.setName("homePanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlName=new JLabel("Ingrese su nombre");
        this.jlName.setBounds(300,100, 200,30);
        this.jlName.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlName);

        this.jtfName=new JTextField();  
        this.jtfName.setBounds(290,150, 200,30);  
        this.add(this.jtfName); 

        this.jbtnCreate = new JButton("Crear Partida");
        this.jbtnCreate.setActionCommand("createGame");
        this.jbtnCreate.addActionListener(a);
        this.jbtnCreate.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnCreate.setBounds(290, 250, 200, 30);
        this.jbtnCreate.setBackground(new Color(138,157,159));
        this.add(this.jbtnCreate);

        this.jbtnLoad = new JButton("Cargar Partida");
        this.jbtnLoad.setActionCommand("loadGame");
        this.jbtnLoad.addActionListener(a);
        this.jbtnLoad.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnLoad.setBounds(290, 300, 200, 30);
        this.jbtnLoad.setBackground(new Color(138,157,159));
        this.add(this.jbtnLoad);
    }// initLabels
}
