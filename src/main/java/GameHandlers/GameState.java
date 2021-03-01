package GameHandlers;

import Entities.Entity;
import Entities.Light;
import Graphics.Renderer;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Tiles.Tile;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class GameState {

    private GameStateController gsc;

    private Screen screen;
    private ArrayList<Light> lights = new ArrayList<>();


    private float darkestvalue= 0.2f;
    private float brightvalue = 0.7f;


    public GameState(Screen screen) {
        System.setProperty("sun.java2d.opengl", "True");
        this.screen = screen;
        init();

    }

    public void setLights(ArrayList<Light> lights) {
        this.lights = lights;
    }

    public float getDarkestvalue() {
        return darkestvalue;
    }

    public float getBrightvalue() {
        return brightvalue;
    }

    public void setBrightvalue(float brightvalue) {
        this.brightvalue = brightvalue;
    }

    public void setDarkestvalue(float darkestvalue) {
        this.darkestvalue = darkestvalue;
    }

    public void addLight(Light light){
        lights.add(light);
    }
    public void removeLight(Light light){
       lights.remove(light);
    }
    public ArrayList<Light> getLights(){
        return  lights;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public GameStateController getGSC(){
        return gsc;
    }

    public abstract void init();
    public abstract void update(float delta);
    public abstract void render(EngineGraphics g);

}
