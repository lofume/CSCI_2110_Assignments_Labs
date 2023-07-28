import java.util.ArrayList;
import java.util.*;
public class Exercise1 {
    public static void main(String[] args){
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter name or done:\t");
        String in= kb.nextLine();
        //creation of empty binary tree
        BinaryTree<String> t= new BinaryTree<String>();
        //creation of arraylist
        ArrayList<BinaryTree<String>> string = new ArrayList<BinaryTree<String>>();
        //if/else case that either sets an empty tree; else a root is made and is added to the list "string"
        if(in.equals("done")){
            t= null;
        }
        else{
            t.makeRoot(in);
            string.add(t);
            System.out.print("Enter name or done:\t");
            in= kb.nextLine();
        }
        //new node created
        BinaryTree<String> newN;
        //allow user input until "done" is entered
        while(!in.equals("done")){
            newN= new BinaryTree<String>();
            newN.makeRoot(in);
            //if the tree is left and null, attach newN to left and then add to string list
            if(string.get(0).getLeft()== null){
                string.get(0).attachLeft(newN);
                string.add(newN);
            }
            //cannot go left, tree is right and null, attach newN to right and then add to string list
            else if(string.get(0).getRight()==null){
                string.get(0).attachRight(newN);
                string.add(newN);
            }
            //else left is full and cannot attach so it is removed and then added to the second tree
            //then it is added to the arraylist
            else{
                string.remove(0);
                string.get(0).attachLeft(newN);
                string.add(newN);
            }
            //gets more input
            System.out.print("Enter name or done:\t");
            in= kb.nextLine();
        }
        //print methods
        System.out.println();
        System.out.println("The height of the tree is:\t"+ BinaryTree.height(t));
        System.out.println("\nThe number of nodes:\t" + BinaryTree.nodes(t));
        System.out.print("\nInorder:\t");
        BinaryTree.inorder(t);
        System.out.print("\nPreorder:\t");
        BinaryTree.preorder(t);
        System.out.print("\nPostorder:\t");
        BinaryTree.postorder(t);
        System.out.print("\nLevel Order:\t");
        BinaryTree.levelOrder(t);
    }
}
