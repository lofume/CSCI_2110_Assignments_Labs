import java.util.Scanner;

public class Exercise5 {
    //if
    public static void writeVertical(int n){
        //if n is less than 10 print single digit
        if(n<=10){
            System.out.println(n);
        }
        else{
            //saves value and prints the value in the sequence
            writeVertical(n/10);
            System.out.println(n%10);
        }
    }
    //print method for the above method, allowing user input
    public static void main(String[] args){
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter positive n integer in sequence: ");
        int n= kb.nextInt();
        writeVertical(n);
    }
}
