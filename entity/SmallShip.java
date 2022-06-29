package entity;

import java.awt.Graphics2D;

import util.Util;

public class SmallShip extends Ship {

    public SmallShip(int x, int y) {
        super(x, y);
		this.sections = new ShipSection[1];
		sections[0] = new ShipSection(x, y);
    }

    @Override
    public void render(Graphics2D g) {
        if (!rotated) {
            g.drawImage(Util.images.get("smallShip"), x * Util.tileSize, y * Util.tileSize, Util.tileSize, Util.tileSize, null);
        } else {
            g.drawImage(Util.rotateImage(Util.images.get("smallShip")), x * Util.tileSize, y * Util.tileSize, Util.tileSize, Util.tileSize,
                    null);
        }
        super.render(g);
    }

    @Override
    public void update() {
        super.update();
    }

}
