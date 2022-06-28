package entity;

import java.awt.Graphics2D;

import util.Util;

public class LargeShip extends Ship {

    private boolean rotated = false;

    public LargeShip(int x, int y, int tileSize) {
        super(x, y, tileSize);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        if (rotated) {
            g.drawImage(Util.images.get("largeShip"), x * tileSize, y * tileSize, tileSize, tileSize * 4, null);
        } else {
            g.drawImage(Util.rotateImage(Util.images.get("largeShip")), x * tileSize, y * tileSize, tileSize * 4, tileSize , null);
        }
    }

    @Override
    public void update() {
        super.update();
    }
}