import java.io.IOException;
import java.util.*;
import java.io.*;
public class OrderedListDemo {
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
        //creation of the merged list
        OrderedList<T> mergedList = new OrderedList<T>();
        //the first items in there lists
         T l1 = list1.first();
         T l2= list2.first();
         //removes duplicates from the list based on list size and adds to the third list
        while(l1 !=null || l2 !=null){
            if(l1.compareTo(l2)<0){
                mergedList.add(mergedList.size(), l1);
                l1= list1.next();
            }
            else if(l1.compareTo(l2)>0){
                mergedList.add(mergedList.size(), l2);
                l2= list2.next();
            }
            else{
                mergedList.add(mergedList.size(), l1);
                l1= list1.next();
                l2= list1.next();
            }
            //test case if one has reached null and the other has not continue adding to the third list
            if(l1==null && l2!=null){
                while(l2!=null){
                    mergedList.add(mergedList.size(), l2);
                    l2= list2.next();
                }
            }
            //test case if one has reached null and the other has not continue adding to the list
            else if(l1!=null && l2==null){
                while(l1!=null){
                    mergedList.add(mergedList.size(), l1);
                    l1= list1.next();
                }
            }
        }
        return mergedList;
    }
    public static void main(String[] args) throws IOException{
        //creation of both ordered lists
        OrderedList<String> list1= new OrderedList<String>();
        OrderedList<String> list2= new OrderedList<String>();
        Scanner keyboard = new Scanner(System.in);
        //similar to ExpenseListDemo from lab4, inserting one file at a time
        System.out.print("Enter the first filename to read from: ");
        String filename = keyboard.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        while(inputFile.hasNext()){
            list1.insert(inputFile.next());
        }
        inputFile.close();
        //similar to ExpenseListDemo from lab4, inserting one file at a time
        System.out.print("Enter the second filename to read from: ");
        String filename2 = keyboard.nextLine();
        File file2 = new File(filename2);
        Scanner inputFile2 = new Scanner(file2);
        while(inputFile2.hasNext()){
            list2.insert(inputFile2.next());
        }
        inputFile2.close();
        System.out.println("The Ordered Lists Contain the following entries:");
        //enumerates both lists and displays both contents of the lists out
        System.out.println("List 1");
        list1.enumerate();
        System.out.println("List 2:");
        list2.enumerate();
        //prints out a merged list of 1 and 2
        System.out.println();
        System.out.println("A merged version of the two lists looks like this: ");
        OrderedListDemo.merge(list1, list2).enumerate();
    }
}