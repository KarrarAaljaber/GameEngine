package GameControllers;

import Graphics.Screen;

import Graphics.EngineGraphics;

public abstract class GameState {

    private GameStateController gameStateController;

    private Screen screen;


    public GameState(Screen screen) {
        System.setProperty("sun.java2d.opengl", "True");
        this.screen = screen;

    }




    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public GameStateController getGameStateController(){
        return gameStateController;
    }

    public abstract void update(float delta);
    public abstract void render(EngineGraphics g);

}
