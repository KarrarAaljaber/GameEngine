package TestingGameEngine;

import Graphics.Screen;

import  Graphics.Renderer;
import java.awt.*;

public class Main {

    private static Screen screen;

    public static final int SCALE = 2;
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    public static void main(String[]args){
        screen = new Screen(WIDTH, HEIGHT,SCALE,false,Color.BLACK);
        TestScene scene = new TestScene(screen);
    }

}