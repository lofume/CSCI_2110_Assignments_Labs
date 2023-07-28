import java.awt.*;
import java.util.*;
public class Exercise7 {
    public static long solve(int n, int start, int end, int tmp){
        //standard base case
        if(n==1){
            return 1;
        }
        //Hanoi case example from class
        else{
            return solve(n-1,start, end, tmp) + solve(n-1, tmp, end, start) +1;
        }
    }
    public static void main(String[] args){
        Scanner kb= new Scanner(System.in);

        long startTime, endTime, executionTime, nOfMoves;

        System.out.print("Enter positive n integer: ");
        int n=kb.nextInt();

        //starts measuring the time
        startTime = System.currentTimeMillis();

        //find number of moves
        nOfMoves = solve(n, 1, 3, 2);

        System.out.print("Value of n: " + n + "\t");

        //calculates the end measuring time
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        //prints out the number of moves and the execution time
        System.out.print("| # of Moves: "+ nOfMoves);
        System.out.print("\t" + "| Execution time: "+ executionTime);
    }
}
