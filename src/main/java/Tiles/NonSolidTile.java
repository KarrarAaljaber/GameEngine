package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;
import Graphics.Renderer;
import java.awt.*;

public class NonSolidTile extends Tile{


    public NonSolidTile(int x, int y, int width, int height, boolean isSolid, Color color) {
        super(x, y, width, height, isSolid,color);
    }

    public NonSolidTile(int x, int y, int width, int height, boolean isSolid, Sprite sprite) {
        super(x, y, width, height, isSolid, sprite);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawGameObject(this);
        if (Renderer.showLayers) {
            g.drawRect(x,y, width, height, Color.WHITE, false);

        }
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void init() {

    }
}
