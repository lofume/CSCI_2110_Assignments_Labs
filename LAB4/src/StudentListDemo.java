import java.util.Scanner;
import java.io.*;
public class StudentListDemo {
    //DUPLICATE OF EXPENSELIST CLASS
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        Scanner input= new Scanner(System.in);
        StudentList sl = new StudentList();

        int ID;
        String fN;
        String lN;
        String email;
        String major;
        String faculty;
        Student sList = null;


        while (inputFile.hasNext()) {
            ID = inputFile.nextInt();
            fN = inputFile.next();
            lN = inputFile.next();
            email = inputFile.next();
            major = inputFile.next();
            faculty = inputFile.next();
            sList = new Student(ID, fN, lN, email, faculty, major);
            sl.addRecord(sList);
        }


        inputFile.close();

        System.out.println("The Student List contains the following entries:");


        sl.enumerate();




        String in= input.next();
        while(true) {
            //reason for the name saying displayFaculty is due to the error in Lab 4 context, the outputs are flipped
            //this case is the same for the faculty
            if(in.equals("display")) {
                String find = input.next();
                //finds major
                if (find.equals("major")) {
                    System.out.println("These students are majoring in Music: ");
                    sl.displayFaculty(input.next());
                }
                //finds faculty
                else if(find.equals("faculty")){
                    System.out.println("These students are studying in the Faculty of Science");
                    sl.displayMajors(input.next());
                }
                //searches for the specific id inputted by user
                else if(find.equals("search")){
                    System.out.println("Find the record for the student with ID '200128' ");
                    System.out.println(sl.searchID(200128));
                }
                //searches for student based on the last name
                else if(find.equals("searchName")){
                    System.out.println("Find the record for the student with the name 'Mike Williams': (insert last name)");
                    sl.displayName(input.next());
                }
                //searches for the student based on their email
                else if(find.equals("email")){
                    System.out.println("Find the record for the student with the email 'apage@email.com': (insert email)");
                    sl.displayEmail(input.next());
                }
                //searches for student and deletes the student and prints the file
                else if(find.equals("delete")){
                    StudentList nSL= new StudentList();
                    int nSList= input.nextInt();
                    sl.deleteRecord(nSList);
                    sl.enumerate();
                }
            }
        }









    }
}
