package Graphics;

import GameHandlers.GameObject;
import Utilities.Vector2f;

import java.awt.*;

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

    public void drawGameObject(GameObject obj){
        g2d.drawImage(obj.getSprite().getImg(), (int)obj.getPos().getX() ,(int)obj.getPos().getY(),null);
    }

    public void drawString(String text, Vector2f pos, String fontname, int fontSize ){
        Font font = new Font(fontname, 0, fontSize);
        g2d.setFont(font);
        g2d.drawString(text, pos.getX(), pos.getY() );
    }





    public Graphics2D getG2d() {
        return g2d;
    }
}