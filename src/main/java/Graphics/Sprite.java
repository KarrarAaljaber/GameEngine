package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Sprite {

    private int width, height;
    private SpriteSheet sheet;

    public Sprite(SpriteSheet sheet, int width, int height){
        this.width = width;
        this.height = height;
        this.sheet = sheet;
    }


    public BufferedImage getSpriteImage(int col, int row) {
        BufferedImage sprite = sheet.getImg().getSubimage((col * width) - width, (row * height) - height, width, height);
        return sprite;
    }
    public SpriteSheet getSheet() {
        return sheet;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
