package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;
import Graphics.Renderer;
import java.awt.*;

public class NonSolidTile extends Tile{


    public NonSolidTile(int x, int y, int width, int height, Color color) {
        super(x, y, width, height,color);
    }

    public NonSolidTile(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawGameObject(this);
        if (Renderer.showLayers) {
            g.drawRect(getX(), getY(), width, height, Color.WHITE, false);

        }
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void init() {

    }
}
