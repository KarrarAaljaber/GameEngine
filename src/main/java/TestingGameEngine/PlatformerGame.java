package TestingGameEngine;

import GameComponents.Collider;
import GameComponents.Collision;
import GameHandlers.GameState;
import Graphics.EngineGraphics;
import Graphics.Renderer;
import Graphics.Screen;
import Tiles.Tile;
import Tiles.colorTile;
import Utilities.Camera;

import java.awt.*;
import java.util.ArrayList;

public class PlatformerGame  extends GameState {

    private PlatformerPlayer player;
    private Camera camera;

    private static Screen screen;

    public static final int SCALE = 2;
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public PlatformerGame(Screen screen) {
        super(screen);
        player = new PlatformerPlayer(200,200, 32,32, Color.BLUE);
        player.setMoveSpeed(5f);
        player.addComponent(new Collision(player));
        player.addComponent(new Collider(player,32,32));
        camera = new Camera(0,0, WIDTH,HEIGHT,2f);




        ArrayList<Tile> colorTiles = new ArrayList<>(10);
        for(int i=0; i < 25; i++){
            colorTiles.add(new colorTile(i * 32, 400,32,32,Color.RED));
        }
        for(int i=0; i < 25; i++){
            colorTiles.get(i).setSolid(true);
            colorTiles.get(i).addComponent(new Collider(colorTiles.get(i),32,32));

        }
        screen = new Screen(WIDTH,HEIGHT, 2,false,false, new Color(0,0,0));
        screen.getRenderer().setCamera(camera);
        Renderer.getGch().addGameState(this);
        Renderer.addObject(player);
        Renderer.addTiles(colorTiles);

        Renderer.addObject(camera);
    }




    @Override
    public void update(float delta) {
        camera.followEntity(player);
    }

    @Override
    public void render(EngineGraphics g) {

    }
}
