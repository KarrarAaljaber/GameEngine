package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class SpriteSheet {


    private BufferedImage img;
    public SpriteSheet(BufferedImage img) {
        this.img = img;
    }

    public BufferedImage getImage(int col, int row, int w, int h) {
        BufferedImage imgg = img.getSubimage((col * w) - w, (row * h) - h, w, h);
        return imgg;
    }



}

