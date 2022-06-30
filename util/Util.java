package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Util {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static float timeStarted = System.nanoTime();
    public static int mouseX = 0;
    public static int mouseY = 0;
    public static int tileSize = 0;
    public static final int TILES = 10;

    public static Map<String, BufferedImage> images = new HashMap<>();
    /**
     * Obtener el tiempo transcurrido desde el inicio del juego
     */
    public static float getTime() {
        return (float) ((System.nanoTime() - timeStarted) * 1E-9);
    }

    public static void updateMouse(int x, int y) {
        mouseX = x;
        mouseY = y;
    }

    public static void loadImages() {
        try {
            images.put("smallShip", ImageIO.read(new File("resources/imgs/barco1.png")));
            images.put("mediumShip", ImageIO.read(new File("resources/imgs/barco2.png")));
            images.put("largeShip", ImageIO.read(new File("resources/imgs/barco3.png")));
            images.put("water", ImageIO.read(new File("resources/imgs/water.png")));
            images.put("flame1", ImageIO.read(new File("resources/imgs/flame1.png")));
            images.put("flame2", ImageIO.read(new File("resources/imgs/flame2.png")));
            images.put("flame3", ImageIO.read(new File("resources/imgs/flame3.png")));
            images.put("flame4", ImageIO.read(new File("resources/imgs/flame4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage rotateImage(BufferedImage bimg) {
        Double angle = -90.0;
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
               cos = Math.abs(Math.cos(Math.toRadians(angle)));
        int w = bimg.getWidth();
        int h = bimg.getHeight();
        int neww = (int) Math.floor(w*cos + h*sin),
            newh = (int) Math.floor(h*cos + w*sin);
        BufferedImage rotated = new BufferedImage(neww, newh, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.translate((neww-w)/2, (newh-h)/2);
        graphic.rotate(Math.toRadians(angle), w/2, h/2);
        graphic.drawRenderedImage(bimg, null);
        graphic.dispose();
        return rotated;
    }
    
    public static boolean isNumber(String s) {
    	if (s.matches("^[0-9]+$")) { //regex
    		return true;
    	}
    	return false;
    }
}
