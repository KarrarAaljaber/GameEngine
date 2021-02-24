package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class SpriteSheet {


    private BufferedImage img;

    public SpriteSheet(String file) {
        img = ImageLoader.loadImage(file);
    }

    public BufferedImage getImg() {
        return img;
    }

    public static BufferedImage getSpriteImageFromSpriteSHeet(SpriteSheet sheet, int col, int row, int width, int height) {
        BufferedImage sprite = sheet.getImg().getSubimage((col * width) - width, (row * height) - height, width, height);
        return sprite;
    }




}

