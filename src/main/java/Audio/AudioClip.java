package Audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public  class AudioClip {

    private final Clip clip;
    private float musicVolume;
    private float soundVolume;


    public AudioClip(Clip clip) {
        this.clip = clip;
        musicVolume = 0;
        soundVolume = 0;
    }

    public int frameLength(){
        return  clip.getFrameLength();
    }

    public void startClip(){
        final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue(getSoundVolume());
        clip.start();
    }


    public void setLoopable(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void setLoopable(int loopCount){
        clip.loop(loopCount);
    }

    public void stopClip(){
        clip.stop();
    }

    // sjekke om at audio filen er ferdig runnne
    public boolean finishedrunning(){
        return !clip.isRunning();
    }

    public void cleanup(){
        clip.close();
    }



    public float getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(float soundVolume) {
        this.soundVolume = soundVolume;
    }
}