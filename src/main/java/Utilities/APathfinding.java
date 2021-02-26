package Utilities;

import Entities.Entity;

import java.util.ArrayList;

public class APathfinding {

    private ArrayList<Node> openNodes;
    private ArrayList<Node> closeNodes;

    private final int straightMoveCost = 10;
    private final int diaMoveCost = 14;

    public APathfinding(){
        openNodes = new ArrayList<>();
        closeNodes = new ArrayList<>();
    }

    public ArrayList<Node> findPath(int startX, int startY, int endX, int endY, int[][]map){
        Node startNode = new Node(startX, startY);
        Node endNode = new Node(endX, endY);

        openNodes.add(startNode);
        for(int x=0; x < map.length; x++){
            for(int y=0; y < map[x].length; y++){
                Node path = new Node(x,y);
                path.setgCost(Integer.MAX_VALUE);
                path.calcfCost();
            }
        }
        startNode.setgCost(0);
        startNode.sethCost(calcDistCost(startNode, endNode));
        startNode.calcfCost();

        while(openNodes.size() >0){
            Node curNode = getNodeWithLowestFCost(openNodes);
            if(curNode == endNode){
                return CalcPath(endNode);
            }
            openNodes.remove(curNode);
            closeNodes.add(curNode);

            for(int k =0; k < findNeighbours(curNode, map.length).size(); k++){
                Node neighbourNode = findNeighbours(curNode, map.length).get(k);

                if(closeNodes.contains(neighbourNode))continue;
                int tentativeGCost = curNode.getgCost() + calcDistCost(curNode, neighbourNode);
                if(tentativeGCost < findNeighbours(curNode, map.length).get(k).getgCost()){
                    neighbourNode.setParent(curNode);
                    neighbourNode.setgCost(tentativeGCost);
                    neighbourNode.sethCost(calcDistCost(neighbourNode, endNode));
                    neighbourNode.calcfCost();

                    if(!openNodes.contains(neighbourNode)){
                        openNodes.add(neighbourNode);
                    }
                }

            }

        }

        return null;
    }

    public ArrayList<Node> findNeighbours(Node curNode, int mapHeight){
        ArrayList<Node> neighbours = new ArrayList<>();
        //straightmove
        if(curNode.getX() - 1 >= 0){
            //left
            neighbours.add(new Node(curNode.getX() - 1, curNode.getY()));
            //left down//diagonalmove
            if(curNode.getY() -1 >=0){
                neighbours.add(new Node(curNode.getY() -1, curNode.getY() - 1));
            }
            //left up//diagonalmove
            if(curNode.getY() +1 >=0){
                neighbours.add(new Node(curNode.getY() -1, curNode.getY() + 1));
            }
        }

        if(curNode.getX() + 1 >= 0){
            //left
            neighbours.add(new Node(curNode.getX() + 1, curNode.getY()));
            //left down//diagonalmove
            if(curNode.getY() -1 >=0){
                neighbours.add(new Node(curNode.getY() +1, curNode.getY() - 1));
            }
            //left up//diagonalmove
            if(curNode.getY() +1 >=0){
                neighbours.add(new Node(curNode.getY() +1, curNode.getY() + 1));
            }
        }
        //DOWN
        if(curNode.getY() - 1 >=0){
            neighbours.add(new Node(curNode.getX(), curNode.getY() - 1));
        }
        if(curNode.getY() + 1 < mapHeight){
            neighbours.add(new Node(curNode.getX(), curNode.getY() + 1));
        }
        return neighbours;
    }

    public ArrayList<Node> CalcPath(Node endNode){
       ArrayList<Node> path = new ArrayList<>();
       path.add(endNode);
       Node curNode = endNode;

       while (curNode.getParent() !=null){
           path.add(curNode.getParent());
           curNode = curNode.getParent();
       }

       path = reverseArrayList(path);
       return  path;

    }

    public ArrayList<Node> reverseArrayList(ArrayList<Node> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<Node> revArrayList = new ArrayList<Node>();
        for (int i = alist.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }

        // Return the reversed arraylist
        return revArrayList;
    }
    public int calcDistCost(Node a, Node b){
        int xDist = Math.abs(a.getX() - b.getX());
        int yDist = Math.abs(a.getY() - b.getY());
        int estremaining = Math.abs(xDist - yDist);

        return diaMoveCost * Math.min(xDist, yDist) + straightMoveCost* estremaining;
    }

    public Node getNodeWithLowestFCost(ArrayList<Node> nodes){
        Node lowest = nodes.get(0);
        for(int i=1; i < nodes.size(); i++){
            if(nodes.get(i).getfCost() < lowest.getfCost()){
                lowest = nodes.get(i);
            }
        }
        return lowest;
    }

}
