package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;
import Graphics.Renderer;
import java.awt.*;

public class NonSolidTile extends Tile{



    private int counter;

    public NonSolidTile(int x, int y, int width, int height, Color color) {
        super(x, y, width, height,color);
        counter =2;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }
    public NonSolidTile(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawGameObject(this, getColorFilter());

        /*
        g.drawRect(getX(),getY(),width,height,color,true);
        g.drawString(String.valueOf(counter), Color.GREEN,getX() + width / 2,getY() + height /2,"arial",15);
*/

        if (Renderer.showLayers) {
            g.drawRect(getX(), getY(), width, height, Color.WHITE, false);

        }
    }

    @Override
    public void update() {

    }

    @Override
    public void init() {

    }
}
