package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import engine.util.Util;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CardLayout layout;
	private JMenuBar jmbMenuBar;
	private JMenuItem jmInicio, jmAyuda, jmSalonFama, jmAbrirPartida;

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
		HomePanel home = new HomePanel(this);
		OtroPanel otro = new OtroPanel(this);

		this.add(home);
		this.add(otro);

		//Agregar paneles a la distribución
		layout.addLayoutComponent(home, "home");
		layout.addLayoutComponent(otro, "otro");

	}

	private void initMenu() {
		this.jmbMenuBar = new JMenuBar();
		this.setJMenuBar(jmbMenuBar);

		this.jmInicio = new JMenuItem("Inicio");
		jmInicio.setActionCommand("inicio");
		this.jmInicio.addActionListener(this);
		this.jmbMenuBar.add(this.jmInicio);

		this.jmAyuda = new JMenuItem("Ayuda");
		this.jmAyuda.addActionListener(this);
		this.jmbMenuBar.add(this.jmAyuda);

		this.jmSalonFama = new JMenuItem("Salón de la fama");
		this.jmSalonFama.addActionListener(this);
		this.jmbMenuBar.add(this.jmSalonFama);

		this.jmAbrirPartida = new JMenuItem("Abrir partida");
		this.jmAbrirPartida.addActionListener(this);
		this.jmbMenuBar.add(this.jmAbrirPartida);

	}// initMenu

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("otro")) {
			layout.show(this.getContentPane(), "otro");
		} else if (e.getActionCommand().equals("home") || e.getActionCommand().equals("inicio")){
			layout.show(this.getContentPane(), "home");
		}

		System.out.println(e.getActionCommand());
	}

}
