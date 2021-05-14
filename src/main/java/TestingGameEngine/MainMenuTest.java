package TestingGameEngine;

import GameHandlers.GameObject;
import GameHandlers.GameState;
import Graphics.EngineGraphics;
import Graphics.Renderer;
import Graphics.Screen;

import Tiles.NonSolidTile;
import Tiles.colorTile;
import UI.UIButton;
import UI.UIContainer;
import Utilities.EngineMath;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenuTest extends GameState {


    private UIContainer container;
    private UIButton play;

    private BufferedImage shadow;
    private  int oldX;
    public MainMenuTest(Screen screen) {
        super(screen);
        shadow = new BufferedImage(screen.getFrame().getWidth(), screen.getFrame().getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        container = new UIContainer(0, 0, Game2.WIDTH, Game2.HEIGHT);
        container.setBackgroundColor(Color.BLACK);
        play = new UIButton(container, 33, 33, 150, 50, Color.WHITE);
        play.setText("Start Game");
        play.setTextColor(Color.BLACK);
        play.setBorderThickness(5);
        play.setBorderColor(Color.white);

        container.placeUIComponentAtCenterX(play);
        container.placeUIComponentAtCenterY(play);
        container.addUIComponent(play);
        oldX = play.getX();

        Renderer.addUIContainer(container);

        Renderer.getGameStateController().addGameState(this);


    }



    @Override
    public void update(float delta) {
        if (play.clicked()) {
            Renderer.getUiController().removeUIContainer(container);
            Renderer.getGameStateController().changeGameState(new Game2(getScreen()));
        }




    }


    @Override
    public void render(EngineGraphics g) {


    }
}
