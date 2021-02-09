package GameHandlers;

import Graphics.Renderer;

import Graphics.EngineGraphics;
import java.awt.event.MouseEvent;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Arrays;

public class GameCaseHandler {

    private ArrayList<GameCase> gameCases;
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

    public ArrayList<GameCase> getGameCases() {
        return gameCases;
    }

    public void setCase(int Case) {
        currentCase = Case;
    }

    public void render(EngineGraphics g) {

        gameCases.get(currentCase).render(g);
        for (int i = 0; i < objects.size(); i++) {
            if( !((objects.get(i).getPos().getX() + 64   <= player.getPos().getX() - renderer.getWidth() /2 )|| (objects.get(i).getPos().getX()  - 64  >=player.getPos().getX()  + renderer.getWidth() /2 )
                    || (objects.get(i).getPos().getY() + 64  <= player.getPos().getY() - renderer.getHeight() /2 ) || (objects.get(i).getPos().getY() -64  >=player.getPos().getY() + renderer.getHeight() / 2))){
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

    public void addObjects(GameObject object) {
        objects.add(object);
    }

    public void addObjectArray(GameObject[][] objectz) {
        for (int i = 0; i < objectz.length; i++) {
            for (int j = 0; j < objectz[i].length; j++) {
                objects.add(objectz[i][j]);
                }
            }
        }





    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }
}


