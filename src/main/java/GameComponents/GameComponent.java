package GameComponents;

import GameObjects.GameObject;

public abstract class GameComponent {


    protected GameObject parent;
    public GameComponent(GameObject parent) {
        this.parent = parent;
    }
    public GameComponent( ) {
    }

    public abstract void init();
    public abstract void update( float delta);
}
