package Graphics;

import java.awt.image.BufferedImage;

public class Animation {



    private int speed, animIndex;
    private BufferedImage[] frames;
    private long lastTime, Timer;

    public Animation(int speed, BufferedImage[]frames) {
        this.speed =speed;
        this.frames = frames;
        animIndex = 0;

        Timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update( ){
        Timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(Timer >speed){
            animIndex++;
            Timer =0;
            if(animIndex >= frames.length){
                animIndex = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame(){
        return frames[animIndex];
    }



}
