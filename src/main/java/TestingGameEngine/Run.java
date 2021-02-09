package TestingGameEngine;

import GameHandlers.GameCase;
import GameHandlers.GameObject;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Tiles.TileMap;
import Utilities.TopDownCamera;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.ImageLoader;
import Graphics.Sprite;

import Graphics.SpriteSheet;

public class Run extends GameCase  {


    private static Screen screen;
    private SpriteSheet spriteSheet;
    private ImageLoader loader;

    //GameObjects
    private TestPlayer player;
    private TileMap tileMap;

    //SpriteSheets
    private SpriteSheet playersheet;
    private SpriteSheet tilesheet;


    //Utils
    private TopDownCamera cam;
    public Run(Screen screen) {
        super(screen);

    }


    public static void main(String[]args){
        Run run = new Run(screen);
    }


    @Override
    public void init() {

        playersheet = new SpriteSheet("spritesheet.png");
        tilesheet = new SpriteSheet("blocksheet.png");


        tileMap = new TileMap(500, 500, 32,32, tilesheet);



        Sprite s =  new Sprite(playersheet, 32,32);
        player = new TestPlayer(new Vector2f(300,300), 64,64, s);
        cam = new TopDownCamera(player,new Vector2f(0,0), 1280 ,720,1);



        //Screen stuff
        screen = new Screen(player,cam,1280, 720, false, new Color(0,0,0));
        screen.getRenderer().getGch().getGameCases().add(this);
        screen.getRenderer().getGch().addObjectArray(tileMap.getMap());
        screen.getRenderer().getGch().addObjects(player);
        screen.getRenderer().getGch().addObjects(cam);

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
           player.setVelocity(new Vector2f( 0,-4f));
        }

        if(key == KeyEvent.VK_S) {
            player.setVelocity(new Vector2f( 0,4f));

        }
        if(key == KeyEvent.VK_A) {
            player.setVelocity(new Vector2f( -4f,0));


        }
        if(key == KeyEvent.VK_D) {
            player.setVelocity(new Vector2f( 4f,0));
        }

    }

    @Override
    public void keyReleased(int key) {
        if(key == KeyEvent.VK_W) {
            player.setVelocity(new Vector2f( 0,0));

        }

        if(key == KeyEvent.VK_S) {
            player.setVelocity(new Vector2f( 0,0));

        }
        if(key == KeyEvent.VK_A) {
            player.setVelocity(new Vector2f( 0,0));


        }
        if(key == KeyEvent.VK_D) {
            player.setVelocity(new Vector2f( 0,0));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
