package Tiles;

import Graphics.Sprite;
import Graphics.SpriteSheet;

public class NonSolidTileLayer extends  TileLayers{


    public NonSolidTileLayer(  String Data, int w, int h, int tileWidth, int tileHeight, int tilecols, SpriteSheet spriteSheet) {
        super( Data, w, h, tileWidth, tileHeight, tilecols, spriteSheet);
    }

    @Override
    public void addTiles() {
        String[] tile = Data.split(",");
        for(int i=0; i < (w*h); i++){
            int temp = Integer.parseInt(tile[i].replaceAll("\\s+",  ""));
            if(temp !=0) {
                tiles.add(new NonSolidTile((int) (i % w) * tileWidth, (int) (i / h) * tileHeight, tileWidth, tileHeight, new Sprite(SpriteSheet
                        .getSpriteImageFromSpriteSheet( spriteSheet,  (int) (temp - 1) / tilecols,(int) (temp - 1) % tilecols))));
            }

        }
    }
}
