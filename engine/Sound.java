package engine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

public class Sound implements Runnable, LineListener{
    private boolean playSong = false;
    private AudioInputStream inputStream;
    private String url;
    private Clip clip;

    private boolean running = false;
    private Thread thread;

    public Sound() {
    }

    @Override
    public void run() {
            if (inputStream == null && playSong) {
                this.playSong = false;
                try {
                    clip.addLineListener(this);
                    this.inputStream = AudioSystem.getAudioInputStream(Sound.class.getResource(url));
                    this.clip.open(inputStream);
                    this.clip.loop(0);
                    while(running){
                        thread.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            disposeSound();
    }

    public void playSound(String string) // call to play .wav file
    {
        if (this.clip != null) {
            this.clip.stop();
            this.clip.close();
        }
        try {
            this.clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        url = string;
        this.playSong = true;
        this.inputStream = null;

        
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    public void disposeSound() {
        if (this.clip != null) {
            this.clip.stop();
            this.clip.close();
            
        }
        this.clip = null;
        this.playSong = false;
        this.inputStream = null;
    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            running = false;
        }
    }
}
