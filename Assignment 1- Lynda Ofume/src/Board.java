import java.util.*;
import java.util.Scanner;
public class Board {
    //instance variable
    private Piece [][] theBoard;


//constructor
    public Board(int xPos, int yPos){
        theBoard = new Piece[xPos][yPos];
    }
//this method adds a instance of the type classes to the board
    public void addNewPiece(String name, String color, String type, int xPos, int yPos){
        if(theBoard[xPos][yPos] == null){
            if(type.equals("FF")){
                FastFlexible newPlace = new FastFlexible(name,color,type,xPos,yPos);
                theBoard[xPos][yPos]= newPlace;
            }
            else if(type.equals("SP")){
                SlowPiece newPlace = new SlowPiece(name,color,type,xPos,yPos);
                theBoard[xPos][yPos]= newPlace;
            }
            else if(type.equals("FP")){
                FastPiece newPlace = new FastPiece(name,color,type,xPos,yPos);
                theBoard[xPos][yPos]= newPlace;
            }
            else if(type.equals("SF")){
                SlowFlexible newPlace = new SlowFlexible(name,color,type,xPos,yPos);
                theBoard[xPos][yPos]= newPlace;
            }
        }
    }
//this method moves the piece to another location on the board depending on whether
    //or not its type, direction, and position is entered by the user.
    public void movePiece(int xPos, int yPos, String moveNow, int nextMove) {
        if (theBoard[xPos][yPos] != null) {

            if (theBoard[xPos][yPos].equals("SP")) {
                if (moveNow.equals("left")) {
                    if (yPos - 1 >= 0) {
                        theBoard[xPos][yPos - 1] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("right")) {
                    if (yPos + 1 < 8) {
                        theBoard[xPos][yPos + 1] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                else {
                    System.out.print("ERROR, try again");
                }
            }
            //case for the FastPiece
            else if (theBoard[xPos][yPos].equals("FP")) {
                if (moveNow.equals("left")) {
                    if (yPos - nextMove > 0) {
                        theBoard[xPos][yPos - nextMove] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("right")) {
                    if (yPos + nextMove < 8) {
                        theBoard[xPos][yPos + nextMove] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                } else {
                    System.out.print("ERROR, try again");
                }
            }
            //case for SlowFlexible
            else if (theBoard[xPos][yPos].equals("SF")) {
                if (moveNow.equals("left")) {
                    if (yPos - 1 > 0) {
                        theBoard[xPos][yPos - 1] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("right")) {
                    if (yPos + 1 < 8) {
                        theBoard[xPos][yPos + 1] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("up")) {
                    if (xPos - 1 > 0) {
                        theBoard[xPos - 1][yPos] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("down")) {
                    if (xPos + 1 < 8) {
                        theBoard[xPos + 1][yPos] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                } else {
                    System.out.print("ERROR, try again");
                }
            }
            //case for FastFlexible
            else if (moveNow.equals("FF")) {
                if (moveNow.equals("left")) {
                    if (yPos - nextMove > 0) {
                        theBoard[xPos][yPos - nextMove] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("right")) {
                    if (yPos + nextMove < 8) {
                        theBoard[xPos][yPos + nextMove] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("up")) {
                    if (xPos - nextMove > 0) {
                        theBoard[xPos - nextMove][yPos] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                if (moveNow.equals("down")) {
                    if (xPos + nextMove < 8) {
                        theBoard[xPos + nextMove][yPos] = theBoard[xPos][yPos];
                        theBoard[xPos][yPos] = null;
                    }
                }
                else {
                    System.out.println("ERROR, NO BOARD PIECE FOUND");
                }
            }
        }
    }
//this method will display the board if it is empty or once it gets filled
    public void display(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(theBoard[i][j]== null){
                    System.out.printf("%12s", " - ");
                }
                else{
                    System.out.print(theBoard[i][j]);
                }
            }
            System.out.println();
        }

    }



}
