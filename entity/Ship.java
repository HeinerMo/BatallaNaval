package entity;

import java.awt.Graphics2D;

public class Ship extends Entity {

    protected int tileSize;
    protected ShipSection[] sections;

    public Ship(int x, int y, int tileSize) {
        super(x, y);
        this.tileSize = tileSize;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g) {
    }

}
