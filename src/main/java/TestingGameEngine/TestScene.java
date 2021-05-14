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
import java.util.Random;

public class TestScene extends GameState {

    private PlatformerPlayer r;
    private Camera camera;

    private static Screen screen;


    public TestScene(Screen screen) {
        super(screen);

        Player player = new Player(200,100,62,22,new Color(255, 75, 75));
        ArrayList<Tile> colorTiles = new ArrayList<>(30);
        Random random = new Random();
        for(int i=0; i < screen.getWIDTH()/21; i++){
            System.out.println(screen.getWIDTH());
            colorTiles.add(new colorTile(i * 22, 400,22,22,new Color(random.nextInt(255),
                    random.nextInt(255),random.nextInt(255))));
        }


        Renderer.getGameStateController().addGameState(this);
        Renderer.addTiles(colorTiles);
        Renderer.addObject(player);

    }



    @Override
    public void update(float delta) {

    }

    @Override
    public void render(EngineGraphics g) {

    }
    //camera.followEntity(player);




             /*
        for(int i=0; i < 25; i++){
            colorTiles.get(i).setSolid(true);
            colorTiles.get(i).addComponent(new Collider(colorTiles.get(i),32,32));

        }*/

    //screen.getRenderer().setCamera(camera);

            /*
        player = new PlatformerPlayer(200,200, 32,32, Color.BLUE);
        player.setMoveSpeed(1f);
        player.addComponent(new Collision(player));
        player.addComponent(new Collider(player,32,32));
        camera = new Camera(0,0, screen.getRenderer().getWidth() / 2,screen.getRenderer().getHeight() / 2,2f);
*/

    //  Renderer.addObject(player);
    // Renderer.addObject(camera);



}
