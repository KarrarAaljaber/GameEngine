package TestingGameEngine;

import  Graphics.Screen;
import Entities.Entity;
import GameComponents.Collider;
import GameComponents.Collision;
import GameComponents.Input;
import GameComponents.Rigidbody;
import GameHandlers.GameState;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Particles.Particle;
import Particles.ParticleSystem;
import Tiles.SolidTile;
import Tiles.TileHandler;
import Tiles.TileLayers;
import Utilities.Node;
import Utilities.Camera;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.Renderer;
import Graphics.ImageLoader;
import Graphics.Sprite;

import Graphics.SpriteSheet;
import Utilities.Vector2f;

public class Game extends GameState {


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


    private  TileHandler tileHandler;

    public Game(Screen screen) {
        super(screen);
    }


    public static void main(String[]args){
        Game run = new Game(screen);
    }



    private static final Color transparency = new Color(0, 0, 0, 0);

    private Chessboard board;
    private ArrayList<Node> moveSteps;
    private     ChessPlayer p;


    @Override
    public void init() {



        //sheets
        /*
        playersheet = new SpriteSheet("2dplayersheet.png");
        tilesheet = new SpriteSheet("blocksheet.png");
        tileMapSheet = new SpriteSheet("tilset.png");
*/

      //  tileHandler = new TileHandler("tilemap2.tmx", 32,32,tileMapSheet );




        //objects
        // tileMap = new TileMap(500, 500, 32,32, tilesheet);

        //Sprite s =  new Sprite(, 1,1,77,77);
        BufferedImage chessplayer = ImageLoader.loadImage("chessplayer.png");
        Sprite chess = new Sprite(chessplayer, 32,32);
        p = new ChessPlayer(0,0,32,32,chess);
        p.addComponent(new Rigidbody(p));
        board = new Chessboard(6,p,1,1);
        board.start();
       // board.findRoute();

        if(board.getBoard() == null){
            System.out.println("fffsss");
        }
        /*
        player = new TestPlayer((WIDTH / 3),(HEIGHT / 2), 32,32, s);
        player.placeGameObjectAtTile(6,9,32,32);
        //components
        /*
        player.addComponent(new Rigidbody(player));
        player.addComponent(new Collider(player, player.getWidth() - 6, player.getHeight() - 6));
        player.addComponent(new Collision(player));
        player.addComponent(new Input(player));

         */
        cam = new Camera(p,WIDTH / 2,HEIGHT /2, WIDTH ,HEIGHT,1);

        cam.setZoomscale(1f);



        /*
        tilesheet = new SpriteSheet("tilset.png");


        tileHandler = new TileHandler("tilemap2.tmx", 32,32,tilesheet );
*/



        //Screen stuff
        screen = new Screen(WIDTH,HEIGHT, SCALE,false,false, new Color(4,200,200));
        Renderer.getGch().getGameCases().add(this);

       // tileHandler.render();
      //  Renderer.addObject(player);
        board.renderBoard();

        Renderer.addObject(cam);
        Renderer.addObject(p);

        ///
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


    private float angle = 0.0f;
    @Override
    public void update(float delta) {
        angle += 0.1f;
     //   p.rotate(angle);
    }

    @Override
    public void render(EngineGraphics g) {
    //    g.drawRect(new Vector2f(22,22), 50,500, Color.RED,false);
    }


}
