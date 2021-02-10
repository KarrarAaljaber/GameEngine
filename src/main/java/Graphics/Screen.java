package Graphics;

import GameHandlers.GameObject;
import Utilities.TopDownCamera;

import javax.swing.*;
import java.awt.*;

public class Screen  {


    private JFrame frame = new JFrame();
    private Renderer renderer;
    private TopDownCamera camera;
    private GameObject player;
    private int sizeScale;
    public Screen(GameObject player,TopDownCamera camera, int WIDTH, int HEIGHT, int sizeScale, boolean resizable, Color Backgroundcolor){
        this.camera = camera;
        this.player = player;
        this.sizeScale = sizeScale;

        renderer = new Renderer(player,WIDTH, HEIGHT, sizeScale, Backgroundcolor, camera);
        frame.setPreferredSize(new Dimension( WIDTH * sizeScale, HEIGHT * sizeScale));
        frame.setMinimumSize(new Dimension( WIDTH * sizeScale, HEIGHT * sizeScale));
        frame.setMaximumSize(new Dimension( WIDTH * sizeScale, HEIGHT * sizeScale));
        frame.setResizable(resizable);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(renderer);
        frame.setVisible(true);

        renderer.start();

    }

    public Renderer getRenderer(){
        return renderer;
    }


    public JFrame getFrame(){
        return frame;
    }

}
