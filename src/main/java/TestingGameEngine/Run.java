package TestingGameEngine;

import GameHandlers.GameCase;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Tiles.TileHandler;
import Tiles.TileLayers;
import Utilities.APathfinding;
import Utilities.Node;
import Utilities.TopDownCamera;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Graphics.Renderer;
import Graphics.ImageLoader;
import Graphics.Sprite;

import Graphics.SpriteSheet;

public class Run extends GameCase  {


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
    private TopDownCamera cam;
    public Run(Screen screen) {
        super(screen);

    }

    private  TileHandler tileHandler;
    public static void main(String[]args){
        Run run = new Run(screen);
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
        cam = new TopDownCamera(player,0,0, WIDTH ,HEIGHT,1);




        //Screen stuff
        screen = new Screen(player,cam,WIDTH,HEIGHT, SCALE,false, new Color(0,0,0));
        screen.getRenderer().getGch().getGameCases().add(this);
//        screen.getRenderer().getGch().addObjectArray(tileMap.getMap());
        tileHandler.render();
        Renderer.addObject(player);
        Renderer.addObject(cam);

        ///


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
        if(key == KeyEvent.VK_W) {
           player.setUp(true);
           player.setDown(false);
           player.setLeft(false);
           player.setRight(false);

        }

        if(key == KeyEvent.VK_S) {
            player.setUp(false);
            player.setDown(true);
            player.setLeft(false);
            player.setRight(false);
        }
        if(key == KeyEvent.VK_A) {
            player.setUp(false);
            player.setDown(false);
            player.setLeft(true);
            player.setRight(false);
        }
        if(key == KeyEvent.VK_D) {
            player.setUp(false);
            player.setDown(false);
            player.setLeft(false);
            player.setRight(true);
        }

    }

    @Override
    public void keyReleased(int key) {
        if(key == KeyEvent.VK_W) {
            player.setVelocity(0,0);
            player.setUp(false);

        }

        if(key == KeyEvent.VK_S) {
            player.setVelocity(0,0);
            player.setDown(false);



        }
        if(key == KeyEvent.VK_A) {
            player.setVelocity(0,0);
            player.setLeft(false);


        }
        if(key == KeyEvent.VK_D) {
            player.setVelocity(0,0);
            player.setRight(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
