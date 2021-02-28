package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Utilities.Vector2f;

public class Rigidbody extends GameComponent{


    private Vector2f velocity;
    private float gravity = 0.001f;
    private Collision collision;
    public Rigidbody(GameObject parent) {
        super(parent);

        velocity = new Vector2f(0,0);
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float delta) {

        parent.getPosition().addVec(velocity);


        /*
        parent.getPosition().setX((int) (parent.getX() + getVelocityX()));
        parent. getPosition().setY((int) (parent.getY() + getVelocityY()));
        */

    }

    @Override
    public void render(EngineGraphics g) {

    }



    public Collision getCollision() {
        return collision;
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }



}
