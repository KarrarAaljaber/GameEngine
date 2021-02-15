package Tiles;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Graphics.Sprite;
import Utilities.Vector2f;

import java.awt.*;

public abstract class Tile extends GameObject {


    public Tile(int x, int y, int width, int height, boolean isSolid, Color color) {
        super(x, y, width, height, isSolid, color);
    }

    public Tile(int x, int y, int width, int height, boolean isSolid, Sprite sprite) {
        super(x, y, width, height, isSolid, sprite);
    }
}
