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

public class PlayerVsPcPanel extends JPanel{

    private JLabel  jlShip1,jlShip2,jlShip3, jlShips;
    private JTextField  jtfShip1,jtfShip2,jtfShip3;
    private JButton jbtnLoadGame;

    JLabel jlImgShip1,jlImgShip2,jlImgShip3;


    public PlayerVsPcPanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
        this.setBackground(new Color(0x007b00) );
        this.setName("playerVsPcPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlShips=new JLabel("Elija el tipo de nave y su respectiva cantidad");  
        this.jlShips.setBounds(200,50, 450,30);  
        this.jlShips.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlShips.setForeground(Color.WHITE);
        this.add(this.jlShips); 

        this.jlShip1=new JLabel("Panga");  
        this.jlShip1.setBounds(200,100, 450,30);  
        this.jlShip1.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlShip1.setForeground(Color.WHITE);
        this.add(this.jlShip1); 

        this.jlImgShip1 = new JLabel();
		this.jlImgShip1.setBounds(200,40, 300, 300);
		this.jlImgShip1.setIcon(new ImageIcon(Util.rotateImage(Util.images.get("smallShip"))));
		this.add(this.jlImgShip1);

        this.jtfShip1=new JTextField();  
        this.jtfShip1.setBounds(350,180, 200,30);  
        this.jtfShip1.setBackground(Color.BLACK);
        this.jtfShip1.setForeground(Color.WHITE);
        this.jtfShip1.setFont(new java.awt.Font("Tahoma", 0, 15));
        this.add(this.jtfShip1); 

        this.jlShip2=new JLabel("Barco");  
        this.jlShip2.setBounds(200,250, 450,30);  
        this.jlShip2.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlShip2.setForeground(Color.WHITE);
        this.add(this.jlShip2); 

        this.jlImgShip2 = new JLabel();
		this.jlImgShip2.setBounds(200,190, 300, 300);
		this.jlImgShip2.setIcon(new ImageIcon(Util.rotateImage(Util.images.get("mediumShip"))));
		this.add(this.jlImgShip2);

        this.jtfShip2=new JTextField();  
        this.jtfShip2.setBounds(350,330, 200,30); 
        this.jtfShip2.setBackground(Color.BLACK);
        this.jtfShip2.setForeground(Color.WHITE); 
        this.jtfShip2.setFont(new java.awt.Font("Tahoma", 0, 15));
        this.add(this.jtfShip2); 

        this.jlShip3=new JLabel("Buque");  
        this.jlShip3.setBounds(200,400, 450,30);  
        this.jlShip3.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlShip3.setForeground(Color.WHITE);
        this.add(this.jlShip3); 

        this.jlImgShip3 = new JLabel();
		this.jlImgShip3.setBounds(180,340, 300, 300);
		this.jlImgShip3.setIcon(new ImageIcon(Util.rotateImage(Util.images.get("largeShip"))));
		this.add(this.jlImgShip3);

        this.jtfShip3=new JTextField();  
        this.jtfShip3.setBounds(350,480, 200,30);  
        this.jtfShip3.setBackground(Color.BLACK);
        this.jtfShip3.setForeground(Color.WHITE); 
        this.jtfShip3.setFont(new java.awt.Font("Tahoma", 0, 15));
        this.add(this.jtfShip3); 

        this.jbtnLoadGame = new JButton("Cargar Partida");
        this.jbtnLoadGame.setActionCommand("cargarPartidaPlayerVsPc");
        this.jbtnLoadGame.addActionListener(a);
        this.jbtnLoadGame.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnLoadGame.setBounds(300, 600, 200, 30);
        this.jbtnLoadGame.setBackground(Color.WHITE);
        this.jbtnLoadGame.setForeground(Color.BLACK);
        this.add(this.jbtnLoadGame);
    }// initLabels
}
