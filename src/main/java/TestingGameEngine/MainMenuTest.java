package TestingGameEngine;

import GameHandlers.GameObject;
import GameHandlers.GameState;
import Graphics.EngineGraphics;
import Graphics.Renderer;
import Graphics.Screen;
import Particles.Particle;
import Particles.ParticleSystem;
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

    private ParticleSystem ps;
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
        ps = new ParticleSystem();

        Renderer.getGch().addGameState(this);


    }



    @Override
    public void update(float delta) {
        if (play.clicked()) {
            Renderer.getUiController().removeUIContainer(container);
            Renderer.getGch().changeGameState(new TestScene(getScreen()));
        }


        if(Renderer.getInput().isMouseMoved()){
            for(int i=0; i < 2; i++){
                Particle p = (new Particle(Renderer.getInput().getMouseX(), Renderer.getInput().getMouseY(), 25,25,EngineMath.rand.nextInt(180),
                        new Color(EngineMath.rand.nextInt(255), 83, 83),1000));
                var angleInRadians =(int)p.getRotationAngle() * Math.PI / 180;
                p.setMoveSpeed(1);
                p.getRigidbody().getVelocity().setX((float) ( p.getMoveSpeed()* Math.cos(angleInRadians) * delta));
                p.getRigidbody().getVelocity().setY((float) (p.getMoveSpeed()* Math.sin(angleInRadians) * delta));
                ps.addParticles(p,25);

            }


        }
        ps.update(delta);

    }


    @Override
    public void render(EngineGraphics g) {


        ps.render(g);
    }
}
