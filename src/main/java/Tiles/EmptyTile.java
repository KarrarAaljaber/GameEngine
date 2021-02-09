package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;

public class EmptyTile extends  Tile{


    public EmptyTile(Vector2f pos, int width, int height, Sprite sprite) {
        super(pos, width, height, sprite);
    }

    @Override
    public void render(EngineGraphics g) {

         g.drawGameObject(this, 1,1);

    }

    @Override
    public void update(double delta) {

    }
}
