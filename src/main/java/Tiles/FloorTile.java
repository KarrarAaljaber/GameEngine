package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;

public class FloorTile extends  Tile{


    public FloorTile(Vector2f pos, int width, int height, Sprite sprite) {
        super(pos, width, height, sprite);
    }

    @Override
    public void render(EngineGraphics g) {

        g.drawGameObject(this);
      //  g.drawRect(pos, width, height, Color.GREEN, false);


    }

    @Override
    public void update(double delta) {

    }
}
