package Tiles;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

public abstract class Tile extends GameObject {


    public Tile(int x, int y, int width, int height, boolean isSolid) {
        super(x, y, width, height, isSolid);
    }

    public Tile(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Tile(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    public Tile(int x, int y, int width, int height, boolean isSolid, Sprite sprite) {
        super(x, y, width, height, isSolid, sprite);
    }


}
