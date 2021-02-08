package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;

public class EmptyTile extends  Tile{


    public EmptyTile(Vector2f pos, int width, int height) {
        super(pos, width, height);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawRect(pos, width, height, Color.green, false);
    }

    @Override
    public void update(double delta) {

    }
}
