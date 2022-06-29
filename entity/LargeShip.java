package entity;

import java.awt.Graphics2D;

import util.Util;

public class LargeShip extends Ship {

    private boolean rotated = false;

    public LargeShip(int x, int y, int tileSize) {
        super(x, y, tileSize);
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
        super.render(g);
        if (rotated) {
            g.drawImage(Util.images.get("largeShip"), x * tileSize, y * tileSize, tileSize, tileSize * 4, null);
        } else {
            g.drawImage(Util.rotateImage(Util.images.get("largeShip")), x * tileSize, y * tileSize, tileSize * 4, tileSize , null);
        }
        for (ShipSection ss: sections) {
        	ss.render(g);
        }
    }

    @Override
    public void update() {
        super.update();

        for (ShipSection ss: sections) {
        	ss.update();
        }
    }
}