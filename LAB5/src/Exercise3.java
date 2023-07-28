import java.util.Scanner;
import java.util.StringTokenizer;
public class Exercise3 {
    //repeat of Exercise2, but modified to countdown by 2's
    public static void countDown(int n){
        if(n<=0){
            System.out.print("BlastOff!");
        }
        //counts down values down by 2
        else{
            System.out.print(n+ "\t");
                countDown(n-2);
            }
        }
//prints the countDown method
        public static void main(String[] args){
            Scanner kb= new Scanner(System.in);
            System.out.print("Enter single positive integer n: ");
            int n= kb.nextInt();
            countDown(n);

        }


    }
