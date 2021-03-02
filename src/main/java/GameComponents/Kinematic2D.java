package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Utilities.EngineMath;
import Utilities.Vector2f;

public class Kinematic2D extends GameComponent{


    private Vector2f velocity;
    public static float gravity = 0.001f;
    private Collision collision;

    private boolean isFalling = true;
    private static float Gravity =0.98f;

    public Kinematic2D(GameObject parent) {
        super(parent);

        velocity = new Vector2f(0,0);
    }

    @Override
    public void init() {

    }


    public void addGravity(float delta){
        if(isFalling){
            getVelocity().setY(getVelocity().getY() + Gravity * delta);
        }
        Collision coll = (Collision) parent.getComponent(Collision.class);
        if(coll.isCollided()){
            getVelocity().setY(getVelocity().getY() );
            isFalling = false;
            System.out.println("coll");

        }else{
            isFalling = true;
        }
    }
    @Override
    public void update(float delta) {

        parent.getPosition().addVec(velocity);


        /*
        parent.getPosition().setX((int) (parent.getX() + getVelocityX()));
        parent. getPosition().setY((int) (parent.getY() + getVelocityY()));
        */

    }
    public void addForce(Vector2f force, float delta ){
        Vector2f goalVel = new Vector2f(force.getX(), force.getY() );
        float forceX = EngineMath.Lerp(goalVel.getX(), getVelocity().getX(), delta );
        float forceY = EngineMath.Lerp(goalVel.getY(), getVelocity().getY(), delta );
        setVelocity(new Vector2f(getVelocity().getX() + forceX, getVelocity().getY() + forceY));

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
