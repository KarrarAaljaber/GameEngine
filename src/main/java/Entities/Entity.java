package Entities;
import GameHandlers.GameObject;
import Graphics.Sprite;
import Utilities.APathfinding;
import Utilities.Node;

import java.awt.*;
import java.util.ArrayList;
import Graphics.Renderer;
public abstract class Entity extends GameObject {

    private final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;

    protected float velocityX, velocityY;
    //abilities
    protected boolean up, down, right, left;
    protected float moveSpeed;


    public Entity(int x, int y, int width, int height, boolean isSolid, Sprite sprite) {
        super(x, y, width, height, isSolid, sprite);
        moveSpeed = 2;

    }

    public Entity(int x, int y, int width, int height, boolean isSolid, Color color) {
        super(x, y, width, height, isSolid, color);
        moveSpeed = 2;

    }


    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }


    public void placeEntityAtTile(int col, int row, int tilesWidth, int tilesHeight) {
        this.setX(col * tilesWidth);
        this.setY(row * tilesHeight);
    }


    public void move(double delta) {

        x += velocityX;
        y += velocityY;


        if (up) {
            setVelocityY((float) (-moveSpeed));
        } else if (down) {
            setVelocityY((float) (moveSpeed));
        } else if (left) {
            setVelocityX((float) (-moveSpeed));

        } else if (right) {
            setVelocityX((float) (moveSpeed));
        }


    }

    public void setVelocity(float x, float y) {
        this.velocityX = x;
        this.velocityY = y;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
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
