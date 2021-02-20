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
        if(isUp()){
            particleSystem.RenderParticles(g);
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
            particleSystem.updateParticles(delta);
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
