package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Renderer;
import Utilities.Vector2f;

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
                Kinematic2D kinematic2DParent = (Kinematic2D) parent.getComponent(Kinematic2D.class);

                if (parentCollider != objCollider) {
                    if(RectInRect(obj)) {

                        collided = true;

                        if (Math.abs(parentCollider.getCenterX() - objCollider.getCenterX()) < Math.abs(parentCollider.getCenterY() - objCollider.getCenterY())) {

                            //onTop of object
                            if (parentCollider.getCenterY() < objCollider.getCenterY()) {

                                if (kinematic2DParent.getVelocity().getY() > 0) {
                                    kinematic2DParent.setVelocity(new Vector2f(0,0));
                                    parent.getPosition().setY(obj.getY() - parent.getHeight() -6);
                                }

                            }//hitting object above
                            if (parentCollider.getCenterY() > objCollider.getCenterY()) {
                                if (kinematic2DParent.getVelocity().getY() < 0) {
                                    kinematic2DParent.setVelocity( new Vector2f(0,0));
                                    parent.getPosition().setY(obj.getY() + parent.getHeight());
                                }
                            }
                            //Side collision
                        }else{
                            //right
                            if (parentCollider.getCenterX() < objCollider.getCenterX()) {

                                if (kinematic2DParent.getVelocity().getX() > 0) {
                                    kinematic2DParent.setVelocity(new Vector2f(0,0));
                                    parent.getPosition().setX(obj.getX() - parent.getWidth() +6);
                                }

                            }//left
                            if (parentCollider.getCenterX() > objCollider.getCenterX()) {
                                if (kinematic2DParent.getVelocity().getX() < 0) {
                                    kinematic2DParent.setVelocity(new Vector2f(0,0));
                                    parent.getPosition().setX(obj.getX() + parent.getWidth());
                                }
                            }
                        }
                    }else {
                        collided = false;
                    }
                    /*
                    if (RectInRect(parentCollider.getCollLeft(), objCollider.getCollRight())) {
                        collided = true;
                        if (kinematic2DParent.getVelocityX() < 0) {
                            kinematic2DParent.setVelocityX(0);

                        }
                    }


                    if (parentCollider.getCollRight().intersects(objCollider.getCollLeft())) {
                        collided = true;
                        if (kinematic2DParent.getVelocityX() > 0) {
                            kinematic2DParent.setVelocityX(0);
                        }

                    }

                    if (parentCollider.getCollUp().intersects(objCollider.getCollDown())) {
                        collided = true;
                        if (kinematic2DParent.getVelocityY() < 0) {
                            kinematic2DParent.setVelocityY(0);
                        }

                    }

                    if (parentCollider.getCollDown().intersects(objCollider.getCollUp())) {
                        collided = true;
                        if (kinematic2DParent.getVelocityY() > 0) {
                            kinematic2DParent.setVelocityY(0);
                            parent.setY( obj.getY() - parent.getHeight());

                        }

                    }

                     */
                }
            }

        }

    }

    public static boolean CircleContainsRect(int circleX, int circleY, int radius, int RectX, int RectY, int width, int height){
        int dx = Math.max(Math.abs(circleX - RectX), Math.abs(RectX + width - circleX));
        int dy = Math.max(Math.abs(circleY - RectY + height), Math.abs(RectY - circleY));
        return (radius * radius) >= (dx * dx) + (dy * dy);
    }

    public boolean isCollided() {
        return collided;
    }

    public static boolean PointInRect(int x, int y, int width, int height, int x2, int y2){
        return (x2 >= x && y2 >=y
        && x2 < x + width && y2 < y + height);

    }
    public static boolean GameObjectInGameObject(GameObject thisobject, GameObject otherObject ){
        boolean collided = false;
        Collider objCollider = (Collider) otherObject.getComponent(Collider.class);
        Collider parentCollider = (Collider) thisobject.getComponent(Collider.class);

        if(Math.abs(parentCollider.getCenterX() - objCollider.getCenterX()) < parentCollider.getHalfWidth() + objCollider.getHalfWidth()){
            if(Math.abs(parentCollider.getCenterY() - objCollider.getCenterY())<parentCollider.getHalfHeight() + objCollider.getHalfHeight() ){
                collided = true;
            }

        }
        return  collided;
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
    public void update(float delta) {
        collision();

    }

    @Override
    public void render(EngineGraphics g) {

    }
}
