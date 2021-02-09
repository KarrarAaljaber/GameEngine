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
    public Screen(GameObject player,TopDownCamera camera, int WIDTH, int HEIGHT, boolean resizable, Color Backgroundcolor){
        this.camera = camera;
        this.player = player;

        renderer = new Renderer(player,WIDTH, HEIGHT, Backgroundcolor, camera);
        frame.setPreferredSize(new Dimension( WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension( WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension( WIDTH, HEIGHT));
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
