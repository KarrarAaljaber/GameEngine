package TestingGameEngine;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

public class TestPlayer extends GameObject {


    private Vector2f velocity;

    public TestPlayer(Vector2f pos, int width, int height, Sprite sprite) {
        super(pos, width, height, sprite);
        velocity = new Vector2f(0,0);
    }

    @Override
    public void render(EngineGraphics g) {

        g.drawString("X:  " + pos.getX() + "   Y:" + pos.getY() , new Vector2f(getPos().getX() , getPos().getY() + 10 ) ,"Arial", 16);
        g.drawGameObject(this,1,1);
    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    @Override
    public void update(double delta) {
        Vector2f move = pos.plus(velocity);
        pos = move;


    }
}
