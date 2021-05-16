package Graphics;

import Utilities.ImageLoader;

import java.awt.image.BufferedImage;


public class SpriteSheet {


    private BufferedImage img;

    private int spriteWidth, spriteHeight;
    public SpriteSheet(String file, int spriteWidth, int spriteHeight)
    {
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
        img = ImageLoader.loadImage(file);
    }



    public int getSpriteWidth() {
        return spriteWidth;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public BufferedImage getImg() {
        return img;
    }

    public static BufferedImage getSpriteImageFromSpriteSheet(SpriteSheet sheet, int row, int col) {


        if (sheet.getImg().getHeight() == sheet.getImg().getWidth()) {
            BufferedImage sprite = sheet.getImg().getSubimage((col * sheet.getSpriteWidth()) - sheet.getSpriteWidth(), (row * sheet.getSpriteHeight()) - sheet.getSpriteHeight(), sheet.getSpriteWidth(), sheet.getSpriteHeight());

            return sprite;
        } else {

            BufferedImage sprite = sheet.getImg().getSubimage(col * sheet.getSpriteWidth(), row * sheet.getSpriteHeight(), sheet.getSpriteWidth(), sheet.getSpriteHeight());

            return sprite;

        }
    }


    }



