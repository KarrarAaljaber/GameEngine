package Graphics;

import Entities.Entity;
import GameHandlers.GameObject;
import GameHandlers.GameState;
import Utilities.Camera;

import javax.swing.*;
import java.awt.*;

public class Screen  {


    private JFrame frame = new JFrame();
    private Renderer renderer;

    private int sizeScale;
    private boolean fullscreen;
    public Screen( int WIDTH, int HEIGHT, int sizeScale, boolean resizable, boolean fullscreen, Color Backgroundcolor){

        this.sizeScale = sizeScale;
        this.fullscreen = fullscreen;

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

        renderer.start();

    }
    public void fullscreen(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);

        device.setFullScreenWindow(frame);
    }
    public void windowed(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();

        frame.setVisible(false);
        if(device.getFullScreenWindow() != null && frame.isDisplayable())device.getFullScreenWindow().dispose();
        device.setFullScreenWindow(null);
        frame.setResizable(false);
        frame.setUndecorated(false);
        frame.setVisible(true);

    }

    public Renderer getRenderer(){
        return renderer;
    }


    public JFrame getFrame(){
        return frame;
    }

}