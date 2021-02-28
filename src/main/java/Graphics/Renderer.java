package Graphics;

import Entities.Entity;
import GameComponents.Input;
import GameHandlers.GameStateController;

import java.awt.*;
import java.awt.Graphics;

import GameHandlers.GameObject;
import TestingGameEngine.Game;
import Tiles.Tile;
import UI.UIContainer;
import UI.UIController;
import Utilities.Camera;

import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.RenderingHints.*;

public class Renderer extends Canvas implements  Runnable, KeyListener , MouseListener, MouseMotionListener {

    private Thread thread;
    private boolean isRunning = false;

    //FRAMES
    private int FPS = 60;
    public 	int frames =0;

    //Grap
    private BufferedImage img;
    private Graphics2D g2d;

    private static GameStateController gch;


    private int WIDTH, HEIGHT;
    private Color backgroundcolor;
    private  Camera camera;
    private GameObject player;
    private int SCALE;

    public static boolean showLayers;
    public static  boolean toggle;
    private static UIController uiController;


    private static Input input;


    public Renderer(GameObject player, int WIDTH, int HEIGHT, int SCALE, Color backgroundcolor, Camera camera){
        this.WIDTH = WIDTH;
        this.SCALE = SCALE;
        this.player = player;
        this.HEIGHT = HEIGHT;
        this.backgroundcolor = backgroundcolor;
        this.camera = camera;
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        gch = new GameStateController(this, player);
        uiController = new UIController();


        init();
        requestFocus();

        System.out.println(getWIDTH());
        input = new Input() ;

    }


    public static Input getInput(){
        return input;
    }
    public void init() {

        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D) img.getGraphics();

        g2d.setRenderingHint(KEY_ANTIALIASING,
                VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(KEY_ALPHA_INTERPOLATION,
                VALUE_ALPHA_INTERPOLATION_QUALITY);

        g2d.setRenderingHint(KEY_RENDERING,	VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(KEY_COLOR_RENDERING,
                VALUE_COLOR_RENDER_QUALITY);

        g2d.setRenderingHint(KEY_DITHERING,
                VALUE_DITHER_ENABLE);

        g2d.setRenderingHint(KEY_INTERPOLATION,
                VALUE_INTERPOLATION_BILINEAR);


        g2d.setRenderingHint(KEY_TEXT_ANTIALIASING,VALUE_TEXT_ANTIALIAS_ON);


    }

    public void renderToScreen() {

        Graphics g = (Graphics) this.getGraphics();


        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        g.dispose();


    }



    public void render() {


        AffineTransform oldAT = g2d.getTransform();




        g2d.setColor(backgroundcolor);
        g2d.fillRect( 0, 0, WIDTH, HEIGHT);



        EngineGraphics engineGraphics = new EngineGraphics(g2d);




        //g2d.scale(camera.getZoomscale(), camera.getZoomscale());

        AffineTransform transform = new AffineTransform();
        transform.translate(camera.getX(), camera.getY());

        g2d.setTransform(transform);
        gch.render(engineGraphics);


        g2d.setTransform(oldAT);


        uiController.render(engineGraphics);


    }
    public void update(float deltaTime) {
        uiController.update();
        gch.update(deltaTime);
        input.update(deltaTime);
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
        int fps = 0, ups =  0;
        double deltaTime =0, deltaRenderTime =0;
        double optimalUpdateTime = 1000000000/MAX_UPS;
        double optimalRenderTime = 1000000000/MAX_FPS;

         long startTime = System.nanoTime();

        while (isRunning) {
            long curTime = System.nanoTime();
            deltaTime += (curTime - startTime);
            deltaRenderTime +=(curTime - startTime);
            startTime = curTime;

           if(deltaTime >= optimalUpdateTime){
               update((float)deltaTime/1000000000);
               ups++;
               deltaTime -=optimalUpdateTime;
           }
            if(deltaRenderTime >= optimalRenderTime){
                renderToScreen();
                render();
                fps++;
                deltaRenderTime -=optimalRenderTime;
            }
            if(System.currentTimeMillis() - timer >= 1000){
                System.out.println(String.format("FPS : %d, UPS: %d", fps, ups));
                fps =0;
                ups = 0;
                timer += 1000;
            }

        }


    }


    public static GameStateController getGch() {
        return gch;
    }
    public static void addObject(GameObject object) {
        getGch().getObjects().add(object);
    }

    public static void addObjects(ArrayList<GameObject> object) {
        getGch().getObjects().addAll(object);
    }
    public static void addEntities(ArrayList<Entity> object) {
        getGch().getObjects().addAll(object);
    }

    public static void addTiles(ArrayList<Tile> object) {
        getGch().getObjects().addAll(object);
    }
    public static void addUIContainer(UIContainer container){
        getUiController().addUIContainer(container);
    }

    public static void add2DObjectArray(GameObject[][] objectz) {
        for (int i = 0; i < objectz.length; i++) {
            for (int j = 0; j < objectz[i].length; j++) {
                getGch().getObjects().add(objectz[i][j]);
            }
        }
    }
    public static void addObjecArray(GameObject[]objects){
        for(int i=0; i < objects.length; i++){
            Renderer.addObject(objects[i]);
        }
    }
    public int getWIDTH() {
        return WIDTH *SCALE ;
    }
    public int getSCALE(){
        return  SCALE;
    }

    public int getHEIGHT() {
        return HEIGHT * SCALE;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        input.keyPressed(key);


        if (key == KeyEvent.VK_G && !toggle) {
            showLayers = !showLayers;
            toggle = true;
        } else if (!(key == KeyEvent.VK_G)) toggle = false;


    }



    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        input.keyReleased(key);
    }

    public static UIController getUiController() {
        return uiController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        input.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        input.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        input.setMouseX(e.getX() / SCALE -camera.getX() );
        input.setMouseY(e.getY() / SCALE -camera.getY());

    }
}