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

    protected Vector2f position;
    private ArrayList<GameComponent> components;
    protected Color color;

    protected float[] colorFilter = {1,1,1};


    private float rotationAngle;
    private float scale = 1.0f;

    public GameObject(int x,int y, int width, int height, float rotationAngle){
        position = new Vector2f(x,y);
        this.rotationAngle = rotationAngle;
        this.width = width;
        this.isSolid = isSolid;
        this.height = height;
        components = new ArrayList<>();


    }


    public float[] getColorFilter() {
        return colorFilter;
    }

    public void setColorFilter(float[] colorFilter) {
        this.colorFilter = colorFilter;
    }

    public GameObject(int x, int y, int width, int height){
        position = new Vector2f(x,y);
        this.width = width;
        this.isSolid = isSolid;
        this.height = height;
        components = new ArrayList<>();


    }
    public GameObject(int x, int y, int width, int height, Color color){
        position = new Vector2f(x,y);
        this.width = width;
        this.height = height;
        this.color = color;
        this.isSolid = isSolid;
        components = new ArrayList<>();

    }
    public GameObject(int x, int y, int width, int height, float rotationAngle, Color color){
        position = new Vector2f(x,y);
        this.rotationAngle = rotationAngle;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isSolid = isSolid;
        components = new ArrayList<>();

    }

    public int getCenterX(){
        return getX() + getWidth() / 2;
    }
    public int getCenterY(){
        return getY() + getHeight() / 2;
    }

    public float getScale(){
        return  scale;
    }
    public void scale(float scale){
        this.scale = scale;
    }
    public float getRotationAngle() {
        return rotationAngle;
    }

    public void rotate(float angle) {
        this.rotationAngle = angle;
    }

    public GameObject(int x, int y, int width, int height, Sprite sprite){
        position = new Vector2f(x,y);
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.isSolid = isSolid;
        components = new ArrayList<>();

    }
    public GameObject(int x, int y, int width, int height, float rotationAngle, Sprite sprite){
        position = new Vector2f(x,y);
        this.rotationAngle = rotationAngle;
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
    public abstract void update(float delta);
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
        this.position.setX(col * tilesWidth);
        this.position.setY(row * tilesHeight);
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

    public void updateAllComponents(float delta, GameObject obj){
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

    public Vector2f getPosition(){
        return position;
    }
    public void setPosition(Vector2f position){
        this.position = position;
    }
    public int getX(){
        return  (int) position.getX();
    }


    public int getY() {
        return (int) position.getY();
    }


}
