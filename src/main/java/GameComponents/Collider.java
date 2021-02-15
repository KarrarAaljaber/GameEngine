package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;

import java.awt.*;

public class Collider extends GameComponent {


    private int x, y, width, height;

    public Collider(GameObject parent,int x, int y, int width, int height){
        super(parent);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    public Rectangle getBoundingBox() {
        return  new Rectangle(parent.getX(), parent.getY(), parent.getWidth(), parent.getHeight());
    }


    @Override
    public void init() {
    }

    @Override
    public void update( double delta) {

    }

    @Override
    public void render( EngineGraphics g) {
        g.drawRect(parent.getX(), parent.getY(), parent.getWidth(), parent.getHeight(), Color.BLUE, false);

    }
}
