package Entities;
import GameComponents.Collider;
import GameComponents.Collision;
import GameComponents.GameComponent;
import GameComponents.Rigidbody;
import GameHandlers.GameObject;
import Graphics.Sprite;
import Utilities.APathfinding;
import Utilities.Node;

import java.awt.*;
import java.util.ArrayList;
import Graphics.Renderer;
import Utilities.Vector2f;

public abstract class Entity extends GameObject {


    //abilities
    protected boolean up, down, right, left, idle;
    protected float moveSpeed = 0.1f;


    public Entity(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);

    }

    public Entity(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);

    }
    public Entity(int x, int y, int width, int height, float rotationAngle, Color color) {
        super(x, y, width, height, rotationAngle, color);
    }


    public Entity(int x, int y, int width, int height, float rotationAngle, Sprite sprite) {
        super(x, y, width, height, rotationAngle, sprite);
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

/*

    public void moveTo(int x, int y){
        Rigidbody rigidbody = (Rigidbody) getComponent(Rigidbody.class);
        rigidbody.setVelocity(new Vector2f(0.001f, 0.001f));

    }
*/

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
