package Graphics;

import GameHandlers.GameObject;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EngineGraphics {

    private Graphics2D g2d;
    public EngineGraphics(Graphics2D g2d){
        this.g2d = g2d;
    }

    public void drawCircle(Vector2f pos, int radius, Color color, boolean isFilled){
        if(!isFilled) {
            g2d.setColor(color);
            g2d.drawOval((int) pos.getX(), (int) pos.getY(), radius, radius);
        }else{
            g2d.setColor(color);
            g2d.fillOval((int) pos.getX(), (int) pos.getY(), radius, radius);
        }
    }

    public void drawRect(Vector2f pos, int width, int height, Color color, boolean isFilled){
        if(!isFilled) {
            g2d.setColor(color);
            g2d.drawRect((int) pos.getX(), (int) pos.getY(), width, height);
        }else{
            g2d.setColor(color);
            g2d.fillRect((int) pos.getX(), (int) pos.getY(), width, height);
        }
    }
    public void drawImage(BufferedImage img, int x, int y, int width, int height){
        g2d.drawImage(img, x,y,width,height, null);
    }

    public void drawGameObject(GameObject obj, int spritecol, int spriterow){
        if(obj == null){
            System.out.println("NULLLL");
        }
        g2d.drawImage(obj.getSprite().getSpriteImage(spritecol, spriterow),(int)obj.getPos().getX(), (int) obj.getPos().getY(), obj.getWidth(), obj.getHeight() , null);
    }
    public void drawGameObject(GameObject obj){
        if(obj == null){
            System.out.println("NULLLL");
        }
        g2d.drawImage(obj.getSprite().getSpriteImage(),(int)obj.getPos().getX(), (int) obj.getPos().getY(), obj.getWidth(), obj.getHeight() , null);
    }

    public void drawString(String text, Vector2f pos, String fontname, int fontSize ){
        Font font = new Font(fontname, 0, fontSize);
        g2d.setFont(font);
        g2d.drawString(text, pos.getX(), pos.getY() );
    }


    public void drawAnim(BufferedImage curImg, int x, int y, int width, int height) {
        g2d.drawImage(curImg, x, y, width, height, null);

    }



    public Graphics2D getG2d() {
        return g2d;
    }
}
