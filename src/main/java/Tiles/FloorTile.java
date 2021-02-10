package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;
import  Graphics.Renderer;

public class FloorTile extends  Tile{


    public FloorTile(int x, int y, int width, int height, boolean isSolid) {
        super(x, y, width, height, isSolid);
    }

    public FloorTile(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public FloorTile(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    public FloorTile(int x, int y, int width, int height, boolean isSolid, Sprite sprite) {
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
}
