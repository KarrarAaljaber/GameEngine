package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;
import  Graphics.Renderer;

import java.awt.*;

public class SolidTile extends  Tile{


    public SolidTile(int x, int y, int width, int height, boolean isSolid) {
        super(x, y, width, height, isSolid);
    }

    public SolidTile(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public SolidTile(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    public SolidTile(int x, int y, int width, int height, boolean isSolid, Sprite sprite) {
        super(x, y, width, height, isSolid, sprite);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawGameObject(this);
        if (Renderer.showLayers) {
            g.drawRect(x,y, width, height, Color.RED, false);

        }
    }

    @Override
    public void update(double delta) {

    }



}
