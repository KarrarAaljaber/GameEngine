package GameHandlers;

import Entities.Entity;
import Graphics.Renderer;
import Graphics.Screen;

import Graphics.EngineGraphics;
import Tiles.Tile;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class GameState {

    private GameStateController gsc;

    private Screen screen;

    public GameState(Screen screen) {
        this.screen = screen;
        init();

    }


    public Screen getScreen() {
        return screen;
    }
    public GameStateController getGSC(){
        return gsc;
    }

    public abstract void init();
    public abstract void update(double delta);
    public abstract void render(EngineGraphics g);
    public abstract void keyPressed(int key);
    public abstract void keyReleased(int key);
    public abstract void mousePressed(MouseEvent e);
    public abstract void mouseReleased(MouseEvent e);
}
