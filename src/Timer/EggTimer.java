package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class EggTimer {
    private final Timer timer = new Timer();
    private final int minutes;

    public EggTimer(int minutes) {
        this.minutes = minutes;
    }

    public void start() {
        timer.schedule(new TimerTask() {
            public void run() {
                playSound();
                
            }
            private void playSound() {
                System.out.println("Your egg is ready!");
                // Start a new thread to play a sound...
            }
        }, 500,500);
    }

    public static void main(String[] args) {
        EggTimer eggTimer = new EggTimer(2);
        eggTimer.start();
    }

}
