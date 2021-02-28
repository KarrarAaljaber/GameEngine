package TestingGameEngine;

import Entities.Entity;
import Entities.Light;
import GameComponents.*;
import GameHandlers.GameObject;
import GameHandlers.GameState;
import Graphics.ImageLoader;
import Graphics.Screen;
import Graphics.SpriteSheet;
import Particles.Particle;
import Particles.ParticleSystem;
import Tiles.TileHandler;
import Tiles.TileLayers;
import UI.UIButton;
import UI.UIComponent;
import UI.UIContainer;
import Utilities.Camera;
import Utilities.Node;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Graphics.Renderer;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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
    }

    public static void main(String[]args){

        Game2 run = new Game2(screen);
    }



    private static final Color transparency = new Color(0, 0, 0, 0);

    private Chessboard board;
    private ArrayList<Node> moveSteps;
    private   ArrayList<Entity> p;
    Rigidbody pbody;


    private Light light;
    private UIContainer uiContainer;


    @Override
    public void init() {

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



        Rigidbody playerbody = new Rigidbody(player );
        player.addComponent(playerbody);
        player.addComponent(new Collider(player, player.getWidth() - 6, player.getHeight() - 6));
        player.addComponent(new Collision(player));
        player.setMoveSpeed(2f);

        Random random = new Random();
        p = new ArrayList<>();
        for(int  i=0; i < 1; i++){
            p.add(new ChessPlayer(random.nextInt(199),random.nextInt(199),32,32,s2));
        }
        for(int i=0; i < p.size(); i++){


            p.get(i).addComponent(new Collider(  p.get(i),   p.get(i).getWidth() - 6,   p.get(i).getHeight() - 6));
            p.get(i).addComponent(new Collision(  p.get(i)));
            p.get(i).addComponent(new Rigidbody(p.get(i)));
            p.get(i).setMoveSpeed(0.01f);
        }



        cam = new Camera(player,WIDTH / 2,HEIGHT /2, WIDTH ,HEIGHT,1);

        cam.setZoomscale(2f);



        tilesheet = new SpriteSheet("terrain.png",32,32);


        tileHandler = new TileHandler("test.tmx", 32,32,tilesheet );




        //Screen stuff
        screen = new Screen(player,cam,WIDTH,HEIGHT, 2,false,false, new Color(0,0,0));
        Renderer.getGch().getGameCases().add(this);

        Renderer.addObject(player);

        setDarkestvalue(0.2f);
        setBrightvalue(0.5f);

        Renderer.addObject(cam);
        tileHandler.render();

        Renderer.addObject(player);
        Renderer.addEntities(p);
        Renderer.addUIContainer(uiContainer);



        this.addLight(new Light(300,2, 300, new float[] {2,0,0}, getBrightvalue()));
        this.addLight(new Light(500,1000, 100, new float[]  {0,0.2f,0}, getBrightvalue()));
        this.addLight(new Light(700,600, 100, new float[] {0,1,0}, getBrightvalue()));
        this.addLight(new Light(200,900, 100, new float[] {1,0,0}, getBrightvalue()));



        light = new Light(player.getX(),player.getY(), 100, new float[]{1,1,1}, getBrightvalue());
        this.addLight(light);




        /*
        SolidTile[] solidTile = new SolidTile[32];
        for(int i=0; i < solidTile.length; i++)
        {

            solidTile[i] = new SolidTile( i * 32, HEIGHT, 32,32,Color.GREEN );
        }
        for(int i=0; i < solidTile.length; i++)
        {

            solidTile[i].addComponent(new Collider( solidTile[i],solidTile[i].getX(),  solidTile[i].getY(),  solidTile[i].getWidth(),  solidTile[i].getHeight()));
        }

        Renderer.addObjecArray(solidTile);

         */






    }


    private int counter =0;

    private float angle = 0.0f;
    @Override
    public void update(float delta ) {
        uiContainer.update();
        angle +=0.01f;
        light.setY(player.getY());
        light.setX(player.getX());
        for(int i=0; i < p.size(); i++){
            Vector2f v = Vector2f.minusVectors(player.getPosition(),p.get(i).getPosition() );
            v.multiplyValue(p.get(i).getMoveSpeed());
            Rigidbody rigidbody =(Rigidbody) p.get(i).getComponent(Rigidbody.class);
            rigidbody.setVelocity(v);

        }

        if(Renderer.getInput().KeyDown(KeyEvent.VK_L)){
            uiContainer.setVisiable(true);
        }

    }



    @Override
    public void render(EngineGraphics g) {
        //    g.drawRect(new Vector2f(22,22), 50,500, Color.RED,false);
       //  g.setLighting(true);
    }


}
