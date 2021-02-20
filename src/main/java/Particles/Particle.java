package Particles;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import TestingGameEngine.Game;
import Utilities.Vector2f;

import java.awt.*;

public class Particle {

    private Vector2f acceleration, velocity, position;
    private Shape particleShape;
    private Color color;
    private int timeToLive;

    public Particle( Shape particleShape, Color color, int timeToLive){
        this.particleShape = particleShape;
        this.color = color;
        this.timeToLive = timeToLive;
        position = new Vector2f((float)particleShape.getBounds().getX(), (float)particleShape.getBounds().getY());
        velocity  = new Vector2f(0,0);
        acceleration = new Vector2f(0,0);
    }

    public void update(GameObject parent,double delta){
        velocity.addVec(acceleration);
        position.addVec(velocity);
        particleShape.getBounds().setLocation(parent.getX(), parent.getY());
        timeToLive--;

    }

    public void render(EngineGraphics g){

        g.drawShape(particleShape, true, new Color(color.getRed(),color.getGreen(),color.getBlue(),timeToLive));

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

    public Shape getParticleShape() {
        return particleShape;
    }

    public void setParticleShape(Shape particleShape) {
        this.particleShape = particleShape;
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
