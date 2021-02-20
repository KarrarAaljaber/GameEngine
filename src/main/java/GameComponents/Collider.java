package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;

import java.awt.*;

public class Collider extends GameComponent {


    private int width, height;
    private int halfWidth, halfHeight;
    private int centerX, centerY;
    public Collider(GameObject parent, int width, int height){
        super(parent);
        this.parent  = parent;
        this.width = width;
        this.height = height;

    }


    @Override
    public void init() {
    }

    @Override
    public void update( double delta) {
        centerX = (int) parent.getX() +  (width / 2);
        centerY = (int) parent.getY() +  (height / 2);
        halfHeight = height /2;
        halfWidth = width /2;

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHalfWidth() {
        return halfWidth;
    }

    public void setHalfWidth(int halfWidth) {
        this.halfWidth = halfWidth;
    }

    public int getHalfHeight() {
        return halfHeight;
    }

    public void setHalfHeight(int halfHeight) {
        this.halfHeight = halfHeight;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    @Override
    public void render( EngineGraphics g) {

        if(parent.isSolid()) {
            g.drawRect(parent.getX(),parent.getY(), width, height, Color.PINK, false);
        }
        /*
        if(parent.isSolid()) {
            g.drawRect(getCollRight(), Color.BLUE, false);
            g.drawRect(getCollLeft(), Color.BLUE, false);
            g.drawRect(getCollUp(), Color.BLUE, false);
            g.drawRect(getCollDown(), Color.BLUE, false);

        }

         */
    }
}
