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
   
    JLabel jlFoto;
    private BufferedImage buffDesa;
    private Image image;
    private JLabel jlBienvenido,jlInfo, jlInstruc, jlSusan, jlHeiner,  jlSusanCorreo, jlHeinerCorreo;
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
        this.jlBienvenido.setBounds(260,20, 350,30); 
        this.jlBienvenido.setFont(new java.awt.Font("Tahoma", 1, 27));
        this.jlBienvenido.setForeground(Color.WHITE);
        this.add(this.jlBienvenido); 

        this.jlInstruc=new JLabel("Instrucciones del juego");  
        this.jlInstruc.setBounds(25,90, 350,30); 
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
        this.jtaInstrc.setBounds(25,130, 750,250);
        this.jtaInstrc.setBackground(new Color(0x007b00) );
        this.jtaInstrc.setForeground(Color.WHITE);
        this.jtaInstrc.setFont(new java.awt.Font("Tahoma", 0, 17));
        this.jtaInstrc.setEditable(false);
        this.add(this.jtaInstrc);

        this.jlInfo=new JLabel("Información de los desarrolladores");  
        this.jlInfo.setBounds(25,400, 400,30); 
        this.jlInfo.setFont(new java.awt.Font("Tahoma", 1, 20));
        this.jlInfo.setForeground(Color.WHITE);
        this.add(this.jlInfo);  

        this.jlFoto = new JLabel();
		this.jlFoto.setBounds(25, 440, 300, 300);
		try {
            this.buffDesa=ImageIO.read(getClass().getResourceAsStream("/gui/1.jpg"));
            this.image = this.buffDesa.getScaledInstance(300, 300, this.image.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlFoto.setIcon(new ImageIcon(this.image));
		this.add(this.jlFoto);

        String informacion="     Nombre                      Contacto"+ "\n"+"\n"+
                            "Heiner Monge Lopéz     heinermongelopez@gmail.com"+"\n"+"\n"+
                            "Susan Sojo Castro        sojos204@gmail.com";

        this.jtaInfo = new JTextArea(informacion); //cadena de texto
        this.jtaInfo.setBounds(370,480, 750,250);
        this.jtaInfo.setBackground(new Color(0x007b00) );
        this.jtaInfo.setForeground(Color.WHITE);
        this.jtaInfo.setFont(new java.awt.Font("Tahoma", 0, 17));
        this.jtaInfo.setEditable(false);
        this.add(this.jtaInfo);


//
//heinermongelopez@gmail.com
    }// initLabels

}
