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
    private JLabel jlInfo, jlInstruc, jlSusan, jlHeiner,  jlSusanCorreo, jlHeinerCorreo;
    private JTextArea jtaInstrc;

    public HelpPanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
        this.setBackground(new Color(0x007b00) );
        this.setName("ayudaPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlInstruc=new JLabel("Instrucciones");  
        this.jlInstruc.setBounds(25,20, 350,30); 
        this.jlInstruc.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlInstruc.setForeground(Color.WHITE);
        this.add(this.jlInstruc); 

        String instrucciones="1.Coloque estratégicamente la totalidad de los barcos elegidos en la posición que desee,"+ "\n"+"ya sea horizontal o vertical *Debe colocarlos en menos de 1 minuto* ";
        this.jtaInstrc = new JTextArea(instrucciones); //cadena de texto
        this.jtaInstrc.setBounds(25,60, 400,400);
        this.jtaInstrc.setBackground(new Color(0x007b00) );
        this.jtaInstrc.setForeground(Color.WHITE);
        this.jtaInstrc.setFont(new java.awt.Font("Tahoma", 0, 16));
        this.jtaInstrc.setEditable(false);
        this.add(this.jtaInstrc);

        this.jlInfo=new JLabel("Información de los desarrolladores");  
        this.jlInfo.setBounds(440,20, 350,30); 
        this.jlInfo.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlInfo.setForeground(Color.WHITE);
        this.add(this.jlInfo);  

        this.jlFoto = new JLabel();
		this.jlFoto.setBounds(445, 60, 300, 300);
		try {
            this.buffDesa=ImageIO.read(getClass().getResourceAsStream("/gui/1.jpg"));
            this.image = this.buffDesa.getScaledInstance(300, 300, this.image.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlFoto.setIcon(new ImageIcon(this.image));
		this.add(this.jlFoto);

        this.jlHeiner=new JLabel("Heiner Monge López");  
        this.jlHeiner.setBounds(470,390, 350,30); 
        this.jlHeiner.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlHeiner.setForeground(Color.WHITE);
        this.add(this.jlHeiner);

        this.jlHeinerCorreo=new JLabel("heinermongelopez@gmail.com ");  
        this.jlHeinerCorreo.setBounds(460,440, 350,30); 
        this.jlHeinerCorreo.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlHeinerCorreo.setForeground(Color.WHITE);
        this.add(this.jlHeinerCorreo);


        this.jlSusan=new JLabel("Susan Sojo Castro");  
        this.jlSusan.setBounds(460,490, 350,30); 
        this.jlSusan.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlSusan.setForeground(Color.WHITE);
        this.add(this.jlSusan);

        this.jlSusanCorreo=new JLabel("sojos204@gmail.com");  
        this.jlSusanCorreo.setBounds(460,540, 350,30); 
        this.jlSusanCorreo.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jlSusanCorreo.setForeground(Color.WHITE);
        this.add(this.jlSusanCorreo);




    }// initLabels

}
