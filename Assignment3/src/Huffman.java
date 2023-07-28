import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Huffman {
        //Enter the file to read from
        public static void main (String[] args) throws IOException{
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter filename to read from/encode: ");
        String filename= kb.nextLine();
        File file= new File(filename);
        Scanner inputFile= new Scanner(file);
        //create an array list to keep track of the frequencies
        ArrayList<frequency> frqs= new ArrayList<frequency>();
        //subtotal of freqs to divide by to get a decimal
        int subTotal= 0;
        //reading lines of and converting each to characters
        while(inputFile.hasNext()){
            String l= inputFile.nextLine();
            char[] chars= l.toCharArray();
            //char frequency counter
            for(char c: chars){
                if(c!=' '){
                    subTotal++;
                    boolean found= false;
                    int here= 0;
                    //case that tests whether c is found in freqs
                    while(!found && here<frqs.size()){
                        if(frqs.get(here).getC()==c){
                            frqs.get(here).inFrq();
                            found=true;
                        }
                        else{
                            here++;
                        }
                    }
                    //if false then add to frequency
                    if(!found){
                        frequency s= new frequency(c);
                        frqs.add(s);
                    }
                }
            }
        }
        inputFile.close();
        //created ordered list to allow items in list to maintain ordered based on probability
        OrderedList<Pair> pairs = new OrderedList<Pair>();
        //add to orderedlist while removing the object from frqs
        while(!frqs.isEmpty()){
            frequency s = frqs.remove(0);
            Pair nPair = new Pair(s.getC(), (double)s.getFrq()/subTotal);
            pairs.insert(nPair);
        }
        //create queue S, create a loop that enqueues trees to S
        ArrayList<BinaryTree<Pair>> S = new ArrayList<BinaryTree<Pair>>();
        Pair p= pairs.first();
        while (p!=null){
            BinaryTree<Pair> trees = new BinaryTree<Pair>();
            trees.makeRoot(p);
            S.add(trees);
            p= pairs.next();
        }
        //create queue T
        ArrayList<BinaryTree<Pair>> T = new ArrayList<BinaryTree<Pair>>();
        BinaryTree<Pair> A;
        BinaryTree<Pair> B;
        //if T is empty dequeue the tree, add A & B to P
        //enqueue P to T
        if(T.isEmpty() && S.size()>=2){
            A= S.remove(0);
            B= S.remove(0);
            //create binary tree P
            BinaryTree<Pair> P= new BinaryTree<Pair>();
            double prob= A.getData().getProb() + B.getData().getProb();
            Pair nPair= new Pair('0', prob);
            P.makeRoot(nPair);
            P.attachLeft(A);
            P.attachRight(B);
            T.add(P);
        }
        //in case 2 symbols are not there to encode
        else{
            System.out.print("Error");
        }
        //S is smaller probability, so let S front be A
        while(!S.isEmpty()){
            if(S.get(0).getData().getProb() < T.get(0).getData().getProb()){
                A= S.remove(0);
            }
            //T is smaller probability, so let T front be A
            else if(S.get(0).getData().getProb() > T.get(0).getData().getProb()){
                A= T.remove(0);
            }
            //if same then add S to front of A
            else{
                A= S.remove(0);
            }
            if(S.isEmpty()){
                B= T.remove(0);
            }
            else if(T.isEmpty()){
                B= S.remove(0);
            }
            //Same case as above but for B
            else{
                if(S.get(0).getData().getProb() > T.get(0).getData().getProb()){
                    B = T.remove(0);
                }
                else if(S.get(0).getData().getProb() < T.get(0).getData().getProb()){
                    B= S.remove(0);
                }
                else{
                    B= S.remove(0);
                }
            }
            //attach to tree, get prob, and attach P to T
            BinaryTree<Pair> P= new BinaryTree<Pair>();
            double prob= A.getData().getProb() + B.getData().getProb();
            Pair nPair= new Pair('0', prob);
            P.makeRoot(nPair);
            P.attachLeft(A);
            P.attachRight(B);
            T.add(P);
        }
        //reduce the items in T
        while(T.size()>1){
            A= T.remove(0);
            B= T.remove(0);
            BinaryTree<Pair> prs= new BinaryTree<Pair>();
            double prob= A.getData().getProb() + B.getData().getProb();
            Pair nPair= new Pair('0', prob);
            prs.makeRoot(nPair);
            prs.attachLeft(A);
            prs.attachRight(B);
            T.add(prs);
        }
        //dequeue huffmanTree from T, then create a "findEncoding" that contains all symbols
        BinaryTree<Pair> huffT = T.remove(0);
        String[] symb= findEncoding(huffT);
        //create output file that will be attached to their corresponding text files
        PrintWriter output= new PrintWriter("Huffman.txt");
        //initiate proper decimal formating
        DecimalFormat format= new DecimalFormat("0.0000");
        p= pairs.first();
        // The Orderedlist will hold these values of probs and symbols
        while (p!=null){
            output.print(p.getValue() + "\t");
            output.print(format.format(p.getProb())+"\t");
            output.print(symb[ p.getValue() ]);
            output.println("");
            p= pairs.next();
        }
        output.close();
        //open Huffman text, store symbols, add to array
        file= new File("src/Huffman.txt");
        inputFile= new Scanner(file);
        StringTokenizer tk;
        char a;
        String val;
        //stores the codes
        String[] read= new String[256];
        //tokenizer helps skips the first items
        while (inputFile.hasNext()){
            String l= inputFile.nextLine();
            a= l.charAt(0);
            tk= new StringTokenizer(l, "\t");
            tk.nextToken();
            tk.nextToken();
            val= tk.nextToken();
            read[a]= val;
        }
        //read pokemon.txt that will be added to the Encoded.txt file
        file= new File("src/Pokemon.txt");
        inputFile= new Scanner(file);
        output= new PrintWriter("src/Encoded.txt");
        while(inputFile.hasNextLine()){
            String l= inputFile.nextLine();
            //line to char array
            char [] chars= l.toCharArray();
            for(char c : chars){
                //encode chars
                if(c!=' '){
                    output.print(read[c]);
                }
                else{
                    output.print(' ');
                }
            }
            output.print('\n');
        }
        output.close();
        //use encoded text from Huffman tree, take that and then output to Decoded text file
        //create parameters for decoding
        file= new File("src/Encoded.txt");
        inputFile= new Scanner(file);
        output= new PrintWriter("src/Decoded.txt");
        while(inputFile.hasNext()){
            String l= inputFile.nextLine();
            decode(l,huffT,huffT,output);
        }
        output.close();
    }
    //method given in Assignment 3
    private static String [] findEncoding(BinaryTree<Pair> bt){
        String [] result= new String[256];
        findEncoding(bt, result,"");
        return result;
    }
    //method given in assignment 3
    private static void findEncoding(BinaryTree<Pair> bt, String[] a, String prefix){
        if(bt.getLeft()==null && bt.getRight()==null){
            a[bt.getData().getValue()] = prefix;
        }
        else{
            findEncoding(bt.getLeft(), a, prefix+"0");
            findEncoding(bt.getRight(), a, prefix+"1");
        }
    }
    //enables the ability to go through lines of code and attach it via leaf
    //this allows for you to iterate through the lines of code
    public static void decode(String l, BinaryTree<Pair> r, BinaryTree<Pair> curr, PrintWriter output) {
        if(curr.getLeft()==null && curr.getRight()==null){
            output.print(curr.getData().getValue());
            decode(l, r, r, output);
        }
        //add space if space is found and then keep decoding the lines of text
        else if(l.charAt(0)==' '){
            output.print(' ');
            decode(l.substring(1),r,r,output);
        }
        //if char is equal to 0 then decode the left child till end of line
        else if(l.charAt(0)=='0'){
            decode(l.substring(1),r,curr.getLeft(),output);
        }
        //if the char is equal to zero then do same as above but to right child
        else if(l.charAt(0)=='1'){
            decode(l.substring(1), r, curr.getRight(),output);
        }
        //if end of line is reached then next line
        else if(l.isEmpty()){
            output.print('\n');
        }
    }
    //frequency class allows the ability to set specific start freq and keep track of the occurrences
    public static class frequency {
        private char c;
        private int frq;
        public frequency(char c){
            this.c=c;
            frq= 1;
        }
        public char getC() {
            return c;
        }
        public int getFrq(){
            return frq;
        }
        public void setFrq(int frq){
            this.frq= frq;
        }
        public void inFrq(){
            frq++;
        }
        @Override
        public String toString() {
            return c+ "\t" + frq;
        }
    }
    //OrderedList class helps with the ordering of the items, so that it is alot
    public  static class OrderedList<T extends Comparable<T>>
    {
        private ArrayList<T> elements;
        private int cursor;

        public OrderedList(int cap)
        {
            elements = new ArrayList<T>(cap);
            cursor=-1;
        }
        public OrderedList()
        {
            elements = new ArrayList<T>();
            cursor=-1;
        }
        public int size()
        {
            return elements.size();
        }
        public boolean isEmpty()
        {
            return elements.isEmpty();
        }
        public void clear()
        {
            elements.clear();
        }
        public T get(int pos)
        {
            if (pos<0||pos>=elements.size())
            {
                System.out.println("Index out of bounds");
                //System.exit(0);
                return null;
            }
            return elements.get(pos);
        }
        public T first()
        {
            if (elements.size()==0)
                return null;
            cursor=0;
            return elements.get(cursor);
        }
        public T next()
        {
            if (cursor<0||cursor==(elements.size()-1))
                return null;
            cursor++;
            return elements.get(cursor);
        }
        public void enumerate()
        {
            System.out.println(elements);
        }
        public int binarySearch(T item)
        {
            if (elements.size()==0)
                return -1;
            int lo=0, hi=elements.size()-1, mid=0;
            while (lo<=hi)
            {
                mid = (lo+hi)/2;
                int c = item.compareTo(elements.get(mid));
                if (c==0) return mid;
                if (c<0) hi = mid-1;
                if (c>0) lo = mid+1;
            }
            if (item.compareTo(elements.get(mid))<0)
                return (-(mid+1));
            else
                return (-(mid+2));
        }
        //add an item to the end of the ordered list
        //useful method for the two-finger walking algorithm
        public void add(T item)
        {
            elements.add(item);
        }
        public void insert(T item)
        {
            if (elements.size()==0)
            {
                elements.add(item);
                return;
            }
            int pos = binarySearch(item);
            if (pos>=0)
            {
                System.out.println("Item " + item + " already present");
                return;
            }
            else
                elements.add(-pos-1, item);
        }
        public void remove(T item)
        {
            int pos = binarySearch(item);
            if (pos<0)
            {
                System.out.println("No such element");
                //System.exit(0);
                return;
            }
            else
                elements.remove(pos);
        }
        public T remove(int pos)
        {
            return elements.remove(pos);
        }
    }
}