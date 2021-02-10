package GameHandlers;

import Graphics.Sprite;
import Utilities.Vector2f;
import Graphics.EngineGraphics;

import java.awt.*;

public abstract class GameObject {


    protected int width, height;
    private Sprite sprite;
    private boolean isSolid;

    protected int x;
    protected int y;

    public GameObject(int x, int y, int width, int height, boolean isSolid){
        this.x  = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isSolid = isSolid;

    }

    public GameObject(int x,int y, int width, int height){
        this.x  = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public GameObject(int x, int y, int width, int height, Sprite sprite){
        this.x  = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public GameObject(int x, int y, int width, int height, boolean isSolid, Sprite sprite){
        this.x  = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.isSolid = isSolid;
    }

    public boolean isSolid() {
        return isSolid;
    }



    public void setSolid(boolean solid) {
        isSolid = solid;
    }

    public Rectangle getCollRight() {
        return new Rectangle (x + width - 2, y, 4, height);
    }
    public Rectangle getCollLeft() {
        return new Rectangle (x, y, 4, height);
    }

    public Rectangle getCollUp() {
        return new Rectangle(x, y, width, 4);
    }
    public Rectangle getCollDown() {
        return new Rectangle(x, y + height - 2, width, 4);
    }

    public abstract void render(EngineGraphics g);
    public abstract void update(double delta);

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
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



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
