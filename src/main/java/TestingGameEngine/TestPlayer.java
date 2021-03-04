package TestingGameEngine;

import Audio.AudioPlayer;
import Audio.SoundClip;
import Entities.Entity;
import Particles.ParticleSystem;
import GameComponents.Kinematic2D;
import Graphics.Animation;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Particles.Particle;
import Graphics.Renderer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Graphics.SpriteSheet;
import Utilities.EngineMath;
import Utilities.Vector2f;

import javax.sound.sampled.Clip;

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


    private ParticleSystem ps;
    private SpriteSheet spriteSheet;


    private AudioPlayer audioPlayer = new AudioPlayer();
    Clip clip = AudioPlayer.getClip("walk.wav");
    SoundClip audio = new SoundClip(clip);

    private Vector2f velocityGoal;
    public TestPlayer(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
        spriteSheet = new SpriteSheet("playersheet.png", 24, 32);


        walkUpSprites = new BufferedImage[3];
        velocityGoal = new Vector2f(0, 0);


        walkUpSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 0, 0);
        walkUpSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 0, 1);
        walkUpSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 0, 2);

        walkRightSprites = new BufferedImage[3];

        walkRightSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 1, 0);
        walkRightSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 1, 1);
        walkRightSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 1, 2);

        walkDownSprites = new BufferedImage[3];

        walkDownSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 2, 0);
        walkDownSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 2, 1);
        walkDownSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 2, 2);

        walkLeftSprites = new BufferedImage[3];

        walkLeftSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 3, 0);
        walkLeftSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 3, 1);
        walkLeftSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet, 3, 2);


        //    sheet = new SpriteSheet("blocksheet.png");
//      health = new Sprite(sheet,32,32);

        walkUp = new Animation(300, walkUpSprites);
        walkDown = new Animation(300, walkDownSprites);
        walkLeft = new Animation(300, walkLeftSprites);
        walkRight = new Animation(300, walkRightSprites);

        ps = new ParticleSystem(this);
        addComponent(ps);

        audio.setSoundVolume(-25);

    }


    @Override
    public void render(EngineGraphics g) {
     //   g.drawString("X:  " + pos.getX() + "   Y:" + pos.getY(), Color.WHITE , new Vector2f(getPos().getX() , getPos().getY() + 10 ) ,"Arial", 16);

        if(isUp()){

            g.drawImage(walkUp.getCurrentFrame(),getX(), getY(), width, height);

        }else if(isDown()){
            //  particleSystem.addParticles(new Particle(new Vector2f(getX()  - width / 2, getY() ),3,3, new Color(65, 234, 65),10),3);

            g.drawImage(walkDown.getCurrentFrame(),getX(),getY(), width, height);


        }else if( isLeft()){
            g.drawImage(walkLeft.getCurrentFrame(),getX(),getY(), width, height);
            //  particleSystem.addParticles(new Particle(new Vector2f(getX()  - width / 2, getY() ),3,3, new Color(65, 234, 65),10),3);

        }else if(isRight()){
            g.drawImage(walkRight.getCurrentFrame(),getX(),getY(),width, height);
            //  particleSystem.addParticles(new Particle(new Vector2f(getX()  - width / 2, getY() ),3,3, new Color(65, 234, 65),10),3);

        }else{
            g.drawImage(walkDownSprites[0],getX(),getY(), width, height);
            audioPlayer.stopSound(audio);
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
    public void update(float delta) {

        walkUp.update();
        walkRight.update();
        walkLeft.update();
        walkDown.update();

        //  move(delta);
        Kinematic2D kinematic2D = (Kinematic2D) getComponent(Kinematic2D.class);


        if(Renderer.getInput().KeyDown(KeyEvent.VK_W) ){

            setUp(true);
            setDown(false);
            setLeft(false);
            setRight(false);

            audioPlayer.playSound(audio);


        }


        if(Renderer.getInput().KeyDown(KeyEvent.VK_S)) {
            setUp(false);
            setDown(true);
            setLeft(false);
            setRight(false);
            audioPlayer.playSound(audio);

        }


        if(Renderer.getInput().KeyDown(KeyEvent.VK_A) ){
            setUp(false);
            setDown(false);
            setLeft(true);
            setRight(false);
            audioPlayer.playSound(audio);

        }
        if(Renderer.getInput().KeyDown(KeyEvent.VK_D) ){
            setUp(false);
            setDown(false);
            setLeft(false);
            setRight(true);
            audioPlayer.playSound(audio);

        }
        if(Renderer.getInput().KeyDown(KeyEvent.VK_SPACE) ){
            jump = true;
        }
        if(Renderer.getInput().KeyUp(KeyEvent.VK_SPACE) ){
            jump = false;
        }




        if(Renderer.getInput().KeyUp( KeyEvent.VK_W)) {
            kinematic2D.setVelocity(new Vector2f(0, 0));
            setUp(false);

        }

        if(Renderer.getInput().KeyUp( KeyEvent.VK_S)) {
            kinematic2D.setVelocity(new Vector2f(0, 0));
            setDown(false);



        }
        if(Renderer.getInput().KeyUp( KeyEvent.VK_A)) {
            kinematic2D.setVelocity(new Vector2f(0, 0));
            setLeft(false);

        }
        if(Renderer.getInput().KeyUp( KeyEvent.VK_D)) {
            kinematic2D.setVelocity(new Vector2f(0, 0));
            setRight(false);
        }

        Particle p = (new Particle(getCenterX(),getY(), 5,5,EngineMath.rand.nextInt(360),
                new Color(66, 46, 46),2000));
        var angleInRadians =(int)p.getRotationAngle() * Math.PI / 180;
        p.setMoveSpeed(EngineMath.randomFloat(0,1));
        p.getRigidbody().getVelocity().setX((float) ( p.getMoveSpeed()* Math.cos(angleInRadians) * delta));
        p.getRigidbody().getVelocity().setY((float) (p.getMoveSpeed()* Math.sin(angleInRadians) * delta));

        if(up){
            kinematic2D.setVelocity(new Vector2f(0, -moveSpeed));
            p.rotate(EngineMath.rand.nextInt(360));
            ps.addParticles(p,25);
        }
        if(down){
            kinematic2D.setVelocity(new Vector2f(0, moveSpeed));

        }  if(left){
            kinematic2D.setVelocity(new Vector2f(-moveSpeed, 0));
            p.rotate(EngineMath.rand.nextInt(360));

            ps.addParticles(p,25);

        }  if(right){
            kinematic2D.setVelocity(new Vector2f(moveSpeed, 0));
            p.rotate(EngineMath.rand.nextInt(360));

            ps.addParticles(p,25);
        }


    }

    public Vector2f getVelocityGoal() {
        return velocityGoal;
    }

    public void setVelocityGoal(Vector2f velocityGoal) {
        this.velocityGoal = velocityGoal;
    }
}
