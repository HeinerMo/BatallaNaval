package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.imageio.ImageIO;
import javax.swing.Icon;


import java.awt.image.BufferedImage;
import java.io.IOException;

import engine.util.Util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AyudaPanel extends JPanel{
   
    JLabel jlFoto;
    private BufferedImage buffDesa;
    private Image image;
    private JLabel jlInfo, jlInstruc, jlSusan, jlHeiner, jlBach, jlUCR;

    public AyudaPanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
		this.setBackground(new Color(27,138,150));
        this.setName("ayudaPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlInstruc=new JLabel("Instrucciones");  
        this.jlInstruc.setBounds(25,20, 350,30); 
        this.jlInstruc.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlInstruc); 

        this.jlInfo=new JLabel("Información de los desarrolladores");  
        this.jlInfo.setBounds(440,20, 350,30); 
        this.jlInfo.setFont(new java.awt.Font("Tahoma", 0, 20));
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

        this.jlUCR=new JLabel("Universidad de Costa Rica");  
        this.jlUCR.setBounds(470,390, 350,30); 
        this.jlUCR.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlUCR);

        this.jlBach=new JLabel("Bach. Informática Empresarial");  
        this.jlBach.setBounds(460,440, 350,30); 
        this.jlBach.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlBach);


        this.jlHeiner=new JLabel("Heiner Monge López 24 años");  
        this.jlHeiner.setBounds(460,490, 350,30); 
        this.jlHeiner.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlHeiner);

        this.jlSusan=new JLabel("Susan Sojo Castro 22 años");  
        this.jlSusan.setBounds(460,540, 350,30); 
        this.jlSusan.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlSusan);




    }// initLabels

}
