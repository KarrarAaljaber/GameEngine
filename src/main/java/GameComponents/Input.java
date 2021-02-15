package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Renderer;

import java.awt.event.MouseEvent;

public class Input extends GameComponent{

    private boolean[] keys = new boolean[256];
    private boolean[] lastKeys = new boolean[256];

    private boolean[] mousebtns = new boolean[5];
    private boolean[] lasatMousebtns = new boolean[5];

    private int mouseX = 0, mouseY = 0;

    private Renderer renderer;
    public Input(GameObject parent) {
        super(parent);

    }

    @Override
    public void init() {

    }

    @Override
    public void update(double delta) {
        for(int i=0; i < 256; i++){
            lastKeys[i] = keys[i];
        }
        for(int i=0; i < 5; i++){
            lasatMousebtns[i] = mousebtns[i];
        }
    }

    @Override
    public void render(EngineGraphics g) {

    }

    public boolean mouseButtonUp(int btn){
        return !mousebtns[btn] && lasatMousebtns[btn];
    }
    public boolean mouseButtonDown(int btn){
        return mousebtns[btn] && !lasatMousebtns[btn];
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
    public void mouseMoved(MouseEvent e){

    }
    public  void mousePressed(MouseEvent e){
        mousebtns[e.getButton()] = true;
    }
    public  void mouseReleased(MouseEvent e){
        mousebtns[e.getButton()] = false;
    }
}
