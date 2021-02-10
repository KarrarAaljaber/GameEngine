package Graphics;

import GameHandlers.GameCaseHandler;

import java.awt.*;
import java.awt.Graphics;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Tiles.Tile;
import Utilities.TopDownCamera;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer extends Canvas implements  Runnable, KeyListener {

    private Thread thread;
    private boolean isRunning = false;

    //FRAMES
    private int FPS = 60;
    public 	int frames =0;

    //Grap
    private BufferedImage img;
    private Graphics2D g2d;

    private static GameCaseHandler gch;


    private int WIDTH, HEIGHT;
    private Color backgroundcolor;
    private  TopDownCamera camera;
    private GameObject player;
    public Renderer(GameObject player, int WIDTH, int HEIGHT, Color backgroundcolor, TopDownCamera camera){
        this.WIDTH = WIDTH;
        this.player = player;
        this.HEIGHT = HEIGHT;
        this.backgroundcolor = backgroundcolor;
        this.camera = camera;
        this.addKeyListener(this);
        init();

    }

    public void init() {

        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D) img.getGraphics();


        gch = new GameCaseHandler(this, player);

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
        g2d.translate(camera.getPos().getX(), camera.getPos().getY());



        gch.render(engineGraphics);

        g2d.translate(-camera.getPos().getX(), -camera.getPos().getY());




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

    public static GameCaseHandler getGch() {
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


    public static void addObjectArray(GameObject[][] objectz) {
        for (int i = 0; i < objectz.length; i++) {
            for (int j = 0; j < objectz[i].length; j++) {
                getGch().getObjects().add(objectz[i][j]);
            }
        }
    }
    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        gch.keyPressed(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        gch.keyReleased(key);
    }
}
