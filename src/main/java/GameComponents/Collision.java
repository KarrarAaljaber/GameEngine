package GameComponents;

import Entities.Entity;
import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Renderer;

import java.awt.*;

public class Collision extends GameComponent{


    private boolean collided = false;
    public Collision(GameObject parent) {
        super(parent);
    }

    public void collision(){

        for(int i = 0; i< Renderer.getGch().getObjects().size(); i++){
            if(Renderer.getGch().getObjects().get(i).isSolid()) {
                GameObject obj = Renderer.getGch().getObjects().get(i);
                Collider parentCollider = (Collider) parent.getComponent(Collider.class);
                Collider objCollider = (Collider) obj.getComponent(Collider.class);
                Rigidbody rigidbodyParent = (Rigidbody) parent.getComponent(Rigidbody.class);
                if (parentCollider != objCollider) {
                    if (RectInRect(parentCollider.getCollLeft(), objCollider.getCollRight())) {
                        collided = true;
                        if (rigidbodyParent.getVelocityX() < 0) {
                            rigidbodyParent.setVelocityX(0);

                        }
                    }


                    if (parentCollider.getCollRight().intersects(objCollider.getCollLeft())) {
                        collided = true;
                        if (rigidbodyParent.getVelocityX() > 0) {
                            rigidbodyParent.setVelocityX(0);
                        }

                    }

                    if (parentCollider.getCollUp().intersects(objCollider.getCollDown())) {
                        collided = true;
                        if (rigidbodyParent.getVelocityY() < 0) {
                            rigidbodyParent.setVelocityY(0);
                        }

                    }

                    if (parentCollider.getCollDown().intersects(objCollider.getCollUp())) {
                        collided = true;
                        if (rigidbodyParent.getVelocityY() > 0) {
                            rigidbodyParent.setVelocityY(0);
                            parent.setY( obj.getY() - 32);
                        }

                    }
                }
            }

        }

    }

    public boolean isCollided() {
        return collided;
    }

    public boolean PointInRect(Rectangle rect, int x, int y){
        return (x >= rect.x && y >=rect.y
        && x < rect.x + rect.width && y < rect.y + rect.width);

    }
    public boolean RectInRect(Rectangle rect ,Rectangle rect2){
        return(rect.x < rect2.x + rect2.width && rect.x + 32 > rect2.x
        && rect.y < rect2.y + rect2.height && rect.y + 32 > rect2.y);
    }





    @Override
    public void init() {

    }

    @Override
    public void update(double delta) {
        collision();

    }

    @Override
    public void render(EngineGraphics g) {

    }
}
