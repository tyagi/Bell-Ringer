/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

/**
 *
 * @author Umesh Tyagi
 */
public class Play_Sound {
    
    static String fname;
    static Clip clip = null;
    
    public Play_Sound(String filename)
    {
      fname = filename;   
    }
    
    public void LoadAudio()
    {
        
        try
        {
            URL url = this.getClass().getClassLoader().getResource("Resources/Sounds/"+fname);

            // Set up an audio input stream piped from the sound file.

             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);

             // Get a clip resource.

             clip = AudioSystem.getClip();

             // Open audio clip and load samples from the audio input stream.

             clip.open(audioInputStream);

        } 
        catch (UnsupportedAudioFileException e) 
        {
             e.printStackTrace();

        }
        catch (IOException e) 
        {
            e.printStackTrace();

        }
        catch (LineUnavailableException e) 
        {
             e.printStackTrace();
        }
         
    }
    
    public void PlayAudioOnce()
    {
        clip.start();
    }
    public void PlayAudioLoop(int loopTimes)
    {
        clip.loop(loopTimes);
    }
    public static void Stop()
    {
        clip.stop();
    }
    public static boolean IsClipLoaded()
    {
        if (clip==null)
        {
            return false;
           
        }
        else
        {
            return true;
        }
    }
       
}
