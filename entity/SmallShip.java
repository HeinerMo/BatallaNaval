package entity;

import java.awt.Graphics2D;

import util.Util;

public class SmallShip extends Ship{

    public SmallShip(int x, int y, int tileSize) {
        super(x, y, tileSize);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.drawImage(Util.images.get("smallShip"), x * tileSize, y * tileSize, tileSize, tileSize, null);
    }
    
}
