package Tiles;

import Graphics.EngineGraphics;

import java.awt.*;

public class colorTile extends  Tile{
    public colorTile(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawRect(getX(),getY(),width,height,color,true);

    }

    @Override
    public void update(float delta) {

    }
}
