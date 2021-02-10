package Utilities;

public class Vector2f {

    private float x, y;

    public Vector2f(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2f multiply(Vector2f v2){
        return  new Vector2f(this.getX() * v2.getX() , this.getY() * v2.getY());
    }
    public Vector2f multiply(float num){
        return  new Vector2f(this.getX() * num , this.getY() *num);
    }

    public Vector2f divide(Vector2f v2){
        return  new Vector2f(this.getX() / v2.getX() , this.getY() / v2.getY());
    }
    public Vector2f divide(float num){
        return  new Vector2f(this.getX() / num , this.getY() / num);
    }

    public Vector2f plus(Vector2f v2){
        return  new Vector2f(this.getX() + v2.getX() , this.getY() + v2.getY());
    }
    public Vector2f plus(float num){
        return  new Vector2f(this.getX() + num , this.getY() + num);
    }

    public Vector2f minus(Vector2f v2){
        return  new Vector2f(this.getX() - v2.getX() , this.getY() - v2.getY());
    }
    public Vector2f minus(float num){
        return  new Vector2f(this.getX() - num , this.getY() - num);
    }

    public float getY() {
        return y;
    }
    public int getIntY() {
        return (int)y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public int getIntX() {
        return (int)x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
