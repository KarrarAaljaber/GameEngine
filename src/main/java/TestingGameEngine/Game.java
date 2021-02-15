package TestingGameEngine;

import Entities.Entity;
import GameComponents.Collider;
import GameComponents.Collision;
import GameComponents.Input;
import GameHandlers.GameState;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Tiles.SolidTile;
import Tiles.TileHandler;
import Tiles.TileLayers;
import Utilities.Node;
import Utilities.Camera;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Graphics.Renderer;
import Graphics.ImageLoader;
import Graphics.Sprite;

import Graphics.SpriteSheet;

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

    public Game( Screen screen) {
        super( screen);
    }

    public static void main(String[]args){
        Game run = new Game(screen);
    }



    private static final Color transparency = new Color(0, 0, 0, 0);

    private ArrayList<Node> moveSteps;
    @Override
    public void init() {

        //sheets
        playersheet = new SpriteSheet("playersheet.png");
        tilesheet = new SpriteSheet("blocksheet.png");
        tileMapSheet = new SpriteSheet("tilset.png");

        tileHandler = new TileHandler("tilemap2.tmx", 32,32,tileMapSheet );




        //objects
        // tileMap = new TileMap(500, 500, 32,32, tilesheet);

        Sprite s =  new Sprite(playersheet, 1,1,24,32);
        player = new TestPlayer((WIDTH / 3),(HEIGHT / 2), 32,32, s);
        player.placeEntityAtTile(6,9,32,32);
        //components
        player.addComponent(new Collider(player, player.getWidth() - 6, player.getHeight() - 6));
        player.addComponent(new Collision(player));
        player.addComponent(new Input(player));
        cam = new Camera(player,0,0, WIDTH ,HEIGHT,1);




        //Screen stuff
        screen = new Screen(player,cam,WIDTH,HEIGHT, SCALE,false, new Color(0,0,0));
        screen.getRenderer().getGch().getGameCases().add(this);
        tileHandler.render();
        Renderer.addObject(player);

        Renderer.addObject(cam);

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
    public void update(double delta) {

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
