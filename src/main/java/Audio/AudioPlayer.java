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

    public void updateMusikk(){
        audioclips.forEach(audioClip -> audioClip.updatemusikk());
        List.copyOf(audioclips).forEach(audioClip -> {
            if(audioClip.finishedrunning()){
                audioClip.cleanup();

                audioclips.remove(audioClip);
            }
        });

    }
    public void updateSound(){
        audioclips.forEach(audioClip -> audioClip.updateSound());

        List.copyOf(audioclips).forEach(audioClip -> {
            if(audioClip.finishedrunning()){
                audioClip.cleanup();
                audioclips.remove(audioClip);
            }
        });


    }
    public void playMusic(String filename){
        final Clip clip = getClip(filename);
        audioclips.add(new MusicClip(clip));

    }

    public void playMusic(MusicClip clip){

        audioclips.add(clip);

    }

    public void playSound(String filename){
        final Clip clip = getClip(filename);
        audioclips.add(new SoundClip(clip));
    }
    public void playSound(AudioClip clip){
        audioclips.add(clip);

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