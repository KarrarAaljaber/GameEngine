package Entities;
import GameHandlers.GameCaseHandler;
import GameHandlers.GameObject;
import Graphics.Animation;
import Graphics.Sprite;
import Tiles.SolidTile;
import Utilities.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import Graphics.Renderer;
public abstract class Entity extends GameObject {

    private final int UP =0, DOWN = 1, RIGHT =2, LEFT =3;

    protected float velocityX, velocityY;
    //abilities
    protected boolean up, down, right, left;
    protected float moveSpeed;

    private  boolean collided = false;

    public Entity(int x, int y, int width, int height) {
        super(x, y, width, height);
        moveSpeed = 2;
    }

    public Entity(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
        moveSpeed = 2;
    }


    public void setMoveSpeed(float moveSpeed){
        this.moveSpeed = moveSpeed;
    }

    public void collision(){

        for(int i=0; i< Renderer.getGch().getObjects().size(); i++){
            if(Renderer.getGch().getObjects().get(i).isSolid()){
                if(getCollLeft().intersects(Renderer.getGch().getObjects().get(i).getCollRight())) {
                    if(getVelocityX() < 0) {
                        setVelocityX(0);
                    }
                }

                if(getCollRight().intersects(Renderer.getGch().getObjects().get(i).getCollLeft())) {
                    if(getVelocityX() > 0) {
                        setVelocityX(0);
                    }
                }

                if(getCollUp().intersects(Renderer.getGch().getObjects().get(i).getCollDown())) {
                    if(getVelocityY() < 0) {
                        setVelocityY(0);
                    }

                }

                if(getCollDown().intersects(Renderer.getGch().getObjects().get(i).getCollUp())) {
                    if(getVelocityY() > 0) {
                        setVelocityY(0);
                    }

                }
            }
        }
    }

    public void placeEntityAtTile(int col, int row, int tilesWidth, int tilesHeight){
        this.setX(col * tilesWidth );
        this.setY(row * tilesHeight);
    }



    public void move(double delta){

        x+= velocityX;
        y+=velocityY;


        if(up){
            setVelocityY( (float)(-moveSpeed ));
        }else if(down){
            setVelocityY( (float)(moveSpeed ));
        }else if(left){
            setVelocityX((float) (-moveSpeed ));

        }else if(right){
            setVelocityX((float) (moveSpeed ));
        }
        collision();


    }

    public void setVelocity(float x, float y){
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
    public Rectangle getCollRight() {
        return new Rectangle (x + width / 2 + 2 , y + 2, 4, height - 4);
    }
    public Rectangle getCollLeft() {
        return new Rectangle (x +6, y + 2, 4, height - 4);
    }

    public Rectangle getCollUp() {
        return new Rectangle(x + 6, y, width /2, 4);
    }
    public Rectangle getCollDown() {
        return new Rectangle(x + 6, y + height - 2, width /2, 4);
    }
}
