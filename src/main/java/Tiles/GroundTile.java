package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;
import  Graphics.Renderer;

public class GroundTile extends  Tile{


    public GroundTile(int x, int y, int width, int height, boolean isSolid, Color color) {
        super(x, y, width, height, isSolid,color);
    }

    public GroundTile(int x, int y, int width, int height, boolean isSolid, Sprite sprite) {
        super(x, y, width, height, isSolid, sprite);
    }

    @Override
    public void render(EngineGraphics g) {

        g.drawGameObject(this);
        if (Renderer.showLayers) {
            g.drawRect(x,y, width, height, Color.GREEN, false);

        }

    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void init() {

    }
}
