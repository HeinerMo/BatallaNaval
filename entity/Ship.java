package entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ship extends Entity {

    private Image img;
    private int tileSize;

    public Ship(int x, int y, int tile) {
        super(x, y);
        this.tileSize = tile;
        try {
            img = ImageIO.read(new File("gui/carabela.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(img, x * tileSize, y * tileSize, tileSize, tileSize, null);
    }

}
