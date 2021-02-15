package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;

public abstract class GameComponent {


    protected GameObject parent;
    public GameComponent(GameObject parent) {
        this.parent = parent;
    }

    public abstract void init();
    public abstract void update( double delta);
    public abstract void render(EngineGraphics g);
}
