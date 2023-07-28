import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>>{
    // declare required fields
	private BinaryTree<T> tree;
	private int size;

    /**
    Constructor 1
    No arg constructor
    */
    public BinarySearchTree(){
		tree = new BinaryTree<T>();
		size=0;
	}
    
	public BinaryTree<T> getTree(){
		return tree;
	}
    
	public boolean isEmpty(){
		return tree.isEmpty();
	}
    
	public int size(){
		return size;
	}
    
	public BinaryTree<T> search(T key){
		BinaryTree<T> t = tree;

        if (isEmpty()) return null;

        while (t!=null){
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
        return null;
	}
				
	public void insert(T item){
        //initialize new BT and sets left, right, parent and data to null
		BinaryTree<T> newNode = new BinaryTree<T>();
		newNode.setData(item);

		if (size==0){
            tree = newNode;
            size++;
            return;
        }
		
		BinaryTree<T> t = tree;
		boolean done = false;

        while (!done){
			int c = item.compareTo(t.getData());
			if (c==0){
				System.out.println("Duplicate key. Can't insert");
				return;
			}
            //need to go left
			else if (c<0){
                //place to insert found
				if (t.getLeft()==null){
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
                    //otherwise go left one branch
					t = t.getLeft();
			}
            //c>0; need to go right
			else{
                //place to insert found
				if (t.getRight()==null){
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}
		}
	}
	
	public BinaryTree<T> findPredecessor(BinaryTree<T> node){
		if (node==null)
            return null;

		if (node.getLeft()==null)
            return null;
        
		BinaryTree<T> pred = node.getLeft();

        while (pred.getRight()!=null)
			pred = pred.getRight();

        return pred;
	}
	
	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach){
		if (deleteNode==null)
            return;
        
		BinaryTree<T> parent = deleteNode.getParent();
		
		if (parent == null)
            return;

        if (attach == null){
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}

        if (deleteNode==parent.getRight()){
			parent.detachRight();
			deleteNode.setParent(null);
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachRight(attach);
			attach.setParent(parent);
		}
		else{
			parent.detachLeft();
			deleteNode.setParent(null);
			
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachLeft(attach);
			attach.setParent(parent);
		}
        
		deleteNode.clear();
	}
	
	public void delete(T key){
		if (size==0){
            System.out.println("Can't delete. Empty tree");
            return;}
        
		BinaryTree<T> deleteNode = search(key);

        if (deleteNode==null){
            System.out.println("Key not found. Can't delete");
            return;
        }
		
		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null){
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null){
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
        else if (deleteNode.getRight()==null){
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}
        
		size--;
	}

	//finds the max node in a tree, while loops searches furthest right till it is found
    public T findMax() {
		BinaryTree<T> newT = tree;
		if (newT == null)
			return null;
		else if (newT.getRight() == null) {
			return newT.getData();
		}
		else
			while (newT.getRight() != null) {
				newT = newT.getRight();
			}
			return newT.getData();
    }

	//finds the max node in a tree, while loops searches furthest left till it is found
    public T findMin(){
    	BinaryTree<T> nT= tree;
    	if(nT==null)
        	return null;
    	else if(nT.getLeft()==null)
    		return nT.getData();
    	else
    		while(nT.getLeft()!=null){
    			nT= nT.getLeft();
			}
    		return nT.getData();
    }

    //two part method, helps initiate the 2 part parameter recursive search
    public BinaryTree<T> recursiveSearch(T key){
    	BinaryTree<T> trees= tree;
    	if(trees.isEmpty())
        	return null;
    	else
    		return recursiveSearch(trees, key);
    }
	//recursive method that goes left or right based on value
	//if larger go to right child and vice versa for smaller
    public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key){
    	if(t==null)
        	return null;
    	else if (key.compareTo(t.getData())==0)
			return t;
    	else if (key.compareTo(t.getData())>0)
    		return recursiveSearch(t.getRight(),key);
    	else
    		return recursiveSearch(t.getLeft(),key);
	}

	//extends to method in Exercise 1
	public static <T> ArrayList<T> findOrder(BinaryTree<T> t, ArrayList<T> array){
    	if(t==null){
    		return array;
		}
    	findOrder(t.getLeft(),array);
    	array.add(t.getData());
    	findOrder(t.getRight(),array);
    	return array;
	}
}
