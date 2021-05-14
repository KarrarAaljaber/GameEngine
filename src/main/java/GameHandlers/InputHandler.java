package GameHandlers;

import GameComponents.Input;
import Graphics.Renderer;

import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {

    private Input input;
    private Renderer renderer;

    public InputHandler(Input input, Renderer renderer) {
        this.input = input;
        this.renderer = renderer;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        input.keyPressed(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        input.keyReleased(key);
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
        input.setMouseX(e.getX() / renderer.getSCALE() );
        input.setMouseY(e.getY() / renderer.getSCALE());
    }

    public Input getInput() {
        return input;
    }

}
