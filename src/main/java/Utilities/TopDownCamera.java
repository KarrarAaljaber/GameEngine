package Utilities;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;

import java.awt.*;

public class TopDownCamera extends GameObject {


    private double camSpeed;
    private GameObject player;
    public TopDownCamera(GameObject player,Vector2f pos, int width, int height, double camSpeed) {
        super(pos, width, height);
        this.camSpeed = camSpeed;
        this.player = player;
    }

    public void followEntity(GameObject obj) {
        if(obj == null){
            System.out.println("Obj is null cant follow player");
        }
        getPos().setX(-(obj.getPos().getX() - width/ 2) * (float)camSpeed) ;
        getPos().setY(-(obj.getPos().getY() - height / 2) * (float) camSpeed);
    }

    public void setCamSpeed(double camSpeed) {
        this.camSpeed = camSpeed;
    }

    @Override
    public void render(EngineGraphics g) {
    }

    @Override
    public void update(double delta) {
        followEntity(player);
    }
}
