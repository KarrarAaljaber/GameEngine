package GameHandlers;

import Graphics.Renderer;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameCaseHandler {

    private ArrayList<GameCase> gameCases;

    private int currentCase;
    public static final int MENUCASE = 0;
    public static final int LEVEL1 = 1;


    private Renderer renderer;
    public GameCaseHandler(Renderer renderer)
    {
        this.renderer = renderer;
        gameCases = new ArrayList<GameCase>();
        currentCase = MENUCASE;


    }

    public ArrayList<GameCase> getGameCases() {
        return gameCases;
    }

    public void setCase(int Case) {
        currentCase = Case;
    }

    public void render(Graphics2D g2d) {

        gameCases.get(currentCase).render(g2d);
    }

    public void update(double delta){


        gameCases.get(currentCase).update(delta);

    }


    public void mousePressed(MouseEvent e) {
        gameCases.get(currentCase).mousePressed(e);

    }

    public void mouseReleased(MouseEvent e) {
        gameCases.get(currentCase).mouseReleased(e);

    }

    public void keyPressed(int key) {
        gameCases.get(currentCase).keyPressed(key);

    }


    public void keyReleased(int key) {
        gameCases.get(currentCase).keyReleased(key);

    }

}


