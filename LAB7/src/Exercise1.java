import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class Exercise1 {
    //binary search method test a boolean to see if it is a true BST or not
    public static<T extends Comparable<T>> boolean isBinarySearchTree(BinaryTree<T> t){
        ArrayList<T> l1= new ArrayList<T>();
        ArrayList<T> l2= new ArrayList<T>();
        if(t==null) {
            return true;
        }
        else {
            l1.addAll((findOrder(t, l2)));
            for (int i = 0; i < l1.size(); i++) {
                for (int k = i + 1; k < l1.size(); k++) {
                    if (l1.get(i).compareTo(l1.get(k)) > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //extended method from BST class that pulls from the method inorder in BinarySearch class
    private static <T extends Comparable<T>> Collection<? extends T> findOrder(BinaryTree<T> t, ArrayList<T> array) {
        if(t==null){
            return array;
        }
        findOrder(t.getLeft(),array);
        array.add(t.getData());
        findOrder(t.getRight(),array);
        return array;
    }
    public static void main(String[] args){
        //initiation of BST
        BinarySearchTree<Integer> tree= new BinarySearchTree<Integer>();
        //input user options
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter int or '0': ");
        int intgr= kb.nextInt();
        while(intgr!=0){
            System.out.print("Enter int or '0': ");
            tree.insert(intgr);
            intgr=kb.nextInt();
        }
        System.out.println();
        //max data value test
        System.out.println("The max data value in the BST is: "+ tree.findMax());
        //min data value test
        System.out.println("The min data value in the BST is: "+ tree.findMin());
        System.out.println();
        //recursive search method
        System.out.println("What key would you like to search for?");
        System.out.print("[INT KEY]>>> ");
        intgr=kb.nextInt();
        BinaryTree<Integer> nT= tree.recursiveSearch(intgr);
        //if else case if found in BST
        if(nT==null){
            System.out.println("Integer not found in the BST");
        }
        else{
            System.out.println("Found!");
        }
        System.out.println();
        //goes through BST method to see whether or not it is a true BST
        System.out.printf("And is it a true BST... %s\n", isBinarySearchTree(nT)? "Yes!":"No.");
        System.out.println();
        //negative hardcoded example and print statements
        BinaryTree<Integer> A = new BinaryTree<Integer>();
        BinaryTree<Integer> B = new BinaryTree<Integer>();
        BinaryTree<Integer> C = new BinaryTree<Integer>();
        BinaryTree<Integer> D = new BinaryTree<Integer>();
        BinaryTree<Integer> E = new BinaryTree<Integer>();
        BinaryTree<Integer> F = new BinaryTree<Integer>();
        A.makeRoot(1); B.makeRoot(2); C.makeRoot(3); D.makeRoot(4); E.makeRoot(5); F.makeRoot(6);
        A.attachLeft(B); A.attachRight(C); B.attachLeft(D); B.attachRight(E); D.attachLeft(F);
        System.out.println("Here's a hardcoded negative example.");
        System.out.println("The basic Binary Tree looks like this in level order:");
        System.out.println("1 2 3 4 5 6");
        System.out.println();
        System.out.printf("And is it a true BST... %s\n", isBinarySearchTree(A)? "Yes!": "No.");
        System.out.println();
    }
}
