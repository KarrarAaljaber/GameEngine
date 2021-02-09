package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class SpriteSheet {


    private ImageLoader loader;
    private BufferedImage img;
    public SpriteSheet(String file) {
        loader = new ImageLoader();
        img = loader.loadImage(file);
    }

    public BufferedImage getImg() {
        return img;
    }


}

