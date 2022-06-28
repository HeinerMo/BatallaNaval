package entity;

import util.Util;
import java.awt.Graphics2D;

public class MediumShip extends Ship{
    private boolean rotated = false;

    public MediumShip(int x, int y, int tileSize) {
        super(x, y, tileSize);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        if (rotated) {
            g.drawImage(Util.images.get("mediumShip"), x * tileSize, y * tileSize, tileSize, tileSize * 2, null);
        } else {
            g.drawImage(Util.rotateImage(Util.images.get("mediumShip")), x * tileSize, y * tileSize, tileSize * 2, tileSize , null);
        }
    }

    @Override
    public void update() {
        super.update();
    }
}
