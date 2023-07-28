import java.util.Scanner;

public class Exercise2 {
//standard test case
    public static void countDown(int n){
        if(n==0){
            System.out.print("BlastOff!");
        }
        //counts down n-1 based on starting value
        else{
            System.out.print(n+ "\t");
            countDown(n-1);
        }
    }
//prints the void method above
    public static void main(String[] args){
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter single positive integer n: ");
        int n= kb.nextInt();
        countDown(n);
    }
}
