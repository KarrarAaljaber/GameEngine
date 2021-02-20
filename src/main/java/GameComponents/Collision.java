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
                    if(RectInRect(obj)) {
                        collided = true;
                        if (Math.abs(parentCollider.getCenterX() - objCollider.getCenterX()) < Math.abs(parentCollider.getCenterY() - objCollider.getCenterY())) {

                            //onTop of object
                            if (parentCollider.getCenterY() < objCollider.getCenterY()) {

                                if (rigidbodyParent.getVelocityY() > 0) {
                                    rigidbodyParent.setVelocityY(0);
                                    parent.setY(obj.getY() - parent.getHeight() +6);
                                }

                            }//hitting object above
                            if (parentCollider.getCenterY() > objCollider.getCenterY()) {
                                if (rigidbodyParent.getVelocityY() < 0) {
                                    rigidbodyParent.setVelocityY(0);
                                    parent.setY(obj.getY() + parent.getHeight());
                                }
                            }
                            //Side collision
                        }else{
                            //right
                            if (parentCollider.getCenterX() < objCollider.getCenterX()) {

                                if (rigidbodyParent.getVelocityX() > 0) {
                                    rigidbodyParent.setVelocityX(0);
                                    parent.setX(obj.getX() - parent.getWidth() +6);
                                }

                            }//left
                            if (parentCollider.getCenterX() > objCollider.getCenterX()) {
                                if (rigidbodyParent.getVelocityX() < 0) {
                                    rigidbodyParent.setVelocityX(0);
                                    parent.setX(obj.getX() + parent.getWidth());
                                }
                            }
                        }
                    }
                    /*
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
                            parent.setY( obj.getY() - parent.getHeight());

                        }

                    }

                     */
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
    public boolean RectInRect(GameObject collidedWith){
        boolean collided = false;
        Collider objCollider = (Collider) collidedWith.getComponent(Collider.class);
        Collider parentCollider = (Collider) parent.getComponent(Collider.class);

        if(Math.abs(parentCollider.getCenterX() - objCollider.getCenterX()) < parentCollider.getHalfWidth() + objCollider.getHalfWidth()){
            if(Math.abs(parentCollider.getCenterY() - objCollider.getCenterY())<parentCollider.getHalfHeight() + objCollider.getHalfHeight() ){
                collided = true;
            }

        }
        return  collided;
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
