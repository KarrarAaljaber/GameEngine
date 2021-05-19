package UI;

import Graphics.EngineGraphics;

import java.awt.*;
import Graphics.Renderer;
public abstract class UIComponent {

    protected UIContainer parent;
    protected int x,  y,  width,  height;
    protected String text = "";
    protected Color textColor = Color.WHITE;
    protected Color backgroundColor;
    protected int fontSize = 12;
    private int borderThickness = 0;
    private Color borderColor = Color.WHITE;


    public UIComponent(UIContainer parent, int x, int y, int width, int height, Color backgroundColor) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
    }

    public UIComponent(UIContainer parent) {
        this.parent = parent;
    }


    public UIContainer getParent() {
        return parent;
    }

    public void setParent(UIContainer parent) {
        this.parent = parent;
    }

    public int getCenterX(){
        return  getX() + getWidth() /2;
    }
    public int getCenterY(){
        return  getY() + getHeight() /2;
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

    public boolean mouseInsideComponent(){
        if ((!(Renderer.getInput().getMouseX() > getX() + getWidth()) && !(Renderer.getInput().getMouseX() < getX()) &&
                !(Renderer.getInput().getMouseY() > getY() + getHeight()) && !(Renderer.getInput().getMouseY() < getY()))) {
                return true;
        }else
            return  false;

    }
    public boolean clicked() {
        if (mouseInsideComponent() && Renderer.getInput().mouseButtonDown(1)) {
            return true;
        } else {
            return false;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public abstract void init();
    public abstract void update( float delta);
    public abstract void render(EngineGraphics g);

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
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

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}
