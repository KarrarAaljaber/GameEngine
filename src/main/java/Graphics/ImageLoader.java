package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageLoader {

    private BufferedImage img;
    public BufferedImage loadImage(String path) {

        try {
            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
            System.out.println("loaded img ! : " + path );
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("image not found" + path);
        }
        return img;

    }
}
