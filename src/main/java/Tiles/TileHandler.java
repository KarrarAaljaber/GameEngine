package Tiles;

import GameControllers.GameState;
import Graphics.Sprite;
import Graphics.SpriteSheet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class TileHandler {

    private ArrayList<TileLayers> tileLayers;

    private int tilecount;
    private int tilecols;
    public TileHandler(){
        tileLayers = new ArrayList<TileLayers>();
    }

    private int tileWidth, tileHeight;
    private SpriteSheet spriteSheet;
    private GameState gameState;

    public TileHandler(String path, int tileWidth, int tileHeight, SpriteSheet spriteSheet){
        tileLayers = new ArrayList<TileLayers>();
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.spriteSheet = spriteSheet;
        addTileMap(spriteSheet,path);
    }


    public void addTileMap(SpriteSheet spriteSheet, String path){
        String imgPath;
        int width =0;
        int height =0;
        int tileWidthM;
        int tileHeightM;

        int layers =0;
        Sprite sprite;
        String[] data = new String[10];

        try {
            DocumentBuilderFactory builderFactory =  DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document document = builder.parse(new File(this.getClass().getClassLoader().getResource(path).toURI()))  ;
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("tileset");
            Node node = list.item(0 );
            Element el = (Element) node;
            imgPath= el.getAttribute("name");
            tileWidthM = Integer.parseInt(el.getAttribute("tilewidth"));
            tileHeightM = Integer.parseInt(el.getAttribute("tileheight"));
            tilecount = Integer.parseInt(el.getAttribute("tilecount"));
            tilecols = Integer.parseInt(el.getAttribute("columns"));

            list = document.getElementsByTagName("layer");
            layers = list.getLength();

            for(int i=0; i < layers; i++){
                node = list.item(i);
                el = (Element) node;
                if(i <= 0){
                    width = Integer.parseInt(el.getAttribute("width"));
                    height = Integer.parseInt(el.getAttribute("height"));

                }
                data[i] = el.getElementsByTagName("data").item(0).getTextContent();

                //floor layer
                if(i == 0)
                {
                    tileLayers.add(new GroundTileLayer(data[i],width, height, tileWidth, tileHeight, tilecols,spriteSheet));
                    //solid layer
                }else if(i==1){
                    tileLayers.add(new SolidTileLayer(data[i],width, height, tileWidth, tileHeight, tilecols,spriteSheet));

                    //non solid layer for props
                }else if(i== 2){
                    tileLayers.add(new NonSolidTileLayer(data[i],width, height, tileWidth, tileHeight, tilecols,spriteSheet));

                }

                //System.out.println("------------------------------------"+ "+\n" + data[i]);
            }



        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void render(){
        for(int i=0; i < tileLayers.size(); i++){
            tileLayers.get(i).renderTiles();
        }
    }

    public int getTilecount() {
        return tilecount;
    }

    public int getTilecols() {
        return tilecols;
    }
}
