package entity;

import java.awt.Graphics2D;

import util.Util;

public class LargeShip extends Ship {

    public LargeShip(int x, int y, int tileSize) {
        super(x, y, tileSize);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.drawImage(Util.images.get("largeShip"), x * tileSize, y * tileSize, tileSize, tileSize * 4,null);
    }
}