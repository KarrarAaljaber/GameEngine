package TestingGameEngine;

import Entities.Entity;
import GameComponents.Collision;
import GameComponents.Input;
import GameComponents.ParticleSystem;
import GameComponents.Rigidbody;
import Graphics.Animation;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Particles.Particle;
import Graphics.ImageLoader;

import Utilities.Node;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.SpriteSheet;
import Utilities.Vector2f;

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


    private boolean jump = false;
    private boolean falling = true;


    private ParticleSystem particleSystem;
    private SpriteSheet spriteSheet;

    public TestPlayer(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height,sprite);
        spriteSheet = new SpriteSheet("playersheet.png");



        walkDownSprites = new BufferedImage[8];
        walkDownSprites[0] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,1,1,width,height);
        walkDownSprites[1] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,2,1,width,height);
        walkDownSprites[2] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,3,1,width,height);
        walkDownSprites[3] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,4,1,width,height);
        walkDownSprites[4] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,5,1,width,height);
        walkDownSprites[5] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,6,1,width,height);
        walkDownSprites[6] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,7,1,width,height);
        walkDownSprites[7] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,8,1,width,height);

        walkLeftSprites = new BufferedImage[8];
        walkLeftSprites[0] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,1,2,width,height);
        walkLeftSprites[1] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,2,2,width,height);
        walkLeftSprites[2] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,3,2,width,height);
        walkLeftSprites[3] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,4,2,width,height);
        walkLeftSprites[4] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,5,2,width,height);
        walkLeftSprites[5] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,6,2,width,height);
        walkLeftSprites[6] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,7,2,width,height);
        walkLeftSprites[7] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,8,2,width,height);



        walkRightSprites = new BufferedImage[8];
        walkRightSprites[0] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,1,3,width,height);
        walkRightSprites[1] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,2,3,width,height);
        walkRightSprites[2] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,3,3,width,height);
        walkRightSprites[3] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,4,3,width,height);
        walkRightSprites[4] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,5,3,width,height);
        walkRightSprites[5] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,6,3,width,height);
        walkRightSprites[6] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,7,3,width,height);
        walkRightSprites[7] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,8,3,width,height);


        walkUpSprites = new BufferedImage[8];
        walkUpSprites[0] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,1,4,width,height);
        walkUpSprites[1] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,2,4,width,height);
        walkUpSprites[2] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,3,4,width,height);
        walkUpSprites[3] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,4,4,width,height);
        walkUpSprites[4] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,5,4,width,height);
        walkUpSprites[5] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,6,4,width,height);
        walkUpSprites[6] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,7,4,width,height);
        walkUpSprites[7] = SpriteSheet.getSpriteImageFromSpriteSHeet(spriteSheet,8,4,width,height);








  //      sheet = new SpriteSheet("blocksheet.png");
//        health = new Sprite(sheet,32,32);

        walkUp = new Animation(300, walkUpSprites);
        walkDown = new Animation(300, walkDownSprites);
        walkLeft = new Animation(300, walkLeftSprites);
        walkRight = new Animation(300, walkRightSprites);

        Particle particle = new Particle(new Rectangle(x,y,5,5), Color.RED,255);
        particleSystem = new ParticleSystem(this);
        addComponent(particleSystem);
        particleSystem.addParticles(particle, 50);


    }
    @Override
    public void init() {

    }
    @Override
    public void render(EngineGraphics g) {
     //   g.drawString("X:  " + pos.getX() + "   Y:" + pos.getY(), Color.WHITE , new Vector2f(getPos().getX() , getPos().getY() + 10 ) ,"Arial", 16);
        particleSystem.RenderParticles(g);

        if(isUp()){
            g.drawImage(walkUp.getCurrentFrame(),getX(), getY(), width, height);
        }else if(isDown()){
            g.drawImage(walkDown.getCurrentFrame(),getX(),getY(), width, height);

        }else if( isLeft()){
            g.drawImage(walkLeft.getCurrentFrame(),getX(),getY(), width, height);

        }else if(isRight()){
            g.drawImage(walkRight.getCurrentFrame(),getX(),getY(),width, height);

        }else{
            g.drawImage(walkDownSprites[0],getX(),getY(), width, height);

        }

        /*
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
        Input input = (Input) getComponent(Input.class);

        //  move(delta);
        Collision col = (Collision) getComponent(Collision.class);
        Rigidbody rigidbody = (Rigidbody) getComponent(Rigidbody.class);

        if(input.KeyDown(KeyEvent.VK_W) ){
            setUp(true);
            setDown(false);
            setLeft(false);
            setRight(false);
        }


        if(input.KeyDown(KeyEvent.VK_S)) {
            setUp(false);
            setDown(true);
            setLeft(false);
            setRight(false);
        }


        if(input.KeyDown(KeyEvent.VK_A) ){
            setUp(false);
            setDown(false);
            setLeft(true);
            setRight(false);
        }
        if(input.KeyDown(KeyEvent.VK_D) ){
            setUp(false);
            setDown(false);
            setLeft(false);
            setRight(true);
        }
        if(input.KeyDown(KeyEvent.VK_SPACE) ){
            jump = true;
        }
        if(input.KeyUp(KeyEvent.VK_SPACE) ){
            jump = false;
        }




        if(input.KeyUp( KeyEvent.VK_W)) {
            rigidbody.setVelocity(new Vector2f(0,0));
            setUp(false);

        }

        if(input.KeyUp( KeyEvent.VK_S)) {
           rigidbody.setVelocity(new Vector2f(0,0));
            setDown(false);



        }
        if(input.KeyUp( KeyEvent.VK_A)) {
            rigidbody.setVelocity(new Vector2f(0,0));
            setLeft(false);

        }
        if(input.KeyUp( KeyEvent.VK_D)) {
            rigidbody.setVelocity(new Vector2f(0,0));
            setRight(false);
        }


        if(up){
            rigidbody.setVelocity(new Vector2f(0,-moveSpeed * (float)delta));
        }
        if(down){
            rigidbody.setVelocity(new Vector2f(0,moveSpeed * (float)delta));
        }  if(left){
            rigidbody.setVelocity(new Vector2f(-moveSpeed * (float)delta,0));
        }  if(right){
            rigidbody.setVelocity(new Vector2f(moveSpeed * (float)delta,0));
        }


    }


}
