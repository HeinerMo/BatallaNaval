package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;


import engine.util.Util;

public class HomePanel extends JPanel{

    private JLabel jlName, jlShip1,jlShip2,jlShip3, jlShips;
    private JTextField jtfName, jtfShip1,jtfShip2,jtfShip3;
    private JButton jbtnLoadGame;

    JLabel jlImgShip1,jlImgShip2,jlImgShip3;
    private BufferedImage buffShip1,buffShip2,buffShip3;
    private Image image1,image2,image3;


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
        this.jlName.setBounds(30,50, 200,30);
        this.jlName.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlName);

        this.jtfName=new JTextField();  
        this.jtfName.setBounds(20,100, 200,30);  
        this.add(this.jtfName); 

        this.jlShips=new JLabel("Elija el tipo de nave y su respectiva cantidad");  
        this.jlShips.setBounds(300,50, 450,30);  
        this.jlShips.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlShips); 

        this.jlShip1=new JLabel("Caravela");  
        this.jlShip1.setBounds(300,100, 450,30);  
        this.jlShip1.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlShip1); 

        this.jlImgShip1 = new JLabel();
		this.jlImgShip1.setBounds(300,40, 300, 300);
		try {
            this.buffShip1=ImageIO.read(getClass().getResourceAsStream("/gui/carabela.png"));
            this.image1 = this.buffShip1.getScaledInstance(100, 100, this.image1.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlImgShip1.setIcon(new ImageIcon(this.image1));
		this.add(this.jlImgShip1);

        this.jtfShip1=new JTextField();  
        this.jtfShip1.setBounds(450,180, 200,30);  
        this.add(this.jtfShip1); 

        this.jlShip2=new JLabel("Pirata");  
        this.jlShip2.setBounds(300,250, 450,30);  
        this.jlShip2.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlShip2); 

        this.jlImgShip2 = new JLabel();
		this.jlImgShip2.setBounds(300,190, 300, 300);
		try {
            this.buffShip2=ImageIO.read(getClass().getResourceAsStream("/gui/carabela.png"));
            this.image2 = this.buffShip2.getScaledInstance(100, 100, this.image2.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlImgShip2.setIcon(new ImageIcon(this.image2));
		this.add(this.jlImgShip2);

        this.jtfShip2=new JTextField();  
        this.jtfShip2.setBounds(450,330, 200,30);  
        this.add(this.jtfShip2); 

        this.jlShip3=new JLabel("Pirata 2");  
        this.jlShip3.setBounds(300,400, 450,30);  
        this.jlShip3.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlShip3); 

        this.jlImgShip3 = new JLabel();
		this.jlImgShip3.setBounds(300,340, 300, 300);
		try {
            this.buffShip3=ImageIO.read(getClass().getResourceAsStream("/gui/carabela.png"));
            this.image3 = this.buffShip3.getScaledInstance(100, 100, this.image3.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlImgShip3.setIcon(new ImageIcon(this.image3));
		this.add(this.jlImgShip3);

        this.jtfShip3=new JTextField();  
        this.jtfShip3.setBounds(450,480, 200,30);  
        this.add(this.jtfShip3); 

        this.jbtnLoadGame = new JButton("Cargar Partida");
        this.jbtnLoadGame.setActionCommand("NuevaPartida");
        this.jbtnLoadGame.addActionListener(a);
        this.jbtnLoadGame.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnLoadGame.setBounds(300, 500, 200, 30);
        this.jbtnLoadGame.setBackground(new Color(138,157,159));
        this.add(this.jbtnLoadGame);
    }// initLabels
}
