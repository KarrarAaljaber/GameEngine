package TestingGameEngine;

import Audio.AudioPlayer;
import GameHandlers.GameCase;
import GameHandlers.GameObject;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import Graphics.ImageLoader;
import Graphics.Sprite;

import Graphics.SpriteSheet;

public class Run extends GameCase  {


    private static Screen screen;
    private SpriteSheet spriteSheet;
    private ImageLoader loader;


    //GameObjects
    private TestPlayer player;
    public Run(Screen screen) {
        super(screen);
        screen = new Screen(1280, 720, false, new Color(0,0,0));
        screen.getRenderer().getGch().getGameCases().add(this);

        player = new TestPlayer(new Vector2f(100,100), 128,128, new Sprite("spritesheet.png", 32    ,32));
        screen.getRenderer().getGch().getObjects().add(player);

    }


    public static void main(String[]args){
        Run run = new Run(screen);
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.playMusic("isobubbler.wav");
    }




    @Override
    public void init() {

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
           player.setVelocity(new Vector2f( 0,-2f));


        }

        if(key == KeyEvent.VK_S) {
            player.setVelocity(new Vector2f( 0,2f));

        }
        if(key == KeyEvent.VK_A) {
            player.setVelocity(new Vector2f( -2f,0));


        }
        if(key == KeyEvent.VK_D) {
            player.setVelocity(new Vector2f( 2f,0));
        }

    }

    @Override
    public void keyReleased(int key) {
        if(key == KeyEvent.VK_W) {
            player.setVelocity(new Vector2f( 0,0));

            System.out.println("dddd");

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
