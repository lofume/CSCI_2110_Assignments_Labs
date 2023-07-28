import java.util.*;
public class Collatz{
    //initializes and executes the collatz theory
    static void printValue(int c){
        while(c != 1){
            System.out.print(c + " ");
            if((c&1)==1){
                c= 3*c +1;
            }
            else{
                c= c/2;
            }
        }
        //prints values
        System.out.print(c);
    }
    // prints collatz values, unsure what the difference in the values are for the sameple output
    public static void main(String[] args){
        printValue(5);
        System.out.println();
        printValue(100);
        System.out.println();
        printValue(1000);
        System.out.println();
        printValue(10000);
        System.out.println();
        printValue(100000);
        System.out.println();
        printValue(10000000);

    }

}
