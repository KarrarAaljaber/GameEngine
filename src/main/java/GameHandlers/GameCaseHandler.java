package GameHandlers;

import Graphics.Renderer;

import Graphics.EngineGraphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameCaseHandler {

    private ArrayList<GameCase> gameCases;
    private ArrayList<GameObject> objects;

    private int currentCase;
    public static final int MENUCASE = 0;
    public static final int LEVEL1 = 1;


    private Renderer renderer;
    public GameCaseHandler(Renderer renderer)
    {
        objects = new ArrayList<>();
        this.renderer = renderer;
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
        for(int i=0; i < objects.size(); i++){
            objects.get(i).render(g);
        }
    }


    public void init(){

        gameCases.get(currentCase).init();

    }

    public void update(double delta){


        for(int i=0; i < objects.size(); i++){
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


