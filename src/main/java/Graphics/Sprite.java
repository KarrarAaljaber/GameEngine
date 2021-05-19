package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Sprite {

    private int width, height;

    private int col,row;
    private BufferedImage sprite;
    public Sprite(BufferedImage sprite, int width, int height){
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public Sprite(BufferedImage sprite){

        this.sprite = sprite;
    }

    public BufferedImage getSpriteBufferImage() {
        return sprite;
    }

    public void setSpriteImage(BufferedImage sprite) {
        this.sprite = sprite;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
