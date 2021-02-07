package GameHandlers;

import Graphics.Sprite;
import Utilities.Vector2f;

public abstract class GameObject {


    private Vector2f pos;

    public GameObject(Vector2f pos){
        this.pos = pos;

    }


    public Vector2f getPos() {
        return pos;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
    }
}
