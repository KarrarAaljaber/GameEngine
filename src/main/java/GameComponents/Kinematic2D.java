package GameComponents;

import GameObjects.GameObject;
import Utilities.Vector2f;

public class Kinematic2D extends GameComponent{


    private Vector2f velocity;
    public static float gravity = 0.98f;



    public Kinematic2D(GameObject parent) {
        super(parent);

        velocity = new Vector2f(0,0);
    }



    @Override
    public void update(float delta) {

        parent.getPosition().addVec(velocity);

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
