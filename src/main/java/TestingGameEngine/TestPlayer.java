package TestingGameEngine;

import Entities.Entity;
import GameComponents.Collision;
import GameHandlers.GameObject;
import Graphics.Animation;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.APathfinding;
import Utilities.Node;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import Graphics.SpriteSheet;

public class TestPlayer extends Entity {

    private  Animation walkUp;
    private BufferedImage[] walkUpSprites;

    private  Animation walkDown;
    private BufferedImage[] walkDownSprites;


    private  Animation walkLeft;
    private BufferedImage[]  walkLeftSprites;

    private  Animation walkRight;
    private BufferedImage[] walkRightSprites;

    private Sprite health;
    private SpriteSheet sheet;


    private ArrayList<Node> path;
    public TestPlayer(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height,sprite);
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


        sheet = new SpriteSheet("blocksheet.png");
        health = new Sprite(sheet,32,32);

        walkUp = new Animation(300, walkUpSprites);
        walkDown = new Animation(300, walkDownSprites);
        walkLeft = new Animation(300, walkLeftSprites);
        walkRight = new Animation(300, walkRightSprites);
    }
    @Override
    public void init() {

    }
    @Override
    public void render(EngineGraphics g) {
     //   g.drawString("X:  " + pos.getX() + "   Y:" + pos.getY(), Color.WHITE , new Vector2f(getPos().getX() , getPos().getY() + 10 ) ,"Arial", 16);
        if(isUp()){
            g.drawImage(walkUp.getCurrentFrame(),x, y, width, height);
        }else if(isDown()){
            g.drawImage(walkDown.getCurrentFrame(),x,y, width, height);

        }else if( isLeft()){
            g.drawImage(walkLeft.getCurrentFrame(),x,y, width, height);

        }else if(isRight()){
            g.drawImage(walkRight.getCurrentFrame(),x,y,width, height);

        }else{
            g.drawImage(walkDownSprites[0],x,y, width, height);

        }

        for(int i=1; i < 5; i++){
            g.drawSprite(health, (this.getX() - 8 ) + i * 8 ,this.getY(),3,1,8,8  );
        }

        /*

        g.drawRect(getCollDown(),Color.BLACK,false);
        g.drawRect(getCollLeft(),Color.BLACK,false);
        g.drawRect(getCollRight(),Color.BLACK,false);
        g.drawRect(getCollUp(),Color.BLACK,false);
*/
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void update(double delta) {

        walkUp.update(delta);
        walkRight.update(delta);
        walkLeft.update(delta);
        walkDown.update(delta);



        move(delta);
        Collision col = (Collision) getComponent(Collision.class);
        if(!col.isCollided()){
            setVelY(7);

        }


    }


}
