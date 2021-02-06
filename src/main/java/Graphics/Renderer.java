package Graphics;

import GameHandlers.GameCaseHandler;

import java.awt.*;
import java.awt.Graphics;
import Graphics.EngineGraphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Renderer extends Canvas implements  Runnable{

    private Thread thread;
    private boolean isRunning = false;

    //FRAMES
    private int FPS = 120;
    public 	int frames =0;

    //Grap
    private BufferedImage img;
    private Graphics2D g2d;

    private GameCaseHandler gch;


    private int WIDTH, HEIGHT;
    private Color backgroundcolor;
    public Renderer(int WIDTH, int HEIGHT, Color backgroundcolor){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.backgroundcolor = backgroundcolor;
        gch = new GameCaseHandler(this);
    }



    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(backgroundcolor);
        g.fillRect( 0, 0, WIDTH, HEIGHT);

        Graphics2D g2d = (Graphics2D)g;
        EngineGraphics engineGraphics = new EngineGraphics(g2d);
        gch.render(engineGraphics);

        g.dispose();

        bs.show();

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
        long lastTime = System.nanoTime();
        double delta = 0;
        double nPerTick =1000000000.0/  60.0 ;
        int frames = 0;
        int ticks = 0;
        long Timer = System.currentTimeMillis();
        requestFocus();
        while(isRunning) {
            long now = System.nanoTime();
            delta  += (now - lastTime) /nPerTick;
            lastTime = now;
            while(delta >=1) {
                update(delta);
                ticks++;
                delta-=1;
            }
            {
                frames++;
                render();

            }

            if(System.currentTimeMillis() - Timer > 1000) {
                Timer+=1000;
                System.out.println( ticks + " ticks " + frames +"  FPS");
                //frame.setTitle(TITLE +  " || " +"UPDATES : " + ticks + " || " + " FPS : " + frames);
                frames = 0;
                ticks =0;
            }
        }
       // stop();

    }

    public GameCaseHandler getGch() {
        return gch;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
