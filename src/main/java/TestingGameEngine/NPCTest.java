package TestingGameEngine;

import Audio.AudioPlayer;
import Audio.SoundClip;
import Entities.Entity;
import GameComponents.Collision;
import GameComponents.Kinematic2D;
import Graphics.Animation;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Graphics.SpriteSheet;

import Utilities.EngineMath;
import Utilities.Vector2f;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import Graphics.Renderer;

public class NPCTest extends Entity {

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
    private Vector2f velocityGoal;

    public NPCTest(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);

        spriteSheet = new SpriteSheet("dog.png",32,48);

        walkDownSprites = new BufferedImage[3];


        velocityGoal = new Vector2f(0,0);
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
        Kinematic2D kinematic2D = (Kinematic2D) getComponent(Kinematic2D.class);
        kinematic2D.getVelocity().setX(EngineMath.Lerp(velocityGoal.getX(), kinematic2D.getVelocity().getX(), delta * 1));
        kinematic2D.getVelocity().setY(EngineMath.Lerp(velocityGoal.getY(), kinematic2D.getVelocity().getY(), delta *1));
        walkLeft.update();
        walkRight.update();
        walkUp.update();
        walkDown.update();




        if(kinematic2D.getVelocity().getX() > 0){
            right = true;
            left = false;
            up = false;
            down = false;
        }else if(kinematic2D.getVelocity().getX() < 0){
            right = false;
            left = true;
            up = false;
            down = false;
        }

        if(kinematic2D.getVelocity().getY() >  0&& kinematic2D.getVelocity().getX() >= 0){
            down = true;
            right = false;
            left = false;
            up = false;
        }else if(kinematic2D.getVelocity().getY() <0 && kinematic2D.getVelocity().getX() <= 0){
            down = false;
            right = false;
            left = false;
            up = true;
        }


    }

    public Vector2f getVelocityGoal() {
        return velocityGoal;
    }

    public void setVelocityGoal(Vector2f velocityGoal) {
        this.velocityGoal = velocityGoal;
    }

}
