package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.util.Util;

public class OpenGamePanel extends JPanel{
   
    private JLabel jlNombre, jlNaves;
    private JTextField jtfNombre;
    private JButton jbtnCargarPartidaGuardada;

    public OpenGamePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
		this.setBackground(new Color(27,138,150));
        this.setName("abrirPartidaPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlNombre=new JLabel("Ingrese su nombre");  
        this.jlNombre.setBounds(315,150, 200,30); 
        this.jlNombre.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlNombre);  

        this.jtfNombre=new JTextField();  
        this.jtfNombre.setBounds(300,200, 200,30);  
        this.add(this.jtfNombre); 

        this.jbtnCargarPartidaGuardada = new JButton("Cargar Partida");
        this.jbtnCargarPartidaGuardada.setActionCommand("PartidaGuardada");
        this.jbtnCargarPartidaGuardada.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnCargarPartidaGuardada.addActionListener(a);
        this.jbtnCargarPartidaGuardada.setBounds(300, 250, 200, 30);
        this.jbtnCargarPartidaGuardada.setBackground(new Color(138,157,159));
        this.add(this.jbtnCargarPartidaGuardada);
    }// initLabels

}

