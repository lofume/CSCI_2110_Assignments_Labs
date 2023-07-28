import java.util.*;
public class Exercise1 {
    //factorial method
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    //fibonacci method
    public static int fib(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }
    //power method that takes x and then raises to the power of n
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        else{
            return power(x, n-1)*x;
        }
    }
    //main method prints the above methods
    public static void main(String[]args){
        System.out.print("Factorial method of the first 10 numbers: ");
        for(int i=0; i<=10; i++){
            System.out.print(factorial(i)+ "\t");
        }
        System.out.print("\nFibonacci calls the first 20 numbers: ");
        for(int i=0; i<=20; i++){
            System.out.print(fib(i)+"\t");
        }
        System.out.print("\n");
        Scanner kb= new Scanner(System.in);
        System.out.print("Insert value for x: ");
        int x= kb.nextInt();
        System.out.print("Insert value for y: ");
        int y= kb.nextInt();
        System.out.print(x+ " to the power of "+y +" equals "+ power(x,y));

    }

}
