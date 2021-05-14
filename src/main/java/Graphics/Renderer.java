package Graphics;

import Entities.Entity;
import GameComponents.Input;
import GameHandlers.GameStateController;

import java.awt.*;
import java.awt.Graphics;

import GameHandlers.GameObject;
import GameHandlers.InputHandler;
import Tiles.Tile;
import UI.UIContainer;
import UI.UIController;
import Utilities.Camera;

import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.RenderingHints.*;

public class Renderer extends Canvas implements  Runnable {

    private Thread thread;
    private boolean isRunning = false;

    //FRAMES
    private int FPS = 60;
    public int frames = 0;

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


    private  InputHandler inputHandler;
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
        inputHandler = new InputHandler(input, this);

        this.addKeyListener(inputHandler);
        this.addMouseListener(inputHandler);
        this.addMouseMotionListener(inputHandler);
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

    private BufferedImage shadow;

    public void init() {

        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        g2d = (Graphics2D) img.getGraphics();
        g2d.setRenderingHint(KEY_ANTIALIASING,
                VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(KEY_ALPHA_INTERPOLATION,
                VALUE_ALPHA_INTERPOLATION_QUALITY);

        g2d.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(KEY_COLOR_RENDERING,
                VALUE_COLOR_RENDER_QUALITY);

        g2d.setRenderingHint(KEY_DITHERING,
                VALUE_DITHER_ENABLE);

        g2d.setRenderingHint(KEY_INTERPOLATION,
                VALUE_INTERPOLATION_BILINEAR);


        g2d.setRenderingHint(KEY_TEXT_ANTIALIASING, VALUE_TEXT_ANTIALIAS_ON);


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


        //g2d.scale(camera.getZoomscale(), camera.getZoomscale());

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

        g2d.drawImage(shadow, 0, 0, null);


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

    public void start() {
        thread = new Thread(this, "mainThread");
        thread.start();
        isRunning = true;
    }

    private final int MAX_FPS = 1000;
    private final int MAX_UPS = 60;

    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        int fps = 0, ups = 0;
        double deltaTime = 0, deltaRenderTime = 0;
        double optimalUpdateTime = 1000000000 / MAX_UPS;
        double optimalRenderTime = 1000000000 / MAX_FPS;

        long startTime = System.nanoTime();
        while (isRunning) {
            long curTime = System.nanoTime();
            deltaTime += (curTime - startTime);
            deltaRenderTime += (curTime - startTime);
            startTime = curTime;

            if (deltaTime >= optimalUpdateTime) {
                update((float) deltaTime / 1000000000);
                ups++;
                deltaTime -= optimalUpdateTime;
            }
            if (deltaRenderTime >= optimalRenderTime) {
                renderToScreen();
                render();
                fps++;
                deltaRenderTime -= optimalRenderTime;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println(String.format("FPS : %d, UPS: %d", fps, ups));
                fps = 0;
                ups = 0;
                timer += 1000;
            }

        }


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