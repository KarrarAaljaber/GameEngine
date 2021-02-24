package TestingGameEngine;

import Tiles.NonSolidTile;
import Tiles.Tile;
import Utilities.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;

import Graphics.EngineGraphics;
import Graphics.Renderer;

public class Chessboard implements  Runnable {

    private NonSolidTile board[][];
    private boolean[][] empty;
    private ArrayList<ChessMoves> moves;
    private ChessPlayer player;

    private int n;
    private int counter;
    private ArrayList<Vector2f> playerPos;

    private boolean black  =false;

    private Thread thread;
    private boolean running = false;

    private int startX, startY;

    public Chessboard(int n, ChessPlayer player, int startX, int startY) {
        this.n = n;
        this.startX = startX;
        this.startY = startY;

        this.player = player;
        board = new NonSolidTile[n][n];
        empty = new boolean[n][n];
        for (int x = 0; x < n; x ++) {

            for (int y = 0; y < n; y++) {

                if (black) {
                    board[x][y] = new NonSolidTile(x * 32, y * 32, 32, 32, Color.BLACK);
                    black= false;
                } else {
                    board[x][y] = new NonSolidTile(x * 32, y * 32, 32, 32, Color.WHITE);
                    black = true;
                }
                empty[x][y] = true;

            }
            if(black)
                black = false;
            else {
                black = true;
            }
        }



    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(NonSolidTile[][] board) {
        this.board = board;
    }

    public void generateMoves() {
        moves = new ArrayList<>();
        final int totalChessmoves = 8;
        //list of possible moves a knight can make in each direction
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < totalChessmoves; i++) {
            moves.add(new ChessMoves(xMove[i], yMove[i]));
        }
    }

    public boolean canBePlacedAt(int x, int y) {
        return (x >= 0 && x < n * 32 && y >= 0 && y < n * 32 && empty[x/32][y/32] == true);
    }

    public boolean findRoute() {

        int arrayX = startX - 1 * 32, arrayY = startY - 1 * 32;
        long starttime = System.currentTimeMillis();

        //generate the knight's move
        generateMoves();

        System.out.println("Finding route");
        //make the startIndexes have the value of 1
        //board[arrayX ][arrayY ] = 1;
        empty[arrayX/32][arrayY/32] = false;
        player.setPosition(new Vector2f(arrayX, arrayY));

        // System.out.println("Start pos");
        //printBoard();

        //start from 2 (since our start will be 1) and increase after every correct move in the function below
        counter = 2;

        if (findRouteRecursiv(arrayX, arrayY, counter, player, moves) == false) {
            System.out.println("Couldnt find route");
            return false;
        } else {
            long endTime = System.currentTimeMillis();
            long timeItTook = endTime - starttime;

            System.out.println("Route found!");
            System.out.println("It took " + timeItTook + " ms to find a route");
            return true;

        }
    }


    public void renderBoard( ){
        for(int x=0; x < n; x++){
            for(int y=0; y < n; y++){
                System.out.println(" X " + board[x][y].getX() + " Y "+  board[x][y].getY());
                Renderer.addObject(board[x][y]);
                if(board[x][y] == null){
                    System.out.println("null");
                }
            }
        }

    }
    public boolean findRouteRecursiv(int startX, int startY, int counter,ChessPlayer player, ArrayList<ChessMoves> moves) {
        int nextMoveX, nextMoveY;
        playerPos = new ArrayList<Vector2f>();

        //since arrays start from 0 we have to add 1
        //lets say n = 5 if the counter = 5*5 = 25 then we are done
        if (counter == n * n + 1) {
            return true;
        }

        //for each of the possible moves for the knight try them and see if theres a solution
        for (int i = 0; i < moves.size(); i++) {
            //make the next move equaql to startX + moves
            nextMoveX = startX + moves.get(i).getX() * 32;
            nextMoveY = startY + moves.get(i).getY() * 32;


            //if the next move is not outside of the board and equal to 0 it means that we can move there
            if (canBePlacedAt(nextMoveX, nextMoveY)) {
                empty[nextMoveX /32][nextMoveY /32] = false;
                board[nextMoveX / 32][nextMoveY /32].setCounter(counter);


                playerPos.add(new Vector2f(nextMoveX, nextMoveY));
                movePlayer();




                //  render(g);
                //the recursiv part of this function
                //This time the startX and startY will be the nextMoveX and nextMoveY

                if (findRouteRecursiv(nextMoveX, nextMoveY, counter + 1, player, moves)) {
                    return true;

                    //if the nextMoveX and nextMoveY didnt lead to a solution make it 0 and try to use another move that will find the soultion form the moves arraylist
                } else {
                    //backtracking
                    playerPos = new ArrayList<Vector2f>();

                    //  board[nextMoveX][nextMoveY] = 0;
                    empty[nextMoveX / 32][nextMoveY /32] = true;

                }
            }
        }
        return false;

    }
    public void movePlayer(){
        try{
        thread.sleep(1000);
        for(int i=0; i < playerPos.size(); i++) {
            player.setPosition(playerPos.get(i));
        }
        }catch(Exception e){
            e.printStackTrace();
            }

    }

    public void start(){
        thread = new Thread(this,"chess");
        thread.start();
        running = true;
    }

    @Override
    public void run() {
        while (running && !findRoute()){
            findRoute();
        }
    }
}


