import java.util.*;
public class Exercise0 {
    public static void main(String[] args){
        Scanner kb= new Scanner(System.in);
        //user input for size
        System.out.println("What size hash table do you want to work with?");
        System.out.println("Enter a positive integer: ");
        int t= kb.nextInt();
        //array linkedlist initiation
        ArrayList<LinkedList<Integer>> table= new ArrayList<LinkedList<Integer>>(t);
        //create empty list and then put into arraylist
        for(int i=0; i<t;i++){
            LinkedList<Integer> table2 = new LinkedList<Integer>();
            table.add(table2);
        }
        //user input for keys
        System.out.println("How many keys do you want to generate?");
        System.out.print("Enter integer n (number of keys): ");
        int n= kb.nextInt();
        kb.close();
        //creates a random key to hashmap
        Random r= new Random();
        int k, pos;
        //for loop that puts the bounds of key and gets the value and key then adds to linkedlist
        for(int i=0;i<n;i++){
            //random value between 1-10000
            k= r.nextInt(10000)+1;
            //gets pos of key
            pos= k%t;
            //add key to hashtable then to the front of list
            table.get(pos).add(0,k);
        }
        //collision and length of list inition
        int col=0;
        int ll=0;
        System.out.println("Hash Table Created: ");
        //for each linked list
        for(LinkedList<Integer> tab: table){
            //if the linkedlist is empty, print empty
            if(tab.isEmpty())
                System.out.println("-->empty");
            //else go through and print arrow plus the random integer
            else{
                for(Integer i: tab)
                    System.out.print("-->"+i);
                //links the numbers together based on placement
                System.out.println();
            }
            //finds the longest list
            if(tab.size() > ll){
                ll= tab.size();
            }
            //finds number of collisions
            if(tab.size()> 1){
                col += tab.size()-1;
            }
        }
        //print functions
        System.out.println();
        System.out.println("Statistics: ");
        System.out.println("Table Size: "+ t);
        System.out.println("Number of Keys: "+ n);
        System.out.println("Load factor: "+ (double)n/t);
        System.out.println("Number of Collisions: "+ col);
        System.out.println("Longest list: "+ ll);
    }
}