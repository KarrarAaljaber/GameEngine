package UI;

import GameComponents.Input;
import GameHandlers.GameObject;
import GameHandlers.GameState;
import Graphics.EngineGraphics;
import Graphics.Renderer;
import Utilities.Camera;

import java.awt.event.*;
import java.util.ArrayList;

public class UIController  {


    private ArrayList<UIContainer> uicontainers;




    public UIController() {
        uicontainers = new ArrayList<>();

    }



    public void render(EngineGraphics g) {
        for(int i=0; i < uicontainers.size(); i++){
            uicontainers.get(i).render(g);

        }

    }





    public void update() {
        for(int i=0; i < uicontainers.size(); i++){
            uicontainers.get(i).update();
        }

    }

    /*

    public void mousePressed(MouseEvent e) {
        gameStates.get(currentState).mousePressed(e);
        for (int i = 0; i < objects.size(); i++) {
            if((Input) objects.get(i).getComponent(Input.class) != null){
                ((Input) objects.get(i).getComponent(Input.class)).mousePressed(e);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        gameStates.get(currentState).mouseReleased(e);

        for (int i = 0; i < objects.size(); i++) {
            if((Input) objects.get(i).getComponent(Input.class) != null){
                ((Input) objects.get(i).getComponent(Input.class)).mouseReleased(e);
            }
        }

    }

    public void keyPressed(int key) {
        gameStates.get(currentState).keyPressed(key);
        for (int i = 0; i < objects.size(); i++) {
            if((Input) objects.get(i).getComponent(Input.class) != null){
                ((Input) objects.get(i).getComponent(Input.class)).keyPressed(key);
            }
        }

    }


    public void keyReleased(int key) {
        gameStates.get(currentState).keyReleased(key);
        for (int i = 0; i < objects.size(); i++) {
            if((Input) objects.get(i).getComponent(Input.class) != null){
                ((Input) objects.get(i).getComponent(Input.class)).keyReleased(key);
            }
        }

    }

    */
    public void addUIContainer(UIContainer uiContainer){
        uicontainers.add(uiContainer);
    }
    public ArrayList<UIContainer> getUIContainers() {
        return uicontainers;
    }


    public UIContainer getUIContainer(Class uiContainer){
        for(UIContainer uc : uicontainers){
            if(uc.getClass() == uiContainer){
                return  uc;
            }
        }
        return  null;

    }



}

