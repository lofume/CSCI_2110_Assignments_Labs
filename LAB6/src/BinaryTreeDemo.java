/*
BinaryTreeDemo
*/

/**
This class tests the code for Lab6: Exercise0. It creates a BinaryTree and
tests the methods of the  BinaryTree class.
It expands upon a framework provided by Srini (Dr. Srini Sampalli).
*/

import java.util.*;

public class BinaryTreeDemo
{
	public static void main(String[] args)
	{
        
		BinaryTree<String> A = new BinaryTree<String>();
		BinaryTree<String> B = new BinaryTree<String>();
		BinaryTree<String> C = new BinaryTree<String>();
		BinaryTree<String> D = new BinaryTree<String>();
		BinaryTree<String> E = new BinaryTree<String>();
		BinaryTree<String> F = new BinaryTree<String>();


		A.makeRoot("A");
		B.makeRoot("B");
		C.makeRoot("C");
		D.makeRoot("D");
		E.makeRoot("E");
		F.makeRoot("F");

		
		A.attachLeft(B);
		A.attachRight(C);
		B.attachLeft(D);
		B.attachRight(E);
		D.attachLeft(F);

		
		//FOR THE TESTS I DELETED THE LAST TWO TRIALS I CREATED BUT KEPT THE ORIGINAL JAVA FILE THAT WAS GIVEN
        // test statements
        System.out.printf("Height of the tree is: %d\n",
                          BinaryTree.height(A));

        System.out.printf("Number of nodes in the tree is: %d\n",
                          BinaryTree.nodes(A));

        System.out.println();
        
		System.out.print("Inorder:\t");
		BinaryTree.inorder(A);
		System.out.println();

        System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();
        
		System.out.print("Postorder:\t");
		BinaryTree.postorder(A);
		System.out.println();
		
		System.out.print("Level order:\t");
		BinaryTree.levelOrder(A);
		System.out.println();
        System.out.println();

        System.out.printf("And is it height balanced... %s\n",
                          BinaryTree.isBalanced(A)? "Yes!": "No.");

        System.out.println();        
    }
}
