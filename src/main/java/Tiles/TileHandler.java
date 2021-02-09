package Tiles;

import Graphics.Sprite;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class TileHandler {

    public static ArrayList<TileMap> tilemaps;

    public TileHandler(){
        tilemaps = new ArrayList<TileMap>();
    }

    public TileHandler(String path){
        tilemaps = new ArrayList<TileMap>();
        addTileMap(path, 64,64);
    }

    public void addTileMap(String path, int tileWidth, int tileHeight){
        String imgPath;
        int width =0;
        int height =0;
        int tileWidthM;
        int tileHeightM;
        int tilecount;
        int tilecols;
        int layer =0;
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
            tileWidthM = Integer.parseInt(el.getAttribute())

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
