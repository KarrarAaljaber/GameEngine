package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Utilities.Vector2f;

public class Rigidbody extends GameComponent{


    private Vector2f velocity;
    private Vector2f velocityGoal;
    private float gravity = 0.001f;
    private Collision collision;
    public Rigidbody(GameObject parent) {
        super(parent);

        velocity = new Vector2f(0,0);
        velocityGoal = new Vector2f(0,0);
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float delta) {

        getVelocity().setX(Vector2f.Lerp(velocityGoal.getX(),getVelocity().getX(), delta * 80));
        getVelocity().setY(Vector2f.Lerp(velocityGoal.getY(),getVelocity().getY(), delta *80));

        parent.getPosition().addVec(velocity);

        /*
        parent.getPosition().setX((int) (parent.getX() + getVelocityX()));
        parent. getPosition().setY((int) (parent.getY() + getVelocityY()));
        */

    }

    @Override
    public void render(EngineGraphics g) {

    }

    public Vector2f getVelocityGoal() {
        return velocityGoal;
    }

    public void setVelocityGoal(Vector2f velocityGoal) {
        this.velocityGoal = velocityGoal;
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
