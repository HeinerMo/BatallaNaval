package entity;

import util.Util;
import java.awt.Graphics2D;

public class MediumShip extends Ship{

    public MediumShip(int x, int y) {
        super(x, y);
		this.sections = new ShipSection[2];
		sections[0] = new ShipSection(x, y);
		sections[1] = new ShipSection(x, y + 1);
    }

    @Override
    public void render(Graphics2D g) {
        if (!rotated) {
            g.drawImage(Util.images.get("mediumShip"), x * Util.tileSize, y * Util.tileSize, Util.tileSize, Util.tileSize * 2, null);
        } else {
            g.drawImage(Util.rotateImage(Util.images.get("mediumShip")), x * Util.tileSize, y * Util.tileSize, Util.tileSize * 2, Util.tileSize , null);
        }
        super.render(g); //ultima linea siempre
    }

    @Override
    public void update() {
        super.update();
    }
}
