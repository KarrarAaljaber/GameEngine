package TestingGameEngine;

import Entities.Entity;
import Graphics.EngineGraphics;
import Graphics.Sprite;

public class ChessPlayer extends Entity {

    public ChessPlayer(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawGameObject(this);
    }

    @Override
    public void update() {

    }

    @Override
    public void init() {

    }
}
