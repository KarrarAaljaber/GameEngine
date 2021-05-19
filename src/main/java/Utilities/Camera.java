package Utilities;

import GameObjects.Entity;
import GameObjects.GameObject;
import Graphics.EngineGraphics;

public class Camera extends GameObject {


    private double camSpeed;


    private float yOffset =0f, xOffset=0;


    public Camera(int x, int y, int width, int height, double camSpeed) {
        super(x, y, width, height);
        this.camSpeed = camSpeed;
    }




    public void followEntity(Entity e) {
        if(e == null){
            System.out.println("Obj is null cant follow player");
        }
        getPosition().setX((int)(-(e.getX() - width/ 2)  +xOffset * (float)camSpeed)) ;
        getPosition(). setY((int)(-(e.getY() - height / 2)  + yOffset * (float) camSpeed));
    }


    public double getCamSpeed() {
        return camSpeed;
    }


    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setCamSpeed(double camSpeed) {
        this.camSpeed = camSpeed;
    }

    @Override
    public void render(EngineGraphics g) {
    }

    @Override
    public void update(float delta) {
    }


}
