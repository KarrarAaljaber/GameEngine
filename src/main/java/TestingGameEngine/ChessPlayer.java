package TestingGameEngine;

import Audio.AudioClip;
import Audio.AudioPlayer;
import Audio.SoundClip;
import Entities.Entity;
import GameComponents.Rigidbody;
import Graphics.Animation;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Graphics.SpriteSheet;
import Particles.Particle;
import Utilities.Vector2f;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ChessPlayer extends Entity {

    private  Animation walkUp;
    private BufferedImage[] walkUpSprites;

    private  Animation walkDown;
    private BufferedImage[] walkDownSprites;


    private  Animation walkLeft;
    private BufferedImage[]  walkLeftSprites;

    private  Animation walkRight;
    private BufferedImage[] walkRightSprites;

    private SpriteSheet spriteSheet;

    private AudioPlayer audioPlayer = new AudioPlayer();
    Clip clip = AudioPlayer.getClip("bark.wav");
    SoundClip audio = new SoundClip(clip);

    public ChessPlayer(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);

        spriteSheet = new SpriteSheet("dog.png",32,48);

        walkDownSprites = new BufferedImage[3];



        walkDownSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,0,0);
        walkDownSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,0,1);
        walkDownSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,0,2);

        walkLeftSprites = new BufferedImage[3];

        walkLeftSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,1,0);
        walkLeftSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,1,1);
        walkLeftSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,1,2);

        walkRightSprites = new BufferedImage[3];

        walkRightSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,2,0);
        walkRightSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,2,1);
        walkRightSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,2,2);

        walkUpSprites = new BufferedImage[3];

        walkUpSprites[0] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,3,0);
        walkUpSprites[1] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,3,1);
        walkUpSprites[2] = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,3,2);




        //    sheet = new SpriteSheet("blocksheet.png");
//      health = new Sprite(sheet,32,32);

        walkUp = new Animation(300, walkUpSprites);
        walkDown = new Animation(300, walkDownSprites);
        walkLeft = new Animation(300, walkLeftSprites);
        walkRight = new Animation(300, walkRightSprites);

        audio.setSoundVolume(-50);
        audio.startClip();

        Random random  = new Random();
        audio.setStartFrame(random.nextInt(audio.frameLength()));
        audio.setLoopable();

        audioPlayer.playSound(audio);





    }


    public void shootAt(float delta,Entity e, EngineGraphics g){
        Particle particle = new Particle(new Vector2f(getX() + getWidth() / 2, height), 5,5,Color.RED, 1000);
        Vector2f  vel = Vector2f.minusVectors(e.getPosition(), getPosition());
        vel.multiplyValue(0.001f);
        particle.setVelocity(vel);
        particle.update(delta,this);
        particle.render(g);
    }
    @Override
    public void render(EngineGraphics g) {


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

    }

    @Override
    public void update(float delta) {
        Rigidbody rigidbody = (Rigidbody) getComponent(Rigidbody.class);
        walkLeft.update();
        walkRight.update();
        walkUp.update();
        walkDown.update();

        if(rigidbody.getVelocity().getX() > 0){
            right = true;
            left = false;
            up = false;
            down = false;
        }else if(rigidbody.getVelocity().getX() < 0){
            right = false;
            left = true;
            up = false;
            down = false;
        }

        if(rigidbody.getVelocity().getY() >  0&& rigidbody.getVelocity().getX() >= 0){
            down = true;
            right = false;
            left = false;
            up = false;
        }else if(rigidbody.getVelocity().getY() <0 && rigidbody.getVelocity().getX() <= 0){
            down = false;
            right = false;
            left = false;
            up = true;
        }


    }

    @Override
    public void init() {

    }
}
