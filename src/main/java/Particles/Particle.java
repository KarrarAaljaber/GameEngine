package Particles;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import TestingGameEngine.Game;
import Utilities.Vector2f;

import java.awt.*;

public class Particle {

    private Vector2f acceleration, velocity, position;
    private Rectangle rectangle;
    private Color color;
    private int timeToLive;

    public Particle( Rectangle rectangle, Color color, int timeToLive){
        this.rectangle = rectangle;
        this.color = color;
        this.timeToLive = timeToLive;
        position = new Vector2f(0,0);
        velocity  = new Vector2f(0,0);
        acceleration = new Vector2f(0,0);
    }

    public void update(GameObject parent,double delta){
        velocity.addVec(acceleration);
        position.addVec(velocity);

        position.setX(parent.getX());
        position.setY(parent.getY());

        rectangle.setLocation((int)position.getX(), (int)position.getY());
        timeToLive--;

        position.setX(position.getX() +1);

    }

    public void render(EngineGraphics g){

        g.drawShape(rectangle, true, new Color(color.getRed(),color.getGreen(),color.getBlue()));

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
