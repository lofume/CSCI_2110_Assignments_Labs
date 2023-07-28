import java.util.*;
public class Exercise6 {
    public static int squares(int n){
        //lowest value that n can be for the sum of squares, standard test case
        if(n==1){
            return 1;
        }
        else{
            //sum of squares formula
            return (n*n+squares(n-1));
        }
    }
    //prints above method, allowing user input
    public static void main(String[] args){
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter positive n integer: ");
        int n= kb.nextInt();
        System.out.print(squares(n));
    }
}
