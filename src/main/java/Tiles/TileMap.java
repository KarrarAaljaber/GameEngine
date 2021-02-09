package Tiles;

import Graphics.EngineGraphics;
import Graphics.Sprite;
import Graphics.SpriteSheet;
import Utilities.Vector2f;

public class TileMap{

    public  Tile[][]map;
    private int w, h;
    private int tileWidth, tileHeight;
    private  SpriteSheet spriteSheet;
    public TileMap(int w, int h, int tileWidth, int tileHeight , SpriteSheet spriteSheet){
        this.w = w;
        this.h =h;
        this.spriteSheet = spriteSheet;
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        map = new Tile[w][h];

        for(int i=0; i < map.length; i++){
            for(int j=0; j < map[i].length; j++){
                map[i][j] = new EmptyTile(new Vector2f(i*tileWidth, j* tileHeight), tileWidth, tileHeight, new Sprite(spriteSheet, tileWidth, tileHeight));
            }

        }
    }

    public Tile[][] getMap() {
        return map;
    }

    public void drawTileMap(EngineGraphics g){
        for(int i=0; i < map.length; i++){
            for(int j=0; j < map[i].length; j++){

                Tile t = map[i][j];
                if(t == null){
                    System.out.println("NULLLLLLL!!!");
                }
                g.drawGameObject(t, t.getWidth(), t.getHeight());
            }
        }
    }


}
