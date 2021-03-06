package Graphics;

import GameObjects.Entity;
import GameControllers.Input;
import GameControllers.GameStateController;

import java.awt.*;
import java.awt.Graphics;

import GameObjects.GameObject;
import GameControllers.InputController;
import Tiles.Tile;
import UI.UIContainer;
import UI.UIController;
import Utilities.Camera;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer extends Canvas  {


    //Grap
    private BufferedImage img;
    private Graphics2D g2d;

    private static GameStateController gameStateController;

    private int WIDTH, HEIGHT;
    private Color backgroundcolor;
    private Camera camera;
    private int SCALE;

    public static boolean showLayers;
    public static boolean toggle;
    private static UIController uiController;

    private InputController inputController;
    private static Input input;


    public Renderer(int WIDTH, int HEIGHT, int SCALE, Color backgroundcolor) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.SCALE = SCALE;
        gameStateController = new GameStateController(this);

        this.backgroundcolor = backgroundcolor;
        setPreferredSize(new Dimension(WIDTH  * SCALE, HEIGHT * SCALE ));
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT *SCALE ));
        setMaximumSize(new Dimension(WIDTH *SCALE, HEIGHT * SCALE ));
        input = new Input();
        inputController = new InputController(input, this);

        this.addKeyListener(inputController);
        this.addMouseListener(inputController);
        this.addMouseMotionListener(inputController);
        uiController = new UIController();

        init();
        requestFocus();

    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

    public static Input getInput() {
        return input;
    }


    public void init() {
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D) img.getGraphics();

    }

    public void renderToScreen() {
        Graphics g = (Graphics) this.getGraphics();
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
    }


    public void render() {
        AffineTransform oldAT = g2d.getTransform();

        g2d.setColor(backgroundcolor);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);


        EngineGraphics engineGraphics = new EngineGraphics(g2d, this);

        AffineTransform transform = new AffineTransform();
        if (getCamera() != null) {
            transform.translate(getCamera().getX(), getCamera().getY());
            g2d.setTransform(transform);

            gameStateController.render(engineGraphics);
            g2d.setTransform(oldAT);
            uiController.render(engineGraphics);

        } else {
            uiController.render(engineGraphics);

            Camera cam = new Camera(0, 0, WIDTH, HEIGHT, 1f);
            transform.translate(cam.getX(), cam.getY());
            g2d.setTransform(transform);
            gameStateController.render(engineGraphics);

            g2d.setTransform(oldAT);

        }


        g2d.setTransform(oldAT);
    }

    public void update(float deltaTime) {
        gameStateController.update(deltaTime);
        input.update(deltaTime);
        uiController.update(deltaTime);
    }


    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }


    public static GameStateController getGameStateController() {
        return gameStateController;
    }

    public static void addObject(GameObject object) {
        getGameStateController().getObjects().add(object);
    }

    public static void addObjects(ArrayList<GameObject> object) {
        getGameStateController().getObjects().addAll(object);
    }

    public static void addEntities(ArrayList<Entity> object) {
        getGameStateController().getObjects().addAll(object);
    }

    public static void addTiles(ArrayList<Tile> object) {
        getGameStateController().getObjects().addAll(object);
    }

    public static void addUIContainer(UIContainer container) {
        getUiController().addUIContainer(container);
    }

    public static void add2DObjectArray(GameObject[][] objectz) {
        for (int i = 0; i < objectz.length; i++) {
            for (int j = 0; j < objectz[i].length; j++) {
                getGameStateController().getObjects().add(objectz[i][j]);
            }
        }
    }

    public static void addObjecArray(GameObject[] objects) {
        for (int i = 0; i < objects.length; i++) {
            Renderer.addObject(objects[i]);
        }
    }

    public int getWidthWithScale() {
        return WIDTH * SCALE;
    }

    public int getSCALE() {
        return SCALE;
    }

    public int getHeightWithScale() {
        return HEIGHT * SCALE;
    }


    public static UIController getUiController() {
        return uiController;
    }



}