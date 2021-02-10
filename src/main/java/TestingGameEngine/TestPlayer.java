package TestingGameEngine;

import Entities.Entity;
import GameHandlers.GameObject;
import Graphics.Animation;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TestPlayer extends Entity {

    private  Animation walkUp;
    private BufferedImage[] walkUpSprites;

    private  Animation walkDown;
    private BufferedImage[] walkDownSprites;


    private  Animation walkLeft;
    private BufferedImage[]  walkLeftSprites;

    private  Animation walkRight;
    private BufferedImage[] walkRightSprites;


    public TestPlayer(Vector2f pos, int width, int height, Sprite sprite) {
        super(pos, width, height, sprite);
        walkUpSprites = new BufferedImage[3];
        walkUpSprites[0] = sprite.getSpriteImage(1,1);
        walkUpSprites[1] = sprite.getSpriteImage(2,1);
        walkUpSprites[2] = sprite.getSpriteImage(3,1);

        walkRightSprites = new BufferedImage[3];
        walkRightSprites[0] = sprite.getSpriteImage(1,2);
        walkRightSprites[1] = sprite.getSpriteImage(2,2);
        walkRightSprites[2] = sprite.getSpriteImage(3,2);

        walkDownSprites = new BufferedImage[3];
        walkDownSprites[0] = sprite.getSpriteImage(1,3);
        walkDownSprites[1] = sprite.getSpriteImage(2,3);
        walkDownSprites[2] = sprite.getSpriteImage(3,3);

        walkLeftSprites = new BufferedImage[3];
        walkLeftSprites[0] = sprite.getSpriteImage(1,4);
        walkLeftSprites[1] = sprite.getSpriteImage(2,4);
        walkLeftSprites[2] = sprite.getSpriteImage(3,4);



        walkUp = new Animation(300, walkUpSprites);
        walkDown = new Animation(300, walkDownSprites);
        walkLeft = new Animation(300, walkLeftSprites);
        walkRight = new Animation(300, walkRightSprites);

    }

    @Override
    public void render(EngineGraphics g) {
     //   g.drawString("X:  " + pos.getX() + "   Y:" + pos.getY(), Color.WHITE , new Vector2f(getPos().getX() , getPos().getY() + 10 ) ,"Arial", 16);
        if(isUp()){
            g.drawImage(walkUp.getCurrentFrame(),pos.getIntX(), pos.getIntY(), width, height);
        }else if(isDown()){
            g.drawImage(walkDown.getCurrentFrame(),pos.getIntX(), pos.getIntY(), width, height);

        }else if( isLeft()){
            g.drawImage(walkLeft.getCurrentFrame(),pos.getIntX(), pos.getIntY(), width, height);

        }else if(isRight()){
            g.drawImage(walkRight.getCurrentFrame(),pos.getIntX(), pos.getIntY(), width, height);

        }else{
            g.drawImage(walkDownSprites[0],pos.getIntX(), pos.getIntY(), width, height);

        }

    }

    @Override
    public void update(double delta) {
        walkUp.update(delta);
        walkRight.update(delta);
        walkLeft.update(delta);
        walkDown.update(delta);

        pos = pos.plus(velocity);

    }
}
