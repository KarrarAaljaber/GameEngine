package Graphics;

import GameHandlers.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EngineGraphics {

    private Graphics2D g2d;
    public EngineGraphics(Graphics2D g2d){
        this.g2d = g2d;
    }

    public void drawCircle(int x, int y, int radius, Color color, boolean isFilled){
        if(!isFilled) {
            g2d.setColor(color);
            g2d.drawOval(x, y, radius, radius);
        }else{
            g2d.setColor(color);
            g2d.fillOval((int) x, y, radius, radius);
        }
    }
    public void drawRect(Rectangle rectangle, Color color, boolean isFilled){
        if(!isFilled) {
            g2d.setColor(color);
            g2d.draw(rectangle);
        }else{
            g2d.setColor(color);
            g2d.fill(rectangle);
        }
    }

    public void drawRect(int x, int y, int width, int height, Color color, boolean isFilled){
        if(!isFilled) {
            g2d.setColor(color);
            g2d.drawRect(x, y, width, height);
        }else{
            g2d.setColor(color);
            g2d.fillRect(x, (int) y, width, height);
        }
    }
    public void drawImage(BufferedImage img, int x, int y, int width, int height){
        g2d.drawImage(img, x,y,width,height, null);
    }

    public void drawGameObject(GameObject obj, int spritecol, int spriterow, int width ,int height, SpriteSheet sp){
        if(obj == null){
            System.out.println("NULLLL");
        }
        BufferedImage sprite = SpriteSheet.getSpriteImageFromSpriteSHeet(sp,spritecol, spriterow,width, height);
        g2d.drawImage(sprite,(int)obj.getX(), (int) obj.getY(), obj.getWidth(), obj.getHeight() , null);
    }
    public void drawGameObject(GameObject obj){
        if(obj == null){
            System.out.println("NULLLL");
        }
        BufferedImage sprite = obj.getSprite().getSpriteBufferImage();

            g2d.drawImage(sprite, (int) obj.getX(), (int) obj.getY(), obj.getWidth(), obj.getHeight(), null);

    }

    public void drawString(String text, Color color, int x, int y, String fontname, int fontSize ){
        Font font = new Font(fontname, 0, fontSize);
        g2d.setFont(font);
        g2d.setColor(color);
        g2d.drawString(text, x,y );
    }

    public void drawShape(Shape shape, boolean isFilled, Color color){
        if(!isFilled) {
            g2d.setColor(color);
            g2d.draw(shape);
        }else{
            g2d.setColor(color);
            g2d.fill(shape);
        }
    }

    public void drawSprite(Sprite sprite, int x, int y, int width, int height){
        g2d.drawImage(sprite.getSpriteBufferImage(), x, y, width, height, null );
    }
    public void drawAnim(BufferedImage curImg, int x, int y, int width, int height) {
        g2d.drawImage(curImg, x, y, width, height, null);
    }



    public Graphics2D getG2d() {
        return g2d;
    }
}
