package Audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public abstract class AudioClip {


    private final Clip clip;
    private float musicVolume;
    private float soundVolume;


    public AudioClip(Clip clip) {
        this.clip = clip;
        clip.start();
        musicVolume = 0;
        soundVolume = 0;
    }
    public void setVolume(float volume){
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }
    public void updatemusikk(){
        final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue(getMusicVolume());
    }
    public void updateSound(){
        final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue(getSoundVolume());
    }

    // sjekke om at audio filen er ferdig runnne
    public boolean finishedrunning(){
        return !clip.isRunning();
    }

    public void cleanup(){
        clip.close();
    }



    public float getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    public float getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(float soundVolume) {
        this.soundVolume = soundVolume;
    }
}