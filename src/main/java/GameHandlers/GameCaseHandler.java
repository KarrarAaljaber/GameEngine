package GameHandlers;

import Graphics.Renderer;

import Graphics.EngineGraphics;
import Tiles.Tile;

import java.awt.event.MouseEvent;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Arrays;

public class GameCaseHandler {

    private ArrayList<GameCase> gameCases;

    //Different GameObjects
    private ArrayList<GameObject> objects;


    private int currentCase;



    private Renderer renderer;
    private GameObject player;

    public GameCaseHandler(Renderer renderer, GameObject player) {
        objects = new ArrayList<>();
        this.renderer = renderer;
        this.player = player;
        gameCases = new ArrayList<GameCase>();
        currentCase = 0;


    }

    public GameCaseHandler() {
        objects = new ArrayList<>();

        gameCases = new ArrayList<GameCase>();
        currentCase = 0;


    }
    public ArrayList<GameCase> getGameCases() {
        return gameCases;
    }

    public void setCase(int Case) {
        currentCase = Case;
    }

    public void render(EngineGraphics g) {

        gameCases.get(currentCase).render(g);
        for (int i = 0; i < objects.size(); i++) {
            if( !((objects.get(i).getX() + 64   <= player.getX() - ( renderer.getWIDTH() /renderer.getSCALE() )/2|| (objects.get(i).getX() -64   >=player.getX()  + (renderer.getWIDTH() /renderer.getSCALE()) / 2 )
                    || (objects.get(i).getY() + 64  <= player.getY() - (renderer.getHEIGHT() /renderer.getSCALE()) / 2))|| (objects.get(i).getY() -64  >=player.getY() +(renderer.getHEIGHT() /renderer.getSCALE()) / 2))){
                objects.get(i).render(g);

            }
        }
    }



    public void init() {

        gameCases.get(currentCase).init();

    }

    public void update(double delta) {


        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update(delta);
        }

        gameCases.get(currentCase).update(delta);

    }


    public void mousePressed(MouseEvent e) {
        gameCases.get(currentCase).mousePressed(e);

    }

    public void mouseReleased(MouseEvent e) {
        gameCases.get(currentCase).mouseReleased(e);

    }

    public void keyPressed(int key) {
        gameCases.get(currentCase).keyPressed(key);

    }


    public void keyReleased(int key) {
        gameCases.get(currentCase).keyReleased(key);

    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }







    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }
}


