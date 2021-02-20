package GameHandlers;

import GameComponents.GameComponent;
import Graphics.Sprite;
import Utilities.Vector2f;
import Graphics.EngineGraphics;

import java.awt.*;
import java.util.ArrayList;

public abstract class GameObject {


    protected int width, height;
    protected Sprite sprite;
    private boolean isSolid = false;

    protected int x;
    protected int y;
    private ArrayList<GameComponent> components;
    protected Color color;




    public GameObject(int x,int y, int width, int height){
        this.x  = x;
        this.y = y;
        this.width = width;
        this.isSolid = isSolid;
        this.height = height;
        components = new ArrayList<>();


    }
    public GameObject(int x, int y, int width, int height, Color color){
        this.x  = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isSolid = isSolid;
        components = new ArrayList<>();

    }



    public GameObject(int x, int y, int width, int height, Sprite sprite){
        this.x  = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.isSolid = isSolid;
        components = new ArrayList<>();

    }

    public boolean isSolid() {
        return isSolid;
    }



    public void setSolid(boolean solid) {
        isSolid = solid;
    }


    public abstract void render(EngineGraphics g);
    public abstract void update(double delta);
    public abstract void init();

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public void placeGameObjectAtTile(int col, int row, int tilesWidth, int tilesHeight) {
        this.setX(col * tilesWidth);
        this.setY(row * tilesHeight);
    }



    public GameComponent getComponent(Class componentObject){
        for (GameComponent c : components)
        {
            if (c.getClass() == componentObject)
                return c;
        }

        return null;
    }
    public void removeComponent(GameComponent component){
        components.remove(component);

    }
    public void initALlComponents(GameObject parent){
        for(int i=0; i < components.size(); i++){
            components.get(i).init();
        }
    }
    public void renderAllComponents(GameObject obj,EngineGraphics g){
        for(int i=0; i < components.size(); i++){
            components.get(i).render(g);
        }
    }

    public void updateAllComponents( GameObject obj,double delta){
        for(int i=0; i < components.size(); i++){
            components.get(i).update(delta);
        }
    }
    public ArrayList<GameComponent> getComponents() {
        return components;
    }

    public void addComponent(GameComponent component){

        components.add(component);

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
