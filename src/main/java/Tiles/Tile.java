package Tiles;

import GameObjects.GameObject;
import Graphics.Sprite;

import java.awt.*;

public abstract class Tile extends GameObject {


    public Tile(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public Tile(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }
}
