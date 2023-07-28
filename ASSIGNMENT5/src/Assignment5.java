import java.io.IOException;
import java.util.*;
import java.io.*;
public class Assignment5 {
    public static void main(String[] args) throws IOException{
        //read file by user input and open file
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter file to read from: ");
        String filename= kb.nextLine();
        File file= new File(filename);
        Scanner inputFile= new Scanner(file);
        //create matrix and get vertices
        int n= Integer.parseInt(inputFile.nextLine());
        int[][] adj= new int[n][n];
        //fill adj
        while(inputFile.hasNext()){
            int v0= inputFile.next().charAt(0)-65;
            int v1= inputFile.next().charAt(0)-65;
            adj[v0][v1] = adj[v1][v0]= 1;
        }
        kb.close();
        inputFile.close();
        //traversal display & displays integer vertices
        System.out.println("Adjacency Matrix: ");
        ArrayList<Integer> DFS = new ArrayList<Integer>(n);
        //call and traverse depthFirstSearch starting at the 0 vertex
        depthFirstS(adj, DFS, 0);
        //display depth-first search
        for(int i: DFS){
            System.out.print((char)(i+65)+ " ");
        }
        System.out.println();
        //display matrix
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++) {
                System.out.print(adj[row][col] + " ");
            }
            System.out.println();
        }
        //add traversal to BFS
        ArrayList<Integer> BFS = breadthFirstS(adj,0);
        //display vertices visited
        System.out.println();
        System.out.println("Vertices visited: ");
        for(int i: BFS ){
            System.out.println((char)(i+65)+ " visited");
        }
        System.out.println();
    }
    //depth first search method
    public static void depthFirstS(int [][] adj, ArrayList<Integer> r, int vert){
        //if vertex is not in the array then put into array
        if(!r.contains(vert))
            r.add(vert);
        //check for neighbours and visit them if not visted yet
        for(int i=0; i<adj[vert].length; i++){
            if(adj[vert][i]==1)
                if(!r.contains(i))
                    depthFirstS(adj,r,i);
        }
    }
    //breadth first search method
    public static ArrayList<Integer> breadthFirstS(int [][] adj, int vert){
        //creates queue arraylist
        ArrayList<Integer> queue = new ArrayList<Integer>();
        //create a results arraylist
        ArrayList<Integer> r= new ArrayList<Integer>();
        //enqueue
        queue.add(vert);
        while(!queue.isEmpty()){
            //dequeue
            int m= queue.remove(0);
            r.add(m);
            //look m's neighbours
            for(int i=0; i<adj[m].length;i++){
                if(adj[m][i]==1)
                    //enqueue neighbour if not in r
                    if(!r.contains(i) && !queue.contains(i))
                        queue.add(i);
            }
        }
        return r;
    }
}