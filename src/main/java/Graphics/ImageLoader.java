package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageLoader {

    private static BufferedImage img;
    public static BufferedImage loadImage(String path) {

        try {
            img = ImageIO.read(ImageLoader.class.getClassLoader().getResourceAsStream(path));
            System.out.println("loaded img ! : " + path );
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("image not found" + path);
        }
        return img;

    }
}
