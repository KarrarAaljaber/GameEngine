package Graphics;

import java.awt.image.BufferedImage;

public class Sprite {

    private SpriteSheet spriteSheet;
    private int width, height;
    private BufferedImage img;
    private int col, row;
    public Sprite(SpriteSheet spriteSheet, int width, int height, int col, int row){
        this.spriteSheet = spriteSheet;
        this.width = width;
        this.col = col;
        this.row = row;
        this.height = height;
    }

    public BufferedImage getImg(){
        return spriteSheet.getImage(col, row, width, height);
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
