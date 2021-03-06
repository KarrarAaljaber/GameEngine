package Audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {

    private List<AudioClip> audioclips;

    public AudioPlayer(){
        audioclips = new ArrayList<>();
    }

    public void playSound(String filename){
        final Clip clip = getClip(filename);
        audioclips.add(new AudioClip(clip));
    }
    public void playSound(AudioClip clip){
       clip.startClip();

    }
    public void stopSound(AudioClip clip){
        clip.stopClip();
    }

    public void setLoopable(AudioClip clip){
        AudioClip c = audioclips.get(audioclips.indexOf(clip));
        c.setLoopable();
    }




    // methode som skal laste ned audioclipen
    public static Clip getClip(String fileName){
        //nå må vi åpne audio inputstream der vi kan lese data
        final URL soundFile = AudioPlayer.class.getClassLoader().getResource(fileName);
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile)){
            //lager en empty clip
            final Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(0);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        return null;
    }
}