package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;

import java.awt.*;

public class Collider extends GameComponent {


    private int width, height;

    public Collider(GameObject parent, int width, int height){
        super(parent);
        this.parent  = parent;
        this.width = width;
        this.height = height;

    }
    public Rectangle getCollRight() {
        return new Rectangle (parent.getX() +width  - 4, parent.getY(), 2, height);
    }
    public Rectangle getCollLeft() {
        return new Rectangle (parent.getX() + 4,parent.getY(), 2, height);
    }

    public Rectangle getCollUp() {
        return new Rectangle(parent.getX() + 4, parent.getY(), width - 6, 2);
    }
    public Rectangle getCollDown() {
        return new Rectangle(parent.getX() + 4, parent.getY() +height - 2, width - 6, 2);
    }


    @Override
    public void init() {
    }

    @Override
    public void update( double delta) {

    }

    @Override
    public void render( EngineGraphics g) {

        /*
        if(parent.isSolid()) {
            g.drawRect(getCollRight(), Color.BLUE, false);
            g.drawRect(getCollLeft(), Color.BLUE, false);
            g.drawRect(getCollUp(), Color.BLUE, false);
            g.drawRect(getCollDown(), Color.BLUE, false);

        }

         */
    }
}
