package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Util;


public class HomePanel extends JPanel{

    private JLabel jlName;
    private JTextField jtfName;
    private JButton jbtnCreate,jbtnLoad;


    public HomePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
        this.setBackground(new Color(0x007b00) );
        this.setName("homePanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlName=new JLabel("Ingrese su nombre");
        this.jlName.setBounds(400,100, 200,30);
        this.jlName.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlName.setForeground(Color.WHITE);
        this.add(this.jlName);

        this.jtfName=new JTextField();  
        this.jtfName.setBounds(390,150, 200,30);  
        this.jtfName.setBackground(Color.BLACK);
        this.jtfName.setForeground(Color.WHITE);
        this.jtfName.setFont(new java.awt.Font("Tahoma", 0, 15));
        this.add(this.jtfName); 

        this.jbtnCreate = new JButton("Crear Partida");
        this.jbtnCreate.setActionCommand("createGame");
        this.jbtnCreate.addActionListener(a);
        this.jbtnCreate.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnCreate.setBounds(390, 250, 200, 30);
        this.jbtnCreate.setBackground(Color.WHITE);
        this.jbtnCreate.setForeground(Color.BLACK);
        this.add(this.jbtnCreate);

        this.jbtnLoad = new JButton("Cargar Partida");
        this.jbtnLoad.setActionCommand("loadGame");
        this.jbtnLoad.addActionListener(a);
        this.jbtnLoad.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnLoad.setBackground(Color.WHITE);
        this.jbtnLoad.setForeground(Color.BLACK);
        this.jbtnLoad.setBounds(390, 300, 200, 30);
        this.add(this.jbtnLoad);
    }// initLabels
}
