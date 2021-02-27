package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Renderer;
import TestingGameEngine.Game;

import java.awt.event.MouseEvent;

public class Input {

    private boolean[] keys = new boolean[256];
    private boolean[] lastKeys = new boolean[256];

    private boolean[] mousebtns = new boolean[5];
    private boolean[] lastMousebtns = new boolean[5];

    private int mouseX = 0, mouseY = 0;

    private Renderer renderer;
    public Input() {

    }



    public void init() {

    }


    public void update() {
        for(int i=0; i < 256; i++){
            lastKeys[i] = keys[i];
        }
        for(int i=0; i < 5; i++){
            lastMousebtns[i] = mousebtns[i];
        }

    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }



    public boolean mouseButtonUp(int btn){
        return !mousebtns[btn] && lastMousebtns[btn];
    }
    public boolean mouseButtonDown(int btn){
        return mousebtns[btn] && !lastMousebtns[btn];
    }

    public boolean KeyUp(int key){
        return !keys[key] && lastKeys[key];

    }
    public boolean KeyDown(int key){
        return keys[key] && !lastKeys[key];
    }
    public  void keyPressed(int key){
        keys[key] = true;
    }
    public  void keyReleased(int key)
    {
        keys[key] = false;
    }

    public  void mousePressed(MouseEvent e){
        mousebtns[e.getButton()] = true;
    }
    public  void mouseReleased(MouseEvent e){
        mousebtns[e.getButton()] = false;
    }
}
