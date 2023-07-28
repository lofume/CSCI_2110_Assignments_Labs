import java.util.*;
public class BinaryTree<T>{
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	public BinaryTree(){
		parent = left = right = null;
		data = null;
	}
	public void makeRoot(T data){
		if (!isEmpty()){
			System.out.println("Can't make root. Already exists");
		}
		else
			this.data = data;
	}
	public void setData(T data){
		this.data = data;
	}
	public void setLeft(BinaryTree<T> tree){
		left = tree;
	}
	public void setRight(BinaryTree<T> tree){
		right = tree;
	}
	public void setParent(BinaryTree<T> tree){
		parent = tree;
	}
	public T getData(){
		return data;
	}
	public BinaryTree<T> getParent(){
		return parent;
	}
	public BinaryTree<T> getLeft(){
		return left;
	}
	public BinaryTree<T> getRight(){
		return right;
	}
	public void attachLeft(BinaryTree<T> tree){
		if (tree==null) return;
		else if (left!=null || tree.getParent()!=null){
			System.out.println("Can't attach");
			return;
		}
		else{
            tree.setParent(this);
            this.setLeft(tree);
		}
	}
	public void attachRight(BinaryTree<T> tree){
		if (tree==null) return;
		else if (right!=null || tree.getParent()!=null){
			System.out.println("Can't attach");
			return;
		}
		else{
            tree.setParent(this);
            this.setRight(tree);
		}
	}
	public BinaryTree<T> detachLeft(){
		if (this.isEmpty()) return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft!=null) retLeft.setParent(null);
		return retLeft;
	}
	public BinaryTree<T> detachRight(){
		if (this.isEmpty()) return null;
		BinaryTree<T> retRight = right;
		right =null;
		if (retRight!=null) retRight.setParent(null);
		return retRight;
	}
	public boolean isEmpty(){
		if (data == null)
			return true;
		else
			return false;
	}
    
	public void clear(){
		left = right = parent =null;
		data = null;
	}
	public BinaryTree<T> root(){
		if (parent == null)
			return this;
		else{
			BinaryTree<T> next = parent;
			while (next.getParent()!=null)
				next = next.getParent();
			return next;
		}
	}
	//finds number of nodes- given from Practice test
    public static<T> int nodes(BinaryTree<T> t){
        if(t==null) {
			return 0;
		}
        else if(t.getLeft()==null && t.getRight()==null){
        	return 1;
		}
        else{
        	return 1+ nodes(t.getLeft()) + nodes(t.getRight());
		}
    }
	//finds the height of the tree
    public static<T> int height(BinaryTree<T> t){
        if(t==null) return -1;
        else if(t.getLeft()== null && t.getRight()==null) return 0;
        else{
        	return 1+ Math.max(height(t.getLeft()), height(t.getRight()));
		}
    }
    //NEW METHOD= recursive method that goes through and checks the left and right subtree
	//returning -1 if not balance, and then comparing the parent height result seeing which is greater in height
    public static <T> int heightB(BinaryTree<T> t){
		//base case
		if(t==null){
			return 0;
		}
		int lH= heightB(t.getLeft());
		int rH= heightB(t.getRight());
		//checks if left or right subtree is not balanced, and if it isn't returns -1
		if(lH== -1 || rH==-1) return -1;
		//checks the absolute value of the subtree is balance
		if(Math.abs(lH-rH)>1) return -1;
		//if all of the subtrees are balanced than we all the left and right height to compare
		else{
			return 1+Math.max(lH,rH);
		}
	}
    public static<T> boolean isBalanced(BinaryTree<T> t){
		//calls from the heightB method and returns a boolean "Yes" or "No" if the tree is balanced or not
		int r= heightB(t);
		if(r>-1){
			return true;
		}else {
			return false;
		}

    }
    public static <T> void preorder(BinaryTree<T> t){
		if (t!=null){
			System.out.print(t.getData()+"\t");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}
	public static <T> void inorder(BinaryTree<T> t){
		if (t!=null){
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}
	public static <T> void postorder(BinaryTree<T> t){
		if (t!=null){
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}
	//level order traversal
    public static <T> void levelOrder(BinaryTree<T> t){
		//base case
        if(t==null) return;
        //empty tree list
        ArrayList<BinaryTree<T>> depth= new ArrayList<BinaryTree<T>>();
        //add t to the depth list
        depth.add(t);
        while(!depth.isEmpty()){
        	//add the tree node to the first level n and print
        	BinaryTree<T> n = depth.get(0);
        	System.out.print(n.getData() + "\t");
        	//if there is a left or right child add it to the level
        	if(n.getLeft()!=null)
        		depth.add(n.getLeft());
        	if(n.getRight()!= null)
				depth.add(n.getRight());
        	//remove n once the children have been added
        	depth.remove(0);
		}
	}
}