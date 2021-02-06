package Graphics;

import javax.swing.*;
import java.awt.*;

public class Screen  {


    private JFrame frame = new JFrame();
    private Renderer renderer;
    public Screen(int WIDTH, int HEIGHT, boolean resizable, Color Backgroundcolor){
        renderer = new Renderer(WIDTH, HEIGHT, Backgroundcolor);
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
