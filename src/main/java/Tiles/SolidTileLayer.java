package Tiles;

import GameComponents.Collider;
import GameHandlers.GameState;
import Graphics.Sprite;
import Graphics.SpriteSheet;

public class SolidTileLayer extends TileLayers{


    public SolidTileLayer( String Data, int w, int h, int tileWidth, int tileHeight, int tilecols, SpriteSheet spriteSheet) {
        super( Data, w, h, tileWidth, tileHeight, tilecols, spriteSheet);
    }

    @Override
    public void addTiles() {
        String[] tile = Data.split(",");
        for(int i=0; i < (w*h); i++){
            int temp = Integer.parseInt(tile[i].replaceAll("\\s+",  ""));
            if(temp !=0){
                SolidTile t = new SolidTile((int)(i%w) * tileWidth,(int) (i/ h) *tileHeight , tileWidth, tileHeight,new Sprite(spriteSheet,(int) ((temp -1) % tilecols ), (int) ((temp -1 ) /tilecols) ,tileWidth,tileHeight ) );
                tiles.add(t);
                t.addComponent(new Collider(t,t.getWidth(), t.getHeight()));


            }

        }
    }

}
