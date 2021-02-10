package GameHandlers;

import Graphics.Sprite;
import Utilities.Vector2f;
import Graphics.EngineGraphics;

public abstract class GameObject {

    protected Vector2f pos;

    protected int width, height;
    private Sprite sprite;


    public GameObject(Vector2f pos, int width, int height){
        this.pos  = pos;
        this.width = width;
        this.height = height;

    }

    public GameObject(Vector2f pos, int width, int height, Sprite sprite){
        this.pos  = pos;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
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

    public Vector2f getPos() {
        return pos;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
    }
}
