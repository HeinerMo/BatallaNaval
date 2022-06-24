package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CardLayout layout;
	private JMenuBar jmbMenuBar;
	private JMenuItem jmInicio, jmAyuda, jmSalonFama, jmAbrirPartida;
	InicioPanel inicioPanel;

	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		layout = new CardLayout(0, 0);
		initMenu();
		this.setLayout(layout);
		initPanels();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initPanels() {
		//Agregar paneles a la ventana
		inicioPanel= new InicioPanel(this);
		AyudaPanel ayudaPanel = new AyudaPanel(this);
		SalonFamaPanel salonFamaPanel = new SalonFamaPanel(this);
		AbrirPartidaPanel abrirPartidaPanel = new AbrirPartidaPanel(this);

		this.add(inicioPanel);
		this.add(ayudaPanel);
		this.add(salonFamaPanel);
		this.add(abrirPartidaPanel);

		//Agregar paneles a la distribución
		layout.addLayoutComponent(inicioPanel, "inicioPanel");
		layout.addLayoutComponent(ayudaPanel, "ayudaPanel");
		layout.addLayoutComponent(salonFamaPanel, "salonFamaPanel");
		layout.addLayoutComponent(abrirPartidaPanel, "abrirPartidaPanel");

	}

	private void initMenu() {
		this.jmbMenuBar = new JMenuBar();
		this.setJMenuBar(jmbMenuBar);

		this.jmInicio = new JMenuItem("Inicio");
		jmInicio.setActionCommand("inicio");
		this.jmInicio.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmInicio.addActionListener(this);
		this.jmbMenuBar.add(this.jmInicio);

		this.jmAyuda = new JMenuItem("Ayuda");
		jmAyuda.setActionCommand("ayuda");
		this.jmAyuda.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmAyuda.addActionListener(this);
		this.jmbMenuBar.add(this.jmAyuda);

		this.jmSalonFama = new JMenuItem("Salón de la fama");
		jmSalonFama.setActionCommand("salonFama");
		this.jmSalonFama.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmSalonFama.addActionListener(this);
		this.jmbMenuBar.add(this.jmSalonFama);

		this.jmAbrirPartida = new JMenuItem("Abrir partida");
		jmAbrirPartida.setActionCommand("abrirPartida");
		this.jmAbrirPartida.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmAbrirPartida.addActionListener(this);
		this.jmbMenuBar.add(this.jmAbrirPartida);

	}// initMenu

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("inicio")) {
			layout.show(this.getContentPane(), "inicioPanel");
		} else if (e.getActionCommand().equals("ayuda")){
			layout.show(this.getContentPane(), "ayudaPanel");
		} else if (e.getActionCommand().equals("salonFama")){
			layout.show(this.getContentPane(), "salonFamaPanel");
		} else if (e.getActionCommand().equals("abrirPartida")){
			layout.show(this.getContentPane(), "abrirPartidaPanel");
		}else if (e.getActionCommand().equals("TipoNaves")){
			this.inicioPanel.item();
			if(this.inicioPanel.item().equals("Tipo 1")){
				String cantidadNaves1 = JOptionPane.showInputDialog(null, "Ingrese la cantidad de naves tipo 1 que desea");
				try {
					int numero = Integer.parseInt(cantidadNaves1);
					}catch(NumberFormatException u){
					JOptionPane.showMessageDialog (null, "El dato digitado no es un número", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}else if (this.inicioPanel.item().equals("Tipo 2")){
				String cantidadNaves2 = JOptionPane.showInputDialog(null, "Ingrese la cantidad de naves tipo 2 que desea");
				try {
					int numero = Integer.parseInt(cantidadNaves2);
					}catch(NumberFormatException u){
					JOptionPane.showMessageDialog (null, "El dato digitado no es un número", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}else if(this.inicioPanel.item().equals("Tipo 3")){
				String cantidadNaves3 = JOptionPane.showInputDialog(null, "Ingrese la cantidad de naves tipo 3 que desea");
				try {
					int numero = Integer.parseInt(cantidadNaves3);
					}catch(NumberFormatException u){
					JOptionPane.showMessageDialog (null, "El dato digitado no es un número", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		}

		System.out.println(e.getActionCommand());
	}

}
