package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Sprite {

    private BufferedImage spritesheet = null;
    private int width, height;



    public Sprite(String file, int width, int height){

        spritesheet = loadSpriteSheet(file);
        this.width = width;
        this.height = height;


    }

    public BufferedImage loadSpriteSheet(String file){
        BufferedImage sprite = null;
        try{
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("couldnt load sprite! at File:  " + file);
        }
        System.out.println(sprite.getWidth());
        return sprite;
    }

    public BufferedImage getSprite(int col, int row) {
        BufferedImage imgg = spritesheet.getSubimage((col * width) - width, (row * height) - height, width, height);
        return imgg;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
