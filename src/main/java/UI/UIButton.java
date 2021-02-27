package UI;

import GameComponents.Collision;
import GameComponents.Input;
import Graphics.EngineGraphics;

import java.awt.*;
import Graphics.Renderer;

public class UIButton extends  UIComponent{

    Color oldColor = backgroundColor;

    public UIButton(UIContainer parent, int x, int y, int width, int height, Color backgroundColor) {
         super(parent, x, y, width, height, backgroundColor);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        if(mouseInsideComponent() ){
            setBorderColor(Color.RED);
        }else{
            setBorderColor(oldColor);

        }

        if(clicked()){
            setText("NIGGA");
            setTextColor(Color.ORANGE);
        }
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