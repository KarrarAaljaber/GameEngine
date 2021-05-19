package UI;

import Graphics.EngineGraphics;

import java.awt.*;
import java.util.ArrayList;

public class UIContainer {

    private ArrayList<UIComponent> uiComponents;
    private int width, height, x, y;
    private Color backgroundColor;
    private int borderThickness = 0;
    private Color borderColor = Color.WHITE;
    private boolean isVisiable = true;


    public UIContainer(int x, int y, int width, int height){
        uiComponents = new ArrayList<UIComponent>();
        this.x =x ;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void placeUIComponentAtCenterX(UIComponent component){
        component.setX(getX() + getWidth() / 2 - component.getWidth() / 2);
    }
    public void placeUIComponentAtCenterY(UIComponent component){
        component.setY(getY() + getHeight() / 2 - component.getHeight() / 2);

    }

    public void removeUIComponent(UIComponent component){
        uiComponents.remove(component);
    }

    public void addUIComponent(UIComponent component){
        uiComponents.add(component);
    }
    public ArrayList<UIComponent> getUiComponents() {
        return uiComponents;
    }

    public void setUiComponents(ArrayList<UIComponent> uiComponents) {
        this.uiComponents = uiComponents;
    }

    public void render(EngineGraphics g){
        if(isVisiable) {
            g.drawBorder(getX(), getY(), getWidth(), getHeight(), getBorderThickness(), getBorderColor());

            g.drawRect(getX(), getY(), getWidth(), getHeight(), getBackgroundColor(), true);

            for (int i = 0; i < uiComponents.size(); i++) {
                //only render the uicomp if its inside the container
                if ((!(uiComponents.get(i).getX() > getX() + getWidth()) && !(uiComponents.get(i).getX() < getX()) &&
                        !(uiComponents.get(i).getY() > getY() + getHeight()) && !(uiComponents.get(i).getY() < getY()))) {

                    uiComponents.get(i).render(g);
                }
            }
        }
    }
    public void update(float delta){

        for(int i=0; i < uiComponents.size(); i++){
            uiComponents.get(i).update(delta);
        }


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

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }


    public Color getBorderColor() {
        return borderColor;
    }

    public boolean isVisiable() {
        return isVisiable;
    }

    public void setVisiable(boolean visiable) {
        isVisiable = visiable;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }


}
