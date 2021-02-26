package Particles;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import TestingGameEngine.Game;
import Utilities.Vector2f;

import java.awt.*;
import java.util.Random;

public class Particle {

    private Vector2f acceleration, velocity, position;
    private Rectangle rectangle;
    private int width, height;
    private Color color;
    private int timeToLive;
    private Random rand = new Random();

    public Particle( Vector2f position, int width, int height, Color color, int timeToLive){
        this.position = position;
        this.width = width;
        this.height = height;
        this.color = color;
        this.timeToLive = timeToLive;
        velocity  = new Vector2f(0,0);
        acceleration = new Vector2f(0,0);
    }

    public void update(GameObject parent){
        timeToLive--;

        acceleration.setX(randomFloat(0,1) * 0.0001f);
        acceleration.setY(randomFloat(0,1) * 0.0001f);

        velocity.addVec(acceleration );
        position.addVec(velocity);

    }

    public void render(EngineGraphics g){

        g.drawRect((int)position.getX(),(int) position.getY(), height,width,color,true);

    }
    public float randomFloat(int min, int max){
        float random = min + rand.nextFloat() * (max - min);
        return  random;
    }

    public Vector2f getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2f acceleration) {
        this.acceleration = acceleration;
    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }
}
