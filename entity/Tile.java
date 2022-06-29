package entity;

import java.awt.Graphics2D;
import util.Util;

public class Tile extends Entity {

    private int tileSize;

    public Tile(int x, int y) {
        super(x, y);
        if (Util.WIDTH <= Util.HEIGHT) {
			tileSize = Util.WIDTH / 10;
		} else {
			tileSize = Util.HEIGHT / 10;
		}
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(Util.images.get("water"), x * tileSize, y * tileSize, tileSize, tileSize, null);
    }
    
}
