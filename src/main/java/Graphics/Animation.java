package Graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed;
    private int frames;

    private int index = 0;
    private int count = 0;

    private BufferedImage[] imgs;
    private BufferedImage curImg;


    public Animation(int speed, BufferedImage... args) {
        this.speed = speed;
        imgs = new BufferedImage[args.length];

        for (int i = 0; i < args.length; i++) {
            imgs[i] = args[i];
        }
        frames = args.length;

    }

    public void startAnim() {
        index++;
        if (index > speed) {
            index = 0;
            nextFrame();
        }
    }

    private void nextFrame() {
        for (int i = 0; i < frames; i++) {
            if (count == i) {
                curImg = imgs[i];

            }
        }
        count++;
        if (count > frames) {
            count = 0;
        }

    }

    public void renderAnim(EngineGraphics g, int x, int y, int width, int height) {
        g.drawImage(curImg, x, y, width, height);

    }
    /*
    public void renderAnim(Graphics2D g2d, int x, int y, int width, int height) {
        g2d.drawImage(curImg, x, y, width , height, null);

    }

     */



}
