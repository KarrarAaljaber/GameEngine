package Graphics;

import Entities.Entity;
import GameHandlers.GameStateController;

import java.awt.*;
import java.awt.Graphics;

import GameHandlers.GameObject;
import TestingGameEngine.Game;
import Tiles.Tile;
import Utilities.Camera;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.RenderingHints.*;

public class Renderer extends Canvas implements  Runnable, KeyListener , MouseListener{

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




    public Renderer(GameObject player, int WIDTH, int HEIGHT, int SCALE, Color backgroundcolor, Camera camera){
        this.WIDTH = WIDTH;
        this.SCALE = SCALE;
        this.player = player;
        this.HEIGHT = HEIGHT;
        this.backgroundcolor = backgroundcolor;
        this.camera = camera;
        this.addKeyListener(this);
        this.addMouseListener(this);
        gch = new GameStateController(this, player);
        init();

        System.out.println(getWIDTH());

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
        fps++;
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


        AffineTransform oldAT = g2d.getTransform();




        g2d.setColor(backgroundcolor);
        g2d.fillRect( 0, 0, WIDTH, HEIGHT);



        EngineGraphics engineGraphics = new EngineGraphics(g2d);




        //g2d.scale(camera.getZoomscale(), camera.getZoomscale());
        g2d.translate(camera.getX(), camera.getY());


        gch.render(engineGraphics);


        g2d.translate(-camera.getX(), -camera.getY());




    }
    public void update() {
        ups++;
        gch.update();
    }




    public void start() {
        thread = new Thread(this, "mainThread");
        thread.start();
        isRunning = true;
    }
    private final double updateRate = 1.0d/60.0d;
    private int fps, ups;
    private long nextStateTime;
    @Override
    public void run() {
        long currentTime, lastUpdate = System.currentTimeMillis();
        double counter =0;
         nextStateTime = System.currentTimeMillis() + 1000;

        while (isRunning) {
            currentTime = System.currentTimeMillis();
            double lastRender = (currentTime - lastUpdate) / 1000d;
            counter += lastRender;
            lastUpdate = currentTime;

            while(counter > updateRate){
                update();

                counter -= updateRate;

            }
                render();
                renderToScreen();
                printRendererStats();

            }


    }
    public void printRendererStats(){
        if(System.currentTimeMillis() > nextStateTime){
            System.out.println(String.format("FPS : %d, UPS: %d", fps, ups));
            fps =0;
            ups = 0;
            nextStateTime = System.currentTimeMillis() + 1000;
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
    public static void addTiles(ArrayList<Tile> object) {
        getGch().getObjects().addAll(object);
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


        gch.keyPressed(key);
        if (key == KeyEvent.VK_G && !toggle) {
            showLayers = !showLayers;
            toggle = true;
        } else if (!(key == KeyEvent.VK_G)) toggle = false;


    }



    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        gch.keyReleased(key);
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        gch.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gch.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
