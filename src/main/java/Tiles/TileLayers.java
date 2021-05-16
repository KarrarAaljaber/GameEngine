package Tiles;

import Graphics.Renderer;
import Graphics.SpriteSheet;

import java.util.ArrayList;

public abstract class TileLayers {

    protected ArrayList<Tile> tiles;
    protected int w, h;
    protected int tileWidth, tileHeight;
    protected int tilecols;
    protected  SpriteSheet spriteSheet;
    protected String Data;

    public TileLayers( String Data, int w, int h, int tileWidth, int tileHeight , int tilecols, SpriteSheet spriteSheet) {
        this.w = w;
        this.tilecols = tilecols;
        this.Data = Data;
        this.h = h;
        this.spriteSheet = spriteSheet;
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        tiles = new ArrayList<>();
        addTiles();

    }

    public abstract void addTiles();


    public void renderTiles(){
        Renderer.addTiles(tiles);

    }




}
