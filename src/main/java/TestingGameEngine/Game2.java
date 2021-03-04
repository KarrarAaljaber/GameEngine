package TestingGameEngine;

import Audio.AudioClip;
import Audio.AudioPlayer;
import Audio.SoundClip;
import Entities.Entity;
import Entities.Light;
import GameComponents.*;
import GameHandlers.GameState;
import Graphics.ImageLoader;
import Graphics.Screen;
import Graphics.SpriteSheet;
import Particles.Particle;
import Particles.ParticleSystem;
import Tiles.TileHandler;
import Tiles.TileLayers;
import UI.UIButton;
import UI.UIContainer;
import Utilities.Camera;
import Utilities.Node;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Graphics.Renderer;
import Utilities.Vector2f;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Game2 extends GameState {


    private static Screen screen;
    private SpriteSheet spriteSheet;
    private ImageLoader loader;

    //GameObjects
    private TestPlayer player;
    private TileLayers tileMap;

    //SpriteSheets
    private SpriteSheet playersheet;
    private SpriteSheet tilesheet;
    private SpriteSheet tileMapSheet;


    public static final int SCALE = 2;
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;




    //Utils
    private Camera cam;




    private TileHandler tileHandler;

    public Game2( Screen screen) {
        super( screen);

        ps = new ParticleSystem();
        audioPlayer = new AudioPlayer();
        Clip clip = AudioPlayer.getClip("music.wav");
        AudioClip audio = new SoundClip(clip);
        audio.setSoundVolume(-20);
       // audio.setLoopable();
        //audioPlayer.playSound(audio);
        /*
        AudioPlayer audioPlayer = new AudioPlayer();
        Clip clip = AudioPlayer.getClip("gatti.wav");
        MusicClip musicClip = new MusicClip(clip);
        musicClip.setMusicVolume(0.9f);
        audioPlayer.playMusic(musicClip);

*/
        uiContainer = new UIContainer(50,100,200,200);
        uiContainer.setBackgroundColor(new Color(0,0,0,200));
        UIButton btn = new UIButton(uiContainer,100,120,100,30,(new Color(0,255,0,100)));
        uiContainer.setBorderThickness(3);

        btn.setText("Click ME!");
        btn.setTextColor(Color.WHITE);
        btn.setBorderThickness(3);
        btn.setBorderColor(Color.BLACK);

        UIButton btn2 = new UIButton(uiContainer,100,200,100,30,(new Color(255,0,0,100)));
        btn2.setText("Click NOO!");
        btn2.setFontSize(8);
        btn2.setTextColor(Color.WHITE);
        btn2.setBorderThickness(3);
        btn2.setBorderColor(Color.BLACK);
        uiContainer.placeUIComponentAtCenterX(btn);
        uiContainer.placeUIComponentAtCenterX(btn2);

        // uiContainer.placeUIComponentAtCenter(btn);

        uiContainer.addUIComponent(btn);
        uiContainer.addUIComponent(btn2);

        //objects
        // tileMap = new TileMap(500, 500, 32,32, tilesheet);
        SpriteSheet spriteSheet = new SpriteSheet("playersheet.png",24,32);
        SpriteSheet spriteSheet2 = new SpriteSheet("dog.png",32,48);

        BufferedImage image = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,1,1);
        Sprite s =  new Sprite(image);
        BufferedImage image2 = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet2,1,1);

        Sprite s2 =  new Sprite(image2);




        player = new TestPlayer((WIDTH / 3),(HEIGHT / 2), 32,32, s);
        player.placeGameObjectAtTile(6,15,32,32);

        //components



        Kinematic2D playerbody = new Kinematic2D(player );
        player.addComponent(playerbody);
        player.addComponent(new Collider(player, player.getWidth() - 6, player.getHeight() - 6));
        player.addComponent(new Collision(player));
        player.setMoveSpeed(1.5f);

        Random random = new Random();
        p = new ArrayList<>();
        for(int  i=0; i < 1; i++){
            p.add(new NPCTest(random.nextInt(199),random.nextInt(199),32,32,s2));
        }
        for(int i=0; i < p.size(); i++){


            p.get(i).addComponent(new Collider(  p.get(i),   p.get(i).getWidth() - 6,   p.get(i).getHeight() - 6));
            p.get(i).addComponent(new Collision(  p.get(i)));
            p.get(i).addComponent(new Kinematic2D(p.get(i)));
            p.get(i).setMoveSpeed(0.01f);
        }



        cam = new Camera(WIDTH / 2,HEIGHT /2, WIDTH ,HEIGHT,1);


        tilesheet = new SpriteSheet("terrain.png",32,32);


        tileHandler = new TileHandler("test.tmx", 32,32,tilesheet );

//        getScreen().getRenderer().setPlayer(player);
        //      getScreen().getRenderer().setCamera(cam);


        //Screen stuff
        Renderer.getGch().addGameState(this);
        screen.getRenderer().setCamera(cam);
        Renderer.getGch().setPlayer(player);
        Renderer.getGch().setRenderOptimized(true);
        Renderer.getGch().setUpdateOptimized(true);




        Renderer.addObject(cam);
        tileHandler.render();
        Renderer.addObject(player);
        Renderer.addEntities(p);
        Renderer.addUIContainer(uiContainer);


    }




    private static final Color transparency = new Color(0, 0, 0, 0);

    private ArrayList<Node> moveSteps;
    private   ArrayList<Entity> p;
    Kinematic2D pbody;


    private Light light;
    private UIContainer uiContainer;

    //particleSystem testing
    private ParticleSystem ps;

    private AudioPlayer audioPlayer;




    private int counter =0;

    private float angle = 0.0f;
    private Random rand = new Random();
    @Override
    public void update(float delta ) {
        cam.followEntity(player);
        angle ++;

        ps.update(delta);
        for(int i=0; i < p.size(); i++){
            Vector2f v = Vector2f.minusVectors(player.getPosition(),p.get(i).getPosition() );
            v.multiplyValue(p.get(i).getMoveSpeed());
            Kinematic2D kinematic2D =(Kinematic2D) p.get(i).getComponent(Kinematic2D.class);
            kinematic2D.setVelocity(v);

        }
        if(Renderer.getInput().isMouseDragged()){
            for(int i=0; i < 2; i++){
                Particle p = (new Particle(Renderer.getInput().getMouseDragX(), Renderer.getInput().getMouseDragY(), 15,15,rand.nextInt(180),
                        new Color(rand.nextInt(255), 83, 83),1000));
                var angleInRadians =(int)p.getRotationAngle() * Math.PI / 180;
                p.setMoveSpeed(1);
                p.getRigidbody().getVelocity().setX((float) ( p.getMoveSpeed()* Math.cos(angleInRadians) * delta));
                p.getRigidbody().getVelocity().setY((float) (p.getMoveSpeed()* Math.sin(angleInRadians) * delta));
                ps.addParticles(p,25);

            }


        }
        if(Renderer.getInput().KeyDown(KeyEvent.VK_L)){
            uiContainer.setVisiable(true);
        }



    }
    private Particle particle;
    boolean addParticles = false;




    @Override
    public void render(EngineGraphics g) {
       // g.setLighting(true);

        ps.render(g);

    }


}
