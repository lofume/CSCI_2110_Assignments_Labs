import java.util.*;
import java.util.Scanner;
public class GameDemo{
    public static void main (String[] args) {
        //board creation
        Board brd = new Board(8,8);
        Scanner add = new Scanner(System.in);
//loops through to re-direct the user to the beginning if there input is wrong, or they reach the end of
        //the amount of user input that is required.
        while(true){
            System.out.print("Enter command: (type help for details) ");
            String nextStep = add.next();
            if(nextStep.equals("help")){ //list of help steps to get through program
                System.out.println("Possible commands are as follows:");
                System.out.println("create location [fast][flexible]: Create a new piece.");
                System.out.println("move location direction [spaces]: Moves a piece");
                System.out.println("print: Displays the board");
                System.out.println("help: Displays help");
                System.out.println("exit: Exits the program");
            }

        //exits program
            if(nextStep.equals("exit")){
                System.out.println("EXIT PROGRAM");
                break;
            }
            //create statement, allowing user to input information in order to create the piece on the board
            if(nextStep.equals("create")){
                System.out.print("Enter x and y piece: "); //enter on same line
                int xPos= add.nextInt();
                int yPos= add.nextInt();
                System.out.print("Enter type name: ");
                String type= add.next();
                System.out.println("Name of piece: ");
                String name= add.next();
                System.out.println("Color of the piece: ");
                String color= add.next();
                brd.addNewPiece(name, color, type, xPos, yPos);

            }
//this statement prints the board if the user wants to enter that
            if(nextStep.equals("print")){
                brd.display();
            }
//this statement allows the user to input new co-ordinates so the user can move a piece
            if(nextStep.equals("move")){
                System.out.print("Enter beginning coordinates: ");
                int xPos= add.nextInt();
                int yPos= add.nextInt();
                System.out.print("Enter direction piece should move to - up or down or left or right -: ");
                String moveNow= add.next();
                System.out.print("Enter the number of spaces: ");
                int nextMove = add.nextInt();
                brd.movePiece(xPos, yPos, moveNow, nextMove);
            }
        }
    }
}
