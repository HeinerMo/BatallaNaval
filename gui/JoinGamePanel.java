package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Util;

public class JoinGamePanel extends JPanel {
    private JLabel jlName;
    private JTextField jtfName;
    private JButton jbtnJoin;


    public JoinGamePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
        this.setBackground(new Color(0x007b00) );
        this.setName("joinGamePanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlName=new JLabel("Ingrese el nombre del oponente");
        this.jlName.setBounds(260,100, 300,30);
        this.jlName.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlName.setForeground(Color.WHITE);
        this.add(this.jlName);

        this.jtfName=new JTextField();  
        this.jtfName.setBounds(290,150, 200,30);  
        this.jtfName.setBackground(Color.BLACK);
        this.jtfName.setForeground(Color.WHITE);
        this.jtfName.setFont(new java.awt.Font("Tahoma", 0, 15));
        this.add(this.jtfName); 

        this.jbtnJoin = new JButton("Unirse");
        this.jbtnJoin.setActionCommand("joinGame");
        this.jbtnJoin.addActionListener(a);
        this.jbtnJoin.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnJoin.setBounds(290, 250, 200, 30);
        this.jbtnJoin.setBackground(Color.WHITE);
        this.jbtnJoin.setForeground(Color.BLACK);
        this.add(this.jbtnJoin);
    }// initLabels
    
}
