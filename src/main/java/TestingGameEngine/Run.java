package TestingGameEngine;

import GameHandlers.GameCase;
import GameHandlers.GameCaseHandler;
import Graphics.Screen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Run extends GameCase {


    private static Screen screen;

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

    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(100,100,100,100);
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
