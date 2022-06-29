package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import engine.Animation;
import engine.InputHandler;
import engine.VanishingMessage;
import util.Util;

public class Board extends Entity {

	private ArrayList<Ship> ships;
	private boolean justRotated, hasSelected, justClicked;
	private ArrayList<Animation> animations;

	public Board(int x, int y, int small, int medium, int large) {
		super(x, y);
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
	}

	@Override
	public void update() {
		boolean hasSelected = false;
		//Determinar si alguna nave se encuentra seleccionada
		for (Ship s : ships) {
			if (s.isSelected) {
				hasSelected = true;
				break;
			}
		}
		
		
		for (Ship s : ships) {
			s.updateDrop(ships);
			//si el mouse fue precionado, determinar si se debe tomar o colocar algún barco
			if (InputHandler.mousePressed) {
				if (s.mouseOver() && !s.isSelected() && !justClicked && !hasSelected) {
					s.select();
					hasSelected = true;
					justClicked = true;
				} else if (s.isSelected() && !justClicked && hasSelected) {

					if (s.canDrop()) {
						s.drop();
					} else {
						animations.add(new VanishingMessage("No puede colocar la nave en este lugar", 3, Util.mouseX, Util.mouseY));
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

		ArrayList<Animation> temp = new ArrayList<>();
		for (Animation a: animations) {
			a.update();
			if (a.isFinished()) {
				temp.add(a);
			}
		}
		
		//eliminar las animaciones que ya han finalizado
		for (Animation a: temp) {
			animations.remove(a);
		}
	}

	@Override
	public void render(Graphics2D g) {
		for (int i = 0; i < Util.TILES; i++) {
			for (int j = 0; j < Util.TILES; j++) {
				g.drawImage(Util.images.get("water"), i * Util.tileSize, j * Util.tileSize, Util.tileSize,
						Util.tileSize, null);
			}
		}
		for (int i = 0; i < Util.TILES; i++) {
			for (int j = 0; j < Util.TILES; j++) {
				if (i * Util.tileSize < Util.mouseX && i * Util.tileSize + Util.tileSize > Util.mouseX
						&& j * Util.tileSize < Util.mouseY && j * Util.tileSize + Util.tileSize > Util.mouseY) {
				}

				g.setColor(new Color(0, 0, 0, 20));
				g.drawRect(i * Util.tileSize, j * Util.tileSize, Util.tileSize, Util.tileSize);
			}
		}
		for (Ship s : ships) {
			s.render(g);
		}

		for (Animation a: animations) {
			a.render(g);
		}
	}

	public boolean isGameReady() {
		boolean ready = true;
		for (Ship s: ships) {
			if (!s.isReady()) {
				ready = false;
				break;
			}
		}
		return ready;
	}

}
