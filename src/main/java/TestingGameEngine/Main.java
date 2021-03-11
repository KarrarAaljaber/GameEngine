package TestingGameEngine;

import Graphics.Screen;
import TestingGameEngine.Player;

import  Graphics.Renderer;
import java.awt.*;

public class Main {

    private static Screen screen;
    private static Player player;


    public static void main(String[]args){
        screen = new Screen(640, 480,1,true,Color.WHITE);
        TestScene scene = new TestScene(screen);
    }

}
