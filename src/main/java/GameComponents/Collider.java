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
    public Rectangle getCollRight() {
        return new Rectangle (parent.getX() +parent.getWidth()  - 4, parent.getY(), 2, parent.getHeight());
    }
    public Rectangle getCollLeft() {
        return new Rectangle (parent.getX() + 4,parent.getY(), 2, parent.getHeight());
    }

    public Rectangle getCollUp() {
        return new Rectangle(parent.getX() + 4, parent.getY(), parent.getWidth() - 4, 2);
    }
    public Rectangle getCollDown() {
        return new Rectangle(parent.getX() + 4, parent.getY() + parent.getHeight() - 2, parent.getWidth() - 4, 2);
    }


    @Override
    public void init() {
    }

    @Override
    public void update( double delta) {

    }

    @Override
    public void render( EngineGraphics g) {
        if(parent.isSolid()) {
            g.drawRect(getCollRight(), Color.BLUE, false);
            g.drawRect(getCollLeft(), Color.BLUE, false);
            g.drawRect(getCollUp(), Color.BLUE, false);
            g.drawRect(getCollDown(), Color.BLUE, false);

        }
    }
}
