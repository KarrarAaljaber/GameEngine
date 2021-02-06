package GameHandlers;

import Graphics.Renderer;
import Graphics.Screen;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GameCase {

    private GameCaseHandler gch;

    private Screen screen;

    public GameCase(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
    public GameCaseHandler getGch(){
        return gch;
    }

    public abstract void init();
    public abstract void update(double delta);
    public abstract void render(Graphics2D g2d);
    public abstract void keyPressed(int key);
    public abstract void keyReleased(int key);
    public abstract void mousePressed(MouseEvent e);
    public abstract void mouseReleased(MouseEvent e);
}
