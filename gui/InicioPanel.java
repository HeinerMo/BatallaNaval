package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.util.Util;

public class InicioPanel extends JPanel{
   
    private JLabel jlNombre, jlNaves;
    private JTextField jtfNombre;
    private JComboBox jcbNaves;
    private JButton jbtnCargarNuevaPartida;


    public InicioPanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
		this.setBackground(new Color(27,138,150));
        this.setName("inicioPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlNombre=new JLabel("Ingrese su nombre");  
        this.jlNombre.setBounds(315,100, 200,30); 
        this.jlNombre.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlNombre);  

        this.jtfNombre=new JTextField();  
        this.jtfNombre.setBounds(300,150, 200,30);  
        this.add(this.jtfNombre); 

        this.jlNaves=new JLabel("Elija el tipo de nave y su  respectiva cantidad");  
        this.jlNaves.setBounds(200,200, 450,30);  
        this.jlNaves.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlNaves); 


        String tiposNaves[]={"Tipo 1","Tipo 2","Tipo 3"};        
        this.jcbNaves=new JComboBox(tiposNaves); 
        this.jcbNaves.setActionCommand("TipoNaves");
        this.jcbNaves.addActionListener(a);   
        this.jcbNaves.setBounds(300, 250,200,30);
        this.jcbNaves.setFont(new java.awt.Font("Tahoma", 0, 18));
        this.add(this.jcbNaves);

        this.jbtnCargarNuevaPartida = new JButton("Cargar Partida");
        this.jbtnCargarNuevaPartida.setActionCommand("NuevaPartida");
        this.jbtnCargarNuevaPartida.addActionListener(a);
        this.jbtnCargarNuevaPartida.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jbtnCargarNuevaPartida.setBounds(300, 350, 200, 30);
        this.jbtnCargarNuevaPartida.setBackground(new Color(138,157,159));
        this.add(this.jbtnCargarNuevaPartida);
    }// initLabels


    public String item(){
        return this.jcbNaves.getSelectedItem().toString();
    }
}
