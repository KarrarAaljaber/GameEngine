package GameComponents;

import GameObjects.GameObject;
import Graphics.Renderer;
import Utilities.Vector2f;

public class Collision extends GameComponent{


    private boolean collided = false;
    public Collision(GameObject parent) {
        super(parent);
    }


    public void collision(){

        for(int i = 0; i< Renderer.getGameStateController().getObjects().size(); i++){
            if(Renderer.getGameStateController().getObjects().get(i).isSolid()) {
                GameObject obj = Renderer.getGameStateController().getObjects().get(i);
                Collider parentCollider = (Collider) parent.getComponent(Collider.class);
                Collider objCollider = (Collider) obj.getComponent(Collider.class);
                Kinematic2D kinematic2DParent = (Kinematic2D) parent.getComponent(Kinematic2D.class);

                if (parentCollider != objCollider) {
                    if(GameObjectInGameObject(parent,obj)) {

                        collided = true;

                        if (Math.abs(parentCollider.getCenterX() - objCollider.getCenterX()) < Math.abs(parentCollider.getCenterY() - objCollider.getCenterY())) {

                            //onTop of object
                            if (parentCollider.getCenterY() < objCollider.getCenterY()) {

                                if (kinematic2DParent.getVelocity().getY() > 0) {
                                    kinematic2DParent.setVelocity(new Vector2f(0,0));
                                    parent.getPosition().setY(obj.getY() - parent.getHeight() +6);
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
                }
            }

        }

    }


    public boolean isCollided() {
        return collided;
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




    @Override
    public void update(float delta) {
        collision();

    }


}
