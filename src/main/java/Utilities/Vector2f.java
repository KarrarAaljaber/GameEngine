package Utilities;

public class Vector2f {

    private float x, y;

    public Vector2f(float x, float y){
        this.x = x;
        this.y = y;
    }
    public void limitVector(float maxValue){
        if(getX() > maxValue){
            setX(maxValue);
        }
        if(getY() > maxValue){
            setY(maxValue);
        }
    }

    public void applyForce(Vector2f force, float mass){
        Vector2f v = new Vector2f(0,0);
        force.divideValue(mass);
        addVec(force);
    }
    public Vector2f rotate(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        return new Vector2f((float)(x * cos - y * sin), (float)(x * sin + y  * cos));
    }
    public static Vector2f addVectors(Vector2f v1, Vector2f v2){
        return new Vector2f(v1.getX() + v2.getX() , v1.getY() + v2.getY());
    }
    public static Vector2f minusVectors(Vector2f v1, Vector2f v2){
        return new Vector2f(v1.getX() - v2.getX() , v1.getY() - v2.getY());
    }
    public static Vector2f multiplyVectors(Vector2f v1, Vector2f v2){
        return new Vector2f(v1.getX() * v2.getX() , v1.getY() * v2.getY());
    }
    public static Vector2f divideVectors(Vector2f v1, Vector2f v2){
        return new Vector2f(v1.getX() / v2.getX() , v1.getY() / v2.getY());
    }
    //smooth movement
    public static float Lerp(float goal, float current, float deltaTime){
        float Diff = goal - current;
        if(Diff > deltaTime) {
            return current + deltaTime;
        }
        if(Diff < -deltaTime){
            return current - deltaTime;
        }
        else
            return 0;
    }

    //length of the vector
    public float magnitude(){
        return (float)Math.sqrt(x * x + y*y);
    }
    public float dotProduct(Vector2f v2){
        return x * v2.getX() + y *v2.getY();
    }
    public void addVec(Vector2f v2){
        this.x+= v2.getX();
        this.y+=v2.getY();
    }
    public void addValue(float value ){
        this.x+= value;
        this.y+= value;
    }
    public void minusVec(Vector2f v2){
        this.x-= v2.getX();
        this.y-=v2.getY();
    }
    public void minusValue(float value ){
        this.x-= value;
        this.y-= value;
    }
    public void multiplyVec(Vector2f v2){
        this.x*= v2.getX();
        this.y*=v2.getY();
    }
    public void multiplyValue(float value ){
        this.x*= value;
        this.y*= value;
    }
    public void divideVec(Vector2f v2){
        this.x/= v2.getX();
        this.y/=v2.getY();
    }
    public void divideValue(float value){
        this.x/= value;
        this.y/=value;
    }

    public Vector2f normalize(){
        float len = magnitude();
        x/= len;
        y/= len;
        return this;

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
