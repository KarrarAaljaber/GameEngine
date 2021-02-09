package Entities;
import GameHandlers.GameObject;
import Graphics.Animation;
import Graphics.Sprite;
import Utilities.Vector2f;

public abstract class Entity extends GameObject {

    private final int UP =0, DOWN = 1, RIGHT =2, LEFT =3;

    protected Vector2f velocity;
    //abilities
    protected boolean up, down, right, left;

    public Entity(Vector2f pos, int width, int height, Sprite sprite) {
        super(pos, width, height, sprite);
        velocity = new Vector2f(0,0);
    }


    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
