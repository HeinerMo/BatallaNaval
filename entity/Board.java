package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.DataManager;
import data.PersonData;
import engine.Animation;
import engine.BulletAnimation;
import engine.InputHandler;
import engine.Sound;
import engine.VanishingMessage;
import util.Util;
import java.awt.Dimension;;

public class Board extends Entity {

	private ArrayList<Ship> ships;
	private boolean justRotated, justClicked, gamestarted;
	private ArrayList<Animation> animations;
	private CPU cpu;
	private boolean turno, ended;
	private BulletAnimation bullet;
	private ArrayList<HitMarker> markers;
	private float time;
	private String name;

	public Board(int x, int y, int small, int medium, int large) {
		super(x, y);
		markers = new ArrayList<>();
		bullet = new BulletAnimation(0, 0, 0);
		bullet.start();
		animations = new ArrayList<>();
		ships = new ArrayList<>();
		for (int i = 0; i < small; i++) {
			ships.add(new SmallShip(11, 0));
		}
		for (int i = 0; i < medium; i++) {
			ships.add(new MediumShip(12, 0));
		}
		for (int i = 0; i < large; i++) {
			ships.add(new LargeShip(13, 0));
		}
		justRotated = justClicked = false;
		cpu = new CPU();
		turno = gamestarted = ended = false;
		this.name = "";
	}

	@Override
	public void update() {
		moveShips();
		updateShips();
		updateAnimations();
		playerTurn();
		checkWinner();
		bullet.update();
	}

	private void updateShips() {
		for (Ship s : ships) {
			s.update();
		}
	}

	private void checkWinner() {
		if (cpu.hasLost()) {
			JOptionPane.showMessageDialog(null, "Has ganado");
			ended = true;
			time = Util.getTime() - time;
			DataManager.getInstance().addToRanking(name, time);
		} else {
			boolean lost = true;
			for (Ship s : ships) {
				if (!s.isDestroyed()) {
					lost = false;
					break;
				}
			}
			if (lost) {
				JOptionPane.showMessageDialog(null, "Has perdido");
				ended = true;
			}
		}
	}

	private void playerTurn() {
		if (turno && gamestarted && bullet.isFinished()) {
			animations.add(new VanishingMessage("Seleccione una casilla para disparar", 4, 100, 100));
			if (InputHandler.mousePressed) {
				int x = (Util.mouseX * 10) / Util.HEIGHT;
				int y = (Util.mouseY * 10) / Util.HEIGHT;
				if (x < 10 && y < 10) {
					if (!cpu.checkBullet(x, y)) {
						Sound sound = new Sound();
						sound.playSound("/resources/audio/miss.wav");
						animations.add(new VanishingMessage("¡Fallo!", 1, x * Util.tileSize, y * Util.tileSize));
					} else {
						Sound sound = new Sound();
						sound.playSound("/resources/audio/hit.wav");
						animations.add(new VanishingMessage("¡Acierto!", 1, x * Util.tileSize, y * Util.tileSize));
					}
					markers.add(new HitMarker(x, y, cpu.checkBullet(x, y)));
					bullet = new BulletAnimation(3, x, y);
					bullet.start();
					turno = !turno;
				}
			}
		}

		if (!turno && gamestarted && bullet.isFinished()) {
			Dimension dim = cpu.generateNewPosition();
			boolean hit = false;
			for (Ship sh : ships) {
				if (sh.checkBullet(dim.width, dim.height)) {
					hit = true;
				}

				if (!hit) {
					Sound sound = new Sound();
					sound.playSound("/resources/audio/miss.wav");
					animations.add(new VanishingMessage("¡Fallo!", 1, dim.width * Util.tileSize, dim.height * Util.tileSize));
				} else {
					Sound sound = new Sound();
					sound.playSound("/resources/audio/hit.wav");
					animations.add(new VanishingMessage("¡Acierto!", 1, dim.width * Util.tileSize, dim.height * Util.tileSize));
				}
			}
			bullet = new BulletAnimation(3, dim.width, dim.height);
			bullet.start();
			turno = !turno;
		}
	}

	private void updateAnimations() {
		ArrayList<Animation> temp = new ArrayList<>();
		for (Animation a : animations) {
			a.update();
			if (a.isFinished()) {
				temp.add(a);
			}
		}

		// eliminar las animaciones que ya han finalizado
		for (Animation a : temp) {
			animations.remove(a);
		}

	}

	private void moveShips() {
		if (!gamestarted) {
			boolean hasSelected = false;
			// Determinar si alguna nave se encuentra seleccionada
			for (Ship s : ships) {
				if (s.isSelected) {
					hasSelected = true;
					break;
				}
			}

			for (Ship s : ships) {
				s.updateDrop(ships);
				// si el mouse fue precionado, determinar si se debe tomar o colocar algún barco
				if (InputHandler.mousePressed) {
					if (s.mouseOver() && !s.isSelected() && !justClicked && !hasSelected) {
						s.select();
						hasSelected = true;
						justClicked = true;
					} else if (s.isSelected() && !justClicked && hasSelected) {

						if (s.canDrop()) {
							s.drop();
						} else {
							animations.add(new VanishingMessage("No puede colocar la nave en este lugar", 3,
									Util.mouseX, Util.mouseY));
						}
						hasSelected = false;
						justClicked = true;
					}
				} else {
					justClicked = false;
				}
				if (InputHandler.keys[82]) {
					if (!justRotated && s.isSelected()) {
						s.rotate();
						justRotated = true;
					} else if (!justRotated && s.isSelected()) {
						s.rotate();
						justRotated = true;
					}
				} else {
					justRotated = false;
				}
				s.update();
			}
		}
	}

	@Override
	public void render(Graphics2D g) {
		renderWater(g);
		renderGrid(g);
		for (HitMarker m : markers) {
			m.render(g);
		}
		renderShips(g);
		renderAnimations(g);
	}

	private void renderAnimations(Graphics2D g) {
		for (Animation a : animations) {
			a.render(g);
		}
		if (!bullet.isFinished()) {
			bullet.render(g);
		}
	}

	private void renderShips(Graphics2D g) {
		for (Ship s : ships) {
			s.render(g);
		}
	}

	public boolean isGameReady() {
		boolean ready = true;
		for (Ship s : ships) {
			if (!s.isReady()) {
				ready = false;
				break;
			}
		}
		return ready;
	}

	public void isGameStarted(boolean gameStarted) {
		this.gamestarted = gameStarted;
	}

	private void renderWater(Graphics2D g) {
		for (int i = 0; i < Util.TILES; i++) {
			for (int j = 0; j < Util.TILES; j++) {
				g.drawImage(Util.images.get("water"), i * Util.tileSize, j * Util.tileSize, Util.tileSize,
						Util.tileSize, null);
			}
		}
	}

	private void renderGrid(Graphics2D g) {
		for (int i = 0; i < Util.TILES; i++) {
			for (int j = 0; j < Util.TILES; j++) {
				if (i * Util.tileSize < Util.mouseX && i * Util.tileSize + Util.tileSize > Util.mouseX
						&& j * Util.tileSize < Util.mouseY && j * Util.tileSize + Util.tileSize > Util.mouseY) {
				}
				g.setColor(new Color(0, 0, 0, 20));
				g.drawRect(i * Util.tileSize, j * Util.tileSize, Util.tileSize, Util.tileSize);
			}
		}
	}

	public boolean hasEnded() {
		return ended;
	}

	public float getTime() {
		return time;
	}

	public void setWinner(String name) {
		this.name = name;
	}

}
