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

    public GameStateController(Renderer renderer) {
        objects = new ArrayList<>();
        this.renderer = renderer;
        gameStates = new ArrayList<GameState>();

        currentState = 0;

    }


    public ArrayList<GameState> getGameCases() {
        return gameStates;
    }



    public void optimaziedRender(EngineGraphics g, GameObject player){
        GameState state = gameStates.get(currentState);
        state.render(g);

        for (int i = 0; i < objects.size(); i++) {

            if(player !=null) {
                if (!((objects.get(i).getX() + 64 <= player.getX() - (renderer.getWIDTH() / renderer.getSCALE()) / 2 || (objects.get(i).getX() - 64 >= player.getX() + (renderer.getWIDTH() / renderer.getSCALE()) / 2)
                        || (objects.get(i).getY() + 64 <= player.getY() - (renderer.getHEIGHT() / renderer.getSCALE()) / 2)) || (objects.get(i).getY() - 64 >= player.getY() + (renderer.getHEIGHT() / renderer.getSCALE()) / 2))) {
                    g.renderWithTransformations(objects.get(i));

                    objects.get(i).renderAllComponents(objects.get(i), g);


                }
            }

        }
    }
    public void render(EngineGraphics g) {
        GameState state = gameStates.get(currentState);
        state.render(g);

        for (int i = 0; i < objects.size(); i++) {
            g.renderWithTransformations(objects.get(i));

            objects.get(i).renderAllComponents(objects.get(i), g);


        }

    }


      //fix for lighting move up



    public void removeState(GameState state){
        gameStates.remove(gameStates.indexOf(state));
    }
    public void update(float delta) {
        gameStates.get(currentState).update(delta);
        for (int i = 0; i < objects.size(); i++) {

            objects.get(i).update(delta);
            objects.get(i).updateAllComponents(delta, objects.get(i));

        }
    }
    public void optimazedUpdate(float delta, GameObject player) {
        gameStates.get(currentState).update(delta);


        for (int i = 0; i < objects.size(); i++) {
            Camera camera = (Camera) getGameObject(Camera.class);

            if (objects.get(i) == camera) {
                objects.get(i).update(delta);
                objects.get(i).updateAllComponents(delta, objects.get(i));
            }
            if (player != null) {
                if (!((objects.get(i).getX() + 64 <= player.getX() - (renderer.getWIDTH() / renderer.getSCALE()) / 2 || (objects.get(i).getX() - 64 >= player.getX() + (renderer.getWIDTH() / renderer.getSCALE()) / 2)
                        || (objects.get(i).getY() + 64 <= player.getY() - (renderer.getHEIGHT() / renderer.getSCALE()) / 2)) || (objects.get(i).getY() - 64 >= player.getY() + (renderer.getHEIGHT() / renderer.getSCALE()) / 2))) {

                    objects.get(i).update(delta);
                    objects.get(i).updateAllComponents(delta, objects.get(i));


                }
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




    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }
}


