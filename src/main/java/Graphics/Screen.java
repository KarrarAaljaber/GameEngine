package Graphics;

import GameControllers.GameLoop;

import javax.swing.*;
import java.awt.*;

public class Screen   {


    private JFrame frame = new JFrame();
    private Renderer renderer;
    private GameLoop gameLoop;

    private int sizeScale;
    private int WIDTH;
    private boolean fullscreen;


    public Screen( int WIDTH, int HEIGHT, int sizeScale, boolean resizable, Color Backgroundcolor){

        this.sizeScale = sizeScale;
        this.fullscreen = fullscreen;
        this.WIDTH = WIDTH;

        renderer = new Renderer(WIDTH, HEIGHT, sizeScale, Backgroundcolor);
        frame.setPreferredSize(new Dimension( WIDTH * sizeScale, HEIGHT * sizeScale));
        frame.setMinimumSize(new Dimension( WIDTH * sizeScale, HEIGHT * sizeScale));
        frame.setMaximumSize(new Dimension( WIDTH * sizeScale, HEIGHT * sizeScale));
        frame.setResizable(resizable);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(renderer);
        frame.requestFocus();


        if(fullscreen){
            fullscreen();
        }
        frame.setVisible(true);

        gameLoop = new GameLoop(renderer);
        gameLoop.start();


    }
    public void fullscreen(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);

        device.setFullScreenWindow(frame);
    }





    public int getWIDTH() {
        return WIDTH;
    }

    public Renderer getRenderer(){
        return renderer;
    }


    public JFrame getFrame(){
        return frame;
    }


}