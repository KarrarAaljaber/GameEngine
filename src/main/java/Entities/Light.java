package Entities;

public class Light {


    private int x, y;
    private int radius;
    private float[]color;

    public Light(int x, int y, int radius, float[]color, float brightnessvalue) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radius = radius;
        for(int i=0; i < 3; i++){
            color[i] = color[i] + brightnessvalue;
        }
    }

    public float[] getColor() {
        return color;
    }

    public void setColor(float[] color) {
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
