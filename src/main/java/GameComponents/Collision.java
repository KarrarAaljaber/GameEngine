package GameComponents;

import Entities.Entity;
import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Renderer;

import java.awt.*;

public class Collision extends GameComponent{


    public Collision(GameObject parent) {
        super(parent);
    }

    public boolean collision(){

        for(int i = 0; i< Renderer.getGch().getObjects().size(); i++){
            if(Renderer.getGch().getObjects().get(i).isSolid()) {
                GameObject obj = Renderer.getGch().getObjects().get(i);
                Collider parentCollider = (Collider) parent.getComponent(Collider.class);
                Collider objCollider = (Collider) obj.getComponent(Collider.class);

                if (RectInRect(parentCollider.getBoundingBox(),objCollider.getBoundingBox() ) && parentCollider != objCollider) {
                    return true;
                }
            }

        }
        return  false;

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
