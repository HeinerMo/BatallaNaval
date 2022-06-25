package util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Util {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static float timeStarted = System.nanoTime();
    public static int mouseX = 0;
    public static int mouseY = 0;

    public static Map<String, Image> images = new HashMap<>();

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
