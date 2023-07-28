import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeListDemo {
    //DUPLICATE OF EXPENSELIST CLASS in LAb 4
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        Scanner input= new Scanner(System.in);
        EmployeeList el = new EmployeeList();


        int employeeID;
        String fN;
        String lN;
        String email;
        String department;
        Employee eList;


        while (inputFile.hasNext()) {
            employeeID = inputFile.nextInt();
            fN = inputFile.next();
            lN = inputFile.next();
            email = inputFile.next();
            department = inputFile.next();
            eList = new Employee(employeeID, fN, lN, email, department);
            el.addEmployee(eList);
        }


        inputFile.close();

        System.out.println("The Employee List contains the following entries:");


        el.enumerate();


        String in= input.next();
        while(true) {
            //if user picks display, it will prompt to either search or delete an employee
            if(in.equals("display")) {
                String find = input.next();
                //searches for the specific id inputted by user
                if(find.equals("search")){
                    System.out.println("Find the record for the student with ID '23455' ");
                    System.out.println(el.searchID(23455));
                }
                //searches for employee and deletes the employee and prints the file
                else if(find.equals("delete")){
                    EmployeeList nSL= new EmployeeList();
                    int nSList= input.nextInt();
                    el.deleteEmployee(nSList);
                    el.enumerate();
                }
            }
        }
    }
}


