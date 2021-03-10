package TestingGameEngine;

import Entities.Entity;
import GameComponents.Kinematic2D;
import Graphics.EngineGraphics;
import Graphics.Renderer;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player  extends Entity {

    private Kinematic2D kinematic2D;
    public Player(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        kinematic2D = new Kinematic2D(this);
        addComponent(kinematic2D);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawRect(getX(),getY(),width,height, color,true);
    }

    @Override
    public void update(float delta) {
        if(Renderer.getInput().KeyDown(KeyEvent.VK_D)){
            kinematic2D.setVelocity(new Vector2f(2,0));
        }
        if(Renderer.getInput().KeyDown(KeyEvent.VK_A)){
            kinematic2D.setVelocity(new Vector2f(-2,0));
        }
        if(Renderer.getInput().KeyUp(KeyEvent.VK_D)){
            kinematic2D.setVelocity(new Vector2f(0,0));
        }
        if(Renderer.getInput().KeyUp(KeyEvent.VK_A)){
            kinematic2D.setVelocity(new Vector2f(0,0));
        }
    }
}
