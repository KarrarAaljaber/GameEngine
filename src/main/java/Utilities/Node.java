package Utilities;

public class Node {

    private int x,y;
    private Node parent;
    private int gCost, hCost;
    private int fCost;

    public Node(int x, int y, int tileWidth, int tileHeight){
        this.x = x * tileWidth;
        this.y = y * tileHeight;
    }
    public Node(int x, int y){
        this.x = x ;
        this.y = y ;
    }

    public int getX() {
        return x;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int gCost) {
        this.gCost = gCost;
    }

    public int gethCost() {
        return hCost;
    }

    public void sethCost(int hCost) {
        this.hCost = hCost;
    }

    public int getfCost() {
        return fCost;
    }
    public int calcfCost() {
        return fCost = getgCost() + gethCost();
    }


    public void setfCost(int fCost) {
        this.fCost = fCost;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
