package GameControllers;

import Graphics.Renderer;

import java.awt.event.*;

public class InputController implements KeyListener, MouseListener, MouseMotionListener {

    private Input input;
    private Renderer renderer;

    public InputController(Input input, Renderer renderer) {
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
        input.mousePressed(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(renderer.getCamera()!=null){
            input.setMouseDragX(e.getX() /  renderer.getSCALE() -renderer.getCamera().getX() );
            input.setMouseDragY(e.getY() /  renderer.getSCALE() -renderer.getCamera().getY() );
        }else {
            input.setMouseDragX(e.getX() /  renderer.getSCALE()  );
            input.setMouseDragY(e.getY() /  renderer.getSCALE()  );
        }

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        input.setMouseX(e.getX() /renderer.getSCALE());
        input.setMouseY(e.getY() / renderer.getSCALE());
        if(renderer.getCamera() !=null) {
            input.setMousetoGraphicsX(e.getX() / renderer.getSCALE() - renderer.getCamera().getX());
            input.setMouseToGraphicsY(e.getY() / renderer.getSCALE() - renderer.getCamera().getY());
        }else{
            input.setMousetoGraphicsX(e.getX() / renderer.getSCALE() );
            input.setMouseToGraphicsY(e.getY() / renderer.getSCALE() );
        }
    }

    public Input getInput() {
        return input;
    }

}
