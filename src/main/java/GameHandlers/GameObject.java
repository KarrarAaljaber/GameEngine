package GameHandlers;

import Graphics.Sprite;
import Utilities.Vector2f;

public class GameObject {


    private Vector2f pos;
    private Sprite sprite;

    public GameObject(Vector2f pos, Sprite sprite){
        this.pos = pos;
        this.sprite = sprite;

    }

    public Sprite getSprite() {
        return sprite;
    }

    public Vector2f getPos() {
        return pos;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
    }
}
