package util;

public class Util {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static float timeStarted = System.nanoTime();
    public static int mouseX = 0;
    public static int mouseY = 0;

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
}
