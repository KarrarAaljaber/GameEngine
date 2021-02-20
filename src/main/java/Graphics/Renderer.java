package Graphics;

import Entities.Entity;
import GameHandlers.GameStateController;

import java.awt.*;
import java.awt.Graphics;

import GameHandlers.GameObject;
import Tiles.Tile;
import Utilities.Camera;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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



        g2d.setColor(backgroundcolor);
        g2d.fillRect( 0, 0, WIDTH, HEIGHT);


        EngineGraphics engineGraphics = new EngineGraphics(g2d);

        g2d.translate(camera.getX(), camera.getY());



        gch.render(engineGraphics);

        g2d.translate(-camera.getX(), -camera.getY());




    }
    public void update(double delta) {
        gch.update(delta);
    }




    public void start() {
        thread = new Thread(this, "mainThread");
        thread.start();
        isRunning = true;
    }

    @Override
    public void run() {
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / FPS;
        final double timeF = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int ticks = 0;
        long timer = System.currentTimeMillis();
        boolean RENDER_TIME = false;
        while (isRunning) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                update(deltaU);
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                RENDER_TIME = true;

                render();
                renderToScreen();

                frames++;
                deltaF--;



            }

            if (System.currentTimeMillis() - timer > 1000) {

                if (RENDER_TIME) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));


                }


                frames = 0;
                ticks = 0;
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
