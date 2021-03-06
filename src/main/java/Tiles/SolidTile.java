package Tiles;

import GameComponents.Collider;
import GameComponents.Collision;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;
import  Graphics.Renderer;

import java.awt.*;

public class SolidTile extends  Tile{

    Collider collider;

    public SolidTile(int x, int y, int width, int height, Color color) {
        super(x, y, width, height,color);

        collider  = (Collider) getComponent(Collider.class);

    }

    public SolidTile(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }


    @Override
    public void render(EngineGraphics g) {
        g.drawGameObject(this);
        if (Renderer.showLayers) {
            g.drawRect(getX(), getY(), width, height, Color.RED, false);

        }



        /*
        g.drawRect(x,y,width,height,color,true);
        g.drawRect(x,y,width,height,Color.WHITE,false);
*/


        /*
        g.drawRect(collider.getCollDown(),Color.RED,true);
        g.drawRect(collider.getCollDown(),Color.WHITE,false);

        g.drawRect(collider.getCollLeft(),Color.RED,true);
        g.drawRect(collider.getCollLeft(),Color.WHITE,false);

        g.drawRect(collider.getCollRight(),Color.RED,true);
        g.drawRect(collider.getCollRight(),Color.WHITE,false);

        g.drawRect(collider.getCollUp(),Color.RED,true);
        g.drawRect(collider.getCollUp(),Color.WHITE,false);

         */



    }

    @Override
    public void update(float delta) {

    }



    @Override
    public boolean isSolid() {
        return true;
    }
}
