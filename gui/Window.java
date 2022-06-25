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
		HomePanel homePanel= new HomePanel(this);
		HelpPanel helpPanel = new HelpPanel(this);
		HallOfFamePanel hallOfFamePanel = new HallOfFamePanel(this);
		OpenGamePanel openGamePanel = new OpenGamePanel(this);

		this.add(homePanel);
		this.add(helpPanel);
		this.add(hallOfFamePanel);
		this.add(openGamePanel);

		//Agregar paneles a la distribución
		layout.addLayoutComponent(homePanel, "homePanel");
		layout.addLayoutComponent(helpPanel, "helpPanel");
		layout.addLayoutComponent(hallOfFamePanel, "hallOfFamePanel");
		layout.addLayoutComponent(openGamePanel, "openGamePanel");

	}

	private void initMenu() {
		this.jmbMenuBar = new JMenuBar();
		this.setJMenuBar(jmbMenuBar);

		this.jmInicio = new JMenuItem("Inicio");
		jmInicio.setActionCommand("home");
		this.jmInicio.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmInicio.addActionListener(this);
		this.jmbMenuBar.add(this.jmInicio);

		this.jmAyuda = new JMenuItem("Ayuda");
		jmAyuda.setActionCommand("help");
		this.jmAyuda.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmAyuda.addActionListener(this);
		this.jmbMenuBar.add(this.jmAyuda);

		this.jmSalonFama = new JMenuItem("Salón de la fama");
		jmSalonFama.setActionCommand("hallOfFame");
		this.jmSalonFama.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmSalonFama.addActionListener(this);
		this.jmbMenuBar.add(this.jmSalonFama);

		this.jmAbrirPartida = new JMenuItem("Abrir partida");
		jmAbrirPartida.setActionCommand("openGame");
		this.jmAbrirPartida.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmAbrirPartida.addActionListener(this);
		this.jmbMenuBar.add(this.jmAbrirPartida);

	}// initMenu

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("home")) {
			layout.show(this.getContentPane(), "homePanel");
		} else if (e.getActionCommand().equals("help")){
			layout.show(this.getContentPane(), "helpPanel");
		} else if (e.getActionCommand().equals("hallOfFame")){
			layout.show(this.getContentPane(), "hallOfFamePanel");
		} else if (e.getActionCommand().equals("openGame")){
			layout.show(this.getContentPane(), "openGamePanel");
		}
		System.out.println(e.getActionCommand());
	}

}
