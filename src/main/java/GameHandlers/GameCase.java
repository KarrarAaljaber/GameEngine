package GameHandlers;

import Graphics.Screen;

import Graphics.EngineGraphics;
import java.awt.event.MouseEvent;

public abstract class GameCase {

    private GameCaseHandler gch;

    private Screen screen;

    public GameCase(Screen screen) {
        this.screen = screen;
        init();

    }

    public Screen getScreen() {
        return screen;
    }
    public GameCaseHandler getGch(){
        return gch;
    }

    public abstract void init();
    public abstract void update(double delta);
    public abstract void render(EngineGraphics g);
    public abstract void keyPressed(int key);
    public abstract void keyReleased(int key);
    public abstract void mousePressed(MouseEvent e);
    public abstract void mouseReleased(MouseEvent e);
}
