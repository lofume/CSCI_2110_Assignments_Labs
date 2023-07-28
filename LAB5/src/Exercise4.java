import java.util.*;
public class Exercise4 {
    //recursive method that multiplies the result of m to n
    public static void multiples(int n, int m){
        //standard case
        if(m==1){
            System.out.print(n+"\t");
        }
        else{
           multiples(n, m-1);
           System.out.print(n*m + "\t");
        }

    }
    //displays the above method, allowing user input
    public static void main(String[]args){
        Scanner kb= new Scanner(System.in);
        System.out.print("Insert value for n: ");
        int n= kb.nextInt();
        System.out.print("Insert value for m: ");
        int m= kb.nextInt();
        multiples(n,m);
    }
}
