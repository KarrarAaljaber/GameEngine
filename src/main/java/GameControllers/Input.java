package GameControllers;

import Graphics.Renderer;

import java.awt.event.MouseEvent;

public class Input {

    private final boolean[]  keys = new boolean[256];
    private final boolean[] lastKeys = new boolean[256];

    private final boolean[] mousebtns = new boolean[5];
    private final boolean[] lastMousebtns = new boolean[5];

    private int mouseX = 0, mouseY = 0;

    private int mouseDragX =0, mouseDragY=0;
    private boolean mouseIsDragged= false;



    public void update(float delta) {
        for(int i=0; i < 256; i++){
            lastKeys[i] = keys[i];
        }
        for(int i=0; i < 5; i++){
            lastMousebtns[i] = mousebtns[i];
            if(!mousebtns[i]){
                mouseIsDragged = false;
            }
        }
        if(mouseIsDragged){
            System.out.println("dragged");
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


    public int getMouseDragX() {
        return mouseDragX;
    }

    public void setMouseDragX(int mouseDragX) {
        this.mouseDragX = mouseDragX;
    }

    public int getMouseDragY() {
        return mouseDragY;
    }

    public void setMouseDragY(int mouseDragY) {
        this.mouseDragY = mouseDragY;
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








    public boolean isMouseDragged() {
        return mouseIsDragged;
    }
    public void setMouseDragged(boolean mouseIsDragged) {
        this.mouseIsDragged = mouseIsDragged;
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
