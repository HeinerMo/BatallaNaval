package entity;

import java.awt.Graphics2D;

import util.Util;

public class LargeShip extends Ship {


	public LargeShip(int x, int y) {
		super(x, y);
		this.sections = new ShipSection[4];
		sections[0] = new ShipSection(x, y);
		sections[1] = new ShipSection(x, y + 1);
		sections[2] = new ShipSection(x, y + 2);
		sections[3] = new ShipSection(x, y + 3);
		sections[0].setDamaged(true);
		sections[1].setDamaged(true);
		sections[2].setDamaged(true);
		sections[3].setDamaged(true);
	}

	@Override
	public void render(Graphics2D g) {
		if (!rotated) {
			g.drawImage(Util.images.get("largeShip"), x * Util.tileSize, y * Util.tileSize, Util.tileSize, Util.tileSize * 4, null);
		} else {
			g.drawImage(Util.rotateImage(Util.images.get("largeShip")), x * Util.tileSize, y * Util.tileSize, Util.tileSize * 4,
					Util.tileSize, null);
		}
		super.render(g);
	}

	@Override
	public void update() {
		super.update();
	}

}