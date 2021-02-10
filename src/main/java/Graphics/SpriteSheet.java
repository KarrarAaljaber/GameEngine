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

    public static BufferedImage getSpriteImage(SpriteSheet sheet, int col, int row, int width, int height) {
        BufferedImage sprite = sheet.getImg().getSubimage((col * width) - width, (row * height) - height, width, height);
        return sprite;
    }

    public static BufferedImage[] spriteSheetToBufferedArray(SpriteSheet sheet, int totalSprites, int totalCol, int totalRow, int spriteWidth, int spriteHeight) {
        BufferedImage[] bufferarray = new BufferedImage[totalSprites];
        int counter = 1;
        for (int i = 1; i < totalCol; i++) {
            for (int j = 1; j < totalRow; j++) {
                counter++;

                bufferarray[counter] = getSpriteImage(sheet, i, j, spriteWidth, spriteHeight);

            }
        }
        return bufferarray;
    }




}

