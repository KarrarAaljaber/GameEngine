package TestingGameEngine;

import GameHandlers.GameCase;
import GameHandlers.GameObject;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import Graphics.ImageLoader;
import Graphics.Sprite;

import Graphics.SpriteSheet;

public class Run extends GameCase {


    private static Screen screen;
    private SpriteSheet spriteSheet;
    private GameObject testPlayer;
    private ImageLoader loader;
    public Run(Screen screen) {
        super(screen);
        screen = new Screen(1280, 720, false, new Color(0,0,0));
        screen.getRenderer().getGch().getGameCases().add(this);

    }


    public static void main(String[]args){
        Run run = new Run(screen);
    }



    @Override
    public void init() {
        loader = new ImageLoader();
         BufferedImage  spriteSheetimg = loader.loadImage("/spritesheet.png");
        spriteSheet = new SpriteSheet(spriteSheetimg);
        testPlayer = new GameObject(new Vector2f(50,50), new Sprite(spriteSheet,32,32,0,0));
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(EngineGraphics g) {

        g.drawRect(new Vector2f(22,22), 50,500, Color.RED,false);
        g.drawGameObject(testPlayer);
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
