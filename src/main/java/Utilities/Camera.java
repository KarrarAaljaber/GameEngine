package Utilities;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;

import java.awt.*;

public class Camera extends GameObject {


    private double camSpeed;
    private GameObject player;

    private float yOffset =0f, xOffset=0;

    private float zoomscale = 0f;

    public Camera(GameObject player, int x, int y, int width, int height, double camSpeed) {
        super(x, y, width, height);
        this.camSpeed = camSpeed;
        this.player = player;
    }




    public void followEntity(GameObject obj) {
        if(obj == null){
            System.out.println("Obj is null cant follow player");
        }
        getPosition().setX((int)(-(obj.getX() - width/ 2)  +xOffset * (float)camSpeed)) ;
        getPosition(). setY((int)(-(obj.getY() - height / 2)  + yOffset * (float) camSpeed));
    }

    public float getZoomscale() {
        return zoomscale;
    }

    public void setZoomscale(float zoomscale) {
        this.zoomscale = zoomscale;
    }

    public double getCamSpeed() {
        return camSpeed;
    }

    public GameObject getPlayer() {
        return player;
    }

    public void setPlayer(GameObject player) {
        this.player = player;
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
    public void update() {
        followEntity(player);
    }

    @Override
    public void init() {

    }
}
