package TestingGameEngine;

import Entities.Entity;
import GameComponents.Input;
import GameComponents.Rigidbody;
import Graphics.Animation;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class platformPlayer extends Entity {

    public platformPlayer(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    public platformPlayer(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(EngineGraphics g) {

        g.drawRect(getX(), getY(), width,height, color, true);
        g.drawRect(getX(), getY(),width,height, Color.WHITE, false);

    }

    private boolean jumping = false;
    @Override
    public void update(double delta) {
        Input input = (Input) getComponent(Input.class);
        Rigidbody rigidbody = (Rigidbody) getComponent(Rigidbody.class);

        if(input.KeyDown(KeyEvent.VK_D)){
            right = true;
        }
        if( input.KeyDown(KeyEvent.VK_A)){
            left = true;
        }
        if( input.KeyDown(KeyEvent.VK_SPACE)){
           jumping = true;
            rigidbody.setVelocity(new Vector2f(0, -10));

        }

        if(input.KeyUp(KeyEvent.VK_D)){
            right = false;
            rigidbody.setVelocity(new Vector2f(0,0));

        }
        if( input.KeyUp(KeyEvent.VK_A)){
            left = false;
            rigidbody.setVelocity(new Vector2f(0,0));

        }
        if( input.KeyUp(KeyEvent.VK_SPACE)){
            rigidbody.setVelocity( new Vector2f(0,10));

        }



        if(right){
            rigidbody.setVelocity(new Vector2f((float) (moveSpeed * delta),0));
        }
        if(left){
            rigidbody.setVelocity(new Vector2f(-(float) (moveSpeed * delta),0));
        }
    }


}
