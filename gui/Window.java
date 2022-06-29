package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import util.Util;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CardLayout layout;
	private JMenuBar jmbMenuBar;
	private JMenuItem jmInicio, jmAyuda, jmSalonFama;
	private HomePanel homePanel;
	private HelpPanel helpPanel;
	private HallOfFamePanel hallOfFamePanel;
	private GamePanel gamePanel;
	private CreateNewGamePanel createNewGamePanel;
	private PlayerVsPcPanel playerVsPcPanel; 
	private JoinGamePanel joinGamePanel; 

	public Window() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		layout = new CardLayout(0, 0);
		initMenu();
		this.setLayout(layout);
		initPanels();
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void initPanels() {
		// Agregar paneles a la ventana
		homePanel = new HomePanel(this);
		helpPanel = new HelpPanel(this);
		hallOfFamePanel = new HallOfFamePanel(this);
		gamePanel = new GamePanel();
		createNewGamePanel = new CreateNewGamePanel(this);
		playerVsPcPanel = new PlayerVsPcPanel(this);
		joinGamePanel = new JoinGamePanel(this);

		this.add(homePanel);
		this.add(helpPanel);
		this.add(hallOfFamePanel);
		this.add(gamePanel);
		this.add(createNewGamePanel);
		this.add(playerVsPcPanel);
		this.add(joinGamePanel);

		// Agregar paneles a la distribución
		layout.addLayoutComponent(homePanel, "homePanel");
		layout.addLayoutComponent(helpPanel, "helpPanel");
		layout.addLayoutComponent(hallOfFamePanel, "hallOfFamePanel");
		layout.addLayoutComponent(gamePanel, "GamePanel");
		layout.addLayoutComponent(createNewGamePanel, "CreateNewGamePanel");
		layout.addLayoutComponent(playerVsPcPanel, "PlayerVsPcPanel");
		layout.addLayoutComponent(joinGamePanel, "JoinGamePanel");

	}

	private void initMenu() {
		this.jmbMenuBar = new JMenuBar();
		this.jmbMenuBar.setBackground(Color.BLACK);
        this.jmbMenuBar.setForeground(Color.WHITE);
		this.setJMenuBar(jmbMenuBar);

		this.jmInicio = new JMenuItem("Inicio");
		jmInicio.setActionCommand("home");
		this.jmInicio.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmInicio.addActionListener(this);
		this.jmInicio.setBackground(Color.BLACK);
        this.jmInicio.setForeground(Color.WHITE);
		this.jmbMenuBar.add(this.jmInicio);

		this.jmAyuda = new JMenuItem("Ayuda");
		jmAyuda.setActionCommand("help");
		this.jmAyuda.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmAyuda.addActionListener(this);
		this.jmAyuda.setBackground(Color.BLACK);
        this.jmAyuda.setForeground(Color.WHITE);
		this.jmbMenuBar.add(this.jmAyuda);

		this.jmSalonFama = new JMenuItem("Salón de la fama");
		jmSalonFama.setActionCommand("hallOfFame");
		this.jmSalonFama.setFont(new java.awt.Font("Tahoma", 0, 20));
		this.jmSalonFama.addActionListener(this);
		this.jmSalonFama.setBackground(Color.BLACK);
        this.jmSalonFama.setForeground(Color.WHITE);
		this.jmbMenuBar.add(this.jmSalonFama);

	}// initMenu

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("iniciarPartida")) {
			if (gamePanel.getGame() == null) {
				//verificar entradas de usuario
				int small, medium, large;
				if (Util.isNumber(playerVsPcPanel.getJtfShip1().getText())) {
					small = Integer.valueOf(playerVsPcPanel.getJtfShip1().getText());
				} else {
					small = 0;
				}
				if (Util.isNumber(playerVsPcPanel.getJtfShip2().getText())) {
					medium = Integer.valueOf(playerVsPcPanel.getJtfShip2().getText());
				} else {
					medium = 0;
				}
				if (Util.isNumber(playerVsPcPanel.getJtfShip3().getText())) {
					large = Integer.valueOf(playerVsPcPanel.getJtfShip3().getText());
				} else {
					large = 0;
				}
				
				if (small == 0 || medium == 0 || large == 0) {
					JOptionPane.showMessageDialog(this, "Debe ingresar un valor entero válido superior a cero.", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					gamePanel.RunGame(small, medium, large);
					layout.show(this.getContentPane(), "GamePanel");
				}
				
			} else {
				gamePanel.RunGame(0, 0, 0);
				layout.show(this.getContentPane(), "GamePanel");
			}
		} else {
			gamePanel.stopGame();
			if (e.getActionCommand().equals("home")) {
				layout.show(this.getContentPane(), "homePanel");
			} else if (e.getActionCommand().equals("help")) {
				layout.show(this.getContentPane(), "helpPanel");
			} else if (e.getActionCommand().equals("hallOfFame")) {
				layout.show(this.getContentPane(), "hallOfFamePanel");
			} else if (e.getActionCommand().equals("createGame")) {
				layout.show(this.getContentPane(), "CreateNewGamePanel");
			} else if (e.getActionCommand().equals("jugVSPc")) {
				playerVsPcPanel.getJtfShip1().setText("");
				playerVsPcPanel.getJtfShip2().setText("");
				playerVsPcPanel.getJtfShip3().setText("");
				layout.show(this.getContentPane(), "PlayerVsPcPanel");
			} else if (e.getActionCommand().equals("crear")) {
				playerVsPcPanel.getJtfShip1().setText("");
				playerVsPcPanel.getJtfShip2().setText("");
				playerVsPcPanel.getJtfShip3().setText("");
				layout.show(this.getContentPane(), "PlayerVsPcPanel");
			} else if (e.getActionCommand().equals("unirse")) {
				layout.show(this.getContentPane(), "JoinGamePanel");
			} else if (e.getActionCommand().equals("joinGame")) {
				layout.show(this.getContentPane(), "PlayerVsPcPanel");
			}
		}
		System.out.println(e.getActionCommand());
	}

}
