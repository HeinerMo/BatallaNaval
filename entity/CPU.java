package entity;

import java.util.ArrayList;

import java.awt.Dimension;

public class CPU {

	private ArrayList<Ship> shipsCPU;
	private ArrayList<Dimension> position;

	public CPU() {
		position = new ArrayList<>();
		shipsCPU = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				position.add(new Dimension(i, j));
			}
		}
		locateShips();
	}

	public void locateShips() {
		shipsCPU.add(new SmallShip(0, 0));
		shipsCPU.add(new SmallShip(4, 0));
		shipsCPU.add(new SmallShip(8, 0));

		shipsCPU.add(new MediumShip(1, 1));
		shipsCPU.add(new MediumShip(3, 1));
		shipsCPU.add(new MediumShip(7, 1));

		shipsCPU.add(new LargeShip(3, 4));
		shipsCPU.add(new LargeShip(7, 5));
		shipsCPU.add(new LargeShip(9, 4));
	}

	public Dimension generateNewPosition() {
		int index = 0, x = 0, y = 0;
		index = (int) (Math.random() * (position.size() - 1));
		if (position.size() > 0) {
			x = position.get(index).width;
			y = position.get(index).height;
			position.remove(index);
		}
		
		System.err.println("CPU");

		return new Dimension(x, y);
	}

	public boolean checkBullet(int x, int y) {
		boolean hit = false;
		for (Ship ss : shipsCPU) {
			if (ss.checkBullet(x, y)) {
				hit = true;
			}
		}
		return hit;
	}

	public boolean hasLost() {
		boolean lost = true;
		for (Ship s : shipsCPU) {
			if (!s.isDestroyed()) {
				lost = false;
				break;
			}
		}
		return lost;
	}
}
