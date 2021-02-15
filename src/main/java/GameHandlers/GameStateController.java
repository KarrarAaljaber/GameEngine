package GameHandlers;

import Graphics.Renderer;

import Graphics.EngineGraphics;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameStateController {

    private ArrayList<GameState> gameStates;

    //Different GameObjects
    private ArrayList<GameObject> objects;


    private int currentCase;



    private Renderer renderer;
    private GameObject player;

    public GameStateController(Renderer renderer, GameObject player) {
        objects = new ArrayList<>();
        this.renderer = renderer;
        this.player = player;
        gameStates = new ArrayList<GameState>();
        currentCase = 0;


    }

    public GameStateController() {
        objects = new ArrayList<>();

        gameStates = new ArrayList<GameState>();
        currentCase = 0;


    }
    public ArrayList<GameState> getGameCases() {
        return gameStates;
    }

    public void setCase(int Case) {
        currentCase = Case;
    }

    public void render(EngineGraphics g) {

        gameStates.get(currentCase).render(g);
        for (int i = 0; i < objects.size(); i++) {
            if( !((objects.get(i).getX() + 64   <= player.getX() - ( renderer.getWIDTH() /renderer.getSCALE() )/2|| (objects.get(i).getX() -64   >=player.getX()  + (renderer.getWIDTH() /renderer.getSCALE()) / 2 )
                    || (objects.get(i).getY() + 64  <= player.getY() - (renderer.getHEIGHT() /renderer.getSCALE()) / 2))|| (objects.get(i).getY() -64  >=player.getY() +(renderer.getHEIGHT() /renderer.getSCALE()) / 2))){
                objects.get(i).render(g);
                objects.get(i).renderAllComponents( objects.get(i),g);


            }
        }
    }



    public void init() {

        gameStates.get(currentCase).init();
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).init();
            objects.get(i).initALlComponents(objects.get(i));
        }

    }

    public void update(double delta) {


        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update(delta);
            objects.get(i).updateAllComponents( objects.get(i),delta);
        }

        gameStates.get(currentCase).update(delta);

    }


    public void mousePressed(MouseEvent e) {
        gameStates.get(currentCase).mousePressed(e);

    }

    public void mouseReleased(MouseEvent e) {
        gameStates.get(currentCase).mouseReleased(e);

    }

    public void keyPressed(int key) {
        gameStates.get(currentCase).keyPressed(key);

    }


    public void keyReleased(int key) {
        gameStates.get(currentCase).keyReleased(key);

    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }


    public GameObject getPlayer() {
        return player;
    }

    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }
}


