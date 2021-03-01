package Particles;

import Entities.Entity;
import GameComponents.Rigidbody;
import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Utilities.EngineMath;
import Utilities.Vector2f;

import java.awt.*;
import java.util.Random;
import Graphics.Sprite;

public class Particle extends Entity {


    private Rigidbody rigidbody;


    private Color endColor;
    private int timeToLive;
    private Color finalColor;
    private Random rand = new Random();




    public Particle(int x, int y, int width, int height, float rotationAngle, Color color, int timeToLive) {
        super(x, y, width, height, rotationAngle, color);
        this.timeToLive = timeToLive;
        endColor= new Color(0,0,0);
        finalColor = new Color(0,0,0);
        rigidbody = new Rigidbody(this);
    }

    public Particle(int x, int y, int width, int height, Sprite sprite, int timeToLive) {
        super(x, y, width, height, sprite);
        this.timeToLive = timeToLive;
        endColor= new Color(0,0,0);
        finalColor = new Color(0,0,0);
        rigidbody = new Rigidbody(this);
    }

    public Particle(int x, int y, int width, int height, float rotationAngle, Sprite sprite, int timeToLive) {
        super(x, y, width, height, rotationAngle, sprite);
        this.timeToLive = timeToLive;
        endColor= new Color(0,0,0);
        finalColor = new Color(0,0,0);
        rigidbody = new Rigidbody(this);
    }


    @Override
    public void update(float delta){


        timeToLive-=delta;

        var angleInRadians =(int)getRotationAngle() * Math.PI / 180;
        rigidbody.getVelocity().setX((float) ( getMoveSpeed()* Math.cos(angleInRadians) * delta));
        rigidbody.getVelocity().setY((float) (getMoveSpeed()* Math.sin(angleInRadians) * delta));


       finalColor= EngineMath.fadeToColor(color, endColor,delta , timeToLive);

        rigidbody.update(delta);


    }

    @Override
    public void render(EngineGraphics g){

        g.drawRect((int)position.getX(),(int) position.getY(), height,width,new Color(color.getRed(), color.getGreen(), color.getBlue(), timeToLive / 255),true);

    }


    public Rigidbody getRigidbody() {
        return rigidbody;
    }




    public java.awt.Color getFinalColor() {
        return finalColor;
    }

    public void setFinalColor(java.awt.Color finalColor) {
        this.finalColor = finalColor;
    }

    public Color getEndColor() {
        return endColor;
    }

    public void setEndColor(Color endColor) {
        this.endColor = endColor;
    }



    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }



    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }
}
