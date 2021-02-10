package Tiles;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

public abstract class Tile extends GameObject {


    public Tile(Vector2f pos, int width, int height) {
        super(pos, width, height);
    }

    public Tile(Vector2f pos, int width, int height, Sprite sprite) {
        super(pos, width, height, sprite);
    }
}
