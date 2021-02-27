package GameHandlers;

import GameComponents.GameComponent;
import GameComponents.Input;
import Graphics.Renderer;

import Graphics.EngineGraphics;
import Utilities.Camera;

import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class GameStateController {

    private ArrayList<GameState> gameStates;

    private ArrayList<GameObject> objects;


    private int currentState;



    private Renderer renderer;
    private GameObject player;

    public GameStateController(Renderer renderer, GameObject player) {
        objects = new ArrayList<>();
        this.renderer = renderer;
        this.player = player;
        gameStates = new ArrayList<GameState>();
        currentState = 0;




    }


    public ArrayList<GameState> getGameCases() {
        return gameStates;
    }



    public void render(EngineGraphics g) {
        GameState state = gameStates.get(currentState);
        for (int i = 0; i < objects.size(); i++) {


                if( !((objects.get(i).getX() + 64   <= player.getX() - ( renderer.getWIDTH() /renderer.getSCALE() )/2|| (objects.get(i).getX() -64   >=player.getX()  + (renderer.getWIDTH() /renderer.getSCALE()) / 2 )
                        || (objects.get(i).getY() + 64  <= player.getY() - (renderer.getHEIGHT() /renderer.getSCALE()) / 2))|| (objects.get(i).getY() -64  >=player.getY() +(renderer.getHEIGHT() /renderer.getSCALE()) / 2))) {
                    g.renderWithTransformations(objects.get(i));

                        g.lighting(state.getLights(), objects.get(i), state.getDarkestvalue(), state.getBrightvalue());


                    objects.get(i).renderAllComponents(objects.get(i), g);



                }

        }
        state.render(g);

    }



    public void init() {

        gameStates.get(currentState).init();
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).init();
            objects.get(i).initALlComponents(objects.get(i));
        }

    }

    public void update() {


        for (int i = 0; i < objects.size(); i++) {
            Camera camera = (Camera) getGameObject(Camera.class);

            if(objects.get(i)==camera) {
                objects.get(i).update();
                objects.get(i).updateAllComponents(objects.get(i));
            }
            if (!((objects.get(i).getX() + 64 <= player.getX() - (renderer.getWIDTH() / renderer.getSCALE()) / 2 || (objects.get(i).getX() - 64 >= player.getX() + (renderer.getWIDTH() / renderer.getSCALE()) / 2)
                    || (objects.get(i).getY() + 64 <= player.getY() - (renderer.getHEIGHT() / renderer.getSCALE()) / 2)) || (objects.get(i).getY() - 64 >= player.getY() + (renderer.getHEIGHT() / renderer.getSCALE()) / 2))) {

                    objects.get(i).update();
                    objects.get(i).updateAllComponents(objects.get(i));



            }
        }

        gameStates.get(currentState).update();

    }


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

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public void addGameState(GameState gameState) {
        gameStates.add(gameState);
    }

    public void changeGameState(GameState gameState) {
        currentState = gameStates.indexOf(gameState);
    }
    public GameObject getGameObject(Class gameObject){
        for(GameObject gb : objects){
            if(gb.getClass() == gameObject){
                return  gb;
            }
        }
        return  null;

    }



    public GameObject getPlayer() {
        return player;
    }

    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }
}


