package TestingGameEngine;

import GameComponents.Collider;
import GameComponents.Collision;
import GameComponents.Input;
import GameComponents.Rigidbody;
import GameHandlers.GameState;
import Graphics.ImageLoader;
import Graphics.Screen;
import Graphics.SpriteSheet;
import Tiles.TileHandler;
import Tiles.TileLayers;
import Utilities.Camera;
import Utilities.Node;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Graphics.Renderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    private     ChessPlayer p;
    @Override
    public void init() {





        //objects
        // tileMap = new TileMap(500, 500, 32,32, tilesheet);
        SpriteSheet spriteSheet = new SpriteSheet("playersheet.png",24,32);

        BufferedImage image = SpriteSheet.getSpriteImageFromSpriteSheet(spriteSheet,1,1);
        Sprite s =  new Sprite(image);




        player = new TestPlayer((WIDTH / 3),(HEIGHT / 2), 32,32, s);
        player.placeGameObjectAtTile(6,9,32,32);
        //components

        player.addComponent(new Rigidbody(player));
        player.addComponent(new Collider(player, player.getWidth() - 6, player.getHeight() - 6));
        player.addComponent(new Collision(player));
        player.addComponent(new Input(player));



        cam = new Camera(player,WIDTH / 2,HEIGHT /2, WIDTH ,HEIGHT,1);

        cam.setZoomscale(1f);



        tilesheet = new SpriteSheet("tilset.png",32,32);


        tileHandler = new TileHandler("tilemap2.tmx", 32,32,tilesheet );




        //Screen stuff
        screen = new Screen(player,cam,WIDTH,HEIGHT, SCALE,false, new Color(4,200,200));
        Renderer.getGch().getGameCases().add(this);

        //  Renderer.addObject(player);

        Renderer.addObject(cam);
        tileHandler.render();
        Renderer.addObject(player);

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


    @Override
    public void update( ) {

    }



    @Override
    public void render(EngineGraphics g) {
        //    g.drawRect(new Vector2f(22,22), 50,500, Color.RED,false);


    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
