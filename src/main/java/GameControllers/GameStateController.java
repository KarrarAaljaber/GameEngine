package GameControllers;

import GameObjects.GameObject;
import Graphics.Renderer;

import Graphics.EngineGraphics;

import java.util.ArrayList;

public class GameStateController {

    private ArrayList<GameState> gameStates;

    private ArrayList<GameObject> objects;


    private int currentState;


    private Renderer renderer;
    private boolean renderOptimized = false;
    private boolean updateOptimized = false;
    private GameObject player;

    public GameStateController(Renderer renderer) {
        objects = new ArrayList<>();
        this.renderer = renderer;
        gameStates = new ArrayList<GameState>();
        player = null;
        currentState = 0;

    }

    public GameObject getPlayer() {
        return player;
    }

    public void setPlayer(GameObject player) {
        this.player = player;
    }

    public ArrayList<GameState> getGameCases() {
        return gameStates;
    }




    public void render(EngineGraphics g) {

        if(gameStates.size() !=0){
            GameState state = gameStates.get(currentState);
            state.render(g);
            if (!renderOptimized) {
                for (int i = 0; i < objects.size(); i++) {
                    g.renderWithTransformations(objects.get(i));

                }

            } else {
                renderOptimized(g);
            }
        }

    }

    public boolean isRenderOptimized() {
        return renderOptimized;
    }

    public void setRenderOptimized(boolean renderOptimized) {
        this.renderOptimized = renderOptimized;
    }

    public boolean isUpdateOptimized() {
        return updateOptimized;
    }

    public void setUpdateOptimized(boolean updateOptimized) {
        this.updateOptimized = updateOptimized;
    }

    public void renderOptimized(EngineGraphics g) {
        if(gameStates.size() !=0) {

            GameState state = gameStates.get(currentState);
            state.render(g);
            if (getPlayer() != null) {
                for (int i = 0; i < objects.size(); i++) {

                    if (!((objects.get(i).getX() + 64 <= getPlayer().getX() - (renderer.getWidthWithScale() / renderer.getSCALE()) / 2 || (objects.get(i).getX() - 64 >= player.getX() + (renderer.getWidthWithScale() / renderer.getSCALE()) / 2)
                            || (objects.get(i).getY() + 64 <= getPlayer().getY() - (renderer.getHeightWithScale() / renderer.getSCALE()) / 2)) || (objects.get(i).getY() - 64 >= player.getY() + (renderer.getHeightWithScale() / renderer.getSCALE()) / 2))) {
                        g.renderWithTransformations(objects.get(i));

                    }
                }

            } else {
                System.out.println("You need to set the player using setPlayer(GameObject player)");
            }
        }

    }





    public void removeState(GameState state){
        gameStates.remove(gameStates.indexOf(state));
    }
    public void update(float delta) {
        if(gameStates.size() !=0) {

            gameStates.get(currentState).update(delta);
            if (!updateOptimized) {
                for (int i = 0; i < objects.size(); i++) {

                    objects.get(i).update(delta);
                    objects.get(i).updateAllComponents(delta, objects.get(i));

                }
            } else {
                updateOptimized(delta);
            }
        }
    }
    public void updateOptimized(float delta) {
        if(gameStates.size() !=0) {

            if (getPlayer() != null) {
                gameStates.get(currentState).update(delta);
                for (int i = 0; i < objects.size(); i++) {

                    if (!((objects.get(i).getX() + 64 <= getPlayer().getX() - (renderer.getWidthWithScale() / renderer.getSCALE()) / 2 || (objects.get(i).getX() - 64 >= getPlayer().getX() + (renderer.getWidthWithScale() / renderer.getSCALE()) / 2)
                            || (objects.get(i).getY() + 64 <= getPlayer().getY() - (renderer.getHeightWithScale() / renderer.getSCALE()) / 2)) || (objects.get(i).getY() - 64 >= getPlayer().getY() + (renderer.getHeightWithScale() / renderer.getSCALE()) / 2))) {

                        objects.get(i).update(delta);
                        objects.get(i).updateAllComponents(delta, objects.get(i));

                    }
                }
            } else {
                System.out.println("You need to set the player using setPlayer(GameObject player)");
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


