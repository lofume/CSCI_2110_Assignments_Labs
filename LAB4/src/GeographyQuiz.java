import java.io.*;
import java.util.Scanner;
import java.util.*;

public class GeographyQuiz {
    public static void main(String args[]) throws IOException {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = kb.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        Scanner input = new Scanner(System.in);
        //creation of linkedlist
        LinkedList<String> quiz = new LinkedList<>();

        String country;
        int questP = 0;
        int corAns = 0;


        while (inputFile.hasNext()) {
            country = inputFile.nextLine();
            quiz.add(country);
        }
        inputFile.close();

        System.out.println("Welcome to the Country-Capital Quiz");

        int chooseQ;
        Random r = new Random();

        while (true) {
            System.out.println("Play? ");
            String c = input.next();
            //if the user enters yes or Yes it output a standard question
            if (c.equals("Yes") || c.equals("yes")) {
                questP++;
                chooseQ = r.nextInt(1);
                if (chooseQ == 0) {
                    int cNum = r.nextInt(quiz.size());
                    if (cNum % 2 == 0) {
                        cNum--;
                    }
                    System.out.println("What is the capital of " + quiz.getAt(cNum) + "?");
                    if (input.next().equals(quiz.getAt(cNum - 1))) {
                        System.out.print("Correct. ");
                        corAns++;
                    } else {
                        System.out.println("Incorrect. The correct answer is " + quiz.getAt(cNum - 1));
                    }
                }
            }
            //if the user enters yes1 it outputs the reverse question of "yes"
            if (c.equals("yes1") || c.equals("Yes1")) {
                questP++;
                chooseQ = r.nextInt(2);
                if (chooseQ == 1) {
                    int cN = r.nextInt(quiz.size());
                    if (cN % 2 == 1) {
                        cN++;
                    }
                    System.out.println("What country has " + quiz.getAt(cN) + " as its capital?");
                    if (input.next().equals(quiz.getAt(cN + 1))) {
                        System.out.print("Correct. ");
                        corAns++;
                    } else {
                        System.out.println("Incorrect. The correct answer is " + quiz.getAt(cN + 1));
                    }
                }
            }
            //this cancels the program and displays the game stats
            else{
                if (c.equals("No") || c.equals("no")) {
                    System.out.println("Game over.");
                    System.out.println("Game Stats: ");
                    double avg= ((corAns/questP)*100);
                    System.out.println("Questions played: " + questP + "; " + "Correct answers: " + corAns + "; " +
                        "Score: " + avg + "%");
                    System.out.println("GAME OVER!");
                    break;
                }
            }
        }
    }
}