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
    public void update(){
        final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue();
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
