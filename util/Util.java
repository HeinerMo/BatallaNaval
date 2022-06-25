package util;

public class Util {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static float timeStarted = System.nanoTime();

    /**
     * Obtener el tiempo transcurrido desde el inicio del juego
     */
    public static float getTime() {
        return (float) ((System.nanoTime() - timeStarted) * 1E-9);
    }
}
