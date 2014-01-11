package Timer;

import bin.Play_Sound;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AlarmClock {

    private final Scheduler scheduler = new Scheduler();
    private final SimpleDateFormat dateFormat =
        new SimpleDateFormat("dd MMM yyyy h:mm:ss a");
    private final int hourOfDay, minute, second;

    public AlarmClock(int hourOfDay, int minute, int second) {
        this.hourOfDay = hourOfDay;
        this.minute = minute;
        this.second = second;
    }

    public void start(final String filename) {
        scheduler.schedule(new SchedulerTask() {
            public void run() {
                soundAlarm();
            }
            private void soundAlarm() {
                System.out.println("Wake up! " +
                    "It's " + dateFormat.format(new Date()));
                if(Play_Sound.IsClipLoaded())
                {
                    Play_Sound.Stop();
                }
                Play_Sound ps = new Play_Sound(filename+".wav");
                ps.LoadAudio();
                ps.PlayAudioOnce();
            }
        }, new DailyIterator(hourOfDay, minute, second));
    }
}
