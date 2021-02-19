package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;

public class Rigidbody extends GameComponent{


    private float velocityX = 0, velocityY = 0;
    private float gravity = 1.98f;

    public Rigidbody(GameObject parent) {
        super(parent);
    }

    @Override
    public void init() {

    }

    Collision collision = (Collision) parent.getComponent(Collision.class);

    @Override
    public void update(double delta) {

        if(!collision.isCollided()){
            velocityY += 2 * delta + gravity;
        }


        parent.setX((int) (parent.getX() + getVelocityX() * delta));
        parent.setY((int) (parent.getY() + getVelocityY() * delta));
    }

    @Override
    public void render(EngineGraphics g) {

    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getVelocityX() {
        return velocityX;
    }


    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocity(float x, float y){
        this.velocityX = x;
        this.velocityY = y;
    }

}
