package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import util.Util;

import javax.imageio.ImageIO;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;

public class HelpPanel extends JPanel{
   
    JLabel jlFoto1, jlFoto2;
    private BufferedImage buffDesa1,buffDesa2;
    private Image image1,image2;
    private JLabel jlBienvenido,jlInfo, jlInstruc;
    private JTextArea jtaInstrc, jtaInfo;

    public HelpPanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
        this.setBackground(new Color(0x007b00) );
        this.setName("ayudaPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlBienvenido=new JLabel("¡Bienvenido a Battleship!");  
        this.jlBienvenido.setBounds(360,20, 350,30); 
        this.jlBienvenido.setFont(new java.awt.Font("Tahoma", 1, 27));
        this.jlBienvenido.setForeground(Color.WHITE);
        this.add(this.jlBienvenido); 

        this.jlInstruc=new JLabel("Instrucciones del juego");  
        this.jlInstruc.setBounds(25,60, 350,30); 
        this.jlInstruc.setFont(new java.awt.Font("Tahoma", 1, 20));
        this.jlInstruc.setForeground(Color.WHITE);
        this.add(this.jlInstruc); 

        String instrucciones="  1.Elija la cantidad de barcos que desea colocar."+ "\n"+ "\n"+
                            "  2.Coloque estratégicamente la totalidad de los barcos"+
                            "elegidos en la posición que desee, ya sea "+  "\n"+
                            "  horizontal o vertical (Debe colocarlos en menos de 1 minuto)."+ "\n"+ "\n"+
                            "  3.Para cambiar la orientacion del barco debe presionar"+
                            "la tecla “R”."+ "\n"+"\n"+
                            "  4.Al iniciar la partida debe adivinar en qué posición"+ 
                            "ocultó los barcos el oponente.";

        this.jtaInstrc = new JTextArea(instrucciones); //cadena de texto
        this.jtaInstrc.setBounds(25,110, 750,180);
        this.jtaInstrc.setBackground(new Color(0x007b00) );
        this.jtaInstrc.setForeground(Color.WHITE);
        this.jtaInstrc.setFont(new java.awt.Font("Tahoma", 0, 17));
        this.jtaInstrc.setEditable(false);
        this.add(this.jtaInstrc);

        this.jlInfo=new JLabel("Información de los desarrolladores");  
        this.jlInfo.setBounds(25,300, 400,30); 
        this.jlInfo.setFont(new java.awt.Font("Tahoma", 1, 20));
        this.jlInfo.setForeground(Color.WHITE);
        this.add(this.jlInfo);  

        this.jlFoto1 = new JLabel();
		this.jlFoto1.setBounds(25, 340, 200, 250);
		try {
            this.buffDesa1=ImageIO.read(getClass().getResourceAsStream("/resources/imgs/SusanF.jpeg"));
            this.image1 = this.buffDesa1.getScaledInstance(200, 250, this.image1.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlFoto1.setIcon(new ImageIcon(this.image1));
		this.add(this.jlFoto1);


        this.jlFoto2 = new JLabel();
		this.jlFoto2.setBounds(250, 320, 300, 300);
		try {
            this.buffDesa2=ImageIO.read(getClass().getResourceAsStream("/resources/imgs/Heiner.png"));
            this.image2 = this.buffDesa2.getScaledInstance(220, 240, this.image2.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlFoto2.setIcon(new ImageIcon(this.image2));
		this.add(this.jlFoto2);

        String informacion="     Nombre                      Contacto"+ "\n"+"\n"+
                            "Heiner Monge Lopéz     heinermongelopez@gmail.com"+"\n"+"\n"+
                            "Susan Sojo Castro        sojos204@gmail.com";

        this.jtaInfo = new JTextArea(informacion); //cadena de texto
        this.jtaInfo.setBounds(490,400, 750,250);
        this.jtaInfo.setBackground(new Color(0x007b00) );
        this.jtaInfo.setForeground(Color.WHITE);
        this.jtaInfo.setFont(new java.awt.Font("Tahoma", 0, 17));
        this.jtaInfo.setEditable(false);
        this.add(this.jtaInfo);

    }// initLabels

}
