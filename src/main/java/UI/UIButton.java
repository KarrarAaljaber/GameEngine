package UI;

import Graphics.EngineGraphics;

import java.awt.*;

public class UIButton extends  UIComponent{

    public UIButton(UIContainer parent, int x, int y, int width, int height, Color backgroundColor) {
         super(parent, x, y, width, height, backgroundColor);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(EngineGraphics g) {
        g.drawBorder(getX(),getY(),getWidth(),getHeight(), getBorderThickness(), getBorderColor());

        g.drawRect(getX(), getY(),getWidth(), getHeight(), getBackgroundColor(), true);
        if(getText()!=null){
            g.drawString(getText(),getTextColor(),getCenterX(),getCenterY(),"arial",fontSize );
        }
    }
}
